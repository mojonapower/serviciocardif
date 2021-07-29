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
import cl.cardif.cotizador.wsCotizador.mapper.FactorValorMapper;

public class ListarValorFactorSP extends StoredProcedure {

    public ListarValorFactorSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_LISTAR_VALOR_FACTOR);

        RowMapper rowMapper = new FactorValorMapper();

        declareParameter(new SqlParameter(ConstantesDAO.VALOR_FACTOR_ID_SOCIO, Types.NUMERIC));
        declareParameter(new SqlParameter(ConstantesDAO.VALOR_FACTOR_ID_FACTOR, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.VALOR_FACTOR_CURSOR_LIST_FACTORES, OracleTypes.CURSOR,
                rowMapper));

        compile();
    }

    public Map<String, Object> listarValorFactor(Long idSocio, Long idFactor) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.VALOR_FACTOR_ID_SOCIO, idSocio);
        parametros.put(ConstantesDAO.VALOR_FACTOR_ID_FACTOR, idFactor);
        logger.info("obtenerFactores-Parametros:" + ConstantesDAO.NOMBRE_SP_LISTAR_VALOR_FACTOR + parametros);
        return execute(parametros);

    }
}
