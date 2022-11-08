/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class Members {

    private ArrayList<ModelUser> members;

    public Members() {
    }

    
    public Members(ArrayList<ModelUser> members) {
        this.members = members;
    }

    public ArrayList<ModelUser> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<ModelUser> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Members{" + "members=" + members + '}';
    }

}
