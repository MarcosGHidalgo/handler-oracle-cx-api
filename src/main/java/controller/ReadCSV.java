/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.MantenimientoCorrectivoUsuarios.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class ReadCSV {

    public static final String SEPARATOR = ";";

//    public static void leerCSVBorrado(String archivo) {
//        String line = "";
//        int cont = 1;
//        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
//            while ((line = br.readLine()) != null) {
//                line = line.replace("\"", "");
//                line = line.replace("\n", "");
//                String user[] = line.split(SEPARATOR);
//                System.out.println("----------------------------------------------------------------------------------------------------------");
//                if (!"".equals(user[1])) {
//                    System.out.println("------------------------------------------EXISTE USUARIO--------------------------------------------------");
//                    System.out.println("USUARIO: " + user[0].replace("\\ufeff","") + "\tCódigo interno usuario: "+user[1]+"\t Corredor: " + user[4]);
//                    MantenimientoCorrectivoUsuarios.deleteUser(user[1], user[3], user[0].replace("\\ufeff",""), user[4], user[2], user[5]);
//                } else {
//                    System.out.println("----------------------------------------NO EXISTE USUARIO-------------------------------------------------");
//                    System.out.println("USUARIO: " + user[0].replace("\\ufeff","") + "\t Corredor: " + user[4]); 
//                    MantenimientoCorrectivoUsuarios.getPartner(user[3], user[0].replace("\\ufeff",""), user[4], user[2], user[5]);
//                }
//                System.out.println("FILA: " + cont);
//                System.out.println("----------------------------------------------------------------------------------------------------------");            
//                cont++;       
//            }
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public static int leerCSVBorradoTeamMember() {
//        String archivo ="C:\\\\Users\\\\Marcos\\\\Desktop\\\\borradoTeam.csv";
//        String user[] = new String[1];
//        String line = "";
//        int success = 0;
//        boolean found = false;
//        int cont = 1;
//        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
//            while ((line = br.readLine()) != null && !found) {
//                line = line.replace("\"", "");
//                line = line.replace("\n", "");
//                user = line.split(SEPARATOR);
//                MantenimientoCorrectivoUsuarios.deleteAccountTeamPartner(user[0]);
//            }
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return success;
//    }
//    public static void leerCSVActualizado(String archivo) {
//        String line = "";
//        int cont = 1;
//        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
//            while ((line = br.readLine()) != null) {
//                line = line.replace("\"", "");
//                line = line.replace("\n", "");
//                String user[] = line.split(SEPARATOR);
//                System.out.println("----------------------------------------------------------------------------------------------------------");
//                MantenimientoCorrectivoUsuarios.updatePasswordUser(user[0], user[2], user[3]);
//                System.out.println("FILA: " + cont);
//                System.out.println("----------------------------------------------------------------------------------------------------------");            
//                cont++;       
//            }
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public static void leerCSVActualizado2(String archivo) {
//        String line = "";
//        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
//            while ((line = br.readLine()) != null) {
//                line = line.replace("\"", "");
//                line = line.replace("\n", "");
//                String user[] = line.split(SEPARATOR);
//                MantenimientoCorrectivoUsuarios.getPartnerVerificar(user[3]);
//            }
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public static void leerCSVActualizado3(String archivo) {
//        String line = "";
//        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
//            while ((line = br.readLine()) != null) {
//                line = line.replace("\"", "");
//                line = line.replace("\n", "");
//                String user[] = line.split(SEPARATOR);
//                MantenimientoCorrectivoUsuarios.verificarAcceso(user[0]);
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        }
////    }
//    public static void leerCSVAddProduct() {
//        String archivo = "C:\\Users\\marco\\Desktop\\CargaProductos.csv";
//        String line = "";
//        int cont = 1;
//        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
//            while ((line = br.readLine()) != null) {
//                line = line.replace("\"", "");
//                line = line.replace("\n", "");
//                String mapeoProducts[] = line.split(SEPARATOR);
//                ArrayList<Productos> productos = new ArrayList<>();
//                //COLUMNA 1: CostePrima(Double)  COLUMNA 2: IdentificadorProducto(Long), así sucesivamente
//                if (Double.parseDouble(mapeoProducts[1]) != 0) {
//                    productos.add(new Productos() {
//                        {
//                            setInventoryItemId(Long.parseLong(mapeoProducts[2]));
//                            setAmount(Double.parseDouble(mapeoProducts[1]));
//                        }
//                    });
//                }
//                if (Double.parseDouble(mapeoProducts[3]) != 0) {
//                    productos.add(new Productos() {
//                        {
//                            setInventoryItemId(Long.parseLong(mapeoProducts[4]));
//                            setAmount(Double.parseDouble(mapeoProducts[3]));
//                        }
//                    });
//                }
//                if (Double.parseDouble(mapeoProducts[5]) != 0) {
//                    productos.add(new Productos() {
//                        {
//                            setInventoryItemId(Long.parseLong(mapeoProducts[6]));
//                            setAmount(Double.parseDouble(mapeoProducts[5]));
//                        }
//                    });
//                }
//                if (Double.parseDouble(mapeoProducts[7]) != 0) {
//                    productos.add(new Productos() {
//                        {
//                            setInventoryItemId(Long.parseLong(mapeoProducts[8]));
//                            setAmount(Double.parseDouble(mapeoProducts[7]));
//                        }
//                    });
//                }
//                if (Double.parseDouble(mapeoProducts[9]) != 0) {
//                    productos.add(new Productos() {
//                        {
//                            setInventoryItemId(Long.parseLong(mapeoProducts[10]));
//                            setAmount(Double.parseDouble(mapeoProducts[9]));
//                        }
//                    });
//                }
//                if (Double.parseDouble(mapeoProducts[11]) != 0) {
//                    productos.add(new Productos() {
//                        {
//                            setInventoryItemId(Long.parseLong(mapeoProducts[12]));
//                            setAmount(Double.parseDouble(mapeoProducts[11]));
//                        }
//                    });
//                }
//                if (Double.parseDouble(mapeoProducts[13]) != 0) {
//                    productos.add(new Productos() {
//                        {
//                            setInventoryItemId(Long.parseLong(mapeoProducts[14]));
//                            setAmount(Double.parseDouble(mapeoProducts[13]));
//                        }
//                    });
//                }
//                if (Double.parseDouble(mapeoProducts[15]) != 0) {
//                    productos.add(new Productos() {
//                        {
//                            setInventoryItemId(Long.parseLong(mapeoProducts[16]));
//                            setAmount(Double.parseDouble(mapeoProducts[15]));
//                        }
//                    });
//                }
//                System.out.println("----------------------------------------------------------------------------FILA" + cont + "------------------------------------------------------------------------------------------------------------");
//                getDeal(mapeoProducts[0], productos);
//                cont++;
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        }
////    }
//    public static void leerCSVPartners() {
//        String archivo = "C:\\Users\\marco\\Desktop\\ParaActualizarTODO.csv";
//        String line = "";
//        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
//            List<String> codigos = new ArrayList();
//            while ((line = br.readLine()) != null) {
//                line = line.replace("\"", "");
//                line = line.replace("\n", "");
//                String user[] = line.split(SEPARATOR);
//                codigos.add(user[0]);
//                //System.out.println("LECTURA código: "  + user[0]);
//            }
//            getPartners(codigos);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
////    public static void leerCSVPartnersActualizacion() {
////        String archivo = "C:\\Users\\marco\\Desktop\\ParaActualizarTODO.csv";
////        String line = "";
////        int cont = 1;
////        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
////            while ((line = br.readLine()) != null) {
////                line = line.replace("\"", "");
////                line = line.replace("\n", "");
////                String data[] = line.split(SEPARATOR);
////                Fichero fichero = new Fichero();
////                System.out.println("----------------------------------------------------------------------------------------------FILA: " + cont + "--------------------------------------------------------------------------------------------------------------");
////                if (!"".equals(data[4])) {
////                    fichero.setCodigoAgente(data[0]);
////                    fichero.setGrId(Long.parseLong(data[2]));
////                    fichero.setGrNumber(data[3]);
////                    fichero.setAcrId(Long.parseLong(data[5]));
////                    fichero.setAcrNumber(data[6]);
////                    fichero.setSucursal(Handlers.JsonTransformerESPECIAL(data[7]));
////                    getPartner(fichero.getCodigoAgente(), fichero.getGrId(), fichero.getGrNumber(), fichero.getAcrId(), fichero.getAcrNumber(), fichero.getSucursal());
////                } else {
////                    fichero.setCodigoAgente(data[0]);
////                    fichero.setGrId(Long.parseLong(data[2]));
////                    fichero.setGrNumber(data[3]);
////                    fichero.setSucursal(Handlers.JsonTransformerESPECIAL(data[7]));                    
////                    getPartnerNOTACR(fichero.getCodigoAgente(), fichero.getGrId(), fichero.getGrNumber(), fichero.getSucursal());
////                }
////                cont++;
////                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
////            }
////        } catch (FileNotFoundException ex) {
////            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
////        } catch (IOException ex) {
////            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
////        }
////    }
////    }
////    public static void leerCSVPartnersActualizacion() {
////        String archivo = "C:\\Users\\marco\\Desktop\\ActualizacionRedComercialProduccionTODO.csv";
////        String line = "";
////        int cont = 1;
////        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
////            while ((line = br.readLine()) != null) {
////                line = line.replace("\"", "");
////                line = line.replace("\n", "");
////                String data[] = line.split(SEPARATOR);
////                Fichero fichero = new Fichero();
////                System.out.println("----------------------------------------------------------------------------------------------FILA: " + cont + "--------------------------------------------------------------------------------------------------------------");
////                if (!getAccountTeamMembersPartnerGR(getPartner(data[0])).toString().equals("FALLO")) {
////                    updateGR(getPartner(data[0]), getAccountTeamMembersPartnerGR(getPartner(data[0])).toString());
////                }
////                cont++;
////                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
////            }
////        } catch (FileNotFoundException ex) {
////            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
////        } catch (IOException ex) {
////            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
////        }
////    }
//    public static void leerCSV() {
//        String archivo = "C:\\Users\\marco\\Desktop\\usuarios.csv";
//        String line = "";
//        int cont = 1;
//        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
//            while ((line = br.readLine()) != null) {
//                line = line.replace("\"", "");
//                line = line.replace("\n", "");
//                String data[] = line.split(SEPARATOR);
//                System.out.println("----------------------------------------------------------------------------------------------FILA: " + cont + "--------------------------------------------------------------------------------------------------------------");
//                getUsers(data);
//                cont++;
//                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public static void leerCSVLeads() throws ParseException {
//        String archivo = "C:\\Users\\marco\\Desktop\\Prospectos.csv";
//        String line = "";
//        int cont = 1;
//        ArrayList<LeadGod> leads = new ArrayList<>();
//        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
//            LeadGod lead = null;
//            while ((line = br.readLine()) != null) {
//                line = line.replace("\"", "");
//                line = line.replace("\n", "");
//                String data[] = line.split(SEPARATOR);
//                //System.out.println("----------------------------------------------------------------------------------------------FILA: " + cont + "--------------------------------------------------------------------------------------------------------------");
//                lead = new LeadGod();
//                lead.setOwnerId(data[2]);
//                lead.setPartnerId(data[5]);
//                lead.setName(Handlers.JsonTransformerURI(data[12]));
//
////                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
////                String dateString = format.format(new Date());
////                Date date = format.parse(data[14]);
//
//                lead.setExpirationDate(data[14]);
//                System.out.println("IDGR: " + lead.getOwnerId() + "\tPartner: " + lead.getPartnerId() + "\tName: " + lead.getName() + "\tExpirationDate: " + lead.getExpirationDate());
//                leads.add(lead);
//                cont++;
//                //System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//            }
//            br.close();
//
//            getLeadsHisto(leads);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
