package cl.cardif.cotizador.wsCotizador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.model.ProcesoCarga;

public class ProcesoCargaMapper implements RowMapper<ProcesoCarga> {

    @Override
    public ProcesoCarga mapRow(ResultSet result, int rowNum) throws SQLException {
        ProcesoCarga proceso = new ProcesoCarga();
        proceso.setIdCarga(result.getInt(ConstantesDAO.CARGA_CODIGO_PROCESO));
        return proceso;
    }

}
