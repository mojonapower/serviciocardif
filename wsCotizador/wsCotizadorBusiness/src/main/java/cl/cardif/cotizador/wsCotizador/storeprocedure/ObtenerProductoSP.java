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
import cl.cardif.cotizador.wsCotizador.mapper.ProductoMapper;

public class ObtenerProductoSP extends StoredProcedure {

    @SuppressWarnings("rawtypes")
    public ObtenerProductoSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_OBTENER_PRODUCTOS);

        RowMapper rowMapper = new ProductoMapper();

        declareParameter(new SqlParameter(ConstantesDAO.PRODUCTO_SOCIO_PRODUCTO, Types.NUMERIC));
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.CURSOR_PRODUCTO, OracleTypes.CURSOR, rowMapper));

        compile();
    }

    public Map<String, Object> obtenerProductos(Long idIntermediario) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.PRODUCTO_SOCIO_PRODUCTO, idIntermediario);
        return execute(parametros);

    }
}
