package cl.cardif.cotizador.wsCotizador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.model.Modelo;

public class ModeloMapper implements RowMapper<Modelo> {

    @Override
    public Modelo mapRow(ResultSet result, int rowNum) throws SQLException {
        Modelo modelo = new Modelo();
        modelo.setId(result.getInt(ConstantesDAO.MODELOS_ID_MODELO));
        modelo.setCodigo(result.getInt(ConstantesDAO.MODELOS_CODIGO_MODELO));
        modelo.setDescripcion(result.getString(ConstantesDAO.MODELOS_DESCRIPCION_MODELO));
        return modelo;
    }

}
