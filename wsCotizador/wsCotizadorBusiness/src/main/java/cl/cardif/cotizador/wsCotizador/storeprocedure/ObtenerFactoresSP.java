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
import cl.cardif.cotizador.wsCotizador.mapper.FactoresMapper;

public class ObtenerFactoresSP extends StoredProcedure {

    public ObtenerFactoresSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_OBTENER_FACTORES);

        RowMapper rowMapper = new FactoresMapper();

        declareParameter(new SqlParameter(ConstantesDAO.LIST_FACT_ID_FACTOR, Types.NUMERIC));
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.LIST_FACT_CURSOR_FACTORES, OracleTypes.CURSOR, rowMapper));

        compile();
    }

    public Map<String, Object> obtenerFactores(Long idProducto) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.LIST_FACT_ID_FACTOR, idProducto);
        logger.info("obtenerFactores-Parametros:" + ConstantesDAO.NOMBRE_SP_OBTENER_FACTORES + parametros);
        return execute(parametros);

    }
}
