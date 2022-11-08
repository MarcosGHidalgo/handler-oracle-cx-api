/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author marco
 */
public class Fichero {
    private String codigoAgente;
    private Long grId;
    private Long grIdProfile;
    private String grNumber;
    private Long acrId;
    private Long acrIdProfile;
    private String acrNumber;
    private String sucursal;

    public Fichero() {
    }

    public Fichero(String codigoAgente, Long grId, Long grIdProfile, String grNumber, Long acrId, Long acrIdProfile, String acrNumber, String sucursal) {
        this.codigoAgente = codigoAgente;
        this.grId = grId;
        this.grIdProfile = grIdProfile;
        this.grNumber = grNumber;
        this.acrId = acrId;
        this.acrIdProfile = acrIdProfile;
        this.acrNumber = acrNumber;
        this.sucursal = sucursal;
    }

    public String getCodigoAgente() {
        return codigoAgente;
    }

    public void setCodigoAgente(String codigoAgente) {
        this.codigoAgente = codigoAgente;
    }

    public Long getGrId() {
        return grId;
    }

    public void setGrId(Long grId) {
        this.grId = grId;
    }

    public Long getGrIdProfile() {
        return grIdProfile;
    }

    public void setGrIdProfile(Long grIdProfile) {
        this.grIdProfile = grIdProfile;
    }

    public String getGrNumber() {
        return grNumber;
    }

    public void setGrNumber(String grNumber) {
        this.grNumber = grNumber;
    }

    public Long getAcrId() {
        return acrId;
    }

    public void setAcrId(Long acrId) {
        this.acrId = acrId;
    }

    public Long getAcrIdProfile() {
        return acrIdProfile;
    }

    public void setAcrIdProfile(Long acrIdProfile) {
        this.acrIdProfile = acrIdProfile;
    }

    public String getAcrNumber() {
        return acrNumber;
    }

    public void setAcrNumber(String acrNumber) {
        this.acrNumber = acrNumber;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
}
