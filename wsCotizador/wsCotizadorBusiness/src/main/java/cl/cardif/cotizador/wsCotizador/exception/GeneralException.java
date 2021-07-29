package cl.cardif.cotizador.wsCotizador.exception;

public class GeneralException extends Exception {

    private static final long serialVersionUID = 2385887188464413940L;

    protected Integer codigoError;

    protected String descripcionError;

    public GeneralException() {
        super();
    }

    public GeneralException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeneralException(String message) {
        super(message);
    }

    public GeneralException(Throwable cause) {
        super(cause);
    }

    public GeneralException(Integer codigoError, String descripcionError, Throwable cause) {
        super(cause);
        this.codigoError = codigoError;
        this.descripcionError = descripcionError;
    }

    /**
     * @return the codigoError
     */
    public Integer getCodigoError() {
        return codigoError;
    }

    /**
     * @param codigoError
     *            the codigoError to set
     */
    public void setCodigoError(Integer codigoError) {
        this.codigoError = codigoError;
    }

    /**
     * @return the descripcionError
     */
    public String getDescripcionError() {
        return descripcionError;
    }

    /**
     * @param descripcionError
     *            the descripcionError to set
     */
    public void setDescripcionError(String descripcionError) {
        this.descripcionError = descripcionError;
    }

}
