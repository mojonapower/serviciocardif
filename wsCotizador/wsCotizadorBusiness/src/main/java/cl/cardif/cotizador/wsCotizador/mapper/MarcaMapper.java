package cl.cardif.cotizador.wsCotizador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.model.Marca;

public class MarcaMapper implements RowMapper<Marca> {

    @Override
    public Marca mapRow(ResultSet result, int rowNum) throws SQLException {
        Marca marca = new Marca();
        marca.setId(result.getInt(ConstantesDAO.MARCAS_ID_MARCA));
        marca.setCodigo(result.getInt(ConstantesDAO.MARCAS_CODIGO_MARCA));
        marca.setDescripcion(result.getString(ConstantesDAO.MARCAS_DESCRIPCION_MARCA));
        return marca;
    }

}
