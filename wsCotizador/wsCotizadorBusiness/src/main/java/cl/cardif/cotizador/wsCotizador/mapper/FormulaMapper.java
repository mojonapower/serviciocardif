package cl.cardif.cotizador.wsCotizador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.model.Formula;

public class FormulaMapper implements RowMapper<Formula> {

    @Override
    public Formula mapRow(ResultSet result, int rowNum) throws SQLException {
        Formula formula = new Formula();
        formula.setIdProducto(result.getLong(ConstantesDAO.FORMULA_ID_PROD));
        formula.setNombreProducto(result.getString(ConstantesDAO.FORMULA_NOMBRE_PRODUCTO));
        formula.setIdFactor(result.getLong(ConstantesDAO.FORMULA_ID_FACTOR));
        formula.setNombreFactor(result.getString(ConstantesDAO.FORMULA_NOMBRE_FACTOR));
        formula.setIdTipoFactor(result.getLong(ConstantesDAO.FORMULA_ID_TIPO_FACTOR));
        formula.setOperador(result.getString(ConstantesDAO.FORMULA_OPERADOR));
        return formula;
    }

}
