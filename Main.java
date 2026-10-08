import ui.MenuProducto;
import util.Validador;
import java.util.Scanner;
import service.ProductoService;
import exception.ProductoNoEncontradoException;
import exception.StockInsuficienteException;
import model.Producto;



public class Main {
    
    public static void main(String[] args) {
        ProductoService service = new ProductoService();
        Scanner sc = new Scanner(System.in);
        MenuProducto menu = new MenuProducto(sc, service);
        cargarDatosDePrueba(service);


        int opcion;

        do{
           menu.mostrarMenu();
           opcion = Validador.leerEntero(sc, "Eligir una opción:");


           try {
            switch (opcion){
                case 1:
                    menu.crearProducto();
                    break;
                case 2:
                    menu.listarProductos();
                    break;
                case 3:
                    menu.buscarProductoPorId();
                    break;
                case 4:
                    menu.modificarProducto();
                    break;
                case 5:
                    menu.eliminarProducto();
                    break;
                case 6:
                    System.out.println("Ha salido del programa.");
                    break;
                default:
                    System.out.println("Opción inválida. Ingresar una opción del menú.");
            }

            //  opcion = menu.leerOpcion();
            } catch (ProductoNoEncontradoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (StockInsuficienteException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Opción inválida. Ingrese un número entero.");
            }
        } while (opcion != 6);

        sc.close();

    }

    private static void cargarDatosDePrueba(ProductoService service){
        service.guardar(new Producto("Vino Pinot Noir", 14000, 16, "Vino Tinto"));
        service.guardar(new Producto("Vino Cabernet", 10000, 20, "Vino Tinto"));
        service.guardar(new Producto("Vino Torrontes", 6000, 6, "Vino Blanco"));    

    }

}
