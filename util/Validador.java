package util;

import java.util.InputMismatchException;
import java.util.Scanner;

import exception.StockInsuficienteException;

/* 
clase con métodos de validacion reutilizables.
Todos los métodos son estáticos, no necesitamos instanciar la clase para usarlos. Se invocan directamente


*/

public class Validador {

    /*
     Validaciones de datos del producto
     Estos métodos lanzan una excepción si el dato es inválido
     No retorna nada, terminan sin lanzar la excepción el dato es válido
     */


    public static void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }
    }

    public static void validarPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio del producto no puede ser negativo.");
        }
    }

    //usando exepcion personalizada StockInsuficienteException
    public static void validarStock(int stock) {
        if (stock < 0) {
            throw new StockInsuficienteException( "El stock del producto no puede ser negativo.");
        }
    }

    public static void validarCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría del producto no puede estar vacía.");
        }
    }

   
    //lectura por consola
    //bucle infinito que se rompe cuando el usuario ingresa un número entero válido
    public static int leerEntero(Scanner sc, String mensaje){
        while (true){
            System.out.println(mensaje);
            try {
                int valor = sc.nextInt();
                sc.nextLine(); //limpia el sato de línea pendiente
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Ingresar un número entero.");
                sc.nextLine(); //limpia el sato de línea pendiente
                
            }
        }
    }

    public static double leerDouble(Scanner sc, String mensaje){
        while (true){
            System.out.println(mensaje);
            try {
                double valor = sc.nextDouble();
                sc.nextLine(); //limpia el sato de línea pendiente
                return valor;
            } catch (Exception e) {
                System.out.println("Ingresar un número decimal.");
                sc.nextLine(); //limpia el sato de línea pendiente
            }
        }
    }

    public static String leerTexto(Scanner sc, String mensaje){
        while (true){
            System.out.println(mensaje);
            String valor = sc.nextLine();
            if (valor.trim().isEmpty()){
                System.out.println("Ingresar un texto.");
            } else {
                return valor;
            }
        }
    }

}
