package cl.cardif.cotizador.wsCotizador.dao;

import java.util.List;

import cl.cardif.cotizador.wsCotizador.dto.CargaTarifa;
import cl.cardif.cotizador.wsCotizador.dto.EstadoOperacion;
import cl.cardif.cotizador.wsCotizador.dto.GlosaVehiculoModelo;
import cl.cardif.cotizador.wsCotizador.dto.ListaFactoresDetalle;
import cl.cardif.cotizador.wsCotizador.exception.CotizadorDaoException;
import cl.cardif.cotizador.wsCotizador.model.Canal;
import cl.cardif.cotizador.wsCotizador.model.Marca;
import cl.cardif.cotizador.wsCotizador.model.Modelo;
import cl.cardif.cotizador.wsCotizador.model.Producto;
import cl.cardif.cotizador.wsCotizador.model.FactoresResponse;
import cl.cardif.cotizador.wsCotizador.model.RutListaNegra;
import cl.cardif.cotizador.wsCotizador.model.Socio;
import cl.cardif.cotizador.wsCotizador.model.Usuario;
import cl.cardif.cotizador.wsCotizador.model.Version;

public interface AdministrarParametroDAO {

    RutListaNegra consultarRutListaNegra(Long rut) throws CotizadorDaoException;

    List<Socio> obtenerIntermediarios(Long idCanal) throws CotizadorDaoException;

    List<Canal> obtenerCanales() throws CotizadorDaoException;

    List<Producto> obtenerProductos(Long idIntermediario) throws CotizadorDaoException;

    List<Marca> obtenerMarcas() throws CotizadorDaoException;

    List<Modelo> obtenerModelos(Long idMarca) throws CotizadorDaoException;

    List<Version> obtenerVersiones(Long idMarca, Long idModelo) throws CotizadorDaoException;

    FactoresResponse obtenerFactores(Long idProducto) throws CotizadorDaoException;

    Integer editarFormula(Long idProducto, Long idFactor) throws CotizadorDaoException;

    ListaFactoresDetalle listarValorFactor(Long idSocio, Long idFactor) throws CotizadorDaoException;

    Integer actualizarValorFactor(Long idSocio, Long idFactorDetalle, Long idFactor, String llaveFactor,
            Double valorFactor) throws CotizadorDaoException;

    Usuario obtenerUsuario(String idUsuarioCardif) throws CotizadorDaoException;

    Integer cargaArchivoTablaTemporal(CargaTarifa tarifas) throws CotizadorDaoException;

    Integer procesoCargaTarifaBase(String nombre) throws CotizadorDaoException;

    EstadoOperacion procesoTraspasoTarifaBase(CargaTarifa tarifas) throws CotizadorDaoException;

    void cambioEstadoProceso(CargaTarifa cargaTarifas, Long estado) throws CotizadorDaoException;

    List<CargaTarifa> obtenerCargasTarifa() throws CotizadorDaoException;

    GlosaVehiculoModelo obtenerGlosaVehiculo(Long idMarca, Long idModelo) throws CotizadorDaoException;
}
