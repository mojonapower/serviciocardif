package cl.cardif.cotizador.wsCotizador.service;

import java.util.List;

import cl.cardif.cotizador.wsCotizador.model.Canal;
import cl.cardif.cotizador.wsCotizador.model.Marca;
import cl.cardif.cotizador.wsCotizador.model.Modelo;
import cl.cardif.cotizador.wsCotizador.model.Producto;
import cl.cardif.cotizador.wsCotizador.model.Usuario;
import cl.cardif.cotizador.wsCotizador.dto.CargaTarifa;
import cl.cardif.cotizador.wsCotizador.dto.EstadoOperacion;
import cl.cardif.cotizador.wsCotizador.dto.GlosaVehiculoModelo;
import cl.cardif.cotizador.wsCotizador.dto.ListaFactoresDetalle;
import cl.cardif.cotizador.wsCotizador.exception.GeneralException;
import cl.cardif.cotizador.wsCotizador.model.FactoresResponse;
import cl.cardif.cotizador.wsCotizador.model.RutListaNegra;
import cl.cardif.cotizador.wsCotizador.model.Socio;
import cl.cardif.cotizador.wsCotizador.model.Version;

public interface AdministradorParametrosService {

    RutListaNegra consultarRutListaNegra(Long rut) throws GeneralException;

    List<Canal> obtenerCanales() throws GeneralException;

    List<Socio> obtenerIntermediarios(Long idCanal) throws GeneralException;

    List<Producto> obtenerProductos(Long idIntermediario) throws GeneralException;

    List<Marca> obtenerMarcas() throws GeneralException;

    List<Modelo> obtenerModelos(Long idMarca) throws GeneralException;

    List<Version> obtenerVersiones(Long idMarca, Long idModelo) throws GeneralException;

    FactoresResponse obtenerFactores(Long idProducto) throws GeneralException;

    Integer editarFormula(Long idProducto, Long idFactor) throws GeneralException;

    ListaFactoresDetalle listarValorFactor(Long idSocio, Long idFactor) throws GeneralException;

    Integer actualizarValorFactor(Long idSocio, Long idFactorDetalle, Long idFactor, String llaveFactor,
            Double valorFactor) throws GeneralException;

    Usuario obtenerUsuario(String idUsuarioCardif, String pass) throws GeneralException;

    Integer cargaArchivoTablaTemporal(CargaTarifa cargaTarifas) throws GeneralException;

    Integer procesoCargaTarifaBase(String nombre) throws GeneralException;

    EstadoOperacion procesoTraspasoTarifaBase(CargaTarifa cargaTarifas) throws GeneralException;

    void cambioEstadoProceso(CargaTarifa cargaTarifas, Long estado) throws GeneralException;

    List<CargaTarifa> obtenerCargasTarifa() throws GeneralException;

    GlosaVehiculoModelo obtenerGlosaVehiculo(Long idMarca, Long idModelo) throws GeneralException;
}
