/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ekitap.controller;

import com.ekitap.beans.KategoriBean;
import com.ekitap.model.KategoriDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
 */
public class AdminKategoriController extends HttpServlet {

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
         ArrayList<KategoriBean> liste = null;
        String adminPath = request.getServletPath();
//        RequestDispatcher rdisp = null;
        String katadi = request.getParameter("katadi");
        String katID = request.getParameter("altKatID");
//        System.out.println("Katid"+katID);
        if (adminPath.equals("/kategorigoster")) {
           liste= KategoriDAO.getKategoriListele();
            if (liste != null) {
                request.setAttribute("katliste", liste);
            }
            String url = "/WEB-INF/view/adminpanel" + adminPath + ".jsp";
        
            request.getRequestDispatcher(url).forward(request, response);
        }else if (adminPath.equals("/kategoriekle")){
            if (katadi == null || katadi.trim().isEmpty()) {
                adminPath = "/kategoriekle";
                String url = "/WEB-INF/view/adminpanel" + adminPath + ".jsp";
                    liste= KategoriDAO.getKategoriListele();
                    
                     if (liste != null) {
                        request.setAttribute("katliste", liste);
                    }
                request.getRequestDispatcher(url).forward(request, response);
            }else{
               
                KategoriBean kategori = new KategoriBean(0,Integer.parseInt(request.getParameter("katidd")),
                    request.getParameter("katadi"),
                    request.getParameter("aciklama"), "bos");
                String durum = KategoriDAO.setKategoriEkle(kategori);
                if (durum.equals("Basarili")) {
                    request.setAttribute("durum", durum);
                    liste= KategoriDAO.getKategoriListele();
                    
                     if (liste != null) {
                        request.setAttribute("katliste", liste);
                    }
                    //adminPath = "/kategorigoster";
                     if (katID == null) {
                        katID="0";
                    }
                    response.sendRedirect("/kategorigoster?altKatID="+katID);
                }else{
                    request.setAttribute("durum", "Kategori Zaten mevcut");
                    adminPath = "/kategoriekle";
                    String url = "/WEB-INF/view/adminpanel" + adminPath + ".jsp";
        
                    request.getRequestDispatcher(url).forward(request, response);
                }
            }
            
        }else if(adminPath.equals("/kategoriguncelle")){
            adminPath = "/kategoriekle";
            String url = "/WEB-INF/view/adminpanel" + adminPath + ".jsp";
        
             request.getRequestDispatcher(url).forward(request, response);
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
