package com.isdcm.controller;

import com.isdcm.dao.VideoDAO;
import com.isdcm.dto.VideoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalTime;


@WebServlet(urlPatterns = {"/register"})
public class ServletRegistroVid extends HttpServlet {
    private VideoDAO videoDAO;

    public ServletRegistroVid() {
        this.videoDAO = new VideoDAO();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletRegistroVid</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletRegistroVid at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private void response(HttpServletResponse resp, String msg)throws IOException {
	PrintWriter out = resp.getWriter();
	out.println("<html>");
	out.println("<body>");
	out.println("<t1>" + msg + "</t1>");
	out.println("</body>");
        out.println("</html>");
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

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
            System.out.println(request);
            String ti = request.getParameter("title");
            String au = request.getParameter("author");
            LocalDate fe = LocalDate.parse(request.getParameter("creation_date"));
            LocalTime du = LocalTime.parse(request.getParameter("duration"));
            String de = request.getParameter("desciption");
            String fo = request.getParameter("format");
            
            System.out.println("title: " + ti);
            System.out.println("author: " + au);
            System.out.println("creation_date: " + fe);
            System.out.println("duration: " + du);
            System.out.println("desciption: " + de);
            System.out.println("format: " + fo);
            
            
            // TODO: Añadir un check que nos confirma que no hay repeticiones en la base de datos
            
            
            // Añadir dato a la base de datos
            VideoDTO video = new VideoDTO(0, ti, au, fe, du, 0, de, fo);
            videoDAO.insertVideo(video);
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
