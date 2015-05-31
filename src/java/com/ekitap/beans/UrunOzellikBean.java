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
public class UrunOzellikBean {
    
    private int urunID;
    private int ozellikID;
    private String deger;

    public UrunOzellikBean(int urunID, int ozellikID, String deger){
        this.urunID = urunID;
        this.ozellikID = ozellikID;
        this.deger = deger;
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
     * @return the ozellikID
     */
    public int getOzellikID() {
        return ozellikID;
    }

    /**
     * @param ozellikID the ozellikID to set
     */
    public void setOzellikID(int ozellikID) {
        this.ozellikID = ozellikID;
    }

    /**
     * @return the deger
     */
    public String getDeger() {
        return deger;
    }

    /**
     * @param deger the deger to set
     */
    public void setDeger(String deger) {
        this.deger = deger;
    }
}
