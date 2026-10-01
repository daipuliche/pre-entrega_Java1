package exception;

/*
excepcion personalizada que se lanza cuando se intenta vender un producto y no hay suficiente stock
si incorporamos un carrito ddemos señalar si un cliente quiere coprar as unidades de las disponibles

*/
public class StockInsuficienteException extends RuntimeException {
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}