/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ekitap.model;

import com.ekitap.beans.YayinEviBean;
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
public class YayinEviDAO {
    
    private static Connection mySqlConnection;
    private static PreparedStatement pStmt ;
    private static ResultSet rs ;
    
    public static ArrayList<YayinEviBean> getYayinEviListele(){
        
        ArrayList<YayinEviBean> liste = null;
        Statement st=null;
        mySqlConnection = Veritabani.getMySqlConnection();
        String sql = "SELECT * FROM yayinevi"; 
        try {
            st = mySqlConnection.createStatement();
            rs = st.executeQuery(sql);
            liste = new ArrayList<YayinEviBean>();
            while (rs.next()) {
                liste.add(new YayinEviBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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
    
    public static String setYayinEviEkle(YayinEviBean yayinEvi){
        
        mySqlConnection = Veritabani.getMySqlConnection();
        String sql = "INSERT INTO yayinevi VALUES (?,?,?,?)"; 
        String sql1 = "SELECT * from yayinevi WHERE ad= ? and website=?";
        try {
            
            
            pStmt = mySqlConnection.prepareStatement(sql1);
            pStmt.setString(1, yayinEvi.getAd());
            pStmt.setString(2, yayinEvi.getWebsite());
            rs = pStmt.executeQuery();
            if (rs.next()) {
                return "Basarisiz";
            }else{
            
            pStmt = mySqlConnection.prepareStatement(sql);
            pStmt.setInt(1, 0);
            pStmt.setString(2, yayinEvi.getAd());
            pStmt.setString(3,yayinEvi.getAdres());
            pStmt.setString(4,yayinEvi.getWebsite());
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
    
}
