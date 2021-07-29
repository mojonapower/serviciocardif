package cl.cardif.cotizador.wsCotizador.storeprocedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;

public class ActualizarValorFactorSP extends StoredProcedure {

    public ActualizarValorFactorSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_ACTUALIZAR_VALOR_FACTOR);

        declareParameter(new SqlParameter(ConstantesDAO.ACT_VALOR_FACTOR_ID_FACTOR_DETALLE, Types.NUMERIC));
        declareParameter(new SqlParameter(ConstantesDAO.ACT_VALOR_FACTOR_ID_SOCIO, Types.NUMERIC));
        declareParameter(new SqlParameter(ConstantesDAO.ACT_VALOR_FACTOR_ID_FACTOR, Types.NUMERIC));
        declareParameter(new SqlParameter(ConstantesDAO.ACT_VALOR_FACTOR_LLAVE_FACTOR, Types.VARCHAR));
        declareParameter(new SqlParameter(ConstantesDAO.ACT_VALOR_FACTOR_VALOR_FACTOR, Types.NUMERIC));
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));

        compile();
    }

    public Map<String, Object> actualizarValorFactor(Long idSocio, Long idFactorDetalle, Long idFactor,
            String llaveFactor, Double valorFactor) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        try{
        parametros.put(ConstantesDAO.ACT_VALOR_FACTOR_ID_FACTOR_DETALLE, idFactorDetalle);
        parametros.put(ConstantesDAO.ACT_VALOR_FACTOR_ID_SOCIO, idSocio);
        parametros.put(ConstantesDAO.ACT_VALOR_FACTOR_ID_FACTOR, idFactor);
        parametros.put(ConstantesDAO.ACT_VALOR_FACTOR_LLAVE_FACTOR, llaveFactor);
        parametros.put(ConstantesDAO.ACT_VALOR_FACTOR_VALOR_FACTOR, valorFactor);
        logger.info("listarValorFactor-Parametros:" + ConstantesDAO.NOMBRE_SP_ACTUALIZAR_VALOR_FACTOR + parametros);
        }catch(Exception e){
        	System.out.println(e);
        }
        return execute(parametros);

    }
}
