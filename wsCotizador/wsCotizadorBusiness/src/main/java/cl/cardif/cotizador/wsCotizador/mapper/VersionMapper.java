package cl.cardif.cotizador.wsCotizador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.model.Version;

public class VersionMapper implements RowMapper<Version> {

    @Override
    public Version mapRow(ResultSet result, int rowNum) throws SQLException {
        Version version = new Version();
        version.setId(result.getInt(ConstantesDAO.VERSION_ID_VERSION));
        version.setCodigo(result.getInt(ConstantesDAO.VERSION_CODIGO_VERSION));
        version.setDescripcion(result.getString(ConstantesDAO.VERSION_DESCRIPCION_VERSION));
        return version;
    }

}
