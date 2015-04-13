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
public class CalisanlarBean {
    
    private int calisan_id;
    private String ad;
    private String soyad;
    private String email;
    private String sifre;

    public CalisanlarBean (int calisan_id, String ad, String soyad, String email, String sifre) {
        this.calisan_id = calisan_id;
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.sifre = sifre;
    }
    /**
     * @return the calisan_id
     */
    public int getCalisan_id() {
        return calisan_id;
    }

    /**
     * @param calisan_id the calisan_id to set
     */
    public void setCalisan_id(int calisan_id) {
        this.calisan_id = calisan_id;
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
     * @return the soyad
     */
    public String getSoyad() {
        return soyad;
    }

    /**
     * @param soyad the soyad to set
     */
    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the sifre
     */
    public String getSifre() {
        return sifre;
    }

    /**
     * @param sifre the sifre to set
     */
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    
}
