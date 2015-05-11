/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ekitap.model;

import com.ekitap.beans.CalisanlarBean;
import com.ekitap.beans.KategoriBean;
import com.ekitap.beans.MD5Uygula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
 */
public class KategoriDAO {
    
    private static Connection mySqlConnection;
    private static PreparedStatement pStmt ;
    private static ResultSet rs ;
    
    public static String setKategoriEkle(KategoriBean kategori){
        
        KategoriBean kategoriList = null;
        mySqlConnection = Veritabani.getMySqlConnection();
        String sql = "INSERT INTO kategoriler VALUES (?,?,?,?,?)"; 
        String sql1 = "SELECT * from kategoriler WHERE kategori_ADI= ?";
        try {
            
            
            pStmt = mySqlConnection.prepareStatement(sql1);
            pStmt.setString(1, kategori.getKategoriADI());
            rs = pStmt.executeQuery();
            if (rs.next()) {
                return "Basarisiz";
            }else{
            
            pStmt = mySqlConnection.prepareStatement(sql);
            pStmt.setInt(1, 0);
            pStmt.setInt(2, kategori.getAltKategoriID());
            pStmt.setString(3,kategori.getKategoriADI());
            pStmt.setString(4,kategori.getKategoriAciklama());
            pStmt.setString(5, "bos");
            pStmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Basarisiz";
        } finally {
            try {
                pStmt.close();
//                rs.close();
                mySqlConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "Basarili";
    }
    
    public static ArrayList<KategoriBean> getKategoriListele(){
        
        ArrayList<KategoriBean> liste = null;
        Statement st=null;
        mySqlConnection = Veritabani.getMySqlConnection();
        String sql = "SELECT * FROM kategoriler"; 
        try {
            st = mySqlConnection.createStatement();
            rs = st.executeQuery(sql);
            liste = new ArrayList<KategoriBean>();
            while (rs.next()) {
                liste.add(new KategoriBean( rs.getInt("kategori_ID"),
                                            rs.getInt("alt_kategori_ID"),
                                            rs.getString("kategori_ADI"),
                                            rs.getString("kategori_aciklama"),
                                            rs.getString("kat_resim_url")));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                st.close();
                rs.close();
                mySqlConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return liste;
    }
    
}
