package cl.cardif.cotizador.wsCotizador.storeprocedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.dto.CargaTarifa;

public class ProcesoCambioEstadoCargaSP extends StoredProcedure {

    public ProcesoCambioEstadoCargaSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_CAMBIO_ESTADO_CARGA);

        declareParameter(new SqlParameter(ConstantesDAO.ESTADO_CARGA_ID_PROCESO, Types.INTEGER));
        declareParameter(new SqlParameter(ConstantesDAO.ESTADO_CARGA_ID_ESTADO, Types.INTEGER));

        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));

        compile();
    }

    public Map<String, Object> cambioEstado(CargaTarifa cargaTarifas, Long estado) {
        logger.debug("cargaTarifas::" + cargaTarifas.toString());
        logger.debug("estado::" + estado);
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.ESTADO_CARGA_ID_PROCESO, cargaTarifas.getIdCarga());
        parametros.put(ConstantesDAO.ESTADO_CARGA_ID_ESTADO, (Long) estado);
        return execute(parametros);
    }

}
