/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ekitap.controller;

import com.ekitap.beans.CalisanlarBean;
import com.ekitap.model.GirisDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
 */
public class LoginController extends HttpServlet {

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
        
        String userPath = request.getServletPath();
        
        response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
        response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
        response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
        response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
        
        if (userPath.equals("/logout")) {
            request.getSession().removeAttribute("calisanlar");
            request.getSession().invalidate();
            request.getRequestDispatcher("/WEB-INF/view/adminpanel/adminlogin.jsp").forward(request, response);
           // response.sendRedirect("adminpanel.jsp");
            
        }else{
        
        Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
        System.out.println("asdas"+request.getContextPath());
        String url = "/WEB-INF/view/adminpanel/adminlogin.jsp";
        RequestDispatcher view = null;
        String email = request.getParameter("email");
//        if (name == null || name.trim().isEmpty()) {
//            messages.put("name", "Please enter name");
//        }
//        else if (!name.matches("\\p{Alnum}+")){
//            messages.put("name", "Please enter alphanumeric characters only");
//        }
        
        String sifre = request.getParameter("sifre");
        if (sifre == null || sifre.trim().isEmpty()) {
            messages.put("sifre", "Please enter password");
        }
//        else if (!age.matches("\\d+")) {
//            messages.put("age", "Please enter digits only");
//        }
//        for (Map.Entry<String, String> entry : messages.entrySet()) {
//            String string = entry.getKey();
//            String string1 = entry.getValue();
//            System.out.println(string + " " + string1);
//        }
        if (messages.isEmpty() ) {
            //veritabanında kontrol et
            CalisanlarBean calisanlar=GirisDAO.getYetkiliKullanici(email, sifre);
            if (calisanlar!=null) {
                request.getSession().setAttribute("calisanlar", calisanlar);
//            messages.put("success", String.format("Hello, your name is %s and your age is %s!", email, sifre));
                view = request.getRequestDispatcher("/WEB-INF/view/adminpanel/adminpanel.jsp");
           // response.sendRedirect("adminpanel.jsp");
                view.forward(request, response);
            }else{
                view = request.getRequestDispatcher("/WEB-INF/view/adminpanel/adminlogin.jsp");
           // response.sendRedirect("adminpanel.jsp");
                view.forward(request, response);
            }
            
        } else if(request.getSession().getAttribute("calisanlar")!=null){
             view = request.getRequestDispatcher("/WEB-INF/view/adminpanel/adminpanel.jsp");
           // response.sendRedirect("adminpanel.jsp");
                view.forward(request, response);
        }
        else{
            view = request.getRequestDispatcher(url);
            view.forward(request,response);
        }
        
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
