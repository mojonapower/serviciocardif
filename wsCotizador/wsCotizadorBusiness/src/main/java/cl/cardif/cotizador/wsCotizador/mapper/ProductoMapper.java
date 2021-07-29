package cl.cardif.cotizador.wsCotizador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.model.Producto;

public class ProductoMapper implements RowMapper<Producto> {

    @Override
    public Producto mapRow(ResultSet result, int rowNum) throws SQLException {
        Producto producto = new Producto();
        producto.setId(result.getInt(ConstantesDAO.PRODUCTO_ID_PRODUCTO));
        producto.setNombre(result.getString(ConstantesDAO.PRODUCTO_NOMBRE_PRODUCTO));
        return producto;
    }

}
