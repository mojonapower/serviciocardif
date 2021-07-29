package cl.cardif.cotizador.wsCotizador.dao;

import java.util.List;

import cl.cardif.cotizador.wsCotizador.dto.ParametrosCotizador;
import cl.cardif.cotizador.wsCotizador.exception.CotizadorDaoException;
import cl.cardif.cotizador.wsCotizador.model.Equifax;
import cl.cardif.cotizador.wsCotizador.model.Formula;
import cl.cardif.cotizador.wsCotizador.model.RutListaNegra;
import cl.cardif.cotizador.wsCotizador.model.TarifaBase;

public interface CotizadorDAO {

    RutListaNegra consultarRutListaNegra(Long rut) throws CotizadorDaoException;

    Double obtenerFactorAach(String rut, Long cantSiniestro, Double montoSiniestro) throws CotizadorDaoException;

    Equifax obtenerInfoEquifax(String rut) throws CotizadorDaoException;

    List<TarifaBase> obtenerTarifaBase(int canal, Long idSocio, Long idProducto, Long idMarca, Long idModelo,
            Long idVersion) throws CotizadorDaoException;

    List<Formula> obtenerFormula(Long idProducto) throws CotizadorDaoException;

    Double obtenerValorFactor(Long idSocio, Long idFactor, String llave) throws CotizadorDaoException;

    Double insertarLog(ParametrosCotizador parametros, String xmlCotizacion) throws CotizadorDaoException;

}
