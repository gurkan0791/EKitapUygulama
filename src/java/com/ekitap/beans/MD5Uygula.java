/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ekitap.beans;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
 */
public class MD5Uygula {
    
    public static String getMD5(String parola){
        try{
        MessageDigest messageDigestNesnesi = MessageDigest.getInstance("MD5");
        messageDigestNesnesi.update(parola.getBytes());
        byte messageDigestDizisi[] = messageDigestNesnesi.digest();
        StringBuilder sb16 = new StringBuilder();
//        StringBuffer sb32 = new StringBuffer();
        for (int i = 0; i < messageDigestDizisi.length; i++) {
        sb16.append(Integer.toString((messageDigestDizisi[i] & 0xff) + 0x100, 16).substring(1));
//        sb32.append(Integer.toString((messageDigestDizisi[i] & 0xff) + 0x100, 32));
        }
        parola = sb16.toString();
        System.out.println("Parolanın Şifrelenmiş Hali:(16) " + sb16.toString());
//        System.out.println("Parolanın Şifrelenmiş Hali:(32) " + sb32.toString());
           }
        catch(NoSuchAlgorithmException ex){
            System.err.println(ex);
        }
        return parola;
    }
    
    }
