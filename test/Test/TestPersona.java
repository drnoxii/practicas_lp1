/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Dao.PersonaDaoImpl;
import Interface.IPersona;
import Model.Persona;
import Model.Rol;
import Model.Usuario;

/**
 *
 * @author spide
 */
public class TestPersona {

    IPersona dao = new PersonaDaoImpl();
    
    
    
    public static void main(String[] args) {
       
        TestPersona t = new TestPersona(); 
        t.insert();
        
    }
    
    public void insert(){
        Persona p = new Persona();
        
        p.setNombre("Josias David");
        p.setEmail("josias@gmail.com");
        p.setTelefono("987654321");
        p.setDireccion("Av.Urbanizacion");
        
        Usuario u = new Usuario();
        u.setPassword("admin123");
        u.setRol(Rol.CLIENTE);
        int result = dao.insert(p, u);
        
        if (result > 0 ){
        System.out.println("Persona y User Creada");
         System.out.println("Usuario:" + p.getEmail());
         System.out.println("Rol asignado" + u.getRol());
        
        }else{
         System.out.println("No se pudo realizar el registro");
        }
    
    }
    
}
