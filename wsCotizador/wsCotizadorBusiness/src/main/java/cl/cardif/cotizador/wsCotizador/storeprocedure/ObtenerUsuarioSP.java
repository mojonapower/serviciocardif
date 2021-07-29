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
import cl.cardif.cotizador.wsCotizador.mapper.UsuarioMapper;

public class ObtenerUsuarioSP extends StoredProcedure {

    public ObtenerUsuarioSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_OBTENER_USUARIO);

        RowMapper rowMapper = new UsuarioMapper();

        declareParameter(new SqlParameter(ConstantesDAO.ID_USUARIO_CARDIF, Types.VARCHAR));
        // Parametros de salida.
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.CURSOR_USUARIOS, OracleTypes.CURSOR, rowMapper));
        compile();
    }

    public Map<String, Object> obtenerUsuario(String idUsuarioCardif) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.ID_USUARIO_CARDIF, idUsuarioCardif);
        logger.info("obtenerUsuario-Parametros:" + ConstantesDAO.NOMBRE_SP_OBTENER_USUARIO + parametros);
        return execute(parametros);

    }
}
