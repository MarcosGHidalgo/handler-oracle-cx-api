/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Jorge
 */
public class MantenimientoCorrectivoUsuarios {

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RESET = "\u001B[0m";

//    public static void getLeads() {
//        try {
//            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//                int aux = 0;
//                do {
//                    HttpGet request = new HttpGet("yourDomain:443/crmRestApi/resources/latest/leads?q=IdentificadorReservaToProspecto_c!=null;StatusCode=UNQUALIFIED&limit=500");
//                    Handlers.setHeaderForAll(request);
//                    HttpResponse response = httpClient.execute(request);
//                    String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
//                    JSONObject responseObject = new JSONObject(reponseString);
//                    JSONArray items = responseObject.getJSONArray("items");
//                    aux = items.length();
//                    if (items.length() > 0) {
//                        updateLeads(items);
//                    }
//                    System.out.println(ANSI_GREEN_BACKGROUND + "***************************YA NO EXISTEN MAS PROSPECTOS NO QUALIFICADOS******************************" + ANSI_RESET);
//                } while (aux > 0);
//                System.out.println(ANSI_GREEN_BACKGROUND + "***********************************************************************************************************" + ANSI_RESET);
//                System.out.println(ANSI_GREEN_BACKGROUND + "*************************************************HEMOS ACABADO*********************************************" + ANSI_RESET);
//                System.out.println(ANSI_GREEN_BACKGROUND + "***********************************************************************************************************" + ANSI_RESET);
//            }
//        } catch (JsonProcessingException ex) {
//            Logger.getLogger(MantenimientoCorrectivoUsuarios.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(MantenimientoCorrectivoUsuarios.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(MantenimientoCorrectivoUsuarios.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public static void updateLeads(JSONArray items) throws IOException {
//        for (int i = 0; i < items.length(); i++) {
//            if (items.getJSONObject(i).get("IdentificadorReservaToProspecto_c") != null || !items.getJSONObject(i).get("IdentificadorReservaToProspecto_c").equals("")) {
//                try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//                    String urlConect = "yourDomain:443/crmRestApi/resources/latest/leads/" + items.getJSONObject(i).get("LeadId");
//                    HttpPatch request = new HttpPatch(urlConect);
//                    Handlers.setHeaderForAll(request);
//                    String jsonSend = "{\n"
//                            + "\"StatusCode\":\"QUALIFIED\" \n"
//                            + "}";
//                    StringEntity entity = new StringEntity(Handlers.JsonTransformer(jsonSend));
//                    request.setEntity(entity);
//                    HttpResponse response = httpClient.execute(request);
//                    if (response.getStatusLine().getStatusCode() == 200) {
//                        System.out.println(ANSI_GREEN_BACKGROUND + "PROSPECTO ACTUALIZADO: " + items.getJSONObject(i).get("LeadId") + ANSI_RESET);
//                    } else {
//                        System.out.println(ANSI_RED_BACKGROUND + "PROSPECTO NO ACTUALIZADO: " + items.getJSONObject(i).get("LeadId") + ANSI_RESET);
//                    }
//                }
//            } else {
//                System.out.println(ANSI_RED_BACKGROUND + "**********************NO ACTUALIZADO / NO TIENE RESERVA ASOCIADA:**************************** " + items.getJSONObject(i).get("LeadId") + ANSI_RESET);
//            }
//        }
//
//    }
//
//    public static void getPartners() throws IOException {
//        while (true) {
//            CloseableHttpClient httpClient = HttpClients.createDefault();
//            String urlConect = "yourDomain:443/crmRestApi/resources/latest/partners";
//            HttpGet request = new HttpGet(urlConect);
//            Handlers.setHeaderForAll(request);
//            HttpResponse response = httpClient.execute(request);
//            if (response.getStatusLine().getStatusCode() == 404) {
//                System.out.println(ANSI_RED_BACKGROUND + "ERROR: Header -> X-ORACLE-DMS-ECID -> " + Arrays.toString(response.getAllHeaders()) + ANSI_RESET);
//            }/*else{
//                System.out.println(ANSI_GREEN_BACKGROUND + "OK :" + Arrays.toString(response.getAllHeaders()) + ANSI_RESET);
//            }*/
//            httpClient.close();
//        }
//    }
//    public static void getUsers(String[] data) throws IOException {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        String urlConect = "yourDomain:443/crmRestApi/resources/latest/resourceUsers?q=Username=" + data[0];
//        HttpGet request = new HttpGet(urlConect);
//        Handlers.setHeaderForAll(request);
//        HttpResponse response = httpClient.execute(request);
//        String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
//        JSONObject responseObject = new JSONObject(reponseString);
//        JSONArray items = responseObject.getJSONArray("items");
//        if (items.length() > 0) {
//            JSONObject user = items.getJSONObject(0);
//            System.out.println(ANSI_GREEN_BACKGROUND + "OK : " + data[0] + ANSI_RESET);
//            updateUsers(user.getString("ResourcePartyNumber"), data);
//        } else {
//            System.out.println(ANSI_RED_BACKGROUND + "NO EXISTE: " + data[0] + ANSI_RESET);
//        }
//        httpClient.close();
//    }
//
//    public static void updateUsers(String resource,String[] data) throws IOException {
//        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            String urlConect = "yourDomain:443/crmRestApi/resources/latest/resourceUsers/" + resource;
//            HttpPatch request = new HttpPatch(urlConect);
//            Handlers.setHeaderForAll(request);
//            String jsonSend = "{\n"
//                    + "\"ResourceEmail\":\""+ data[4] +"\", \n"
//                    + "\"RutAgente_c\":"+ data[1] +", \n"
//                    + "\"DvAgente_c\":\""+ data[2] +"\", \n"
//                    + "\"CodigosAgente_c\":\""+ data[3] +"\" \n"
//                    + "}";
//            StringEntity entity = new StringEntity(Handlers.JsonTransformer(jsonSend));
//            request.setEntity(entity);
//            HttpResponse response = httpClient.execute(request);
//            if (response.getStatusLine().getStatusCode() == 200) {
//                System.out.println(ANSI_GREEN_BACKGROUND + "usuario actualizado RUT: " + data[1] + ANSI_RESET);
//            } else {
//                System.out.println(ANSI_RED_BACKGROUND + "usuario no actualizado RUT: " + data[1] + ANSI_RESET);
//            }
//        }
//    }
/*    public static void getSR() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String urlConect = "yourDomain:443/crmRestApi/resources/latest/serviceRequests?limit=500";
        HttpGet request = new HttpGet(urlConect);
        Handlers.setHeaderForAll(request);
        HttpResponse response = httpClient.execute(request);
        String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
        JSONObject responseObject = new JSONObject(reponseString);
        JSONArray items = responseObject.getJSONArray("items");
        if (items.length() > 0) {
            for (int i = 0; i < items.length(); i++) {
                JSONObject sr = items.getJSONObject(i);
                deleteSR(sr.getString("SrNumber").toString());
                System.out.println(ANSI_GREEN_BACKGROUND + "Delete SR: " + sr.getString("SrNumber") + ANSI_RESET);
            }
        } else {
            System.out.println(ANSI_RED_BACKGROUND + "acaba" + ANSI_RESET);
        }
        httpClient.close();
    }

    public static void deleteSR(String srNumber) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String urlConect = "https:/yourDomain:443/crmRestApi/resources/latest/serviceRequests/" + srNumber;
        HttpDelete request = new HttpDelete(urlConect);
        Handlers.setHeaderForAll(request);
        HttpResponse response = httpClient.execute(request);
        httpClient.close();
    }*/
    
    public static void getDataEloqua() throws IOException {
        int idField = 100001;
        for (int i = 0; i < 10; i++) {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            String urlConect = "https://yourDomain.eloqua.com/api/REST/1.0/assets/contact/field/"+idField;
            HttpGet request = new HttpGet(urlConect);
            Handlers.setHeaderForAll(request);
            HttpResponse response = httpClient.execute(request);
            if(response!=null){
                String reponseString = EntityUtils.toString(response.getEntity(), "UTF-8");
                JSONObject responseObject = new JSONObject(reponseString);
                System.out.println(ANSI_GREEN_BACKGROUND + "Type: " + responseObject.get("dataType") + "ID" + responseObject.get("id") + "Name"+ responseObject.get("name") +"InternalName" + responseObject.get("internalName") + ANSI_RESET);
            }else {
                System.out.println(ANSI_RED_BACKGROUND + "acaba" + ANSI_RESET);
            }
            httpClient.close();
        }
        idField=idField+1;
    }
  
}
