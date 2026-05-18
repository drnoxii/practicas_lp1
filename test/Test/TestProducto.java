/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Dao.ProductoDaoImpl;
import Interface.IProducto;
import Model.Productos;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author spide
 */
public class TestProducto {

    public static IProducto dao = new ProductoDaoImpl();
    
    TestProducto t = new TestProducto();
    
    
    
    public static void main(String[] args) {
      
       // insertar();
        
       // actulizar();
       // listar(); 
       
       search();
        
        
        
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
    public static void insertar(){
    
    Productos p = new Productos();
    p.setNombre("Mouse Logitech");
    p.setDescripcion("RGB ON DPI 2400");
    p.setPrecio(230.99);
    p.setStock(17);
    p.setImagen("/resources/img/teclado.jpg");
    boolean result = dao.insert(p);
        if (result) {
            System.out.println("Producto insertado");
        }else {
        
            System.out.println("Error al insertar");
        }
    }
    
   public static void actulizar(){
   
       Productos p = new Productos();
    p.setNombre("arroz costeño");
    p.setDescripcion("mas agradable");
    p.setPrecio(20);
    p.setStock(30);
    p.setImagen("/resources/img/arroz.jpg");
    p.setId_producto(1);
       
    boolean result = dao.insert(p);
        if (result) {
            System.out.println("Producto actualizado");
        }else {
        
            System.out.println("Error al actulizar");
        }
   
   }
   public static void search(){
   
   Productos pr = dao.SearchbyId(3);
       if (pr !=null) {
           System.out.println("Producto Encontrado");
           System.out.println("ID:"+ pr.getId_producto());
           System.out.println("Nombre:"+ pr.getNombre());
           System.out.println("Descripcion:"+ pr.getDescripcion());
           System.out.println("Precio:"+ pr.getPrecio());
           System.out.println("Stock:"+ pr.getStock());
           System.out.println("Ruta img:"+ pr.getImagen());
       } else {
           System.out.println("No hay registros");
       }
   
   }
   public static void delete(){
    boolean result = dao.delete(3);
  
       if (result) {
           System.out.println("Producto Eliminado");
       } else {
           System.out.println("No se pudo eliminar");
       }
   
   }
   
   public static void updatestock(){
   boolean result = dao.updateStock(4,299);
  
       if (result) {
           System.out.println("Stock Actulizado");
       } else {
           System.out.println("No se pudo actualizar");
       }
   }
   
}
