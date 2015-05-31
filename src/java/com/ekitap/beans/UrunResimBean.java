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
public class UrunResimBean {
    
    private int resimID;
    private int urunID;
    private String url;

    public UrunResimBean(int resimID, int urunID, String url){
        this.resimID = resimID;
        this.urunID = urunID;
        this.url = url;
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
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
