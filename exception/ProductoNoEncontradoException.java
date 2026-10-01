package exception;

/*
excepcion personalizada que se lanza cuando se busca un producto por su id y no existe en el sistema
hereda de RuntimeException (excepciones no chequeda) no obliga a quien usa el método a envolver la llamada en un try catch, 
pero si permite captanos interesa
*/ 
//van con extends?

public class ProductoNoEncontradoException extends RuntimeException{
    public ProductoNoEncontradoException(String mensaje) {

        /*
        el super llama al constructor de la clase padre (RuntimeException) con el mensaje de error 
        guarda el mensaje y lo expone con getMessage() cuando se captura la excepcion
        crear nuestras propias nos permite comunicar errores de dominio con nombres claros, 
        en lugar de usar excepciones genericas como eption o illegalArgumentException
        */

        super();
    }
}
