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

//SELECT * FROM `urunler` INNER JOIN urun_fiyat on urunler.kitap_ID = urun_fiyat.urunid SELECT * FROM urun_resim  INNER JOIN urun_resim on urunler.kitap_ID= urun_resim.urunID  order by urunler.kitap_ID desc limit 2


//SELECT * FROM urunler INNER JOIN urun_fiyat on urunler.kitap_ID = urun_fiyat.urunid  INNER JOIN (select * from urun_resim group by urunID) urun_resim on urunler.kitap_ID= urun_resim.urunID  order by urunler.kitap_ID desc limit 10
public class StokBean {
    
    private int id;
    private int urunID;
    private int stok;

    public StokBean(int id, int urunID, int stok){
        this.id = id;
        this.urunID = urunID;
        this.stok = stok;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the stok
     */
    public int getStok() {
        return stok;
    }

    /**
     * @param stok the stok to set
     */
    public void setStok(int stok) {
        this.stok = stok;
    }
    
}
