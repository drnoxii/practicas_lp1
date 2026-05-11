/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Interface.IProducto;
import Model.Productos;
import java.util.List;
import java.sql.*;
import Util.ConexionSingleton;
import java.util.ArrayList;
/**
 *
 * @author spide
 */
public class ProductoDaoImpl implements IProducto{
    private Connection cn;

    @Override
    public List<Productos> lista() {
        List<Productos> lista = null;
        Productos pr;
        PreparedStatement st;
        ResultSet rs;
        String query = null;
        
        try {
            query = "SELECT id_producto, nombre, descripcion, precio,stock FROM productos";
            
            lista = new ArrayList <>();
            if (cn==null || cn.isClosed()) {
                System.out.println("La conexion es nula o esta cerrada");
                
            }
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {  
                pr = new Productos();
                pr.setId_producto(rs.getInt("id_producto"));
               pr.setNombre(rs.getString("nombre"));
               pr.setDescripcion(rs.getString("descrpcion"));
               pr.setPrecio(rs.getDouble("precio"));
               pr.setStock(rs.getInt("stock"));
               lista.add(pr);
                
                                        }
            
        } catch(Exception e){
            System.out.println("Error al validar usuario:"+ e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
               
            }
            System.out.println("No se pudo validar el usuario");
        }finally {
            if (cn!=null) {
                try {
                } catch (Exception ex) {
                    
                }
            }
        }return lista;
    }
    @Override
    public boolean insert(Productos p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Productos p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Productos SearchbyId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateStock(int id, int stock) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
