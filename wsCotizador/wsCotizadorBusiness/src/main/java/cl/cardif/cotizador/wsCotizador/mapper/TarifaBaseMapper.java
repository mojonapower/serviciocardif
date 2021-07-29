package cl.cardif.cotizador.wsCotizador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.model.TarifaBase;

public class TarifaBaseMapper implements RowMapper<TarifaBase> {

    @Override
    public TarifaBase mapRow(ResultSet result, int rowNum) throws SQLException {
        TarifaBase tarifaBase = new TarifaBase();

        tarifaBase.setIdCanal(result.getInt((ConstantesDAO.TBASE_ID_CANAL)));
        tarifaBase.setNombreCanal(result.getString(ConstantesDAO.TBASE_NOMBRE_CANAL));
        // tarifaBase.setIdSocio(result.getLong(ConstantesDAO.TBASE_ID_SOCIO));
        tarifaBase.setNombreSocio(result.getString(ConstantesDAO.TBASE_NOMBRE_SOCIO));
        tarifaBase.setIdProducto(result.getLong(ConstantesDAO.TBASE_ID_PRODUCTO));
        tarifaBase.setNombreProducto(result.getString(ConstantesDAO.TBASE_NOMBRE_PRODUCTO));
        tarifaBase.setIdMarca(result.getLong(ConstantesDAO.TBASE_ID_MARCA));
        tarifaBase.setIdModelo(result.getLong(ConstantesDAO.TBASE_ID_MODELO));
        tarifaBase.setIdVersion(result.getLong(ConstantesDAO.TBASE_ID_VERSION));
        tarifaBase.setIdDeducible(result.getLong(ConstantesDAO.TBASE_ID_DEDUCIBLE));
        tarifaBase.setNombreDeducible(result.getLong(ConstantesDAO.TBASE_NOMBRE_DEDUCIBLE));
        tarifaBase.setValor(result.getDouble(ConstantesDAO.TBASE_VALOR));
        return tarifaBase;
    }

}
