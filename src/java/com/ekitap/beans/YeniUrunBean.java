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
public class YeniUrunBean {
    
    private int urunID;
    private String urunAD;
    private float urunFiyat;
    private String urunResim;

    
    public YeniUrunBean(int urunID, String urunAD, float urunFiyat, String urunResim){
        this.urunAD = urunAD;
        this.urunFiyat = urunFiyat;
        this.urunID = urunID;
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
