package service;

import java.util.List;

import exception.ProductoNoEncontradoException;

import java.util.ArrayList;
import model.Producto;
import util.Validador;

/*
capa de servicio, contiene la lógica de negocio de nuestro sistema.
Es reponsable de: 
-mantener la colección de productos
-Asignar id al guardar un nuevo producto
-Validar los datos antes de guardar o actualizar
-Buscar, modificar y eliminar productos por id
No tiene scanner ni system.out, no interactua con el usuario.
Para mostrar mensajes o leer datos lo hace por afuera (la clase main) 
Esto permite después separar el menú del controlador por una API REST sin tocar este archivo ni modificar la lógica de negocio.
 */


public class ProductoService {
    //coleccion en memoria que guarda los productos
    private List<Producto> productos = new ArrayList<>();

    //contador de id únicos (static porque pertenece a la clase, no a la instancia) autoincremental
    
    private static int contadorId = 1;

    //Operaciones CRUD (Create, Read, Update, Delete) para manejar los productos

    //CREATE: guardar un nuevo producto
    public Producto guardar (Producto p){
        //validar antes de guardar, si está mal se lanza excepción y no se guarda en la lista

        Validador.validarNombre(p.getNombre());
        Validador.validarPrecio(p.getPrecio());
        Validador.validarStock(p.getStock());
        Validador.validarCategoria(p.getCategoria());

        //el id lo asigna el servicio, no el usuario. Después de asignarlo incrementamos el contador

        p.setId(contadorId);
        contadorId++;

        productos.add(p);
        return p;

    }

    //READ: devuelve toda la lista de productos
    public List<Producto> listarTodos(){
        return productos;
    }

    //buscar un producto por id

    public Producto buscarPorId(int id){
        for (Producto p: productos){
            if (p.getId() == id){
                return p;
            }
        }

        throw new ProductoNoEncontradoException("Producto " + id + " no encontrado.");
    }

    //UPDATE: actualiza los datos de un producto existente (todos los datos)
    //DAI: ver como podemos poner que pregunte qué dato quiere actualizar y actualizar solo ese
    public Producto actualizar(int id, Producto datos){
        //reutilizamos obtenerPorId, si lanza excepción la actualización se cancela
        Producto p = buscarPorId(id);

        //validamos los datos antes de aplicarlos
        Validador.validarNombre(datos.getNombre());
        Validador.validarPrecio(datos.getPrecio());
        Validador.validarStock(datos.getStock());
        Validador.validarCategoria(datos.getCategoria());

        //modificamos el producto encontrado
        p.setNombre(datos.getNombre());
        p.setPrecio(datos.getPrecio());
        p.setStock(datos.getStock());
        p.setCategoria(datos.getCategoria());

        return p;

    }   
    
    //DELETE: 
    public void eliminar (int id){
        Producto p = buscarPorId(id);
        productos.remove(p);
    }

    



}
