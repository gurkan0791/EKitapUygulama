/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ekitap.model;

import com.ekitap.beans.UrunlerBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
 */
public class UrunlerDAO {
    
   
    
    private static Connection baglan;
    private static CallableStatement cs = null;
    
    
    public static int setUrunEkle(UrunlerBean urunler){
        baglan = Veritabani.getMySqlConnection();
        
        int urunID = 0;
        try {
            cs = baglan.prepareCall("{call sp_urun_ekle(?,?,?,?,?,?)}");
            cs.setInt(1, 0);
            cs.setString(2, urunler.getKitapAD());
            cs.setInt(3, urunler.getYayinEviID());
            cs.setInt(4, urunler.getYazarID());
            cs.setInt(5, urunler.getKategoriID());
            cs.setString(6, urunler.getAciklama());
            
            ResultSet a= cs.executeQuery();
            if (a.next()) {
                urunID = a.getInt(1);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }finally{
            try {
                cs.close();
                baglan.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return  0;
            }
        }
        
        return urunID;
    }
    
     public static ArrayList<UrunlerBean> getUrunListele(int baslangicSayisi, int sayfaBasinaUrun){
        baglan = Veritabani.getMySqlConnection();
        ArrayList<UrunlerBean> liste = null;
        int urunID = 0;
        try {
            cs = baglan.prepareCall("{call sp_urun_listele(?,?)}");
            cs.setInt(1, baslangicSayisi);
            cs.setInt(2, sayfaBasinaUrun);
            ResultSet rs= cs.executeQuery();
            liste = new ArrayList<UrunlerBean>();
            while (rs.next()) {
                liste.add(new UrunlerBean(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e1){}
        finally{
            try {
                cs.close();
                baglan.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return  null;
            }
        }
         
        return liste;
    }
    
    public static int getUrunAdet(){
        ResultSet rs = null;
        int adet = 0;
        try {
        baglan = Veritabani.getMySqlConnection();
        Statement st = baglan.createStatement();
        rs= st.executeQuery("SELECT COUNT(kitap_ID) FROM urunler");
        rs.next();
        adet = rs.getInt(1);
        } catch (SQLException e) {
        }
        
        return adet;
    }
     
    public static double sayfaSayisi(int kitapSayisi,int sayfaBasinaUrun){
    
        return Math.ceil((double)kitapSayisi/sayfaBasinaUrun);
    }
    
}
