package cl.cardif.cotizador.wsCotizador.storeprocedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;

public class ProcesoCargaTarifasSP extends StoredProcedure {

    public ProcesoCargaTarifasSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_INSERT_PROCESO_CARGA_TARIFA);

        declareParameter(new SqlParameter(ConstantesDAO.CARGA_NOMBRE_ARCHIVO, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.CARGA_CODIGO_PROCESO, Types.INTEGER));

        compile();
    }

    public Map<String, Object> cargaProceso(String nombreArchivo) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.CARGA_NOMBRE_ARCHIVO, nombreArchivo);
        return execute(parametros);
    }

}
