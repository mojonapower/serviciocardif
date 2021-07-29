package cl.cardif.cotizador.wsCotizador.exception;

public class CotizadorDaoException extends GeneralException {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;

    public CotizadorDaoException() {
        super();
    }

    public CotizadorDaoException(Integer codigoError, String descripcionError, Throwable cause) {
        super(codigoError, descripcionError, cause);
    }

    public CotizadorDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CotizadorDaoException(String message) {
        super(message);
    }

    public CotizadorDaoException(Throwable cause) {
        super(cause);
    }

}
