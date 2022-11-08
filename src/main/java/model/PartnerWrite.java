/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Marcos
 */
public class PartnerWrite {
    private String organizationm, idCompany, userName, idUser;

    public PartnerWrite() {
    }

    public PartnerWrite(String organizationm, String idCompany, String userName, String idUser) {
        this.organizationm = organizationm;
        this.idCompany = idCompany;
        this.userName = userName;
        this.idUser = idUser;
    }

    public String getOrganizationm() {
        return organizationm;
    }

    public String getIdCompany() {
        return idCompany;
    }

    public String getUserName() {
        return userName;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setOrganizationm(String organizationm) {
        this.organizationm = organizationm;
    }

    public void setIdCompany(String idCompany) {
        this.idCompany = idCompany;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    
}
