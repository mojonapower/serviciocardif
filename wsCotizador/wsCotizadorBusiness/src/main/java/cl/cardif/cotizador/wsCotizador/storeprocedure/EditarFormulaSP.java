package cl.cardif.cotizador.wsCotizador.storeprocedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;

public class EditarFormulaSP extends StoredProcedure {

    public EditarFormulaSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_EDITAR_FORMULA);

        declareParameter(new SqlParameter(ConstantesDAO.EDIT_FORMULA_ID_PRODUCTO, Types.NUMERIC));
        declareParameter(new SqlParameter(ConstantesDAO.EDIT_FORMULA_ID_FACTOR, Types.NUMERIC));
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));

        compile();
    }

    public Map<String, Object> editarFormula(Long idProducto, Long idFactor) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.EDIT_FORMULA_ID_PRODUCTO, idProducto);
        parametros.put(ConstantesDAO.EDIT_FORMULA_ID_FACTOR, idFactor);
        logger.info("obtenerFactores-Parametros:" + ConstantesDAO.NOMBRE_SP_EDITAR_FORMULA + parametros);
        return execute(parametros);

    }
}
