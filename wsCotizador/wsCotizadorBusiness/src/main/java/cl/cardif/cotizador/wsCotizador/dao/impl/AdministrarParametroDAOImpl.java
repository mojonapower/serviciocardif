package cl.cardif.cotizador.wsCotizador.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.dao.AdministrarParametroDAO;
import cl.cardif.cotizador.wsCotizador.dao.UtilDAO;
import cl.cardif.cotizador.wsCotizador.dto.CargaTarifa;
import cl.cardif.cotizador.wsCotizador.dto.EstadoOperacion;
import cl.cardif.cotizador.wsCotizador.dto.GlosaVehiculoModelo;
import cl.cardif.cotizador.wsCotizador.dto.ListaFactoresDetalle;
import cl.cardif.cotizador.wsCotizador.exception.CotizadorDaoException;
import cl.cardif.cotizador.wsCotizador.model.Canal;
import cl.cardif.cotizador.wsCotizador.model.FactoresDetalle;
import cl.cardif.cotizador.wsCotizador.model.Marca;
import cl.cardif.cotizador.wsCotizador.model.Modelo;
import cl.cardif.cotizador.wsCotizador.model.Producto;
import cl.cardif.cotizador.wsCotizador.model.Factores;
import cl.cardif.cotizador.wsCotizador.model.FactoresResponse;
import cl.cardif.cotizador.wsCotizador.model.Socio;
import cl.cardif.cotizador.wsCotizador.model.TarifaBase;
import cl.cardif.cotizador.wsCotizador.model.Usuario;
import cl.cardif.cotizador.wsCotizador.model.Version;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ActualizarValorFactorSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.CargaArchivoTarifasSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.EditarFormulaSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ListarValorFactorSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ObtenerCanalesSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ObtenerCargaTarifaSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ObtenerGlosaVehiculoSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ObtenerMarcasSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ObtenerModelosSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ObtenerProductoSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ObtenerFactoresSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ObtenerSocioSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ObtenerVersionesSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ObtenerUsuarioSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ProcesoCambioEstadoCargaSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ProcesoCargaTarifasSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ProcesoTraspasoCargaTarifasSP;

@Component
@SuppressWarnings("unchecked")
public class AdministrarParametroDAOImpl extends UtilDAO implements AdministrarParametroDAO {
    
    @Override
    public List<Canal> obtenerCanales() throws CotizadorDaoException {
        try {
            ObtenerCanalesSP obtenerCanalSP = new ObtenerCanalesSP(jdbcTemplate);
            Map<String, Object> resultado = obtenerCanalSP.obtenerCanales();
            this.procesaExcepcion((Integer) resultado.get(ConstantesDAO.COD_RESPUESTA),
                    (String) resultado.get(ConstantesDAO.DESC_RESPUESTA));
            return (List<Canal>) resultado.get(ConstantesDAO.CURSOR_CANAL);
        } catch (CotizadorDaoException e) {
            logger.error("obtenerCanales:" + e.getDescripcionError(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerCanales:" + e.getMessage(), e);
            throw new CotizadorDaoException("obtenerCanales", e);
        }
    }

    public List<Socio> obtenerIntermediarios(Long idCanal) throws CotizadorDaoException {
        try {
            ObtenerSocioSP obtenerSocioSP = new ObtenerSocioSP(jdbcTemplate);
            Map<String, Object> resultado = obtenerSocioSP.obtenerIntermediarios(idCanal);
            this.procesaExcepcion((Integer) resultado.get(ConstantesDAO.COD_RESPUESTA),
                    (String) resultado.get(ConstantesDAO.DESC_RESPUESTA));
            return (List<Socio>) resultado.get(ConstantesDAO.CURSOR_SOCIO);
        } catch (CotizadorDaoException e) {
            logger.error("obtenerIntermediarios:" + e.getDescripcionError(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerIntermediarios:" + e.getMessage(), e);
            throw new CotizadorDaoException("obtenerIntermediarios", e);
        }
    }

    @Override
    public List<Producto> obtenerProductos(Long idIntermediario) throws CotizadorDaoException {
        try {
            ObtenerProductoSP obtenerProductoSP = new ObtenerProductoSP(jdbcTemplate);
            Map<String, Object> resultado = obtenerProductoSP.obtenerProductos(idIntermediario);
            this.procesaExcepcion((Integer) resultado.get(ConstantesDAO.COD_RESPUESTA),
                    (String) resultado.get(ConstantesDAO.DESC_RESPUESTA));
            return (List<Producto>) resultado.get(ConstantesDAO.CURSOR_PRODUCTO);
        } catch (CotizadorDaoException e) {
            logger.error("obtenerProductos:" + e.getDescripcionError(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerProductos:" + e.getMessage(), e);
            throw new CotizadorDaoException("obtenerProductos", e);
        }
    }

    @Override
    public List<Marca> obtenerMarcas() throws CotizadorDaoException {
        try {
            ObtenerMarcasSP obtenerMarcaSP = new ObtenerMarcasSP(jdbcTemplateExterno);
            Map<String, Object> resultado = obtenerMarcaSP.obtenerMarcas();
            this.procesaExcepcionCardif((Integer) resultado.get(ConstantesDAO.COD_RESPUESTA),
                    (String) resultado.get(ConstantesDAO.DESC_RESPUESTA));
            return (List<Marca>) resultado.get(ConstantesDAO.MARCAS_CURSOR_MARCA);
        } catch (CotizadorDaoException e) {
            logger.error("obtenerMarcas:" + e.getDescripcionError(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerMarcas:" + e.getMessage(), e);
            throw new CotizadorDaoException("obtenerMarcas", e);
        }
    }

    @Override
    public List<Modelo> obtenerModelos(Long idMarca) throws CotizadorDaoException {
        try {
            ObtenerModelosSP obtenerModelosSP = new ObtenerModelosSP(jdbcTemplateExterno);
            Map<String, Object> resultado = obtenerModelosSP.obtenerModelos(idMarca);
            this.procesaExcepcionCardif((Integer) resultado.get(ConstantesDAO.COD_RESPUESTA),
                    (String) resultado.get(ConstantesDAO.DESC_RESPUESTA));
            return (List<Modelo>) resultado.get(ConstantesDAO.MODELOS_CURSOR_MODELO);
        } catch (CotizadorDaoException e) {
            logger.error("obtenerModelos:" + e.getDescripcionError(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerModelos:" + e.getMessage(), e);
            throw new CotizadorDaoException("obtenerModelos", e);
        }
    }

    @Override
    public List<Version> obtenerVersiones(Long idMarca, Long idModelo) throws CotizadorDaoException {
        try {
            ObtenerVersionesSP obtenerVersionesSP = new ObtenerVersionesSP(jdbcTemplateExterno);
            Map<String, Object> resultado = obtenerVersionesSP.obtenerModelos(idMarca, idModelo);
            this.procesaExcepcionCardif((Integer) resultado.get(ConstantesDAO.COD_RESPUESTA),
                    (String) resultado.get(ConstantesDAO.DESC_RESPUESTA));
            return (List<Version>) resultado.get(ConstantesDAO.VERSION_CURSOR_VERSION);
        } catch (CotizadorDaoException e) {
            logger.error("obtenerVersiones:" + e.getDescripcionError(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerVersiones:" + e.getMessage(), e);
            throw new CotizadorDaoException("obtenerVersiones", e);
        }
    }

    public FactoresResponse obtenerFactores(Long idProducto) throws CotizadorDaoException {
        FactoresResponse response = new FactoresResponse();
        try {
            ObtenerFactoresSP obtenerFactoresSP = new ObtenerFactoresSP(jdbcTemplate);
            Map<String, Object> resultado = obtenerFactoresSP.obtenerFactores(idProducto);
            Integer codigo = (Integer) resultado.get(ConstantesDAO.COD_RESPUESTA);
            String desc = (String) resultado.get(ConstantesDAO.DESC_RESPUESTA);
            List<Factores> factores = (List<Factores>) resultado.get(ConstantesDAO.LIST_FACT_CURSOR_FACTORES);
            response.setCodigo(codigo);
            response.setDescripcion(desc);
            response.setListadoFactores(factores);
            return response;
        } catch (Exception e) {
            logger.error("obtenerFactores-Fin Error Exception:" + e.getMessage(), e);
            throw new CotizadorDaoException("Error al consultar factores", e);
        }        
    }

    public Integer editarFormula(Long idProducto, Long idFactor) throws CotizadorDaoException {
        Integer codigo = null;
        try {
            EditarFormulaSP editarFormulaSP = new EditarFormulaSP(jdbcTemplate);
            Map<String, Object> resultado = editarFormulaSP.editarFormula(idProducto, idFactor);
            codigo = (Integer) resultado.get(ConstantesDAO.COD_RESPUESTA);
        } catch (Exception e) {
            logger.error("editarFormula-Fin Error Exception:" + e.getMessage(), e);
            throw new CotizadorDaoException("Error al editar formula", e);
        }
        return codigo;
    }

    public ListaFactoresDetalle listarValorFactor(Long idSocio, Long idFactor) throws CotizadorDaoException {
        ListaFactoresDetalle response = new ListaFactoresDetalle();
        List<FactoresDetalle> factores = null;
        try {
            ListarValorFactorSP listarValorFactor = new ListarValorFactorSP(jdbcTemplate);
            Map<String, Object> resultado = listarValorFactor.listarValorFactor(idSocio, idFactor);
            Integer codigo = (Integer) resultado.get(ConstantesDAO.COD_RESPUESTA);
            String desc = (String) resultado.get(ConstantesDAO.DESC_RESPUESTA);
            factores = (List<FactoresDetalle>) resultado.get(ConstantesDAO.VALOR_FACTOR_CURSOR_LIST_FACTORES);
            response.setCodigo(codigo);
            response.setDescripcion(desc);
            response.setListadoFactoresDetalle(factores);
        } catch (Exception e) {
            logger.error("listarValorFactor-Fin Error Exception:" + e.getMessage(), e);
            throw new CotizadorDaoException("Error al obtener factores", e);

        }
        return response;
    }

    public Integer actualizarValorFactor(Long idSocio, Long idFactorDetalle, Long idFactor, String llaveFactor,
            Double valorFactor) throws CotizadorDaoException {
        Integer codigo = null;
        try {
            ActualizarValorFactorSP actualizarValorFactorSP = new ActualizarValorFactorSP(jdbcTemplate);
            Map<String, Object> resultado = actualizarValorFactorSP.actualizarValorFactor(idSocio, idFactorDetalle,
                    idFactor, llaveFactor, valorFactor);
            codigo = (Integer) resultado.get(ConstantesDAO.COD_RESPUESTA);
        } catch (Exception e) {
            logger.error("actualizarValorFactor-Fin Error Exception:" + e.getMessage(), e);
            throw new CotizadorDaoException("Error al editar formula", e);

        }
        return codigo;
    }

    public Usuario obtenerUsuario(String idUsuarioCardif) throws CotizadorDaoException {
        Usuario usuario = null;
        try {
            ObtenerUsuarioSP obtenerUsuarioSP = new ObtenerUsuarioSP(jdbcTemplate);
            Map<String, Object> resultado = obtenerUsuarioSP.obtenerUsuario(idUsuarioCardif);
            this.procesaExcepcion((Integer) resultado.get(ConstantesDAO.COD_RESPUESTA),
                    (String) resultado.get(ConstantesDAO.DESC_RESPUESTA));
            List<Usuario> listUsuario = (List<Usuario>) resultado.get(ConstantesDAO.CURSOR_USUARIOS);
            if (listUsuario != null && listUsuario.size() > 0) {
                usuario = listUsuario.get(0);
            }
            return usuario;
        } catch (CotizadorDaoException e) {
            logger.error("obtenerUsuario:" + e.getDescripcionError(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerUsuario:" + e.getMessage(), e);
            throw new CotizadorDaoException("obtenerUsuario", e);
        }
    }

    @Override
    public Integer cargaArchivoTablaTemporal(CargaTarifa tarifas) throws CotizadorDaoException {
        logger.debug("cargaArchivoTablaTemporal");
        try {
            CargaArchivoTarifasSP cargaArchivoTarifasSP = new CargaArchivoTarifasSP(jdbcTemplate);
            Integer numeroRegistros = 0;
            for (TarifaBase tarifaBase : tarifas.getTarifas()) {
                Map<String, Object> resultado = cargaArchivoTarifasSP.cargaArchivoTarifas(tarifas.getIdCarga(),
                        tarifaBase);
                this.procesaExcepcion((Integer) resultado.get(ConstantesDAO.COD_RESPUESTA),
                        (String) resultado.get(ConstantesDAO.DESC_RESPUESTA));
                numeroRegistros++;
            }
            logger.debug("numeroRegistros: " + numeroRegistros);
            return numeroRegistros;        
        } catch (CotizadorDaoException e) {
            logger.error("cargaArchivoTablaTemporal :" + e.getDescripcionError(), e);
            throw e;
        } catch (Exception e) {
            logger.error("cargaArchivoTablaTemporal :" + e.getMessage(), e);
            throw new CotizadorDaoException("cargaArchivoTablaTemporal", e);
        }
    }

    @Override
    public Integer procesoCargaTarifaBase(String nombre) throws CotizadorDaoException {
        try {
            ProcesoCargaTarifasSP procesoCargaTarifaSP = new ProcesoCargaTarifasSP(jdbcTemplate);
            Map<String, Object> resultado = procesoCargaTarifaSP.cargaProceso(nombre);
            this.procesaExcepcion((Integer) resultado.get(ConstantesDAO.COD_RESPUESTA),
                    (String) resultado.get(ConstantesDAO.DESC_RESPUESTA));
            return (Integer) resultado.get(ConstantesDAO.CARGA_CODIGO_PROCESO);
        } catch (CotizadorDaoException e) {
            logger.error("procesoCargaTarifaBase:" + e.getDescripcionError(), e);
            throw e;
        } catch (Exception e) {
            logger.error("procesoCargaTarifaBase:" + e.getMessage(), e);
            throw new CotizadorDaoException("procesoCargaTarifaBase", e);
        }
    }

    @Override
    public EstadoOperacion procesoTraspasoTarifaBase(CargaTarifa tarifas) throws CotizadorDaoException {
        EstadoOperacion response = new EstadoOperacion();
        try {
            ProcesoTraspasoCargaTarifasSP procesoTraspasoCargaTarifasSP = new ProcesoTraspasoCargaTarifasSP(
                    jdbcTemplate);
            Map<String, Object> resultado = procesoTraspasoCargaTarifasSP.traspasoCargaTarifasSP(tarifas);
            this.procesaExcepcion((Integer) resultado.get(ConstantesDAO.COD_RESPUESTA),
                    (String) resultado.get(ConstantesDAO.DESC_RESPUESTA));
            response.setRegistrosEliminados((Integer) resultado.get(ConstantesDAO.TRASPASO_CARGA_REG_ELIMINADOS));
            response.setRegistrosInsertados((Integer) resultado.get(ConstantesDAO.TRASPASO_CARGA_REG_INSERTADOS));
            response.setCodigoEstado(Long.parseLong(resultado.get(ConstantesDAO.COD_RESPUESTA).toString()));
            return response;
        } catch (CotizadorDaoException e) {
            logger.error("procesoTraspasoTarifaBase:" + e.getDescripcionError(), e);
            throw e;
        } catch (Exception e) {
            logger.error("procesoTraspasoTarifaBase:" + e.getMessage(), e);
            throw new CotizadorDaoException("procesoTraspasoTarifaBase", e);
        }
    }

    @Override
    public void cambioEstadoProceso(CargaTarifa cargaTarifas, Long estado) throws CotizadorDaoException {
        try {
            ProcesoCambioEstadoCargaSP procesoCambioEstadoCargaSP = new ProcesoCambioEstadoCargaSP(jdbcTemplate);
            Map<String, Object> resultado = procesoCambioEstadoCargaSP.cambioEstado(cargaTarifas, estado);
            this.procesaExcepcion((Integer) resultado.get(ConstantesDAO.COD_RESPUESTA),
                    (String) resultado.get(ConstantesDAO.DESC_RESPUESTA));
        } catch (CotizadorDaoException e) {
            logger.error("cambioEstadoProceso:" + e.getDescripcionError(), e);
            throw e;
        } catch (Exception e) {
            logger.error("cambioEstadoProceso:" + e.getMessage(), e);
            throw new CotizadorDaoException("cambioEstadoProceso", e);
        }
    }

    @Override
    public List<CargaTarifa> obtenerCargasTarifa() throws CotizadorDaoException {
        List<CargaTarifa> response = null;
        try {
            ObtenerCargaTarifaSP obtenerCargasTarifaSP = new ObtenerCargaTarifaSP(jdbcTemplate);
            Map<String, Object> resultado = obtenerCargasTarifaSP.obtenerCargasTarifa();
            this.procesaExcepcion((Integer) resultado.get(ConstantesDAO.COD_RESPUESTA),
                    (String) resultado.get(ConstantesDAO.DESC_RESPUESTA));
            response = (List<CargaTarifa>) resultado.get(ConstantesDAO.OBTENER_CARGA_CURSOR);
            logger.debug("response " + response.size());
            return response;
        } catch (CotizadorDaoException e) {
            logger.error("cargaArchivoTablaTemporal:" + e.getDescripcionError(), e);
            throw e;
        } catch (Exception e) {
            logger.error("cargaArchivoTablaTemporal:" + e.getMessage(), e);
            throw new CotizadorDaoException("cargaArchivoTablaTemporal", e);
        }        
    }

    @Override
    public GlosaVehiculoModelo obtenerGlosaVehiculo(Long idMarca, Long idModelo) throws CotizadorDaoException {
        GlosaVehiculoModelo glosa = new GlosaVehiculoModelo();
        try {
            ObtenerGlosaVehiculoSP obtenerGlosaSP = new ObtenerGlosaVehiculoSP(jdbcTemplateExterno);
            Map<String, Object> resultado = obtenerGlosaSP.obtenerGlosaVehiculo(idMarca, idModelo);
            Integer codigo = (Integer) resultado.get(ConstantesDAO.COD_ERROR);
            String desc = (String) resultado.get(ConstantesDAO.COD_DESC);
            String marca = (String) resultado.get(ConstantesDAO.SALIDA_MARCA);
            String modelo = (String) resultado.get(ConstantesDAO.SALIDA_MODELO);

            glosa.setCodigo(codigo);
            glosa.setDescripcion(desc);
            glosa.setGlosaMarca(marca);
            glosa.setGlosaModelo(modelo);
        } catch (Exception e) {
            logger.error("consultarRutListaNegra-Fin Error Exception:" + e.getMessage(), e);
            throw new CotizadorDaoException("Error al obtener glosa vehiculo", e);
        }

        return glosa;
    }

}
