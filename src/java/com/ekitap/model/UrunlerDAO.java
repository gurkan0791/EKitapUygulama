/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ekitap.model;

import com.ekitap.beans.UrunFiyatBean;
import com.ekitap.beans.OzellikBean;
import com.ekitap.beans.StokBean;
import com.ekitap.beans.UrunDetayBean;
import com.ekitap.beans.UrunOzellikBean;
import com.ekitap.beans.UrunResimBean;
import com.ekitap.beans.UrunYazarYayinBean;
import com.ekitap.beans.UrunlerBean;
import com.ekitap.beans.YeniUrunBean;
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
    
    
    public static int setUrunEkle(UrunlerBean urunler,int urunKontrol){
        baglan = Veritabani.getMySqlConnection();
        
        int urunID = 0;
        try {
            cs = baglan.prepareCall("{call sp_urun_ekle(?,?,?,?,?)}");
            cs.setInt(1, 0);
            cs.setString(2, urunler.getKitapAD());
//            cs.setInt(3, urunler.getYayinEviID());
//            cs.setInt(4, urunler.getYazarID());
            cs.setInt(3, urunler.getKategoriID());
            cs.setString(4, urunler.getAciklama());
            cs.setInt(5,urunKontrol);
            if (urunKontrol==0) {
                ResultSet a= cs.executeQuery();
            if (a.next()) {
                urunID = a.getInt(1);
            }
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
    
     public static ArrayList<UrunlerBean> getUrunGuncelBilgi(String katID){
        baglan = Veritabani.getMySqlConnection();
        ArrayList<UrunlerBean> liste = null;
        int urunID = 0;
        try {
            cs = baglan.prepareCall("{call sp_urun_guncelbilgi(?)}");
            cs.setString(1, katID);
            
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
     
    public static ArrayList resimKaydet(int urunID, String url){
        
        ArrayList liste = null;
        ResultSet rs=null;
       // String sql = "INSERT INTO evresim(ID,EVID,resim) VALUES (?,?) ";
        baglan = Veritabani.getMySqlConnection();
        try {
            cs = baglan.prepareCall("{call sp_urun_resim_ekle(?,?)}");
            
            cs.setInt(1, urunID);
            cs.setString(2, url);
            
            rs= cs.executeQuery();
            liste = new ArrayList<UrunResimBean>();
            while (rs.next()) {
                liste.add(new UrunResimBean(rs.getInt(1), rs.getInt(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e1){}
        finally{
            try {
                cs.close();
                rs.close();
                baglan.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return  null;
            }
        }
        return liste;
    }  
    
    public static ArrayList getResimListele(int urunID){
        
        ArrayList liste = null;
        ResultSet rs=null;
       // String sql = "INSERT INTO evresim(ID,EVID,resim) VALUES (?,?) ";
        baglan = Veritabani.getMySqlConnection();
        try {
            cs = baglan.prepareCall("{call sp_urun_resim_listele(?)}");
            cs.setInt(1, urunID);
            rs= cs.executeQuery();
            liste = new ArrayList<UrunResimBean>();
            while (rs.next()) {
                liste.add(new UrunResimBean(rs.getInt(1), rs.getInt(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e1){}
        finally{
            try {
                cs.close();
                rs.close();
                baglan.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return  null;
            }
        }
        return liste;
    }  
    
    public static ArrayList setUrunFiyat(int urunID,float vergiOnce, float vergiSonra){
        
        ArrayList liste = null;
        ResultSet rs=null;
       // String sql = "INSERT INTO evresim(ID,EVID,resim) VALUES (?,?) ";
        baglan = Veritabani.getMySqlConnection();
        try {
            cs = baglan.prepareCall("{call sp_urun_fiyat_ekle(?,?,?)}");
            cs.setInt(1,urunID);
            cs.setFloat(2, vergiOnce);
            cs.setFloat(3, vergiSonra);
            
            rs= cs.executeQuery();
            liste = new ArrayList<UrunFiyatBean>();
            while (rs.next()) {
                liste.add(new UrunFiyatBean(rs.getInt(1),rs.getInt(2),rs.getFloat(3),rs.getFloat(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e1){}
        finally{
            try {
                cs.close();
                rs.close();
                baglan.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return  null;
            }
        }
        return liste;
    }  
    
    public static ArrayList getUrunFiyat(int urunID){
        
        ArrayList liste = null;
        ResultSet rs=null;
       // String sql = "INSERT INTO evresim(ID,EVID,resim) VALUES (?,?) ";
        baglan = Veritabani.getMySqlConnection();
        try {
            cs = baglan.prepareCall("{call sp_urun_fiyat_listele(?)}");
            cs.setInt(1, urunID);
            rs= cs.executeQuery();
            liste = new ArrayList<UrunFiyatBean>();
            while (rs.next()) {
                liste.add(new UrunFiyatBean(rs.getInt(1), rs.getInt(2), rs.getFloat(3), rs.getFloat(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e1){}
        finally{
            try {
                cs.close();
                rs.close();
                baglan.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return  null;
            }
        }
        return liste;
    }  
    
     public static ArrayList<StokBean> setUrunStok(StokBean stok){
        
//        ArrayList liste = null;
        ResultSet rs=null;
       // String sql = "INSERT INTO evresim(ID,EVID,resim) VALUES (?,?) ";
        baglan = Veritabani.getMySqlConnection();
        try {
            cs = baglan.prepareCall("{call sp_urun_stok_ekle(?,?,?)}");
            cs.setInt(1,stok.getId());
            cs.setInt(2, stok.getUrunID());
            cs.setInt(3, stok.getStok());
            
            rs= cs.executeQuery();
           
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e1){}
        finally{
            try {
                cs.close();
                rs.close();
                baglan.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return  null;
            }
        }
        return null;
    }  
     
     public static ArrayList<StokBean> getUrunStok(int urunID){
        
        ArrayList liste = null;
        ResultSet rs=null;
       // String sql = "INSERT INTO evresim(ID,EVID,resim) VALUES (?,?) ";
        baglan = Veritabani.getMySqlConnection();
        try {
            cs = baglan.prepareCall("{call sp_urun_stok_listele(?)}");
            cs.setInt(1, urunID);
            
            rs= cs.executeQuery();
            liste = new ArrayList<StokBean>();
            while (rs.next()) {
                liste.add(new StokBean(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e1){}
        finally{
            try {
                cs.close();
                rs.close();
                baglan.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return  null;
            }
        }
        return liste;
    }  
     
    public static ArrayList setUrunOzellik(ArrayList<UrunOzellikBean> liste){
        
       
        ResultSet rs=null;
       // String sql = "INSERT INTO evresim(ID,EVID,resim) VALUES (?,?) ";
        baglan = Veritabani.getMySqlConnection();
        try {
            for (UrunOzellikBean urunOzellikBean : liste) {
                cs = baglan.prepareCall("{call sp_urun_ozellik_ekle(?,?,?)}");
                cs.setInt(1,urunOzellikBean.getUrunID());
                cs.setInt(2, urunOzellikBean.getOzellikID());
                cs.setString(3, urunOzellikBean.getDeger());
            rs= cs.executeQuery();
            }
            
//            liste = new ArrayList<UrunFiyatBean>();
//            while (rs.next()) {
//                liste.add(new UrunFiyatBean(rs.getInt(1),rs.getInt(2),rs.getFloat(3),rs.getFloat(4)));
//            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e1){}
        finally{
            try {
                cs.close();
                rs.close();
                baglan.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return  null;
            }
        }
        return liste;
    }  
    
    public static ArrayList getOzellik(){
        
        ArrayList liste = null;
        ResultSet rs=null;
       // String sql = "INSERT INTO evresim(ID,EVID,resim) VALUES (?,?) ";
        baglan = Veritabani.getMySqlConnection();
        try {
            cs = baglan.prepareCall("{call sp_ozellik_listele()}");
           // cs.setInt(1, urunID);
            rs= cs.executeQuery();
            liste = new ArrayList<OzellikBean>();
            while (rs.next()) {
                liste.add(new OzellikBean(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e1){}
        finally{
            try {
                cs.close();
                rs.close();
                baglan.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return  null;
            }
        }
        return liste;
    }  
    
    public static ArrayList getUrunOzellik(int urunID){
        
        ArrayList liste = null;
        ResultSet rs=null;
       // String sql = "INSERT INTO evresim(ID,EVID,resim) VALUES (?,?) ";
        baglan = Veritabani.getMySqlConnection();
        try {
            cs = baglan.prepareCall("{call sp_urun_ozellik_listele(?)}");
            cs.setInt(1, urunID);
            rs= cs.executeQuery();
            liste = new ArrayList<UrunOzellikBean>();
            while (rs.next()) {
                liste.add(new UrunOzellikBean(rs.getInt(1), rs.getInt(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e1){}
        finally{
            try {
                cs.close();
                rs.close();
                baglan.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return  null;
            }
        }
        return liste;
    }  
    
    public static ArrayList getYeniUrun(){
        
        ArrayList liste = null;
        
        ResultSet rs=null;
       // String sql = "INSERT INTO evresim(ID,EVID,resim) VALUES (?,?) ";
        baglan = Veritabani.getMySqlConnection();
        try {
            cs = baglan.prepareCall("{call sp_yeni_urun_cek()}");
           // cs.setInt(1, urunID);
            rs= cs.executeQuery();
            liste = new ArrayList<UrunlerBean>();
            while (rs.next()) {
                liste.add(new YeniUrunBean(rs.getInt(1), rs.getString(2), rs.getFloat(10), rs.getString(16)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e1){}
        finally{
            try {
                cs.close();
                rs.close();
                baglan.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return  null;
            }
        }
        return liste;
    }  
    
    public static ArrayList getUrunDetayBilgi(int urunID){
        
        ArrayList liste = null;
        
        ResultSet rs=null;
       // String sql = "INSERT INTO evresim(ID,EVID,resim) VALUES (?,?) ";
        baglan = Veritabani.getMySqlConnection();
        try {
            cs = baglan.prepareCall("{call sp_urun_detay_listele(?)}");
            cs.setInt(1, urunID);
            rs= cs.executeQuery();
            liste = new ArrayList<UrunlerBean>();
            if (rs.next()) {
                liste.add(new UrunDetayBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getFloat(10), rs.getInt(14), rs.getString(16)));
            }else{
                liste = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e1){}
        finally{
            try {
                cs.close();
                rs.close();
                baglan.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return  null;
            }
        }
        return liste;
    }  
    
    public static ArrayList getUrunYazarYayin(int urunID){
        
        ArrayList liste = null;
        
        ResultSet rs=null;
        
//        SELECT * FROM `urunler` as u INNER JOIN yayinevi as ye on u.yayinevi_ID = ye.yayinID INNER JOIN yazar as y on u.yazar_ID = y.yazarID WHERE u.kitap_ID= 1
        baglan = Veritabani.getMySqlConnection();
        try {
            cs = baglan.prepareCall("{call sp_urun_yazar_yayin(?)}");
            cs.setInt(1, urunID);
            rs= cs.executeQuery();
            liste = new ArrayList<UrunlerBean>();
            while (rs.next()) {
                liste.add(new UrunYazarYayinBean(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(8), rs.getInt(4), rs.getString(12), rs.getString(13), rs.getInt(5), rs.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e1){}
        finally{
            try {
                cs.close();
                rs.close();
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
