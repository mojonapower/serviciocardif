package cl.cardif.cotizador.wsCotizador.exception;

public class CotizadorException extends Exception {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;

    public CotizadorException() {
        super();
    }

    public CotizadorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CotizadorException(String message) {
        super(message);
    }

    public CotizadorException(Throwable cause) {
        super(cause);
    }

}
