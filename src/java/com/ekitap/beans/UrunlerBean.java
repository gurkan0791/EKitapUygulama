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
public class UrunlerBean {
    
    private int kitapID;
    private String kitapAD;
    private int yayinEviID;
    private int yazarID;
    private int kategoriID;
    private String aciklama;

    public UrunlerBean(){}
    public UrunlerBean(int kitapID,String kitapAD, int yayinEviID, int yazarID, int kategoriID, String aciklama){
        this.kitapID = kitapID;
        this.kitapAD = kitapAD;
        this.yayinEviID = yayinEviID;
        this.yazarID = yazarID;
        this.kategoriID = kategoriID;
        this.aciklama = aciklama;
    }
    /**
     * @return the kitapID
     */
    public int getKitapID() {
        return kitapID;
    }

    /**
     * @param kitapID the kitapID to set
     */
    public void setKitapID(int kitapID) {
        this.kitapID = kitapID;
    }

    /**
     * @return the kitapAD
     */
    public String getKitapAD() {
        return kitapAD;
    }

    /**
     * @param kitapAD the kitapAD to set
     */
    public void setKitapAD(String kitapAD) {
        this.kitapAD = kitapAD;
    }

    /**
     * @return the yayinEviID
     */
    public int getYayinEviID() {
        return yayinEviID;
    }

    /**
     * @param yayinEviID the yayinEviID to set
     */
    public void setYayinEviID(int yayinEviID) {
        this.yayinEviID = yayinEviID;
    }

    /**
     * @return the yazarID
     */
    public int getYazarID() {
        return yazarID;
    }

    /**
     * @param yazarID the yazarID to set
     */
    public void setYazarID(int yazarID) {
        this.yazarID = yazarID;
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
     * @return the aciklama
     */
    public String getAciklama() {
        return aciklama;
    }

    /**
     * @param aciklama the aciklama to set
     */
    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
    
}
