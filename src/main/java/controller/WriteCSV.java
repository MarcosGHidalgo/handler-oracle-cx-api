/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LeadGod;
import model.PartnerJson;
import model.PartnerWrite;

/**
 *
 * @author Jorge
 */
public class WriteCSV {

    public static final String SEPARATOR = ";";

    public static ArrayList leerCSVOrganizaciones(String archivo, String archivoEscritura) {
        ArrayList<PartnerWrite> partner = new ArrayList<>();
        String datos[] = new String[5];
        String line = "";
        int count = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            //System.out.println("ABRIENDO ARCHIVO");
            while ((line = br.readLine()) != null) {
                //System.out.println("ENTRAR");
                PartnerWrite p = new PartnerWrite();
                line = line.replace("\"", "");
                line = line.replace("\n", "");
                datos = line.split(SEPARATOR);
                if (count != 592) {
                    if (datos[4] != null) {
                        System.out.println("FILA: " + count );
                        p.setOrganizationm(datos[4]);
                        p.setUserName(datos[0]);
                        partner.add(p);
                        count++;
                    } else {
                        br.close();
                    }
                }

            }
            br.close();
            //getPartnerOrganizationName(partner, archivoEscritura);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WriteCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return partner;
    }

    public static void leerCSVActualizado2(String archivo) {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while ((line = br.readLine()) != null) {
                line = line.replace("\"", "");
                line = line.replace("\n", "");
                String user[] = line.split(SEPARATOR);
                
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void escribirCSVOrganizaciones(ArrayList<PartnerJson> partner) throws FileNotFoundException {
        File fout = new File("C:\\Users\\marco\\Desktop\\VolcadoPartners.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fos))) {
            for (int i = 0; i < partner.size(); i++) {
                br.write(partner.get(i).getPartnerProfilePEO_NumeroInscripcionCorredor_c().toString() + 
                        ";" + partner.get(i).getPartnerProfilePEO_CodigoAgenteCorredor_c().toString()+
                        ";" + partner.get(i).getPartnerProfilePEO_RUTCorredor_c().toString() +
                        ";" + partner.get(i).getPartnerProfilePEO_DvCorredor_c().toString() +
                        ";" + partner.get(i).getOrganizationName().toString() + 
                        ";" + partner.get(i).getPartnerProfilePEO_ZonaCorredores_c().toString() + 
                        ";" + partner.get(i).getPartnerProfilePEO_SucursalCorredores_c().toString() + 
                        ";" + partner.get(i).getOwnerName().toString() + 
                        ";" + partner.get(i).getPartnerProfilePEO_AsignadoPorGR_c().toString() + 
                        ";" + partner.get(i).getPartnerProfilePEO_SegmentoCorredor_c().toString() + 
                        ";" + partner.get(i).getPartnerProfilePEO_InspeccionesCorredor_c().toString() + 
                        ";" + partner.get(i).getPartnerProfilePEO_SiniestrosCorredor_c().toString() + 
                        ";" + partner.get(i).getPartnerProfilePEO_ComisionesCorredor_c().toString() + 
                        ";" + partner.get(i).getPartnerProfilePEO_CobranzaCorredor_c().toString() + 
                        ";" + partner.get(i).getPartnerProfilePEO_CampanasMarketingCorredor_c().toString() + 
                        ";" + partner.get(i).getPartnerProfilePEO_ComunicacionesComercialesCorredor_c().toString() + 
                        ";" + partner.get(i).getPartnerProfilePEO_ProduccionCorredor_c().toString() + 
                        ";" + partner.get(i).getPartnerProfilePEO_TipoCorredor_c().toString() + 
                        ";" + partner.get(i).getStatus().toString() + 
                        ";" + partner.get(i).getPhoneNumber().toString() + 
                        ";" + partner.get(i).getPartnerProfilePEO_AtributoTributarioCorredor_c().toString());
                br.newLine();
            }
            br.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WriteCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void escribirCSVLeads(ArrayList<LeadGod> leads) throws FileNotFoundException {
        File fout = new File("C:\\Users\\marco\\Desktop\\Prospectos2.csv");
        FileOutputStream fos = new FileOutputStream(fout);
        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fos))) {
            for (int i = 0; i < leads.size(); i++) {
                br.write(leads.get(i).getLeadNumber()+";");
                br.newLine();
            }
            br.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WriteCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
