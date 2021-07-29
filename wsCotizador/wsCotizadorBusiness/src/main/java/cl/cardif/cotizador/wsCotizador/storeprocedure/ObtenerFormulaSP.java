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
import cl.cardif.cotizador.wsCotizador.mapper.FormulaMapper;

public class ObtenerFormulaSP extends StoredProcedure {

    public ObtenerFormulaSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_OBTENER_FORMULA);

        RowMapper rowMapper = new FormulaMapper();

        declareParameter(new SqlParameter(ConstantesDAO.FORMULA_ID_PRODUCTO, Types.NUMERIC));
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.FORMULA_CURSOR_FORMULA, OracleTypes.CURSOR, rowMapper));

        compile();
    }

    public Map<String, Object> obtenerFormula(Long idProducto) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.FORMULA_ID_PRODUCTO, idProducto);
        logger.info("obtenerFormula-Parametros:" + ConstantesDAO.NOMBRE_SP_OBTENER_FORMULA + parametros);
        return execute(parametros);
    }
}
