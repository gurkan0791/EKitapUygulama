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
public class YayinEviBean {
    
    private int yayinID;
    private String ad;
    private String adres;
    private String website;

    public YayinEviBean(){}
    public YayinEviBean(int yayinID, String ad, String adres, String website){
        this.yayinID = yayinID;
        this.ad = ad;
        this.adres = adres;
        this.website = website;
    }
    /**
     * @return the yayinID
     */
    public int getYayinID() {
        return yayinID;
    }

    /**
     * @param yayinID the yayinID to set
     */
    public void setYayinID(int yayinID) {
        this.yayinID = yayinID;
    }

    /**
     * @return the ad
     */
    public String getAd() {
        return ad;
    }

    /**
     * @param ad the ad to set
     */
    public void setAd(String ad) {
        this.ad = ad;
    }

    /**
     * @return the adres
     */
    public String getAdres() {
        return adres;
    }

    /**
     * @param adres the adres to set
     */
    public void setAdres(String adres) {
        this.adres = adres;
    }

    /**
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website the website to set
     */
    public void setWebsite(String website) {
        this.website = website;
    }
}
