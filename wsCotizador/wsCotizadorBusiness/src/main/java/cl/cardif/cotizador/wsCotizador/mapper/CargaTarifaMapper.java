package cl.cardif.cotizador.wsCotizador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.dto.CargaTarifa;

public class CargaTarifaMapper implements RowMapper<CargaTarifa> {

    @Override
    public CargaTarifa mapRow(ResultSet result, int rowNum) throws SQLException {
        CargaTarifa cargaTarifa = new CargaTarifa();
        cargaTarifa.setIdCarga(result.getInt(ConstantesDAO.CARGA_CURSOR_ID_CARGA));
        cargaTarifa.setNombreArchivo(result.getString(ConstantesDAO.CARGA_CURSOR_NOMBRE));
        cargaTarifa.setFechaOperacion(result.getDate(ConstantesDAO.CARGA_CURSOR_FECHA));
        cargaTarifa.setEstado(result.getInt(ConstantesDAO.CARGA_CURSOR_ESTADO));

        return cargaTarifa;
    }

}
