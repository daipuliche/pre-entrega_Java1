package model;

public class Producto {


    //atributos privados: nadie puede editar los atributos de la clase Producto desde fuera de la clase
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    
    //constructor sin id, lo asigna el Productoservice
    public Producto(String nombre, double precio, int stock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    //constructor vacío: crear un producto y completarlo
    public Producto() {
    }

    //getters y setters: la unica forma de acceder o modificar los atributos de la clase Producto es a través de estos métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    //tostring: para mostrar el producto en consola
    @Override
    public String toString() {
        return  "ID: " + id +
                ", Nombre: " + nombre +
                ", Precio: " + precio +
                ", Stock: " + stock +
                ", Categoría: " + categoria;
    }

    public static void main(String[] args) {
        Producto producto = new Producto("Producto 1", 10.0, 100, "Categoría 1");
        System.out.println(producto);
    }

}