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

public class ProcesoTraspasoCargaTarifasSP extends StoredProcedure {

    public ProcesoTraspasoCargaTarifasSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_TRASPASO_CARGA_TARIFA);

        declareParameter(new SqlParameter(ConstantesDAO.TRASPASO_CARGA_ID_PROCESO, Types.INTEGER));
        declareParameter(new SqlParameter(ConstantesDAO.TRASPASO_CARGA_ID_PRODUCTO, Types.INTEGER));

        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.TRASPASO_CARGA_REG_ELIMINADOS, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.TRASPASO_CARGA_REG_INSERTADOS, Types.INTEGER));

        compile();
    }

    public Map<String, Object> traspasoCargaTarifasSP(CargaTarifa tarifa) {
        logger.debug("SP SP:: " + tarifa.toString());
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.TRASPASO_CARGA_ID_PROCESO, tarifa.getIdCarga());
        parametros.put(ConstantesDAO.TRASPASO_CARGA_ID_PRODUCTO, tarifa.getIdProducto());
        return execute(parametros);
    }

}
