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
public class OzellikBean {
    
    
    private int ID;
    private String ozellik;
    private String gorunurAD;
    
    public OzellikBean(int ID, String ozellik, String gorunurAD){
        this.ID = ID;
        this.ozellik = ozellik;
        this.gorunurAD = gorunurAD;
    }
    
//    private int urunID;
//    private String yazar;
//    private String yayin;
//    private String isbn;
//    private String kitapSayfa;
//    private String kitapEbat; 
//
//    public OzellikBean(int urunID, String yazar, String yayin, String isbn, String kitapSayfa, String kitapEbat){
//        this.urunID = urunID;
//        this.yazar = yazar;
//        this.yayin = yayin;
//        this.isbn = isbn;
//        this.kitapSayfa = kitapSayfa;
//        this.kitapEbat = kitapEbat;
//    }
//    /**
//     * @return the urunID
//     */
//    public int getUrunID() {
//        return urunID;
//    }
//
//    /**
//     * @param urunID the urunID to set
//     */
//    public void setUrunID(int urunID) {
//        this.urunID = urunID;
//    }
//
//    /**
//     * @return the yazar
//     */
//    public String getYazar() {
//        return yazar;
//    }
//
//    /**
//     * @param yazar the yazar to set
//     */
//    public void setYazar(String yazar) {
//        this.yazar = yazar;
//    }
//
//    /**
//     * @return the yayin
//     */
//    public String getYayin() {
//        return yayin;
//    }
//
//    /**
//     * @param yayin the yayin to set
//     */
//    public void setYayin(String yayin) {
//        this.yayin = yayin;
//    }
//
//    /**
//     * @return the isbn
//     */
//    public String getIsbn() {
//        return isbn;
//    }
//
//    /**
//     * @param isbn the isbn to set
//     */
//    public void setIsbn(String isbn) {
//        this.isbn = isbn;
//    }
//
//    /**
//     * @return the kitapSayfa
//     */
//    public String getKitapSayfa() {
//        return kitapSayfa;
//    }
//
//    /**
//     * @param kitapSayfa the kitapSayfa to set
//     */
//    public void setKitapSayfa(String kitapSayfa) {
//        this.kitapSayfa = kitapSayfa;
//    }
//
//    /**
//     * @return the kitapEbat
//     */
//    public String getKitapEbat() {
//        return kitapEbat;
//    }
//
//    /**
//     * @param kitapEbat the kitapEbat to set
//     */
//    public void setKitapEbat(String kitapEbat) {
//        this.kitapEbat = kitapEbat;
//    }

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
     * @return the ozellik
     */
    public String getOzellik() {
        return ozellik;
    }

    /**
     * @param ozellik the ozellik to set
     */
    public void setOzellik(String ozellik) {
        this.ozellik = ozellik;
    }

    /**
     * @return the gorunurAD
     */
    public String getGorunurAD() {
        return gorunurAD;
    }

    /**
     * @param gorunurAD the gorunurAD to set
     */
    public void setGorunurAD(String gorunurAD) {
        this.gorunurAD = gorunurAD;
    }
}
