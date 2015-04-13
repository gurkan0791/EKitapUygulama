/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ekitap.model;

import com.ekitap.beans.CalisanlarBean;
import com.ekitap.beans.MD5Uygula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
}
