/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "procesaServlet", urlPatterns = {"/procesaServlet"})
public class procesaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int contador = 0;
        Cookie[] cukis = request.getCookies();
        if (cukis != null) {
            for (Cookie c : cukis) {
                if (c.getName().equals("visitas")) {
                    //antes de la asignacion se convierte en un valor cadena
                    contador = Integer.parseInt(c.getValue());
                }
            }
        }
        contador++;
        Cookie c = new Cookie("visitas", Integer.toString(contador));
        //establece el tiempo de la cookie en segundos

        c.setMaxAge(30);
        response.addCookie(c);
        
        response.setContentType("text/html");
        if (contador == 1) {
            PrintWriter out = response.getWriter();
            out.print("<h2>Bienvenido a nuestro sitio Web</h2>  "+" cookie en: "+contador);
            
        } else {
            PrintWriter out = response.getWriter();
            out.print("<h2>Gracias por visitarnos nuevamente</h2> "+"  cookie en: "+contador);
           
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
