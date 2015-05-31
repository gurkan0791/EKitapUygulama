/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ekitap.controller;

import com.ekitap.beans.UrunDetayBean;
import com.ekitap.beans.UrunOzellikBean;
import com.ekitap.beans.UrunYazarYayinBean;
import com.ekitap.model.UrunlerDAO;
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
public class UrunController extends HttpServlet {

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
        ArrayList<UrunDetayBean> detay_liste = null;
        ArrayList<UrunYazarYayinBean> yazar_yayin_liste = null;
        ArrayList<UrunOzellikBean> urun_ozellik_liste = null;
        switch(adminPath){
            case "/kitap" :
                try {
                    int urunID = Integer.parseInt(request.getParameter("urunID"));
//                    System.out.println("lalala"+urunID);
                    detay_liste = UrunlerDAO.getUrunDetayBilgi(urunID);
                    yazar_yayin_liste = UrunlerDAO.getUrunYazarYayin(urunID);
                    urun_ozellik_liste = UrunlerDAO.getUrunOzellik(urunID);
                    
                    if (detay_liste == null) {
                          request.setAttribute("uyari", "Urun Bulunamadı");
                    }
                    if (detay_liste != null) {
                     request.setAttribute("urundetayliste", detay_liste);
                    }
                    if (yazar_yayin_liste != null) {
                       request.setAttribute("urunyazaryayinliste", yazar_yayin_liste);
                    }
                    if (urun_ozellik_liste != null) {
                        request.setAttribute("urunozellikliste", urun_ozellik_liste);
                    }
                    
                    
                    
//                    UrunYazarYayinBean a = yazar_yayin_liste.get(0);
//                    System.out.println("Yazarad : "+a.getYazarAD());
                   

                    url = "/WEB-INF/view/user" + adminPath + ".jsp";
                    request.getRequestDispatcher(url).forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                
            break;
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
