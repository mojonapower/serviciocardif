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
import cl.cardif.cotizador.wsCotizador.mapper.TarifaBaseMapper;

public class ObtenerTarifaBaseSP extends StoredProcedure {

    public ObtenerTarifaBaseSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_OBTENER_TARIFA_BASE);

        RowMapper rowMapper = new TarifaBaseMapper();
        // Parametros Entrantes.
        declareParameter(new SqlParameter(ConstantesDAO.TBASE_CANAL, Types.NUMERIC));
        declareParameter(new SqlParameter(ConstantesDAO.TBASE_SOCIO, Types.NUMERIC));
        declareParameter(new SqlParameter(ConstantesDAO.TBASE_PRODUCTO, Types.NUMERIC));
        declareParameter(new SqlParameter(ConstantesDAO.TBASE_MARCA, Types.NUMERIC));
        declareParameter(new SqlParameter(ConstantesDAO.TBASE_MODELO, Types.NUMERIC));
        declareParameter(new SqlParameter(ConstantesDAO.TBASE_VERSION, Types.NUMERIC));

        // Parametros de salida.
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.TBASE_CURSOR_TARIFA_BASE, OracleTypes.CURSOR, rowMapper));

        compile();
    }

    public Map<String, Object> obtenerTarifaBaseSP(int canal, Long idSocio, Long idProducto, Long idMarca,
            Long idModelo, Long idVersion) {
        Map<String, Object> parametros = new HashMap<String, Object>();

        parametros.put(ConstantesDAO.TBASE_CANAL, canal);
        parametros.put(ConstantesDAO.TBASE_SOCIO, idSocio);
        parametros.put(ConstantesDAO.TBASE_PRODUCTO, idProducto);
        parametros.put(ConstantesDAO.TBASE_MARCA, idMarca);
        parametros.put(ConstantesDAO.TBASE_MODELO, idModelo);
        parametros.put(ConstantesDAO.TBASE_VERSION, idVersion);
        logger.info("obtenerTarifaBaseSP-Parametros:" + ConstantesDAO.NOMBRE_SP_OBTENER_TARIFA_BASE + parametros);
        return execute(parametros);

    }
}
