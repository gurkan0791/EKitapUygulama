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
public class YazarBean {
    
    private int yazarID;
    private String yazarAd;
    private String yazarSoyad;
    private String yazarWebsite;

    public YazarBean(){}
    public YazarBean(int yazarID, String yazarAd, String yazarSoyad, String yazarWebsite){
        this.yazarID = yazarID;
        this.yazarAd = yazarAd;
        this.yazarSoyad = yazarSoyad;
        this.yazarWebsite = yazarWebsite;
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
     * @return the yazarAd
     */
    public String getYazarAd() {
        return yazarAd;
    }

    /**
     * @param yazarAd the yazarAd to set
     */
    public void setYazarAd(String yazarAd) {
        this.yazarAd = yazarAd;
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
     * @return the yazarWebsite
     */
    public String getYazarWebsite() {
        return yazarWebsite;
    }

    /**
     * @param yazarWebsite the yazarWebsite to set
     */
    public void setYazarWebsite(String yazarWebsite) {
        this.yazarWebsite = yazarWebsite;
    }
    
}
