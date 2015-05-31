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
public class UrunDetayBean {
    
    private int urunID;
    private String urunAD;
    private int yayineviID;
    private int yazarID;
    private int kategoriID;
    private String aciklama;
    private float urunFiyat;
    private int resimID;
    private String urunResim;

    public UrunDetayBean(int urunID,String urunAD,int yayineviID,int yazarID,int kategoriID,String aciklama,float urunFiyat,int resimID, String urunResim){
        this.urunID = urunID;
        this.urunAD = urunAD;
        this.yayineviID = yayineviID;
        this.yazarID = yazarID;
        this.kategoriID = kategoriID;
        this.aciklama = aciklama;
        this.urunFiyat = urunFiyat;
        this.resimID = resimID;
        this.urunResim = urunResim;
    }
    
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
     * @return the yayineviID
     */
    public int getYayineviID() {
        return yayineviID;
    }

    /**
     * @param yayineviID the yayineviID to set
     */
    public void setYayineviID(int yayineviID) {
        this.yayineviID = yayineviID;
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

    /**
     * @return the urunFiyat
     */
    public float getUrunFiyat() {
        return urunFiyat;
    }

    /**
     * @param urunFiyat the urunFiyat to set
     */
    public void setUrunFiyat(float urunFiyat) {
        this.urunFiyat = urunFiyat;
    }

    /**
     * @return the resimID
     */
    public int getResimID() {
        return resimID;
    }

    /**
     * @param resimID the resimID to set
     */
    public void setResimID(int resimID) {
        this.resimID = resimID;
    }

    /**
     * @return the urunResim
     */
    public String getUrunResim() {
        return urunResim;
    }

    /**
     * @param urunResim the urunResim to set
     */
    public void setUrunResim(String urunResim) {
        this.urunResim = urunResim;
    }
    
    
}
