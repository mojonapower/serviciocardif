package cl.cardif.cotizador.wsCotizador.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.model.Equifax;

public class EquifaxMapper implements RowMapper<Equifax> {

    @Override
    public Equifax mapRow(ResultSet result, int rowNum) throws SQLException {
        Equifax equifax = new Equifax();

        equifax.setRut(result.getString(ConstantesDAO.EQUIFAX_CRUT));
        equifax.setNombre(result.getString(ConstantesDAO.EQUIFAX_NOMBRE));
        equifax.setFechaNacimiento(result.getString(ConstantesDAO.EQUIFAX_FECHA_NACIMIENTO));
        equifax.setSexo(result.getString(ConstantesDAO.EQUIFAX_SEXO));
        equifax.setEstadoCivil(result.getString(ConstantesDAO.EQUIFAX_ESTADO_CIVIL));
        equifax.setProfecionOficio(result.getString(ConstantesDAO.EQUIFAX_PROFESION_OFICIO));
        equifax.setCantiadHijos(result.getString(ConstantesDAO.EQUIFAX_CANTIDAD_HIJOS).trim().equalsIgnoreCase("") ? 0
                : result.getInt(ConstantesDAO.EQUIFAX_CANTIDAD_HIJOS));
        equifax.setBanco(result.getString(ConstantesDAO.EQUIFAX_BANCO));
        equifax.setGlosaGse(result.getString(ConstantesDAO.EQUIFAX_GLOSA_GSE));
        equifax.setCalleParticular(result.getString(ConstantesDAO.EQUIFAX_CALLE_PARTICULAR));
        equifax.setNumeroParticular(result.getString(ConstantesDAO.EQUIFAX_NUMERO_PARTICULAR));
        equifax.setTipoPropiedadParticular(result.getString(ConstantesDAO.EQUIFAX_TIPO_PROPIEDAD_PARTICULAR));
        equifax.setNumeroPropiedadParticular(result.getString(ConstantesDAO.EQUIFAX_NUMERO_PROPIEDAD_PARTICULAR));
        equifax.setRestoDireccionParticular(result.getString(ConstantesDAO.EQUIFAX_REGION_PARTICULAR));
        equifax.setComunaParticular(result.getString(ConstantesDAO.EQUIFAX_COMUNA_PARTICULAR));
        equifax.setCiudadParticular(result.getString(ConstantesDAO.EQUIFAX_CIUDAD_PARTICULAR));
        equifax.setRegionParticular(result.getString(ConstantesDAO.EQUIFAX_REGION_PARTICULAR));
        equifax.setCodProfesion(result.getString(ConstantesDAO.EQUIFAX_COD_PROFESION).trim().equalsIgnoreCase("") ? 0
                : result.getInt(ConstantesDAO.EQUIFAX_COD_PROFESION));
        equifax.setCodGse(result.getString(ConstantesDAO.EQUIFAX_COD_GSE).trim().equalsIgnoreCase("") ? 0 : result
                .getInt(ConstantesDAO.EQUIFAX_COD_GSE));
        return equifax;
    }

}
