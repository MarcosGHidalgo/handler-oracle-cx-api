/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;

/**
 *
 * @author SOAINT
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartnersJson {
    
   private ArrayList<PartnerContact> items;
   
   public PartnersJson(){
       
   }

    public ArrayList<PartnerContact> getItems() {
        return items;
    }

    public void setItems(ArrayList<PartnerContact> items) {
        this.items = items;
    } 
}
