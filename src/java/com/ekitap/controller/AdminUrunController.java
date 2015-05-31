/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ekitap.controller;

import com.ekitap.beans.KategoriBean;
import com.ekitap.beans.OzellikBean;
import com.ekitap.beans.StokBean;
import com.ekitap.beans.UrunOzellikBean;
import com.ekitap.beans.UrunResimBean;
import com.ekitap.beans.UrunlerBean;
import com.ekitap.beans.YayinEviBean;
import com.ekitap.beans.YazarBean;
import com.ekitap.model.KategoriDAO;
import com.ekitap.model.UrunlerDAO;
import com.ekitap.model.YayinEviDAO;
import com.ekitap.model.YazarDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Gurkan Yesilyurt <gurkan.yesilyurt@mynet.com>
 */
public class AdminUrunController extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "C:\\Users\\sony\\Documents\\NetBeansProjects\\EKitapUygulama\\web\\resimler";
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
        ArrayList<UrunlerBean> urunGuncelListe = null;
        ArrayList<UrunResimBean> liste_resim = null;
        ArrayList liste_fiyat = null;
        ArrayList<OzellikBean> liste_ozellik;
        ArrayList<UrunOzellikBean> liste_urun_ozellik;
        ArrayList<StokBean> liste_stok;
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
                int urunid ;
                try {
                 //   System.out.println(request.getParameter("urunID"));
                    urunid = Integer.parseInt(request.getParameter("urunID"));
                   // System.out.println(urunid);
                } catch (Exception e) {
                    urunid = 0;
                }
                
//                int yayin = Integer.parseInt(request.getParameter("yayin"));
//                int yazar = Integer.parseInt(request.getParameter("yazar"));
                int katidd = Integer.parseInt(request.getParameter("katidd"));
                UrunlerBean urunler = new UrunlerBean(0,request.getParameter("adi"),0,
                        0,katidd,request.getParameter("aciklama"));
                int urunID =  UrunlerDAO.setUrunEkle(urunler,urunid);
                
                adminPath = "/urunguncelle";
                response.sendRedirect("/urunguncelle?urunID="+urunID);
//                url = "/WEB-INF/view/adminpanel" + adminPath + ".jsp";
//            request.getRequestDispatcher(url).forward(request, response);
            }
            
        }
        else if (adminPath.equals("/urunguncelle")){
            liste= KategoriDAO.getKategoriListele();
            yazarListe = YazarDAO.getYazarListele();
            yayinEviListe = YayinEviDAO.getYayinEviListele();
            String urunid = request.getParameter("urunID");
             liste_resim = UrunlerDAO.getResimListele(Integer.parseInt(urunid));
             liste_fiyat = UrunlerDAO.getUrunFiyat(Integer.parseInt(urunid));
            liste_ozellik = UrunlerDAO.getOzellik();
            liste_urun_ozellik = UrunlerDAO.getUrunOzellik(Integer.parseInt(urunid));
            liste_stok = UrunlerDAO.getUrunStok(Integer.parseInt(urunid));
            if (urunid == null || urunid.trim().isEmpty()) {
                return;
            }
            urunGuncelListe = UrunlerDAO.getUrunGuncelBilgi(urunid);
            if (liste != null) {
                request.setAttribute("katliste", liste);
             }
             if (yazarListe != null) {
                request.setAttribute("yazarliste", yazarListe);
            }
             if (yayinEviListe != null) {
                request.setAttribute("yayinliste", yayinEviListe);
            }
             if (urunGuncelListe != null) {
                request.setAttribute("guncelurun", urunGuncelListe);
            }
              if (liste_resim != null) {
                    request.setAttribute("resimliste", liste_resim);
                }
              if (liste_fiyat != null) {
                    request.setAttribute("fiyatliste", liste_fiyat);
                }
            if (liste_ozellik != null) {
                request.setAttribute("ozellikliste", liste_ozellik);
            }
            if (liste_urun_ozellik != null) {
                request.setAttribute("urunozellikliste", liste_urun_ozellik);
            }
            if (liste_stok!= null) {
                request.setAttribute("stokliste", liste_stok);
            }
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
            
        }else if (adminPath.equals("/resimekle")){
            int urunID =Integer.parseInt(request.getParameter("urunID")) ;

        System.out.println(urunID);
       boolean isMultipart = ServletFileUpload.isMultipartContent(request);
       String name =null;
        // process only if it is multipart content
        if (isMultipart) {
                // Create a factory for disk-based file items
                FileItemFactory factory = new DiskFileItemFactory();

                // Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);
                try {
                // Parse the request
                List<FileItem> multiparts = upload.parseRequest(request);

                for (FileItem item : multiparts) {
                if (!item.isFormField()) {
                 name = new File(item.getName()).getName();
                item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
                }
                }
                } 
                catch (Exception e) 
                {
                  e.printStackTrace();
                }
        }
          liste_resim =   UrunlerDAO.resimKaydet(urunID, name);
          request.setAttribute("resimliste", liste_resim);
          url = "/WEB-INF/view/adminpanel" + adminPath + ".jsp";
          request.getRequestDispatcher(url).forward(request, response);
        }else if(adminPath.equals("/fiyatekle")){
            float vergiOnce =Float.parseFloat(request.getParameter("vergionce")) ;
            float vergiSonra =Float.parseFloat(request.getParameter("vergisonra")) ;
            int urunID =Integer.parseInt(request.getParameter("urunID")) ;
            
            UrunlerDAO.setUrunFiyat(urunID, vergiOnce, vergiSonra);
        }
        else if (adminPath.equals("/ozellikekle")){
            String urunid = request.getParameter("urunID");
            if (urunid == null || urunid.trim().isEmpty()) {
                return;
            }
            int i=1;
            ArrayList<UrunOzellikBean> a = new ArrayList();
            UrunOzellikBean urunOzellik;
            while (request.getParameter("field" + Integer.toString(i)) != null) {
                urunOzellik = new UrunOzellikBean(Integer.parseInt(urunid), Integer.parseInt(request.getParameter("ofield"+Integer.toString(i))), request.getParameter("field"+Integer.toString(i)));
                a.add(urunOzellik);
               
            i++;
            }
                UrunlerDAO.setUrunOzellik(a);
//            for (UrunOzellikBean object : a) {
//                System.out.println(object.getDeger()+object.getOzellikID());
//            }

        }
        else if (adminPath.equals("/stokekle")) {
             String urunid = request.getParameter("urunID");
            if (urunid == null || urunid.trim().isEmpty()) {
                return;
            }
            try {
                int stok = Integer.parseInt(request.getParameter("stok"));
                
                UrunlerDAO.setUrunStok(new StokBean(0, Integer.parseInt(urunid), stok));
            } catch (Exception e) {
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
