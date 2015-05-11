/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ekitap.beans;

/**
 *
 * @author Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
 */
public class KategoriBean {
    
    private int kategoriID;
    private int altKategoriID;
    private String kategoriADI;
    private String kategoriAciklama;
    private String kategoriResimUrl;

    public KategoriBean(int kategoriID, int altKategoriID, String kategoriADI, String kategoriAciklama, String kategoriResimUrl){
        this.kategoriID = kategoriID;
        this.altKategoriID = altKategoriID;
        this.kategoriADI = kategoriADI;
        this.kategoriAciklama = kategoriAciklama;
        this.kategoriResimUrl = kategoriResimUrl;
    }
    
    /**
     * @return the kategoriID
     */
    public int getKategoriID() {
        return kategoriID;
    }

    /**
     * @param kategoriID the kategoriID to set
     */
    public void setKategoriID(int kategoriID) {
        this.kategoriID = kategoriID;
    }

    /**
     * @return the altKategoriID
     */
    public int getAltKategoriID() {
        return altKategoriID;
    }

    /**
     * @param altKategoriID the altKategoriID to set
     */
    public void setAltKategoriID(int altKategoriID) {
        this.altKategoriID = altKategoriID;
    }

    /**
     * @return the kategoriADI
     */
    public String getKategoriADI() {
        return kategoriADI;
    }

    /**
     * @param kategoriADI the kategoriADI to set
     */
    public void setKategoriADI(String kategoriADI) {
        this.kategoriADI = kategoriADI;
    }

    /**
     * @return the kategoriAciklama
     */
    public String getKategoriAciklama() {
        return kategoriAciklama;
    }

    /**
     * @param kategoriAciklama the kategoriAciklama to set
     */
    public void setKategoriAciklama(String kategoriAciklama) {
        this.kategoriAciklama = kategoriAciklama;
    }

    /**
     * @return the kategoriResimUrl
     */
    public String getKategoriResimUrl() {
        return kategoriResimUrl;
    }

    /**
     * @param kategoriResimUrl the kategoriResimUrl to set
     */
    public void setKategoriResimUrl(String kategoriResimUrl) {
        this.kategoriResimUrl = kategoriResimUrl;
    }
    
}
