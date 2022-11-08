/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertiesReader;

import java.util.ResourceBundle;

/**
 *
 * @author Jorge
 */
public class PropertiesReader {
    private static final ResourceBundle PROPERTIES = ResourceBundle.getBundle("propertiesSecurity/Security");
       
    public static String getURL(){
        return PROPERTIES.getString("URL");
    }

    public static String getContacts(){
        return PROPERTIES.getString("CONTACTS");
    }
    
    public static String getPartners(){
        return PROPERTIES.getString("PARTNERS");
    }
    
    public static String getLeads(){
        return PROPERTIES.getString("LEADS");
    }
    
    public static String getDeals(){
        return PROPERTIES.getString("DEALS");
    }
    
    public static String getAccounts(){
        return PROPERTIES.getString("ACCOUNTS");
    }
    
    public static String getData(){
        return PROPERTIES.getString("DATA");
    }
    
    public static String getG(){
        return PROPERTIES.getString("G");
    }
    
    public static String getA(){
        return PROPERTIES.getString("A");
    }
    
    public static String getContent(){
        return PROPERTIES.getString("CONTENT");
    }
    
    public static String getType(){
        return PROPERTIES.getString("TYPE");
    }
    
    public static String getTypeSpecial(){
        return PROPERTIES.getString("TYPESPECIAL");
    }
    
    public static String getMethod(){
        return PROPERTIES.getString("METHOD");
    }
    
    public static String getUpdate(){
        return PROPERTIES.getString("UPDATE");
    }
    
    public static String getAuth(){
        return PROPERTIES.getString("AUTH");
    }
    
    public static String getBasic(){
        return PROPERTIES.getString("BASIC");
    }
    
    public static String getURLPartnerContact(){
        return PROPERTIES.getString("PCONTACT");
    }
    
    public static String getUsers(){
        return PROPERTIES.getString("USERS");
    }
    
    public static String getFile(){
        return PROPERTIES.getString("FILEUSER");
    }
    
    public static String getFile2(){
        return PROPERTIES.getString("FILEUSER2");
    }
}
