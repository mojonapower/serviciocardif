package cl.cardif.cotizador.wsCotizador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.model.FactoresDetalle;

public class FactorValorMapper implements RowMapper<FactoresDetalle> {

    @Override
    public FactoresDetalle mapRow(ResultSet result, int rowNum) throws SQLException {
        FactoresDetalle factoresDetalle = new FactoresDetalle();
        factoresDetalle.setIdFactorDetalle(result.getLong(ConstantesDAO.VALOR_FACTOR_ID_FACTOR_DETALLE));
        factoresDetalle.setLlaveFactor(result.getString(ConstantesDAO.VALOR_FACTOR_LLAVE_FACTOR));
        factoresDetalle.setValorFactor(result.getDouble(ConstantesDAO.VALOR_FACTOR_VALOR_FACTOR));
        return factoresDetalle;
    }

}
