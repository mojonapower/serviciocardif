package cl.cardif.cotizador.wsCotizador.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Entrega un string con el caracter que se indique repetido tantas veces como se indique. Por ejemplo,
     * <code>repiteCaracter('a', 4)</code> entrega <code>"aaaa"</code>. Reemplaza al antiguo método repeatChar().
     * <P>
     * Registro de versiones:
     * <UL>
     * </UL>
     * <P>
     *
     * @param repiteme
     *            el caracter a repetir.
     * @param largo
     *            el largo del string final; si se entrega un número negativo, se reemplaza por 0 (lo que implica que se
     *            retornará "").
     * @return el string con la repetición indicada.
     * @since 1.0
     */
    static public String repiteCaracter(char repiteme, int largoEntrante) {
        int largo = largoEntrante;
        String resultado = "";
        if (largo < 0){
            largo = 0;
        }
        for (int i = 1; i <= largo; i++) {
            resultado = resultado.concat(String.valueOf(repiteme));
        }
        return resultado;
    }

    /**
     * Rellena un string para que tenga el largo indicado, utilizando el caracter de relleno especificado por la
     * izquierda. Si el string es más largo que el parámetro correspondiente, no hace nada.
     * <P>
     * Registro de versiones:
     * <UL>
     * </UL>
     * <P>
     *
     * @param texto
     *            El string a rellenar; si es <CODE>null</CODE>, se reemplaza por <CODE>""</CODE>.
     * @param largo
     *            El largo en que se quiere dejar el string; un valor negativo será reemplazado por cero.
     * @param relleno
     *            El caracter con que se va a rellenar el string.
     * @return El string rellenado.
     * @since 1.0
     */
    static public String rellenaPorLaIzquierda(String textoEntrante, int largoEntrante, char relleno) {
        String texto = textoEntrante;
        int largo = largoEntrante;

        if (texto == null) {
            texto = "";
        }
        if (largo < 0) {
            largo = 0;
        }
        if (texto.length() >= largo) {
            return texto;
        }
        return (repiteCaracter(relleno, largo - texto.length()) + texto);
    }

    public boolean validaRut(String rutEntrante) {
        String rut = rutEntrante;
        boolean validacion = false;
        if (rut.length() > 1) {
            try {
                rut = rut.toUpperCase();
                rut = rut.replace(".", "");
                rut = rut.replace("-", "");
                int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
                char dv = rut.charAt(rut.length() - 1);

                int m = 0, s = 1;
                for (; rutAux != 0; rutAux /= 10) {
                    s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
                }
                if (dv == (char) (s != 0 ? s + 47 : 75)) {
                    validacion = true;
                }

            } catch (Exception e) {
                logger.error("Error al validar el rut");
            }
        } else {
            validacion = false;
        }

        return validacion;
    }

}
