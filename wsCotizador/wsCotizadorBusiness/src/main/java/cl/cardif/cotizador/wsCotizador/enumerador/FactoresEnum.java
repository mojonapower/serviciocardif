package cl.cardif.cotizador.wsCotizador.enumerador;
    /**
     * 
     * Clase encargada de almacenar constantes de los factores con sus id.
     * <p>
     * Registro de Versiones : <ul>
     * <li> 1.0 27-01-2016, Héctor Beas D. (Imagemaker IT): Versión inicial</li>
     * </ul>
     * </p>
     * <p> 
     * <B>Todos los derechos reservados por BNP Paribas Cardif.</B>
     * </p>
     */
    public enum FactoresEnum {
        
        ANTIGUEDAD(Long.valueOf(1)),
        EDAD(Long.valueOf(2)),
        SEXO(Long.valueOf(3)),
        ESTADO_CIVIL(Long.valueOf(4)),
        IVA(Long.valueOf(5)),
        PROFESION(Long.valueOf(6)),
        SOCIO_ECONOMICO(Long.valueOf(7)),
        ZONA_GEOGRAFICA(Long.valueOf(8)),
        PROMOCION(Long.valueOf(9));
        
        private Long idFactor;

        private FactoresEnum(final Long idFactor) {
            this.idFactor = idFactor;
        }

        @Override
        public String toString() {
            return "Backoffice : " + name();
        }

        /**
         * @return the mensajeWeb
         */
        public Long getIdFactor() {
            return idFactor;
        }

        /**
         * @param mensajeWeb
         *            the mensajeWeb to set
         */
        public void setIdFactor(Long idFactor) {
            this.idFactor = idFactor;
        }

    }
    
