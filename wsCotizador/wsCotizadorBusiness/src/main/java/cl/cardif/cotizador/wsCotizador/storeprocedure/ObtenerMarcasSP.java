package cl.cardif.cotizador.wsCotizador.storeprocedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import oracle.jdbc.driver.OracleTypes;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.mapper.MarcaMapper;

public class ObtenerMarcasSP extends StoredProcedure {

    @SuppressWarnings("rawtypes")
    public ObtenerMarcasSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_OBTENER_MARCAS);

        RowMapper rowMapper = new MarcaMapper();
        declareParameter(new SqlOutParameter(ConstantesDAO.MARCAS_CURSOR_MARCA, OracleTypes.CURSOR, rowMapper));
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));

        compile();
    }

    public Map<String, Object> obtenerMarcas() {
        Map<String, Object> parametros = new HashMap<String, Object>();
        return execute(parametros);

    }

}
