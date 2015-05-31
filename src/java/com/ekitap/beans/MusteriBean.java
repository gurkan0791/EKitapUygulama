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
public class MusteriBean {
    
    private int ID;
    private String musteriAD;
    private String musteriSoyad;
    private String musteriMail;
    private String musteriSifre;

    public MusteriBean(int ID, String musteriAD, String musteriSoyad, String musteriMail, String musteriSifre) {
        this.ID = ID;
        this.musteriAD = musteriAD;
        this.musteriSoyad = musteriSoyad;
        this.musteriMail = musteriMail;
        this.musteriSifre = musteriSifre;
    }

    
    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the musteriAD
     */
    public String getMusteriAD() {
        return musteriAD;
    }

    /**
     * @param musteriAD the musteriAD to set
     */
    public void setMusteriAD(String musteriAD) {
        this.musteriAD = musteriAD;
    }

    /**
     * @return the musteriSoyad
     */
    public String getMusteriSoyad() {
        return musteriSoyad;
    }

    /**
     * @param musteriSoyad the musteriSoyad to set
     */
    public void setMusteriSoyad(String musteriSoyad) {
        this.musteriSoyad = musteriSoyad;
    }

    /**
     * @return the musteriMail
     */
    public String getMusteriMail() {
        return musteriMail;
    }

    /**
     * @param musteriMail the musteriMail to set
     */
    public void setMusteriMail(String musteriMail) {
        this.musteriMail = musteriMail;
    }

    /**
     * @return the musteriSifre
     */
    public String getMusteriSifre() {
        return musteriSifre;
    }

    /**
     * @param musteriSifre the musteriSifre to set
     */
    public void setMusteriSifre(String musteriSifre) {
        this.musteriSifre = musteriSifre;
    }
    
}
