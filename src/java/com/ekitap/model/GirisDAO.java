/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ekitap.model;

import com.ekitap.beans.CalisanlarBean;
import com.ekitap.beans.MD5Uygula;
import com.ekitap.beans.MusteriBean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
 */
public class GirisDAO {
    
    private static Connection mySqlConnection;
    private static PreparedStatement pStmt ;
    private static ResultSet rs ;
    
    public static CalisanlarBean getYetkiliKullanici(String email, String sifre){
        
        CalisanlarBean calisanlar = null;
        mySqlConnection = Veritabani.getMySqlConnection();
        String sql = "SELECT *FROM calisanlar WHERE email=? and sifre=?"; 
        try {
            pStmt = mySqlConnection.prepareStatement(sql);
            pStmt.setString(1, email);
            pStmt.setString(2, MD5Uygula.getMD5(sifre));
            
            rs = pStmt.executeQuery();
            
            if (rs.next()) {
                calisanlar = new CalisanlarBean(rs.getInt("calisan_id"),
                                                rs.getString("ad"),
                                                rs.getString("soyad"),
                                                rs.getString("email"),
                                                rs.getString("sifre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pStmt.close();
                rs.close();
                mySqlConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return calisanlar;
    }
    
    public static MusteriBean getYetkiliMusteri(String email, String sifre){
        
        MusteriBean musteri = null;
        mySqlConnection = Veritabani.getMySqlConnection();
        String sql = "SELECT *FROM musteriler WHERE email=? and sifre=?"; 
        try {
            pStmt = mySqlConnection.prepareStatement(sql);
            pStmt.setString(1, email);
            pStmt.setString(2, MD5Uygula.getMD5(sifre));
            
            rs = pStmt.executeQuery();
            
            if (rs.next()) {
                musteri = new MusteriBean(rs.getInt(1),
                                                rs.getString(2),
                                                rs.getString(3),
                                                rs.getString(4),
                                                rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pStmt.close();
                rs.close();
                mySqlConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return musteri;
    }
    
    
    
    /* Kullanıcı Kayıt*/
    public static MusteriBean setMusteri(MusteriBean musteri){
        
//        MusteriBean musteriList = null;
        MusteriBean musteriList = null;
        mySqlConnection = Veritabani.getMySqlConnection();
        String sql = "INSERT INTO musteriler (ID,ad,soyad,email,sifre)  VALUES (?,?,?,?,?)"; 
        String sql1 = "SELECT * from musteriler WHERE email= ?";
        try {
            
            
            pStmt = mySqlConnection.prepareStatement(sql1);
            pStmt.setString(1, musteri.getMusteriMail());
            rs = pStmt.executeQuery();
            if (rs.next()) {
                return null;
            }else{
            
            pStmt = mySqlConnection.prepareStatement(sql);
            pStmt.setInt(1, 0);
            pStmt.setString(2, musteri.getMusteriAD());
            pStmt.setString(3,musteri.getMusteriSoyad());
            pStmt.setString(4,musteri.getMusteriMail());
            pStmt.setString(5,MD5Uygula.getMD5(musteri.getMusteriSifre()));
            pStmt.executeUpdate();
            
            pStmt = mySqlConnection.prepareStatement(sql1);
            pStmt.setString(1, musteri.getMusteriMail());
            rs = pStmt.executeQuery();
                if (rs.next()) {
                 
                    musteriList = new MusteriBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                pStmt.close();
                rs.close();
                mySqlConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return musteriList;
    }
}
