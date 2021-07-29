package cl.cardif.cotizador.wsCotizador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.model.Factores;

public class FactoresMapper implements RowMapper<Factores> {

    @Override
    public Factores mapRow(ResultSet result, int rowNum) throws SQLException {
        Factores factores = new Factores();
        factores.setIdFactor(result.getInt(ConstantesDAO.LIST_FACT_ID_FACTOR));
        factores.setNombreFactor(result.getString(ConstantesDAO.LIST_FACT_NOMBRE_FACTOR));
        factores.setTipoOperador(result.getString(ConstantesDAO.LIST_FACT_OPERADOR));
        factores.setEstadoFactor(result.getLong(ConstantesDAO.LIST_FACT_ESTADO_FORMULA));
        return factores;
    }

}
