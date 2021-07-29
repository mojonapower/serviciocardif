package cl.cardif.cotizador.wsCotizador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.model.Canal;

public class CanalMapper implements RowMapper<Canal> {

    @Override
    public Canal mapRow(ResultSet result, int rowNum) throws SQLException {
        Canal canal = new Canal();
        canal.setId(result.getInt(ConstantesDAO.ID_CANAL));
        canal.setNombre(result.getString(ConstantesDAO.NOMBRE_CANAL));
        return canal;
    }

}
