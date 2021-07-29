package cl.cardif.cotizador.wsCotizador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.model.Usuario;

public class UsuarioMapper implements RowMapper<Usuario> {

    @Override
    public Usuario mapRow(ResultSet result, int rowNum) throws SQLException {
        Usuario usuario = new Usuario();

        usuario.setIdUsuario(result.getLong(ConstantesDAO.USUARIO_CURSOR_ID_USUARIO));
        usuario.setIdUsuarioCardif(result.getString(ConstantesDAO.USUARIO_CURSOR_ID_USUARIO_CARDIF));
        usuario.setNombreUsuario(result.getString(ConstantesDAO.USUARIO_CURSOR_NOMBRE_USUARIO));
        usuario.setEstadoUsuario(result.getInt(ConstantesDAO.USUARIO_CURSOR_ESTADO_USUARIO));
        usuario.setFechaCreacion(result.getDate(ConstantesDAO.USUARIO_CURSOR_FECHA_CREACION));
        return usuario;
    }

}
