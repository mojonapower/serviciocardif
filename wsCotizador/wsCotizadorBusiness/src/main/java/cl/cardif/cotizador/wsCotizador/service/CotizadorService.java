package cl.cardif.cotizador.wsCotizador.service;

import cl.cardif.cotizador.wsCotizador.dto.ParametrosCotizador;
import cl.cardif.cotizador.wsCotizador.dto.SalidaCotizacion;
import cl.cardif.cotizador.wsCotizador.exception.GeneralException;

public interface CotizadorService {
    
    SalidaCotizacion cotizar(ParametrosCotizador parametros) throws GeneralException;
    
}
