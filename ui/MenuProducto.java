package ui;

import java.util.List;
import java.util.Scanner;
import model.Producto;
import service.ProductoService;
import util.Validador;



public class MenuProducto {

    private final Scanner sc;
    private final ProductoService service;


    public MenuProducto(Scanner sc,  ProductoService service){
        this.sc = sc;
        this.service = service;
    }

    //menu principal

    public void mostrarMenu(){
        System.out.println("----- MENÚ GESTIÓN DE PRODUCTOS -----");
        System.out.println("1. Crear producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Buscar producto por ID");
        System.out.println("4. Modificar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Salir");
        System.out.println("-------------------------------------");
     //   System.out.println("Ingresar una opción: ");

    }




    public void crearProducto(){
        System.out.println("1. Nuevo producto");
        String nombre = Validador.leerTexto(sc, "Nombre: ");
        double precio = Validador.leerDouble(sc, "Precio: ");
        int stock = Validador.leerEntero(sc, "Stock: ");
        String categoria = Validador.leerTexto(sc, "Categoría: ");


        Producto p = new Producto(nombre, precio, stock, categoria);
        Producto guardado = service.guardar(p);

        System.out.println("Producto creado con ID: " + guardado.getId());
        
    }


    public void listarProductos(){
        List<Producto> lista = service.listarTodos();
        if (lista.isEmpty()){
            System.out.println("No hay productos para mostrar.");
            return;
        }

        System.out.println("Lista de productos: ");
        for(Producto p: lista){
            System.out.println(p);
        }

    }


    public void buscarProductoPorId(){
        int id = Validador.leerEntero(sc, "Ingresar el ID del producto a buscar:");
        Producto p = service.buscarPorId(id);

        if (p == null){
            System.out.println("El producto no existe.");
        } else {
            System.out.println("Producto: " + p);
        }
    }


    public void modificarProducto(){
        int id = Validador.leerEntero(sc, "Ingresar el ID del producto a modificar:");
        Producto actual = service.buscarPorId(id);

        System.out.println("Producto guardado: " + actual);

        if (actual == null){
            System.out.println("El producto no existe.");
            return;
        }

        System.out.println("Ingresar los nuevos datos para el producto: " + actual); //ver si muestra solo el id
        String nombre = Validador.leerTexto(sc, "Nuevo nombre:");
        double precio = Validador.leerDouble(sc, "Nuevo precio:");
        int stock = Validador.leerEntero(sc, "Nuevo stock:");
        String categoria = Validador.leerTexto(sc, "Nueva categoría:");


        Producto datos = new Producto(nombre, precio, stock, categoria);

        Producto modificado = service.actualizar(id, datos);
        System.out.println("Producto modificado: " + modificado);
    }


    public void eliminarProducto(){
        int id = Validador.leerEntero(sc, "Ingresar el ID del producto a eliminar: ");
        service.eliminar(id);
        System.out.println("Producto" + id + " eliminado.");
    }







}
