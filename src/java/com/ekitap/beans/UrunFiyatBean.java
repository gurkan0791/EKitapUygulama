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
public class UrunFiyatBean {
 
    
    private int fiyatID;
    private int urunID;
    private float vergisiz;
    private float vergili;

    public UrunFiyatBean(int fiyatID, int urunID, float vergisiz, float vergili){
        this.fiyatID = fiyatID;
        this.urunID = urunID;
        this.vergisiz =  vergisiz;
        this.vergili = vergili;
    }
    
    /**
     * @return the fiyatID
     */
    public int getFiyatID() {
        return fiyatID;
    }

    /**
     * @param fiyatID the fiyatID to set
     */
    public void setFiyatID(int fiyatID) {
        this.fiyatID = fiyatID;
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
     * @return the vergisiz
     */
    public float getVergisiz() {
        return vergisiz;
    }

    /**
     * @param vergisiz the vergisiz to set
     */
    public void setVergisiz(float vergisiz) {
        this.vergisiz = vergisiz;
    }

    /**
     * @return the vergili
     */
    public float getVergili() {
        return vergili;
    }

    /**
     * @param vergili the vergili to set
     */
    public void setVergili(float vergili) {
        this.vergili = vergili;
    }
    
}
