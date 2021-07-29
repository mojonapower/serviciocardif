package cl.cardif.cotizador.wsCotizador.storeprocedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import oracle.jdbc.driver.OracleTypes;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.mapper.VersionMapper;

public class ObtenerVersionesSP extends StoredProcedure {

    @SuppressWarnings("rawtypes")
    public ObtenerVersionesSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_OBTENER_VERSION);

        RowMapper rowMapper = new VersionMapper();
        declareParameter(new SqlParameter(ConstantesDAO.VERSION_ID_MARCA, Types.NUMERIC));
        declareParameter(new SqlParameter(ConstantesDAO.VERSION_ID_MODELO, Types.NUMERIC));
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.VERSION_CURSOR_VERSION, OracleTypes.CURSOR, rowMapper));

        compile();
    }

    public Map<String, Object> obtenerModelos(Long idMarca, Long idModelo) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.VERSION_ID_MARCA, idMarca);
        parametros.put(ConstantesDAO.VERSION_ID_MODELO, idModelo);
        return execute(parametros);

    }
}
