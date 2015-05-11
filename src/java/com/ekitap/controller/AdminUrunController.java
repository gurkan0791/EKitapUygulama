/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ekitap.controller;

import com.ekitap.beans.KategoriBean;
import com.ekitap.beans.UrunlerBean;
import com.ekitap.beans.YayinEviBean;
import com.ekitap.beans.YazarBean;
import com.ekitap.model.KategoriDAO;
import com.ekitap.model.UrunlerDAO;
import com.ekitap.model.YayinEviDAO;
import com.ekitap.model.YazarDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
 */
public class AdminUrunController extends HttpServlet {

     private static final int sayfaBasinaUrun = 5;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("ISO-8859-9");
        String adminPath = request.getServletPath();
        String url = null;
        String adi = request.getParameter("adi");
        ArrayList<KategoriBean> liste = null;
        ArrayList<YazarBean> yazarListe = null;
        ArrayList<YayinEviBean> yayinEviListe = null;
        ArrayList<UrunlerBean> urunListe = null;
        int sayfa = 1;
        int sayfaSayisi =(int) UrunlerDAO.sayfaSayisi(UrunlerDAO.getUrunAdet(),sayfaBasinaUrun);
        if(adminPath.equals("/urungoster")){
            System.out.println(request.getParameter("id"));
            try {
            sayfa = Integer.parseInt(request.getParameter("id"));
                if (sayfa<=0 || sayfa>sayfaSayisi) {
                    sayfa = 1;
                }
            } catch (Exception e) {
                sayfa = 1;
            }
            
            int baslangicSayisi = (sayfa-1)*sayfaBasinaUrun; 
            urunListe = UrunlerDAO.getUrunListele(baslangicSayisi,sayfaBasinaUrun);
            if (urunListe != null) {
                request.setAttribute("urunliste", urunListe);
                request.setAttribute("sayfasayisi", sayfaSayisi);
             }
            
            url = "/WEB-INF/view/adminpanel" + adminPath + ".jsp";
            request.getRequestDispatcher(url).forward(request, response);
        }
        else if (adminPath.equals("/urunekle")) {
            if (adi == null || adi.trim().isEmpty()) {
                liste= KategoriDAO.getKategoriListele();
            yazarListe = YazarDAO.getYazarListele();
            yayinEviListe = YayinEviDAO.getYayinEviListele();
             if (liste != null) {
                request.setAttribute("katliste", liste);
             }
             if (yazarListe != null) {
                request.setAttribute("yazarliste", yazarListe);
            }
             if (yayinEviListe != null) {
                request.setAttribute("yayinliste", yayinEviListe);
            }
            url = "/WEB-INF/view/adminpanel" + adminPath + ".jsp";
            request.getRequestDispatcher(url).forward(request, response);
            }
            // ürün ekle
            else{
                int yayin = Integer.parseInt(request.getParameter("yayin"));
                int yazar = Integer.parseInt(request.getParameter("yazar"));
                int katidd = Integer.parseInt(request.getParameter("katidd"));
                UrunlerBean urunler = new UrunlerBean(0,request.getParameter("adi"),yayin,
                        yazar,katidd,request.getParameter("aciklama"));
                int urunID =  UrunlerDAO.setUrunEkle(urunler);
                
            }
            
        }
        else if (adminPath.equals("/urunguncelle")){
            url = "/WEB-INF/view/adminpanel" + adminPath + ".jsp";
            request.getRequestDispatcher(url).forward(request, response);
        }
        else if (adminPath.equals("/yazarekle")){
            System.out.println(request.getParameter("yazaradi"));
            //burdan cek
            YazarBean yazar = new YazarBean(0, request.getParameter("yazarad"), 
                    request.getParameter("yazarsoyad"),
                    request.getParameter("yazarmail"));
          //  System.out.println(request.getParameter("yazarad")+request.getParameter("yazarsoyad")+request.getParameter("yazarmail"));
            YazarDAO.setYazarEkle(yazar);
        }
        else if (adminPath.equals("/yayineviekle")){
            YayinEviBean yayinEvi = new YayinEviBean(0, request.getParameter("yayinad"), 
                    request.getParameter("yayinadres"),
                    request.getParameter("yayinmail"));
            YayinEviDAO.setYayinEviEkle(yayinEvi);
            
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
