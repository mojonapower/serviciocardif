package cl.cardif.cotizador.wsCotizador.storeprocedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.model.TarifaBase;

public class CargaArchivoTarifasSP extends StoredProcedure {

    public CargaArchivoTarifasSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_INSERT_TARIFA);

        declareParameter(new SqlParameter(ConstantesDAO.CARGA_TARIFA_ID_PROCESO, Types.INTEGER));
        declareParameter(new SqlParameter(ConstantesDAO.CARGA_TARIFA_ID_PRODUCTO, Types.BIGINT));
        declareParameter(new SqlParameter(ConstantesDAO.CARGA_TARIFA_ID_MARCA, Types.BIGINT));
        declareParameter(new SqlParameter(ConstantesDAO.CARGA_TARIFA_ID_MODELO, Types.BIGINT));
        declareParameter(new SqlParameter(ConstantesDAO.CARGA_TARIFA_ID_VERSION, Types.BIGINT));
        declareParameter(new SqlParameter(ConstantesDAO.CARGA_TARIFA_ID_DEDUCIBLE, Types.BIGINT));
        declareParameter(new SqlParameter(ConstantesDAO.CARGA_TARIFA_ID_VALOR, Types.DOUBLE));

        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));

        compile();
    }

    public Map<String, Object> cargaArchivoTarifas(Integer idCarga, TarifaBase tarifa) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.CARGA_TARIFA_ID_PROCESO, idCarga);
        parametros.put(ConstantesDAO.CARGA_TARIFA_ID_PRODUCTO, tarifa.getIdProducto());
        parametros.put(ConstantesDAO.CARGA_TARIFA_ID_MARCA, tarifa.getIdMarca());
        parametros.put(ConstantesDAO.CARGA_TARIFA_ID_MODELO, tarifa.getIdModelo());
        parametros.put(ConstantesDAO.CARGA_TARIFA_ID_VERSION, tarifa.getIdVersion());
        parametros.put(ConstantesDAO.CARGA_TARIFA_ID_DEDUCIBLE, tarifa.getIdDeducible());
        parametros.put(ConstantesDAO.CARGA_TARIFA_ID_VALOR, tarifa.getValor());

        return execute(parametros);
    }

}
