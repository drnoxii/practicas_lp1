/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Dao.ProductoDaoImpl;
import Interface.IProducto;
import Model.Productos;
import java.util.List;

/**
 *
 * @author spide
 */
public class TestProducto {

    public static IProducto dao = new ProductoDaoImpl();
    
    TestProducto t = new TestProducto();
    
    
    
    public static void main(String[] args) {
      
        listar();
        
        
        
    }
    public static void listar (){
    List<Productos> lista = dao.lista();
    
        if (lista !=null && !lista.isEmpty()) {
            System.out.println("ID\tNombre\t\tPrecio\tStock");
            for (Productos p : lista){
            
                System.out.println(p.getId_producto()+ "\t"+ p.getNombre() + "\t" + p.getPrecio()+ "\t"+ p.getStock());
            }
        } else {
            System.out.println("no hay productos");
        }
    
    
    }
    
}
