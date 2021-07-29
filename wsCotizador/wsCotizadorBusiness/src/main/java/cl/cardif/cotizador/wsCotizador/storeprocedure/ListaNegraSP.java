package cl.cardif.cotizador.wsCotizador.storeprocedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;

public class ListaNegraSP extends StoredProcedure {

    public ListaNegraSP(JdbcTemplate jdbcTemplate) {

        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_LISTA_NEGRA);

        declareParameter(new SqlParameter(ConstantesDAO.LISTA_NEGRA_RUT_ASEGURADO, Types.NUMERIC));
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.LISTA_NEGRA_FACTOR, Types.DOUBLE));
        compile();
    }

    public Map<String, Object> consultarRutListaNegra(Long rut) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.LISTA_NEGRA_RUT_ASEGURADO, rut);
        logger.info("consultarRutListaNegra-Parametros:" + ConstantesDAO.NOMBRE_SP_LISTA_NEGRA + parametros);
        return execute(parametros);

    }
}
