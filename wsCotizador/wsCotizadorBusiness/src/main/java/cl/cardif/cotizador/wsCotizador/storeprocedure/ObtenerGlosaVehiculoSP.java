package cl.cardif.cotizador.wsCotizador.storeprocedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;

public class ObtenerGlosaVehiculoSP extends StoredProcedure {

    public ObtenerGlosaVehiculoSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_OBTENER_GLOSA_VEHICULO);

        declareParameter(new SqlParameter(ConstantesDAO.P_MARCA, Types.NUMERIC));
        declareParameter(new SqlParameter(ConstantesDAO.P_MODELO, Types.NUMERIC));
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_ERROR, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_DESC, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.SALIDA_MARCA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.SALIDA_MODELO, Types.VARCHAR));

        compile();
    }

    public Map<String, Object> obtenerGlosaVehiculo(Long idMarca, Long idModelo) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.P_MARCA, idMarca);
        parametros.put(ConstantesDAO.P_MODELO, idModelo);
        logger.info("obtenerFactores-Parametros:" + ConstantesDAO.NOMBRE_SP_OBTENER_GLOSA_VEHICULO + parametros);
        return execute(parametros);
    }
}
