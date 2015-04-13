/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ekitap.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
 */
public class Veritabani {
    
    public static Connection getMySqlConnection(){
        Connection connection = null;
        try {
            Class.forName(Sabitler.DB_DRIVER);
            connection = DriverManager.getConnection(Sabitler.SERVER_NAME,Sabitler.DB_USER_NAME,Sabitler.DB_USER_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
}
