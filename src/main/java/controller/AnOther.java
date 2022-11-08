/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import static controller.MantenimientoCorrectivoUsuarios.ANSI_GREEN_BACKGROUND;
import static controller.MantenimientoCorrectivoUsuarios.ANSI_RED_BACKGROUND;
import static controller.MantenimientoCorrectivoUsuarios.ANSI_RESET;
import static controller.ReadCSV.SEPARATOR;
import static controller.WriteCSV.escribirCSVOrganizaciones;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LeadGod;
import model.Members;
import model.ModelUser;
import model.PartnerContact;
import model.PartnerJson;
import model.PartnerWrite;
import model.PartnersJson;
import model.Productos;
import model.TeamPartner;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import propertiesReader.PropertiesReader;

/**
 *
 * @author Marcos
 */
public class AnOther {

        public static void deleteUser(String idUsuario, String nCompany, String userName, String corredor, String agenteId, String pass) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpDelete request = new HttpDelete(PropertiesReader.getURL() + PropertiesReader.getUsers() + "/" + idUsuario);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == 204) {
                System.out.println("BORRADO USUARIO:       " + userName + "\t ID Interno: " + idUsuario);
                getContactPartner(nCompany, userName, corredor, agenteId, pass);
                httpClient.close();
            } else {
                System.out.println("FALLO BORRADO USUARIO: " + userName + "\t ID Interno: " + idUsuario);
                httpClient.close();
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getPartner(String nCompany, String userName, String corredor, String agenteId, String pass) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + nCompany);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String responseContact = EntityUtils.toString(response.getEntity());
            if (!responseContact.isEmpty()) {
                PartnerJson partnerJson1 = Handlers.parserPartnerJson(responseContact);
                if (partnerJson1.getStatus().equals("ACTIVE")) {
                    System.out.println("PARTNER ACTIVO - COMPANY: " + corredor + "\tPARTY NUMBER: " + nCompany + "\tAgente: "+agenteId);
                    getContactPartner(nCompany, userName, corredor, agenteId, pass);
                    httpClient.close();
                } else {
                    System.out.println("NO SE PUEDE CREAR USUARIO - PARTNER INACTIVO - COMPANY: " + corredor + "\tPARTY NUMBER: " + nCompany + "\tAgente: " + agenteId);
                    httpClient.close();
                }
            } else {
                System.out.println("NO SE PUEDE CREAR USUARIO CORREDOR INEXISTENTE COMPANY: " + corredor + "\tPARTY NUMBER: " + nCompany + "\tAgente: " + agenteId);
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void getContactPartner(String nCompany, String userName, String corredor, String agenteId, String pass) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + nCompany + "/child/contacts");
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String responseContact = EntityUtils.toString(response.getEntity());
            PartnersJson partnerJson1 = Handlers.parserPartnerContact(responseContact);

            if (!partnerJson1.getItems().isEmpty()) {
                PartnerContact partnerJson = partnerJson1.getItems().get(0);
                if (response.getStatusLine().getStatusCode() != 200 || response.getStatusLine().getStatusCode() != 201) {
                    if (partnerJson.getPartyNumber() != null) {
                        String partyNumber = partnerJson.getPartyNumber();
                        System.out.println("CONTACTO CORREDOR - USERNAME: " + userName + "\t COMPANY: " + nCompany + "\t PARTY NUMBER CONTACTO: " + partyNumber);
                        createUser(partyNumber, userName, nCompany, corredor, pass);
                        httpClient.close();
                    } else {
                        System.out.println("NO CONTIENE CONTACTO - NO existe ningún contacto asociado al Corredor: " + corredor + "\t El Código de agente es: " + agenteId + "\t NCompany OSC: " + nCompany + "\nEl corredor debe de contener al menos un contacto para generar un usuario (USUARIO: " + userName + ")");
                        httpClient.close();
                    }
                }
            } else {
                System.out.println("NO CONTIENE CONTACTO - NO existe ningún contacto asociado al Corredor: " + corredor + "\t El Código de agente es: " + agenteId + "\t NCompany: " + nCompany + "\nEl corredor debe de contener al menos un contacto para generar un usuario (USUARIO: " + userName + ")");
                httpClient.close();
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void createUser(String partyNumber, String userName, String nCompany, String corredor, String pass) {
        try {
            //json.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost request = new HttpPost(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + nCompany + "/child/contacts/" + partyNumber + "/child/userdetails");
            Handlers.setHeaderForAll(request);
            String jsonUserName = "{\"Username\":\"" + userName + "\"}";
            StringEntity entity = new StringEntity(Handlers.JsonTransformer(jsonUserName));
            request.setEntity(entity);
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == 200 || response.getStatusLine().getStatusCode() == 201) {
                System.out.println("CREADO USUARIO:            " + userName + "\tPARTYNUMBER USUARIO: " + partyNumber + "\t CORREDOR: " + corredor + "\tCOMPANY: " + nCompany + "\tJSON SEND: " + jsonUserName);
                updatePasswordUser(getUserPartner(userName), pass, userName);
            } else {
                System.out.println("FALLO EN CREACIÓN USUARIO: " + userName + "\tPARTYNUMBER USUARIO: " + partyNumber + "\t CORREDOR: " + corredor + "\tCOMPANY: " + nCompany + "\tJSON SEND: " + jsonUserName);
            }
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String getUserPartner(String userName) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            String aux = PropertiesReader.getURL() + PropertiesReader.getUsers() + "?filter=userName%20eq%20%22" + Handlers.JsonTransformerURI(userName).replace(" ", "%20") + "%22";
            HttpGet request = new HttpGet(aux);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String responseContact = EntityUtils.toString(response.getEntity());
            JSONObject partnerUser = new JSONObject(responseContact);
            JSONArray other = partnerUser.getJSONArray("Resources");
            if (other.length() > 0) {
                partnerUser = other.getJSONObject(0);
                return partnerUser.get("id").toString();
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "NO EXISTE USUARIO";
    }

    public static String getUser(String userName) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            String aux = PropertiesReader.getURL() + PropertiesReader.getUsers() + "?filter=userName%20eq%20%22" + Handlers.JsonTransformerURI(userName).replace(" ", "%20") + "%22";
            HttpGet request = new HttpGet(aux);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String responseContact = EntityUtils.toString(response.getEntity());
            JSONObject partnerUser = new JSONObject(responseContact);
            JSONArray other = partnerUser.getJSONArray("Resources");
            if (other.length() > 0) {
                partnerUser = other.getJSONObject(0);
                return partnerUser.get("id").toString();
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "NO EXISTE";
    }

    public static void updateStatusUser(String userName) {
        if (!getUser(userName).equals("NO EXISTE")) {
            try {
                String jsonSend = "{\n"
                        + "\"schemas\":[\n"
                        + "      \"urn:scim:schemas:core:2.0:User\"\n"
                        + "     ],\n"
                        + "  \"active\": true \n"
                        + "}";
                CloseableHttpClient httpClient = HttpClients.createDefault();
                HttpPatch request = new HttpPatch(PropertiesReader.getURL() + PropertiesReader.getUsers() + "/" + getUser(userName));
                Handlers.setHeaderForAll(request);
                StringEntity entity = new StringEntity(jsonSend);
                request.setEntity(entity);
                HttpResponse response = httpClient.execute(request);
                if (response.getStatusLine().getStatusCode() == 200) {
                    System.out.println("ACTUALIZADO");
                } else {
                    System.out.println("NO ACTUALIZADO");
                }

                httpClient.close();
            } catch (JsonProcessingException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("NO EXISTE USUARIO");
        }

    }

    public static void updatePasswordUser(String userName, String passWord, String userNameGood) {
        if (!getUser(userName).equals("NO EXISTE")) {
            try {
                passWord = "Reale." + passWord;
                String jsonSend = "{\n"
                        + "\"schemas\":[\n"
                        + "      \"urn:scim:schemas:core:2.0:User\"\n"
                        + "     ],\n"
                        + "  \"password\":\"" + passWord + "\"\n"
                        + "}";
                CloseableHttpClient httpClient = HttpClients.createDefault();
                HttpPatch request = new HttpPatch(PropertiesReader.getURL() + PropertiesReader.getUsers() + "/" + getUser(userName));
                Handlers.setHeaderForAll(request);
                StringEntity entity = new StringEntity(jsonSend);
                request.setEntity(entity);
                HttpResponse response = httpClient.execute(request);
                if (response.getStatusLine().getStatusCode() == 200) {
                    System.out.println("CAMBIADA CONTRASEÑA DE USUARIO:          " + userName + "\tPASS USUARIO: " + passWord);
                } else {
                    System.out.println("FALLO CAMBIO CONTRASEÑA DE USUARIO:      " + userName + "\tPASS USUARIO: " + passWord);
                }

                httpClient.close();
            } catch (JsonProcessingException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("NO EXISTE USUARIO");
        }

    }

    public static void deleteAccountTeamPartner(String nCompany) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpDelete request = new HttpDelete(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + nCompany + "/child/accountTeamMembers/300000011973445");
            Handlers.setHeaderForAll(request);
            httpClient.execute(request);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void getPartnerOrganizationName(ArrayList<PartnerWrite> partner, String archivoEscritura, String codigoAgente) throws FileNotFoundException {

        for (int i = 0; i < partner.size(); i++) {
            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "?q=PartnerProfilePEO_CodigoAgenteCorredor_c=" + codigoAgente);
                Handlers.setHeaderForAll(request);
                HttpResponse response = httpClient.execute(request);
                String responseEntity = EntityUtils.toString(response.getEntity());
                JSONObject partnerJson = new JSONObject(responseEntity);
                if (Integer.parseInt(partnerJson.get("count").toString()) != 0) {
                    JSONArray items = partnerJson.getJSONArray("items");
                    partnerJson = items.getJSONObject(0);
                    partner.get(i).setIdCompany(partnerJson.get("CompanyNumber").toString());
                    partner.get(i).setIdUser(getUserPartner(partner.get(i).getUserName()));
                    System.out.println("PARTNER ADD: " + partner.get(i).getOrganizationm() + "\tPARTNER COMPANY: " + partner.get(i).getIdCompany() + "\tPARTNER USER: " + partner.get(i).getIdUser());
                    httpClient.close();
                } else {
                    System.out.println("NO EXISTE ORGANIZACIÓN: " + partner.get(i).getOrganizationm());
                    httpClient.close();
                }
            } catch (JsonProcessingException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //escribirCSVOrganizaciones(partner, archivoEscritura);
    }
    public static void getPartnerVerificar(String nCompany) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + nCompany + "/child/contacts");
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String responseContact = EntityUtils.toString(response.getEntity());
            JSONObject partnerJson = new JSONObject(responseContact);
            if (Integer.parseInt(partnerJson.get("count").toString()) > 1) {
                System.out.println("Partner: " + nCompany);
            }
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static HtmlPage goToUrl(WebClient webClient, String url) {
        HtmlPage page = null;
        boolean fail = true;
        while (fail) {
            try {
                page = webClient.getPage(url);
                webClient.waitForBackgroundJavaScriptStartingBefore(1000);
                webClient.waitForBackgroundJavaScript(20000);
                fail = false;
            } catch (IOException ex) {
                System.err.println("ERROR: " + url);
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FailingHttpStatusCodeException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return page;
    }

    public static void verificarAcceso(String userName) {
        WebClient webClient = generateWebClient();
        HtmlPage page = goToUrl(webClient, "url/" + userName + "/url");
        //System.out.println("FILA: " + cont + " PAGINA: " + page.getUrl().toString().replace("%20", ""));
        //cont++;
    }

    public static void navegacionUsuario(String userName) {
        WebClient webClient = generateWebClient();
        HtmlPage page = goToUrl(webClient, "url/" + userName + "/url");
        HtmlForm form = page.getFormByName("loginForm");
        form.getInputByName("userid").setValueAttribute("mgomez");
        form.getInputByName("password").setValueAttribute("Soaint2018");
    }

    public static WebClient generateWebClient() {
        WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
        webClient.getBrowserVersion().setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36");
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setTimeout(20000);
        return webClient;
    }

    public static void getOppRUTc() {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            String aux = PropertiesReader.getURL() + PropertiesReader.getData() + "opportunities/9137/child/RutContratanteOpp_c?limit=500";
            HttpGet request = new HttpGet(aux);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String responseContact = EntityUtils.toString(response.getEntity());
            JSONObject partnerUser = new JSONObject(responseContact);
            JSONArray other = partnerUser.getJSONArray("items");
            for (int i = 0; i < other.length(); i++) {
                partnerUser = other.getJSONObject(i);
                deleteRUTC(partnerUser.getLong("Id"));
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteRUTC(Long idRUT) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpDelete request = new HttpDelete(PropertiesReader.getURL() + PropertiesReader.getData() + "opportunities/9137/child/RutContratanteOpp_c/" + idRUT);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == 204) {
                httpClient.close();
            } else {
                System.out.println(ANSI_RED_BACKGROUND + "FALLO BORRADO RUT C: " + idRUT + ANSI_RESET);
                httpClient.close();
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getOppRUTa() {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            String aux = PropertiesReader.getURL() + PropertiesReader.getData() + "opportunities/9137/child/RutAseguradosOpp_c?limit=500";
            HttpGet request = new HttpGet(aux);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String responseContact = EntityUtils.toString(response.getEntity());
            JSONObject partnerUser = new JSONObject(responseContact);
            JSONArray other = partnerUser.getJSONArray("items");
            for (int i = 0; i < other.length(); i++) {
                partnerUser = other.getJSONObject(i);
                deleteRUTa(partnerUser.getLong("Id"));
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteRUTa(Long idRUT) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpDelete request = new HttpDelete(PropertiesReader.getURL() + PropertiesReader.getData() + "opportunities/9137/child/RutAseguradosOpp_c/" + idRUT);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == 204) {
                httpClient.close();
            } else {
                System.out.println(ANSI_RED_BACKGROUND + "FALLO BORRADO RUT A: " + idRUT + ANSI_RESET);
                httpClient.close();
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getOppRUTd() {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            String aux = PropertiesReader.getURL() + PropertiesReader.getData() + "opportunities/9137/child/DuplicidadRUTOportunidad_c?limit=500";
            HttpGet request = new HttpGet(aux);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String responseContact = EntityUtils.toString(response.getEntity());
            JSONObject partnerUser = new JSONObject(responseContact);
            JSONArray other = partnerUser.getJSONArray("items");
            for (int i = 0; i < other.length(); i++) {
                partnerUser = other.getJSONObject(i);
                deleteRUTd(partnerUser.getLong("Id"));
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteRUTd(Long idRUT) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpDelete request = new HttpDelete(PropertiesReader.getURL() + PropertiesReader.getData() + "opportunities/9137/child/DuplicidadRUTOportunidad_c/" + idRUT);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == 204) {
                httpClient.close();
            } else {
                System.out.println(ANSI_RED_BACKGROUND + "FALLO BORRADO RUT D: " + idRUT + ANSI_RESET);
                httpClient.close();
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getRol() {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            String aux = PropertiesReader.getURL() + "hcmRestApi/scim/Roles";
            HttpGet request = new HttpGet(aux);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String responseRole = EntityUtils.toString(response.getEntity());
            JSONObject responseRoleObject = new JSONObject(responseRole);
            JSONArray resourcesRole = responseRoleObject.getJSONArray("Resources");
            boolean flag = true;
            for (int i = 0; i < resourcesRole.length() || flag; i++) {
                responseRoleObject = resourcesRole.getJSONObject(i);
                if (responseRoleObject.getString("name").equals("PER_EMPLOYEE_ABSTRACT")) {
                    resourcesRole = responseRoleObject.getJSONArray("members");
                    //printRolesID(resourcesRole);
                    flag = false;
                    break;
                }
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static void printRolesID(JSONArray array) throws IOException {
//        try {
//            ArrayList<ModelUser> model = new ArrayList();
//            ModelUser modelUser = null;
//            Members members = new Members();
//
//            for (int i = 0; i < array.length(); i++) {
//                modelUser = new ModelUser();
//                JSONObject objectValue = (JSONObject) array.get(i);
//                String aux = objectValue.get("value").toString();
//                modelUser.setValue(aux);
//                model.add(modelUser);
//            }
//            members.setMembers(model);
//
//            addUSERRole(model);
//        } catch (JsonProcessingException ex) {
//            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

//    public static void addUSERRole(ArrayList<ModelUser> members) throws UnsupportedEncodingException, IOException {
//        try {
//            CloseableHttpClient httpClient = HttpClients.createDefault();
//            HttpPatch request = new HttpPatch(PropertiesReader.getURL() + "hcmRestApi/scim/Roles/BD60C68F4E54469D91509AE80EBFF0F0");
//            Handlers.setHeaderForAll(request);
//            String aux = om.writeValueAsString(members);
//            String aux2 = "{\n"
//                    + "\"schemas\": [\n"
//                    + "\"urn:oracle:apps:scim:schemas:fa:1.0:Role\"\n"
//                    + "],\"members\":[" + aux + "]}";
//            StringEntity entity = new StringEntity(aux2);
//            System.out.println("AUX2 " + aux2);
//            request.setEntity(entity);
//            HttpResponse response = httpClient.execute(request);
//            System.out.println("RESPONSE: " + response.toString());
//        } catch (JsonProcessingException ex) {
//            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public static void getDealOpportunitie(String idDeal, ArrayList<Productos> productos) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            String aux = PropertiesReader.getURL() + PropertiesReader.getData() + "deals/" + idDeal;
            HttpGet request = new HttpGet(aux);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String responseProduct = EntityUtils.toString(response.getEntity());
            JSONObject product = new JSONObject(responseProduct);
            if (!product.get("OptyId").toString().isEmpty()) {
                httpClient.close();
                System.out.println("OPTYID: " + product.get("OptyNumber").toString());
                createProductOpportunitie(product.get("OptyNumber").toString(), productos);
            } else {
                System.out.println("DEAL SIN OPP: " + idDeal);
                httpClient.close();
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void createProductOpportunitie(String idOpp, ArrayList<Productos> productos) {
        for (int i = 0; i < productos.size(); i++) {
            int cont = 0;
            boolean flag = true;
            while (flag) {
                try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                    //om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                    String aux = PropertiesReader.getURL() + PropertiesReader.getData() + "opportunities/" + idOpp + "/child/ChildRevenue";
                    System.out.println(aux);
                    HttpPost request = new HttpPost(aux);
                    Handlers.setHeaderForAll(request);
                    String productoJSON = "{\n"
                            + "\t\"InventoryItemId\":" + productos.get(i).getInventoryItemId() + ",\n"
                            + "\t\"InventoryOrgId\":1,\n"
                            + "\t\"UnitPrice\":" + productos.get(i).getAmount() + ",\n"
                            + "\t\"Quantity\":1\n"
                            + "}";
                    System.out.println(productoJSON);
                    StringEntity entity = new StringEntity(Handlers.JsonTransformer(productoJSON));
                    request.setEntity(entity);
                    HttpResponse response = httpClient.execute(request);;
                    httpClient.close();

                    if (response.getStatusLine().getStatusCode() == 200 || response.getStatusLine().getStatusCode() == 201) {
                        flag = false;
                        System.out.println(ANSI_GREEN_BACKGROUND + "Creación correcta: " + idOpp + "\tId Producto: " + productos.get(i).getInventoryItemId() + "\tCantidad: " + productos.get(i).getAmount() + ANSI_RESET);
                    } else {
                        cont++;
                        if (cont == 8) {
                            flag = false;
                        }
                        System.out.println(ANSI_RED_BACKGROUND + "Fallo en creación: " + idOpp + "\tId Producto: " + productos.get(i).getInventoryItemId() + "\tCantidad: " + productos.get(i).getAmount() + ANSI_RESET);
                    }
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(MantenimientoCorrectivoUsuarios.class
                            .getName()).log(Level.SEVERE, null, ex);

                } catch (IOException ex) {
                    Logger.getLogger(MantenimientoCorrectivoUsuarios.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void getDeal(String idDeal, ArrayList<Productos> productos) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            String aux = PropertiesReader.getURL() + PropertiesReader.getData() + "deals/" + idDeal;
            HttpGet request = new HttpGet(aux);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String responseProduct = EntityUtils.toString(response.getEntity());
            JSONObject product = new JSONObject(responseProduct);
            if ("ORA_APPROVED".equals(product.get("StatusCode").toString())) {
                httpClient.close();
                getDealOpportunitie(idDeal, productos);
            } else {
                System.out.println("NO ACTUALIZABLE: " + idDeal);
                httpClient.close();
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getProduct(String idDeal, ArrayList<Productos> productos) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            String aux = PropertiesReader.getURL() + PropertiesReader.getData() + "deals/" + idDeal + "/child/DealProduct";
            HttpGet request = new HttpGet(aux);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String responseProduct = EntityUtils.toString(response.getEntity());
            JSONObject product = new JSONObject(responseProduct);
            if (Integer.parseInt(product.get("count").toString()) > 0) {
                httpClient.close();
                System.out.println("TIENE PRODUCTOS" + product.get("count"));
            } else {
                httpClient.close();
                System.out.println("NO TIENE PRODUCTOS" + product.get("count"));
                createProductDeal(idDeal, productos);
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void createProductDeal(String idDeal, ArrayList<Productos> productos) {
        for (int i = 0; i < productos.size(); i++) {
            //System.out.println("Identificador Deal: "+ idDeal + "\tProducto: " + productos.get(i).getInventoryItemId() + "\tOrganización: "+ productos.get(i).getOrganizationId()+ "\tAmount: "+productos.get(i).getAmount()+"\tQuantity: "+productos.get(i).getQuantity());

            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                //om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                String aux = PropertiesReader.getURL() + PropertiesReader.getData() + "deals/" + idDeal + "/child/DealProduct";
                HttpPost request = new HttpPost(aux);
                Handlers.setHeaderForAll(request);
                String productoJSON = "{\n"
                        + "\"InventoryItemId\":" + productos.get(i).getInventoryItemId() + ",\n"
                        + "\"InvOrgId\":1,\n"
                        + "\"Amount\":" + productos.get(i).getAmount() + ",\n"
                        + "\"Quantity\":1\n"
                        + "}";
                System.out.println(productoJSON + "\n\n" + idDeal);
                StringEntity entity = new StringEntity(Handlers.JsonTransformer(productoJSON));
                request.setEntity(entity);
                HttpResponse response = httpClient.execute(request);
                if (response.getStatusLine().getStatusCode() == 200 || response.getStatusLine().getStatusCode() == 201) {
                    System.out.println(ANSI_GREEN_BACKGROUND + "Creación correcta: " + idDeal + "\tId Producto: " + productos.get(i).getInventoryItemId() + "\tCantidad: " + productos.get(i).getAmount() + ANSI_RESET);
                } else {
                    System.out.println("FALLO: " + response.toString());
                    System.out.println(ANSI_RED_BACKGROUND + "Fallo en creación: " + idDeal + "\tId Producto: " + productos.get(i).getInventoryItemId() + "\tCantidad: " + productos.get(i).getAmount() + ANSI_RESET);
                }
            } catch (JsonProcessingException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class
                        .getName()).log(Level.SEVERE, null, ex);

            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class
                        .getName()).log(Level.SEVERE, null, ex);

            } catch (IOException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void getPartnerNcompany(String agenteId) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/?q=PartnerProfilePEO_CodigoAgenteCorredor_c=" + agenteId);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String reponseString = EntityUtils.toString(response.getEntity());
            JSONObject responseObject = new JSONObject(reponseString);
            JSONArray items = responseObject.getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                responseObject = items.getJSONObject(i);
                if (responseObject.getString("name").equals("PER_EMPLOYEE_ABSTRACT")) {
                    //resourcesRole = responseObject.getJSONArray("members");

                }
            }

        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void getPartners(List<String> codigoAgente) throws FileNotFoundException {
        ArrayList<PartnerJson> partners = new ArrayList<PartnerJson>();
        System.out.println("CREANDO ARRAYLIST DE DATOS");
        for (int y = 0; y < codigoAgente.size(); y++) {
            System.out.println("Codigo agente: " + codigoAgente.get(y));
            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/?q=PartnerProfilePEO_CodigoAgenteCorredor_c=" + codigoAgente.get(y));
                Handlers.setHeaderForAll(request);
                HttpResponse response = httpClient.execute(request);
                String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
                JSONObject responseObject = new JSONObject(reponseString);
                int count = responseObject.getInt("count");
                if (count != 0) {
                    JSONArray items = responseObject.getJSONArray("items");
                    PartnerJson partner = null;
                    for (int i = 0; i < items.length(); i++) {
                        responseObject = items.getJSONObject(i);
                        partner = new PartnerJson();
                        partner.setPartnerProfilePEO_NumeroInscripcionCorredor_c(responseObject.getInt("PartnerProfilePEO_NumeroInscripcionCorredor_c"));
                        partner.setPartnerProfilePEO_CodigoAgenteCorredor_c(responseObject.get("PartnerProfilePEO_CodigoAgenteCorredor_c"));
                        partner.setPartnerProfilePEO_RUTCorredor_c(responseObject.getString("PartnerProfilePEO_RUTCorredor_c"));
                        partner.setPartnerProfilePEO_DvCorredor_c(responseObject.get("PartnerProfilePEO_DvCorredor_c"));
                        partner.setOrganizationName(responseObject.getString("OrganizationName"));
                        partner.setPartnerProfilePEO_ZonaCorredores_c(responseObject.get("PartnerProfilePEO_ZonaCorredores_c"));
                        partner.setPartnerProfilePEO_SucursalCorredores_c(responseObject.get("PartnerProfilePEO_SucursalCorredores_c"));
                        partner.setOwnerName(responseObject.getString("OwnerName"));
                        partner.setPartnerProfilePEO_AsignadoPorGR_c(responseObject.get("PartnerProfilePEO_ACRAsignadoPorGR_c"));
                        partner.setPartnerProfilePEO_SegmentoCorredor_c(responseObject.get("PartnerProfilePEO_SegmentoCorredor_c"));
                        partner.setPartnerProfilePEO_InspeccionesCorredor_c(responseObject.get("PartnerProfilePEO_InspeccionesCorredor_c"));
                        partner.setPartnerProfilePEO_SiniestrosCorredor_c(responseObject.get("PartnerProfilePEO_SiniestrosCorredor_c"));
                        partner.setPartnerProfilePEO_ComisionesCorredor_c(responseObject.get("PartnerProfilePEO_ComisionesCorredor_c"));
                        partner.setPartnerProfilePEO_CobranzaCorredor_c(responseObject.get("PartnerProfilePEO_CobranzaCorredor_c"));
                        partner.setPartnerProfilePEO_CampanasMarketingCorredor_c(responseObject.get("PartnerProfilePEO_CampanasMarketingCorredor_c"));
                        partner.setPartnerProfilePEO_ComunicacionesComercialesCorredor_c(responseObject.get("PartnerProfilePEO_ComunicacionesComercialesCorredor_c"));
                        partner.setPartnerProfilePEO_ProduccionCorredor_c(responseObject.get("PartnerProfilePEO_ProduccionCorredor_c"));
                        partner.setPartnerProfilePEO_TipoCorredor_c(responseObject.get("PartnerProfilePEO_TipoCorredor_c"));
                        partner.setStatus(responseObject.getString("Status"));
                        partner.setPhoneNumber(responseObject.get("PhoneNumber"));
                        partner.setPartnerProfilePEO_AtributoTributarioCorredor_c(responseObject.get("PartnerProfilePEO_AtributoTributarioCorredor_c"));
                        partners.add(partner);
                    }
                } else {
                    System.out.println(ANSI_RED_BACKGROUND + "NO EXISTE ESTE PARTNER: " + codigoAgente + ANSI_RESET);
                }
            } catch (JsonProcessingException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        escribirCSVOrganizaciones(partners);
    }

    public static void getPartner(String codigoAgente, Long grId, String grNumber, Long acrId, String acrNumber, String sucursal) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/?q=PartnerProfilePEO_CodigoAgenteCorredor_c=" + codigoAgente);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONObject responseObject = new JSONObject(reponseString);
            if (Integer.parseInt(responseObject.get("count").toString()) != 0) {
                JSONArray items = responseObject.getJSONArray("items");
                for (int i = 0; i < items.length(); i++) {
                    responseObject = items.getJSONObject(i);
                    getResource(responseObject.getString("CompanyNumber"), grNumber, acrId, sucursal);
                    getAccountTeamMembersPartner(responseObject.getString("CompanyNumber"), grId, grNumber, acrId, acrNumber);
                }
            } else {
                System.out.println(ANSI_RED_BACKGROUND + "NO EXITE EL PARTNER CON CÓDIGO AGENTE: " + codigoAgente + ANSI_RESET);
            }
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getPartnerNOTACR(String codigoAgente, Long grId, String grNumber, String sucursal) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/?q=PartnerProfilePEO_CodigoAgenteCorredor_c=" + codigoAgente);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONObject responseObject = new JSONObject(reponseString);
            if (Integer.parseInt(responseObject.get("count").toString()) != 0) {
                JSONArray items = responseObject.getJSONArray("items");
                for (int i = 0; i < items.length(); i++) {
                    responseObject = items.getJSONObject(i);
                    updatePartnerNOTACR(responseObject.getString("CompanyNumber"), grNumber, sucursal);
                    getAccountTeamMembersPartnerNOTACR(responseObject.getString("CompanyNumber"), grId, grNumber);
                }
            } else {
                System.out.println(ANSI_RED_BACKGROUND + "NO EXITE EL PARTNER CON CÓDIGO AGENTE: " + codigoAgente + ANSI_RESET);
            }
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getResource(String ncompany, String grNumber, Long acrId, String sucursal) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + "resources?q=PartyId=" + acrId);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONObject responseObject = new JSONObject(reponseString);
            JSONArray items = responseObject.getJSONArray("items");
            responseObject = items.getJSONObject(0);
            updatePartner(ncompany, grNumber, acrId, responseObject.get("PartyName").toString(), sucursal);
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updatePartner(String ncompany, String grNumber, Long acrId, String nameACR, String sucursal) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPatch request = new HttpPatch(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + ncompany);
            Handlers.setHeaderForAll(request);
            String jsonSend = "{\n"
                    + "\"PartnerProfilePEO_ACRAsignadoPorGR_c\": \"" + nameACR + "\",\n"
                    + "\"PartnerProfilePEO_SucursalCorredores_c\": \"" + sucursal + "\",\n"
                    + "\"OwnerPartyNumber\": \"" + grNumber + "\"\n"
                    + "}";
            StringEntity entity = new StringEntity(Handlers.JsonTransformer(jsonSend));
            request.setEntity(entity);
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println(ANSI_GREEN_BACKGROUND + "ACTUALIZADO PARTNER: " + ncompany + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED_BACKGROUND + "NO ACTUALIZADO PARTNER: " + ncompany + "\tSTATUS: " + response.getStatusLine().getStatusCode() + ANSI_RESET);
            }
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getAccountTeamMembersPartner(String ncompany, Long grId, String grNumber, Long acrId, String acrNumber) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + ncompany + "/child/accountTeamMembers");
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONObject responseObject = new JSONObject(reponseString);
            JSONArray items = responseObject.getJSONArray("items");
            ArrayList<TeamPartner> teamAll = new ArrayList<>();
            TeamPartner team = null;
            for (int i = 0; i < items.length(); i++) {
                responseObject = items.getJSONObject(i);
                team = new TeamPartner();
                team.setPartnerAccountResourceId(responseObject.getLong("PartnerAccountResourceId"));
                team.setResourceId(responseObject.getLong("ResourceId"));
                if (!responseObject.get("OrganizationRole").equals(null)) {
                    team.setOrganizationRole(responseObject.getString("OrganizationRole"));
                }
                team.setAccessLevelCode(responseObject.getString("AccessLevelCode"));
                team.setAssignmentTypeCode(responseObject.getString("AssignmentTypeCode"));
                if (!responseObject.get("MemberFunctionCode").equals(null)) {
                    team.setMemberFunctionCode(responseObject.getString("MemberFunctionCode"));
                }
                team.setOwnerIndicator(responseObject.getString("OwnerIndicator"));
                team.setResourcePartyNumber(responseObject.getString("ResourcePartyNumber"));
                teamAll.add(team);
            }
            httpClient.close();
            deleteGRAccountTeamMembersPartner(ncompany, teamAll, grId, grNumber);
            //deleteACRAccountTeamMembersPartner(ncompany, teamAll, acrId, acrNumber);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void createGRAccountTeamMember(String ncompany, Long grId) {
        try {
            //om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost request = new HttpPost(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + ncompany + "/child/accountTeamMembers");
            Handlers.setHeaderForAll(request);
            String jsonUserName = "{\n"
                    + "	\"ResourceId\": " + grId + ",\n"
                    + "	\"OrganizationRole\": \"Gerente de Red\",\n"
                    + "	\"AccessLevelCode\": \"300\",\n"
                    + "	\"AssignmentTypeCode\": \"MANUAL\",\n"
                    + "	\"MemberFunctionCode\": \"GR_REALE\",\n"
                    + "	\"OwnerIndicator\": \"Y\"\n"
                    + "}";
            StringEntity entity = new StringEntity(Handlers.JsonTransformer(jsonUserName));
            request.setEntity(entity);
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == 200 || response.getStatusLine().getStatusCode() == 201) {
                System.out.println(ANSI_GREEN_BACKGROUND + "CREADO GR EN PARTNER: " + ncompany + ANSI_RESET);
            } else {
                if (response.getStatusLine().getStatusCode() == 404) {
                    System.out.println(ANSI_GREEN_BACKGROUND + "YA EXISTE EL GR EN PARTNER: " + ncompany + ANSI_RESET);
                } else {
                    System.out.println(ANSI_RED_BACKGROUND + "FALLO CREADO GR EN PARTNER: " + ncompany + "\tSTATUS: " + response.getStatusLine().getStatusCode() + ANSI_RESET);
                }
            }
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void createACRAccountTeamMember(String ncompany, Long acrId) {
        try {
            //om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost request = new HttpPost(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + ncompany + "/child/accountTeamMembers");
            Handlers.setHeaderForAll(request);
            String jsonUserName = "{\n"
                    + "	\"ResourceId\": " + acrId + ",\n"
                    + "	\"OrganizationRole\": \"ACR\",\n"
                    + "	\"AccessLevelCode\": \"300\",\n"
                    + "	\"AssignmentTypeCode\": \"MANUAL\",\n"
                    + "	\"MemberFunctionCode\": \"ACR_REALE\",\n"
                    + "	\"OwnerIndicator\": \"N\"\n"
                    + "}";
            StringEntity entity = new StringEntity(Handlers.JsonTransformer(jsonUserName));
            request.setEntity(entity);
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == 200 || response.getStatusLine().getStatusCode() == 201) {
                System.out.println(ANSI_GREEN_BACKGROUND + "CREADO ACR EN PARTNER: " + ncompany + ANSI_RESET);
            } else {
                if (response.getStatusLine().getStatusCode() == 404) {
                    System.out.println(ANSI_GREEN_BACKGROUND + "YA EXISTE EL ACR EN PARTNER: " + ncompany + ANSI_RESET);
                } else {
                    System.out.println(ANSI_RED_BACKGROUND + "FALLO CREADO ACR EN PARTNER: " + ncompany + "\tSTATUS: " + response.getStatusLine().getStatusCode() + ANSI_RESET);
                }
            }
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void deleteACRAccountTeamMembersPartner(String ncompany, Long acrId) {
        /*for (int i = 0; i < team.size(); i++) {
            if (!team.get(i).getResourceId().equals(acrId)) {
                createACRAccountTeamMember(ncompany, acrId);*/
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpDelete request = new HttpDelete(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + ncompany + "/child/accountTeamMembers/" + acrId);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == 204) {
                System.out.println(ANSI_GREEN_BACKGROUND + "BORRADO ACR PARTNER: " + ncompany + ANSI_RESET);
            } else {
                if (response.getStatusLine().getStatusCode() == 404) {
                    System.out.println(ANSI_RED_BACKGROUND + "NO EXISTE ACR PARTNER: " + ncompany + ANSI_RESET);
                } else {
                    System.out.println(ANSI_RED_BACKGROUND + "FALLO BORRADO ACR PARTNER: " + ncompany + "\tSTATUS: " + response.getStatusLine().getStatusCode() + ANSI_RESET);
                }
            }
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* }
        }*/
    }

    public static void deleteGRAccountTeamMembersPartner(String ncompany, ArrayList<TeamPartner> team, Long grId, String grNumber) {
        for (int i = 0; i < team.size(); i++) {
            if (!team.get(i).getResourceId().equals(grId)) {
                createGRAccountTeamMember(ncompany, grId);
                try {
                    CloseableHttpClient httpClient = HttpClients.createDefault();
                    HttpDelete request = new HttpDelete(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + ncompany + "/child/accountTeamMembers/" + team.get(i).getPartnerAccountResourceId());
                    Handlers.setHeaderForAll(request);
                    HttpResponse response = httpClient.execute(request);
                    if (response.getStatusLine().getStatusCode() == 204) {
                        System.out.println(ANSI_GREEN_BACKGROUND + "BORRADO GR PARTNER: " + ncompany + ANSI_RESET);
                    } else {
                        if (response.getStatusLine().getStatusCode() == 404) {
                            System.out.println(ANSI_RED_BACKGROUND + "NO EXISTE GR PARTNER: " + ncompany + ANSI_RESET);
                        } else {
                            System.out.println(ANSI_RED_BACKGROUND + "FALLO BORRADO GR PARTNER: " + ncompany + "\tSTATUS: " + response.getStatusLine().getStatusCode() + ANSI_RESET);
                        }
                    }
                    httpClient.close();
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println(ANSI_GREEN_BACKGROUND + "YA EXISTE EL GR EN PARTNER: " + ncompany + ANSI_RESET);
            }
        }
    }



    public static void updatePartnerNOTACR(String ncompany, String grNumber, String sucursal) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPatch request = new HttpPatch(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + ncompany);
            Handlers.setHeaderForAll(request);
            String jsonSend = "{\n"
                    + "\"PartnerProfilePEO_ACRAsignadoPorGR_c\": null,\n"
                    + "\"PartnerProfilePEO_SucursalCorredores_c\": \"" + sucursal + "\",\n"
                    + "\"OwnerPartyNumber\": \"" + grNumber + "\"\n"
                    + "}";
            StringEntity entity = new StringEntity(Handlers.JsonTransformer(jsonSend));
            request.setEntity(entity);
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println(ANSI_GREEN_BACKGROUND + "ACTUALIZADO PARTNER: " + ncompany + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED_BACKGROUND + "NO ACTUALIZADO PARTNER: " + ncompany + "\tSTATUS: " + response.getStatusLine().getStatusCode() + ANSI_RESET);
            }
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getAccountTeamMembersPartnerNOTACR(String ncompany, Long grId, String grNumber) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + ncompany + "/child/accountTeamMembers");
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONObject responseObject = new JSONObject(reponseString);
            JSONArray items = responseObject.getJSONArray("items");
            ArrayList<TeamPartner> teamAll = new ArrayList<>();
            TeamPartner team = null;
            for (int i = 0; i < items.length(); i++) {
                responseObject = items.getJSONObject(i);
                team = new TeamPartner();
                team.setPartnerAccountResourceId(responseObject.getLong("PartnerAccountResourceId"));
                team.setResourceId(responseObject.getLong("ResourceId"));
                if (!responseObject.get("OrganizationRole").equals(null)) {
                    team.setOrganizationRole(responseObject.getString("OrganizationRole"));
                }
                team.setAccessLevelCode(responseObject.getString("AccessLevelCode"));
                team.setAssignmentTypeCode(responseObject.getString("AssignmentTypeCode"));
                if (!responseObject.get("OrganizationRole").equals(null)) {
                    team.setMemberFunctionCode(responseObject.get("MemberFunctionCode"));
                }
                team.setOwnerIndicator(responseObject.getString("OwnerIndicator"));
                team.setResourcePartyNumber(responseObject.getString("ResourcePartyNumber"));
                teamAll.add(team);
            }
            httpClient.close();
            deleteGRAccountTeamMembersPartner(ncompany, teamAll, grId, grNumber);
            deleteACRAccountTeamMembersPartnerNOTACR(ncompany, teamAll);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteACRAccountTeamMembersPartnerNOTACR(String ncompany, ArrayList<TeamPartner> team) {
        for (int i = 0; i < team.size(); i++) {
            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                HttpDelete request = new HttpDelete(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + ncompany + "/child/accountTeamMembers/" + team.get(i).getPartnerAccountResourceId());
                Handlers.setHeaderForAll(request);
                HttpResponse response = httpClient.execute(request);
                if (response.getStatusLine().getStatusCode() == 204) {
                    System.out.println(ANSI_GREEN_BACKGROUND + "BORRADO ACR PARTNER: " + ncompany + ANSI_RESET);
                } else {
                    if (response.getStatusLine().getStatusCode() == 404) {
                        System.out.println(ANSI_RED_BACKGROUND + "NO EXISTE ACR PARTNER: " + ncompany + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED_BACKGROUND + "FALLO BORRADO ACR PARTNER: " + ncompany + "\tSTATUS: " + response.getStatusLine().getStatusCode() + ANSI_RESET);
                    }
                }
                httpClient.close();
            } catch (JsonProcessingException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String getResourceACR(Long id) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + "resources?q=PartyId=" + id);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONObject responseObject = new JSONObject(reponseString);
            JSONArray items = responseObject.getJSONArray("items");
            responseObject = items.getJSONObject(0);
            httpClient.close();
            return responseObject.get("PartyName").toString();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "NO EXISTE ACR";
    }

    public static String getResourceGR(Long id) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + "resources?q=PartyId=" + id);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONObject responseObject = new JSONObject(reponseString);
            JSONArray items = responseObject.getJSONArray("items");
            responseObject = items.getJSONObject(0);
            httpClient.close();
            return responseObject.get("PartyName").toString();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "NO EXISTE GR";
    }

    public static void getPartnerData(String codigoAgente, Long idGr, String sucursalField) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/?q=PartnerProfilePEO_CodigoAgenteCorredor_c=" + codigoAgente);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONObject responseObject = new JSONObject(reponseString);
            if (Integer.parseInt(responseObject.get("count").toString()) != 0) {
                JSONArray items = responseObject.getJSONArray("items");
                for (int i = 0; i < items.length(); i++) {
                    responseObject = items.getJSONObject(i);
                    if (responseObject.get("PartnerProfilePEO_ACRAsignadoPorGR_c").equals(null) || responseObject.get("PartnerProfilePEO_ACRAsignadoPorGR_c") == null) {
                        verificarDatosActualizadosPartner(responseObject.getString("OwnerName"), responseObject.getString("PartnerProfilePEO_SucursalCorredores_c"), idGr, sucursalField, codigoAgente);
                    } else {
                        updatePartner(getPartner(codigoAgente), codigoAgente, idGr, sucursalField);
                        System.out.println(ANSI_RED_BACKGROUND + "CONTIENE ACR Y NO DEBERÍA: " + codigoAgente + "\tNCOMPANY: " + getPartner(codigoAgente) + ANSI_RESET);
                    }
                }
            } else {
                System.out.println(ANSI_RED_BACKGROUND + "NO EXITE EL PARTNER CON CÓDIGO AGENTE: " + codigoAgente + ANSI_RESET);
            }
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updatePartner(String ncompany, String codigoAgente, Long idGr, String sucursalField) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPatch request = new HttpPatch(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + ncompany);
            Handlers.setHeaderForAll(request);
            String jsonSend = "{\"PartnerProfilePEO_ACRAsignadoPorGR_c\": null}";
            StringEntity entity = new StringEntity(Handlers.JsonTransformer(jsonSend));
            request.setEntity(entity);
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println(ANSI_GREEN_BACKGROUND + "ACTUALIZADO PARTNER: " + ncompany + ANSI_RESET);
                getPartnerData(codigoAgente, idGr, sucursalField);
            } else {
                System.out.println(ANSI_RED_BACKGROUND + "NO ACTUALIZADO PARTNER: " + ncompany + "\tSTATUS: " + response.getStatusLine().getStatusCode() + ANSI_RESET);
            }
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getPartner(String codigoAgente) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/?q=PartnerProfilePEO_CodigoAgenteCorredor_c=" + codigoAgente);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONObject responseObject = new JSONObject(reponseString);
            if (Integer.parseInt(responseObject.get("count").toString()) != 0) {
                JSONArray items = responseObject.getJSONArray("items");
                responseObject = items.getJSONObject(0);
                return responseObject.get("CompanyNumber").toString();
            } else {
                return ANSI_RED_BACKGROUND + "NO EXITE EL PARTNER CON CÓDIGO AGENTE: " + codigoAgente + ANSI_RESET;
            }

        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ANSI_RED_BACKGROUND + "FALLO AL HACER GET DEL PARTNER" + ANSI_RESET;
    }

    public static void verificarDatosActualizadosPartner(String owner, String sucursal, Long idGr, String sucursalField, String codigoAgente) {
        if (owner.equals(getResourceGR(idGr)) && sucursal.equals(sucursalField)) {
            System.out.println(ANSI_GREEN_BACKGROUND + "EL PARTNER CON CÓDIGO AGENTE ESTA BIEN: " + codigoAgente + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED_BACKGROUND + "EL PARTNER CON CÓDIGO AGENTE ESTA MAL: " + codigoAgente + "\tNCOMPANY: " + getPartner(codigoAgente) + ANSI_RESET);
        }
        getAccountTeamMembersPartner(getPartner(codigoAgente), idGr, codigoAgente);
    }

    public static void getAccountTeamMembersPartner(String ncompany, Long idGr, String codigoAgente) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + ncompany + "/child/accountTeamMembers");
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONObject responseObject = new JSONObject(reponseString);
            JSONArray items = responseObject.getJSONArray("items");
            String acrResponse = "";
            String grResponse = "";
            for (int i = 0; i < items.length(); i++) {
                responseObject = items.getJSONObject(i);
                if (responseObject.get("MemberFunctionCode") != null || responseObject.get("OrganizationRole") != null) {
                    if (responseObject.get("MemberFunctionCode").equals("GR_REALE") || responseObject.get("OrganizationRole").equals("Gerente de Red")) {
                        grResponse = responseObject.getString("ResourceName");
                    } else {
                        if (responseObject.get("MemberFunctionCode").equals("ACR_REALE") || responseObject.get("OrganizationRole").equals("ACR")) {
                            acrResponse = responseObject.getString("ResourceName");
                            System.out.println("TIENE ACR EN SU EQUIPO");
                            deleteACRAccountTeamMembersPartner(ncompany, responseObject.getLong("PartnerAccountResourceId"));
                        } else {
                            System.out.println(ANSI_RED_BACKGROUND + "FALLO, NINGUNO COINCIDE EQUIPO" + ANSI_RESET);
                            if (responseObject.get("ResourceId").equals(idGr)) {
                                updateGR(ncompany, responseObject.get("PartnerAccountResourceId").toString());
                            }
                        }
                    }
                } else {
                    System.out.println(ANSI_RED_BACKGROUND + "FALLO, TODO NULO EQUIPO" + ANSI_RESET);
                }
            }
            verificarDatosActualizadosTeamPartner(grResponse, idGr, codigoAgente);
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void verificarDatosActualizadosTeamPartner(String grResponse, Long idGr, String codigoAgente) {
        if (grResponse.equals(getResourceGR(idGr))) {
            System.out.println(ANSI_GREEN_BACKGROUND + "EL EQUIPO DEL PARTNER CON CÓDIGO AGENTE ESTA BIEN: " + codigoAgente + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED_BACKGROUND + "EL EQUIPO DEL PARTNER CON CÓDIGO AGENTE ESTA MAL: " + codigoAgente + ANSI_RESET);
        }
    }

    public static void updateGR(String ncompany, String idProfileGR) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPatch request = new HttpPatch(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + ncompany + "/child/accountTeamMembers/" + idProfileGR);
            Handlers.setHeaderForAll(request);
            String role = Handlers.JsonTransformerESPECIAL("Gerente Técnico");
            String jsonSend = "{\n"
                    + "	\"OrganizationRole\": \"" + role + "\",\n"
                    + "\"MemberFunctionCode\": \"GR_REALE\"\n"
                    + "}";
            StringEntity entity = new StringEntity(Handlers.JsonTransformer(jsonSend));
            request.setEntity(entity);
            HttpResponse response = httpClient.execute(request);
            String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONObject responseObject = new JSONObject(reponseString);
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println(ANSI_GREEN_BACKGROUND + "Role: " + responseObject.get("OrganizationRole") + "\tCode: " + responseObject.get("MemberFunctionCode") + ANSI_RESET);
                System.out.println(ANSI_GREEN_BACKGROUND + "ACTUALIZADO COMPANY: " + ncompany + "\tGR: " + idProfileGR + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED_BACKGROUND + "NO ACTUALIZADO COMPANY: " + ncompany + "\tGR: " + idProfileGR + "\tSTATUS: " + response.getStatusLine().getStatusCode() + ANSI_RESET);
            }
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Object getAccountTeamMembersPartnerGR(String ncompany) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + ncompany + "/child/accountTeamMembers");
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONObject responseObject = new JSONObject(reponseString);
            JSONArray items = responseObject.getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                responseObject = items.getJSONObject(i);
                if (responseObject.get("MemberFunctionCode") != null || responseObject.get("OrganizationRole") != null) {
                    if (responseObject.get("MemberFunctionCode").equals("GR_REALE") || responseObject.get("OrganizationRole").equals("Gerente de Red")) {
                        return responseObject.get("PartnerAccountResourceId");
                    }
                } else {
                    return "FALLO";
                }
            }
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "FALLO";
    }

    public static Object getPartners(String ncompany) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + ncompany + "/child/accountTeamMembers");
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONObject responseObject = new JSONObject(reponseString);
            JSONArray items = responseObject.getJSONArray("items");
            for (int i = 0; i < items.length(); i++) {
                responseObject = items.getJSONObject(i);
                if (responseObject.get("MemberFunctionCode") != null || responseObject.get("OrganizationRole") != null) {
                    if (responseObject.get("MemberFunctionCode").equals("GR_REALE") || responseObject.get("OrganizationRole").equals("Gerente de Red")) {
                        return responseObject.get("PartnerAccountResourceId");
                    }
                } else {
                    return "FALLO";
                }
            }
            httpClient.close();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "FALLO";
    }
    public static void getLeadsHisto(ArrayList<LeadGod> leads) throws FileNotFoundException {
        int count = 1;
        for (int i = 0; i < leads.size(); i++) {
            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getLeads() + "?q=OwnerId=" + leads.get(i).getOwnerId() + ";PartnerId=" + leads.get(i).getPartnerId() + ";Name=" + leads.get(i).getName() + ";ExpirationDate=" + leads.get(i).getExpirationDate());
                Handlers.setHeaderForAll(request);
                HttpResponse response = httpClient.execute(request);
                String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
                JSONObject responseObject = new JSONObject(reponseString);
                JSONArray items = responseObject.getJSONArray("items");
                if (items.length() > 0) {
                    System.out.println("-------------------------------------------------------------------------------------");
                    responseObject = items.getJSONObject(0);
                    leads.get(i).setLeadNumber(responseObject.get("LeadNumber").toString());
                    System.out.println("FILA: " + count);
                    System.out.println("-------------------------------------------------------------------------------------");

                } else {
                    System.out.println("-------------------------------------------------------------------------------------");
                    System.out.println(ANSI_RED_BACKGROUND + "SIN COINCIDENCIAS" + ANSI_RESET);
                    leads.get(i).setLeadNumber("SIN COINCIDENCIA");
                    System.out.println("FILA: " + count);
                    System.out.println("-------------------------------------------------------------------------------------");
                }

                count++;
                httpClient.close();
            } catch (JsonProcessingException ex) {
                WriteCSV.escribirCSVLeads(leads);
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                WriteCSV.escribirCSVLeads(leads);
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                WriteCSV.escribirCSVLeads(leads);
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        WriteCSV.escribirCSVLeads(leads);
    }
    
    
//    public static Object getParatnersWhitSucursales() {
//        try {
//            CloseableHttpClient httpClient = HttpClients.createDefault();
//            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "?q=PartnerProfilePEO_SucursalCorredores_Id_c=300000012110895&limit=500");
//            Handlers.setHeaderForAll(request);
//            HttpResponse response = httpClient.execute(request);
//            String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
//            JSONObject responseObject = new JSONObject(reponseString);
//            JSONArray items = responseObject.getJSONArray("items");
//            for (int i = 0; i < items.length(); i++) {
//                responseObject = items.getJSONObject(i);
//                updatePartnerSucursal(responseObject.getString("CompanyNumber"));
//            }
//            httpClient.close();
//        } catch (JsonProcessingException ex) {
//            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(MantenimientoCorrectivoUsuarios.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return "FALLO";
//    }

//    public static void updatePartnerSucursal() throws IOException {
//        for (int i = 0; i < numero.length; i++) {
//            PartnerJson partner = getPartnerData(numero[i]);
//            System.out.println("Sucursal: " + partner.getPartnerProfilePEO_SucursalCorredores_c() + "\tZona: " + partner.getPartnerProfilePEO_ZonaCorredores_c());
//            String jsonSend = "";
//            if (partner.getPartnerProfilePEO_SucursalCorredores_c() != null && partner.getPartnerProfilePEO_ZonaCorredores_c() != null) {
//                jsonSend = "{\n\t\"PartnerProfilePEO_Sucursal_c\": \"" + Handlers.JsonTransformer(getPartnerData(numero[i]).getPartnerProfilePEO_SucursalCorredores_c().toString()) + "\",\n"
//                        + "\t\"PartnerProfilePEO_Zona_c\": \"" + Handlers.JsonTransformer(getPartnerData(numero[i]).getPartnerProfilePEO_ZonaCorredores_c().toString()) + "\"\n}";
//            } else {
//                if (partner.getPartnerProfilePEO_SucursalCorredores_c() != null) {
//                    jsonSend = "{\n\t\"PartnerProfilePEO_Sucursal_c\": \"" + Handlers.JsonTransformer(getPartnerData(numero[i]).getPartnerProfilePEO_SucursalCorredores_c().toString()) + "\n}";
//
//                } else {
//                    if (partner.getPartnerProfilePEO_ZonaCorredores_c() != null) {
//                        jsonSend = "{\n\t\"PartnerProfilePEO_Zona_c\": \"" + Handlers.JsonTransformer(getPartnerData(numero[i]).getPartnerProfilePEO_ZonaCorredores_c().toString()) + "\"\n}";
//                    }
//                }
//
//            }
//            callService(jsonSend, numero[i]);
//        }
//    }

    public static void callService(String jsonSend, int i) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String urlConect = PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + i;
        HttpPatch request = new HttpPatch(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + i);
        Handlers.setHeaderForAll(request);
        StringEntity entity = new StringEntity(Handlers.JsonTransformer(jsonSend));
        request.setEntity(entity);
        HttpResponse response = httpClient.execute(request);
        if (response.getStatusLine().getStatusCode() == 200) {
            System.out.println(ANSI_GREEN_BACKGROUND + "CORREDOR ACTUALIZADO: " + i + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED_BACKGROUND + "CORREDOR NO ACTUALIZADO: " + i + ANSI_RESET);
        }
        httpClient.close();
    }

    public static PartnerJson getPartnerData(int numero) {
        PartnerJson partner = new PartnerJson();
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(PropertiesReader.getURL() + PropertiesReader.getData() + PropertiesReader.getPartners() + "/" + numero);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            JSONObject responseObject = new JSONObject(reponseString);
            httpClient.close();
            partner.setPartnerProfilePEO_SucursalCorredores_c(responseObject.get("PartnerProfilePEO_SucursalCorredores_c"));
            partner.setPartnerProfilePEO_ZonaCorredores_c(responseObject.get("PartnerProfilePEO_ZonaCorredores_c"));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return partner;
    }
    public static void leerCSVActualizacion() {
        String archivo = "C:\\Users\\marco\\Desktop\\update.csv";
        String line = "";
        int cont = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while ((line = br.readLine()) != null) {
                line = line.replace("\"", "");
                line = line.replace("\n", "");
                String data[] = line.split(SEPARATOR);
                System.out.println("----------------------------------------------------------------------------------------------FILA: " + cont + "--------------------------------------------------------------------------------------------------------------");
                getResourceUser(data[0], data[1]);
                cont++;
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getResourceUser(String userName, String cagente) {
        try {
            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                HttpGet request = new HttpGet("domainCloud:443/crmRestApi/resources/latest/resourceUsers?q=Username=" + userName);
                Handlers.setHeaderForAll(request);
                HttpResponse response = httpClient.execute(request);
                String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
                JSONObject responseObject = new JSONObject(reponseString);
                JSONArray items = responseObject.getJSONArray("items");
                if (items.length() > 0) {
                    responseObject = items.getJSONObject(0);
                    System.out.println(ANSI_GREEN_BACKGROUND + "AGENTE ENCONTRADO: " + responseObject.get("Username").toString() + ANSI_RESET);
                    updateResourceUser(cagente, responseObject.get("ResourcePartyNumber").toString());
                } else {
                    System.out.println(ANSI_RED_BACKGROUND + "AGENTE NO ENCONTRADO: " + userName + ANSI_RESET);
                }
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MantenimientoCorrectivoUsuarios.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateResourceUser(String cagente, String idUser) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String urlConect = "domainCloud:443/crmRestApi/resources/latest/resourceUsers/" + idUser;
            HttpPatch request = new HttpPatch(urlConect);
            Handlers.setHeaderForAll(request);
            String jsonSend = "{\n"
                    + "\"CodigosAgente_c\":\"" + cagente + "\" \n"
                    + "}";
            StringEntity entity = new StringEntity(Handlers.JsonTransformer(jsonSend));
            request.setEntity(entity);
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println(ANSI_GREEN_BACKGROUND + "AGENTE ACTUALIZADO: " + cagente + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED_BACKGROUND + "AGENTE NO ACTUALIZADO: " + cagente + ANSI_RESET);
            }
        }
    }

    public static void getDeal() {
        for (int i = 13979; i < 20000; i++) {
            try {
                try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                    HttpGet request = new HttpGet("domainCloud:443/crmRestApi/resources/latest/deals?q=DealNumber=R00" + i);
                    Handlers.setHeaderForAll(request);
                    HttpResponse response = httpClient.execute(request);
                    String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
                    JSONObject responseObject = new JSONObject(reponseString);
                    JSONArray items = responseObject.getJSONArray("items");
                    if (items.length() > 0) {
                        System.out.println(ANSI_RED_BACKGROUND + "RESERVA EXISTENTE: R00" + i + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_GREEN_BACKGROUND + "RESERVA NO EXISTE: R00" + i + ANSI_RESET);
                    }
                }
            } catch (JsonProcessingException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MantenimientoCorrectivoUsuarios.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
