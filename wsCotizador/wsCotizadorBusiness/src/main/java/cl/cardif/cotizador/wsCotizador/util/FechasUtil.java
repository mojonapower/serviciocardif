package cl.cardif.cotizador.wsCotizador.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class FechasUtil {
    
    private FechasUtil(){
        
    }

    /**
     * Calcula la edad actual (en años) dada una fecha (de nacimiento). Nótese que entregará alegremente números
     * negativos si la fecha dada es futura.
     * <P>
     * Registro de versiones:
     * <UL>
     * 
     * </UL>
     * <P>
     *
     * @param fechaDeNacimiento
     *            La fecha de nacimiento.
     * @return edad en años; si la fecha entregada es <code>null</code>, se retorna -1.
     * @since 1.0
     */
    static public int calculaEdad(Calendar fechaDeNacimiento) {
        if (fechaDeNacimiento == null) {
            return -1;
        } else {
            Calendar c = ahora();
            int diaActual = c.get(Calendar.DATE);
            int mesActual = c.get(Calendar.MONTH) + 1;
            int anoActual = c.get(Calendar.YEAR);
            int diaDeNacimiento = fechaDeNacimiento.get(Calendar.DATE);
            int mesDeNacimiento = fechaDeNacimiento.get(Calendar.MONTH) + 1;
            int anoDeNacimiento = fechaDeNacimiento.get(Calendar.YEAR);

            int edad = anoActual - anoDeNacimiento - 1;
            if ((mesDeNacimiento < mesActual) || ((mesDeNacimiento == mesActual) && (diaDeNacimiento <= diaActual))) {
                edad++;
            }
            return edad;
        }
    }

    /**
     * Calcula la edad actual (en años) dada una fecha (de nacimiento).
     * <P>
     * Registro de versiones:
     * <UL>
     * 
     * </UL>
     * <P>
     *
     * @param fechaDeNacimiento
     *            La fecha de nacimiento.
     * @return edad en años; si la fecha entregada es <code>null</code>, se retorna -1.
     * @see #calculaEdad(Calendar)
     * @since 1.0
     */
    static public int calculaEdad(Date fechaDeNacimiento) {
        if (fechaDeNacimiento == null) {
            return -1;
        } else {
            Calendar fecha = Calendar.getInstance();
            fecha.setTime(fechaDeNacimiento);
            return calculaEdad(fecha);
        }
    }

    /**
     * Entrega un objeto Calendar instanciado con la fecha/hora actual. Registro de versiones:
     * <UL>
     *
     * 
     * </UL>
     * <P>
     *
     * @return Un objeto Calendar instanciado con la fecha/hora actual.
     * @since 1.0
     */
    static public Calendar ahora() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c;
    }

    /**
     * Compara dos fechas, indicando si la primera es anterior a (-1), igual que (0) o posterior a (+1) la segunda; la
     * diferencia entre este método y los nativos de Java (Calendar.before(), Calendar.after(), Date.compareTo(),
     * etcétera) es que solamente se considera la fecha (día, mes, año) y NO la hora (horas, minutos, segundos).
     * <P>
     * Nótese que este conjunto de valores de retorno (-1, 0, 1) es el mismo que entrega el operador
     * <code>&lt;=&gt;</code> [conocido como "spaceship operator"] de Perl.
     * <P>
     * Registro de versiones:
     * <UL>
     * </UL>
     * <P>
     *
     * @param a
     *            La primera fecha - <B>no puede ser <code>null</code></B>.
     * @param z
     *            La segunda fecha - <B>no puede ser <code>null</code></B>.
     * @return Uno de los siguientes valores: -1, 0, 1.
     * @since 1.0
     */
    static public int comparaDias(Calendar a, Calendar z) {
        int diaA = a.get(Calendar.DAY_OF_MONTH);
        int mesA = 1 + a.get(Calendar.MONTH);
        int anoA = a.get(Calendar.YEAR);
        int diaZ = z.get(Calendar.DAY_OF_MONTH);
        int mesZ = 1 + z.get(Calendar.MONTH);
        int anoZ = z.get(Calendar.YEAR);

        // Vamos con los años...
        if (anoA < anoZ){
            return -1;
        }
        if (anoA > anoZ){
            return 1;
        }
        // Mismo año, veamos los meses...
        if (mesA < mesZ){
            return -1;
        }
        if (mesA > mesZ){
            return 1;
        }
        // Mismo año y mes, veamos los días...
        if (diaA < diaZ){
            return -1;
        }
        if (diaA > diaZ){
            return 1;
        }

        // Es el mismo día.
        return 0;
    }

    /**
     * Compara dos fechas, indicando si la primera es anterior a (-1), igual que (0) o posterior a (+1) la segunda; la
     * diferencia entre este método y los nativos de Java (Calendar.before(), Calendar.after(), Date.compareTo(),
     * etcétera) es que solamente se considera la fecha (día, mes, año) y NO la hora (horas, minutos, segundos).
     * <P>
     * Nótese que este conjunto de valores de retorno (-1, 0, 1) es el mismo que entrega el operador
     * <code>&lt;=&gt;</code> [conocido como "spaceship operator"] de Perl.
     * <P>
     * Registro de versiones:
     * <UL>
     *
     * </UL>
     * <P>
     *
     * @param a
     *            La primera fecha - <B>no puede ser <code>null</code></B>.
     * @param z
     *            La segunda fecha - <B>no puede ser <code>null</code></B>.
     * @return Uno de los siguientes valores: -1, 0, 1.
     * @see #comparaDias(Calendar, Calendar)
     * @since 1.0
     */
    static public int comparaDias(Date a, Date z) {
        Calendar aa = Calendar.getInstance();
        Calendar zz = Calendar.getInstance();
        aa.setTime(a);
        zz.setTime(z);
        return comparaDias(aa, zz);
    }

    /**
     * Entrega una fecha expresada como <code>Date</code> a partir de la fecha entregada como <code>String</code> y de
     * un formato dados. Se retorna <code>null</code> si la fecha es <code>null</code>, no se reconoce el formato o hay
     * algún otro error.
     * <P>
     * Registro de versiones:
     * <UL>
     * 
     *
     * </UL>
     * <P>
     *
     * @param fecha
     *            La fecha a convertir.
     * @param formato
     *            El formato a utilizar.
     * @return La fecha convertida a <code>Date</code>.
     * @since 1.6
     */
    static public Date convierteStringADate(String fecha, SimpleDateFormat formato) {
        if (fecha == null) {
            return null;
        }
        try {
            formato.setLenient(false);
            return formato.parse(fecha);
        } catch (java.text.ParseException e) {
            return null;
        }
    }

    /**
     * Entrega el año actual.
     * <P>
     * Registro de versiones:
     * <UL>
     *
     * 
     * </UL>
     * <P>
     *
     * @return El año actual expresado como número.
     * @since 1.0
     */
    static public int anoActual() {
        Calendar c = ahora();
        return c.get(Calendar.YEAR);
    }
}
