/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Interface.IUsuario;
import Model.Persona;
import Model.Usuario;
import com.sun.jdi.connect.spi.Connection;

/**
 *
 * @author spide
 */
public class UsuarioDaoImpl implements IUsuario {
    private Connection cn;

    @Override
    public Usuario validate(String user, String password) {
        Usuario u = null;
        Persona p = null;
        
        PreparedStatement st;
        ResultSet rs;
        String query = null;    
}       
}





