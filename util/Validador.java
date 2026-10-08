package util;

import java.util.InputMismatchException;
import java.util.Scanner;
import exception.StockInsuficienteException;




public class Validador {

   
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

    public static int leerEntero(Scanner sc, String mensaje){

        while (true){
            System.out.println(mensaje);
            try {
                int valor = sc.nextInt();
                sc.nextLine(); 
                return valor;

            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Ingresar un número entero.");
                sc.nextLine(); 
                
            }
        }

    }


    public static double leerDouble(Scanner sc, String mensaje){

        while (true){
            System.out.println(mensaje);
            try {
                double valor = sc.nextDouble();
                sc.nextLine(); 
                return valor;

            } catch (Exception e) {
                System.out.println("Valor inválido. Ingresar un número decimal.");
                sc.nextLine();
            }
        }

    }


    public static String leerTexto(Scanner sc, String mensaje){
        while (true){
            System.out.println(mensaje);
            String valor = sc.nextLine();

            if (valor.trim().isEmpty()){
                System.out.println("Ingresar un texto válido.");
            } else {
                return valor;
            }
        }
    }



}
