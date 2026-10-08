package service;

import java.util.List;

import exception.ProductoNoEncontradoException;

import java.util.ArrayList;
import model.Producto;
import util.Validador;



public class ProductoService {

    private List<Producto> productos = new ArrayList<>();
    
    private static int contadorId = 1;

    public Producto guardar (Producto p){

        Validador.validarNombre(p.getNombre());
        Validador.validarPrecio(p.getPrecio());
        Validador.validarStock(p.getStock());
        Validador.validarCategoria(p.getCategoria());

        p.setId(contadorId);
        contadorId++;

        productos.add(p);
        return p;

    }


    public List<Producto> listarTodos(){
        return productos;
    }


    public Producto buscarPorId(int id){
        for (Producto p: productos){
            if (p.getId() == id){
                return p;
            }
        }

        throw new ProductoNoEncontradoException("Producto " + id + " no encontrado.");
    }


    public Producto actualizar(int id, Producto datos){

        Producto p = buscarPorId(id);
 
        Validador.validarNombre(datos.getNombre());
        Validador.validarPrecio(datos.getPrecio());
        Validador.validarStock(datos.getStock());
        Validador.validarCategoria(datos.getCategoria());


        p.setNombre(datos.getNombre());
        p.setPrecio(datos.getPrecio());
        p.setStock(datos.getStock());
        p.setCategoria(datos.getCategoria());

        return p;

    }   
    
 
    public void eliminar (int id){
        Producto p = buscarPorId(id);
        productos.remove(p);
    }

    



}
