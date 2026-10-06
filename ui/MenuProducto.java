package ui;

import java.util.Scanner;

import model.Producto;
import service.ProductoService;
import util.Validador;

/*
Manejar la interaccion con el usuario: mostrar el menu, leer datos, mostrar mensajes de error o exito.

responsable de:
-Mostrar el menu al usuario
-Pedir los datos
-Mostrar los resultados

No contiene la logica de negocio, no controla el flujo del programa. 

*/

public class MenuProducto {
    //Atributo: el scanner y el service se reciben por constructor (no se crean aca dentro)

    private final Scanner sc;
    private final ProductoService service;

    //Inyeccion por constructor, patron utilizado en spring boot
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
        System.out.print("Ingrese una opción: "); //VER SI VA BIEN DE ACA PARA abajo
        //int opcion = sc.nextInt();
       // sc.nextLine(); //limpia el salto de línea pendiente
       // return opcion;
    }

    //Operaciones del CRUD, cada método corresponde a una opción del menu

    public void crearProducto(){
        System.out.println("Nuevo producto");
        String nombre = Validador.leerTexto(sc, "Nombre:");
        double precio = Validador.leerDouble(sc, "Precio:");
        int stock = Validador.leerEntero(sc, "Stock:");
        String categoria = Validador.leerTexto(sc, "Categoría:");

        //construimos el producto y lo enviamos al servicio, este se encarga de validar y asignar el id.

        Producto p = new Producto(nombre, precio, stock, categoria);
        Producto guardado = service.guardar(p);
        
        System.out.println("Producto creado con ID: " + guardado.getId());
        

    }







}
