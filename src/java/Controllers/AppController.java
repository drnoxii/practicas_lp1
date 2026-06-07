/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Dao.PedidoDaoImpl;
import Dao.ProductoDaoImpl;
import Interface.IPedido;
import Interface.IProducto;
import Model.Carrito;
import Model.Productos;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author spide
 */
@WebServlet(name = "AppController", urlPatterns = {"/AppController"})
public class AppController extends HttpServlet {

   private IProducto pDao = new ProductoDaoImpl();
    private IPedido IDao = new PedidoDaoImpl();
    private  Gson gson= new Gson();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        JsonObject jsonResponse = new JsonObject();
        
        HttpSession session = request.getSession();
        List<Carrito> listCarrito = (List<Carrito>) session.getAttribute("carrito");
        
        if (listCarrito == null) {
           listCarrito = new ArrayList<>();
           session.setAttribute("carrito", listCarrito);
            
            try (PrintWriter out = response.getWriter()){
                switch (action) {
                    case "listarProductos" :
                        List<Productos> productos = pDao.lista();
                        out.print(gson.toJson(productos));
                        break;
                    case "addcarrito":
                        int id = Integer.parseInt(request.getParameter("id"));
                        Productos p = pDao.SearchbyId(id);
                        if (p != null) {
                            
                        
                        int pos = -1;
                        for (int i = 0; i < listCarrito.size(); i++) {
                            if (listCarrito.get(i).getIdProducto()== id ){
                                pos = i;
                                break;
                            }
                        }
                        if (pos != -1) {
                            int nuevaCant = listCarrito.get(pos).getCantidad()+1;
                            listCarrito.get(pos).setCantidad(nuevaCant);
                            listCarrito.get(pos).setSubTotal(nuevaCant* p.getPrecio());
                            
                            
                        }
                        }
                        
                        break;
                    default:
                        jsonResponse.addProperty("success",false);
                        jsonResponse.addProperty("messagge","accion no encontrada");
                        out.print(jsonResponse.toString());
                }
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
