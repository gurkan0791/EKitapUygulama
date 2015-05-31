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
public class UrunYazarYayinBean {
    
    private int urunID;
    private String urunAD;
    private int yayinEviID;
    private String yayinEviAD;
    private int yazarID;
    private String yazarAD;
    private String yazarSoyad;
    private int kategoriID;
    private String aciklama;

    public UrunYazarYayinBean(int urunID, String urunAD, int yayinEviID, String yayinEviAD, int yazarID, String yazarAD, String yazarSoyad, int kategoriID, String aciklama) {
        this.urunID = urunID;
        this.urunAD = urunAD;
        this.yayinEviID = yayinEviID;
        this.yayinEviAD = yayinEviAD;
        this.yazarID = yazarID;
        this.yazarAD = yazarAD;
        this.yazarSoyad = yazarSoyad;
        this.kategoriID = kategoriID;
        this.aciklama = aciklama;
    }

    public UrunYazarYayinBean(){}
    
    /**
     * @return the urunID
     */
    public int getUrunID() {
        return urunID;
    }

    /**
     * @param urunID the urunID to set
     */
    public void setUrunID(int urunID) {
        this.urunID = urunID;
    }

    /**
     * @return the urunAD
     */
    public String getUrunAD() {
        return urunAD;
    }

    /**
     * @param urunAD the urunAD to set
     */
    public void setUrunAD(String urunAD) {
        this.urunAD = urunAD;
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
     * @return the yayinEviAD
     */
    public String getYayinEviAD() {
        return yayinEviAD;
    }

    /**
     * @param yayinEviAD the yayinEviAD to set
     */
    public void setYayinEviAD(String yayinEviAD) {
        this.yayinEviAD = yayinEviAD;
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
     * @return the yazarAD
     */
    public String getYazarAD() {
        return yazarAD;
    }

    /**
     * @param yazarAD the yazarAD to set
     */
    public void setYazarAD(String yazarAD) {
        this.yazarAD = yazarAD;
    }

    /**
     * @return the yazarSoyad
     */
    public String getYazarSoyad() {
        return yazarSoyad;
    }

    /**
     * @param yazarSoyad the yazarSoyad to set
     */
    public void setYazarSoyad(String yazarSoyad) {
        this.yazarSoyad = yazarSoyad;
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
