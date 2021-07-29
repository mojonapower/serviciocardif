package cl.cardif.cotizador.wsCotizador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.model.Socio;

public class SocioMapper implements RowMapper<Socio> {

    @Override
    public Socio mapRow(ResultSet result, int rowNum) throws SQLException {
        Socio socio = new Socio();
        socio.setId(result.getInt(ConstantesDAO.ID_SOCIO));
        socio.setNombre(result.getString(ConstantesDAO.NOMBRE_SOCIO));
        socio.setEstado(result.getInt(ConstantesDAO.ESTADO_SOCIO));
        return socio;
    }

}
