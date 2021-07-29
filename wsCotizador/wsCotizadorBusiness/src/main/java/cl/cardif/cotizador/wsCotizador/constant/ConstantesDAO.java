package cl.cardif.cotizador.wsCotizador.constant;

public interface ConstantesDAO {

	public static final String COD_RESPUESTA = "P_CODRESPUESTA";
	public static final String DESC_RESPUESTA = "P_MSJRESPUESTA";
	public static final String NOMBRE_PACKAGE = "PCK_COTIZADOR_AUTOMOTIZ_WEB.";
	public static final String NOMBRE_PACKAGE_EXTERNO = "PCK_STANDARD_CODE.";
	public static final String PN_ID_SOCIO = "P_N_ID_SOCIO";
	public static final String PN_ID_FACTOR = "P_N_ID_FACTOR";
	public static final String PN_ID_PRODUCTO = "P_N_ID_PRODUCTO";

	/* Lista Negra */
	public static final String NOMBRE_SP_LISTA_NEGRA = NOMBRE_PACKAGE + "PRC_CONSULTAR_LISTA_NEGRA";
	public static final String LISTA_NEGRA_RUT_ASEGURADO = "P_N_RUT_ASEGURADO";
	public static final String LISTA_NEGRA_FACTOR = "P_N_FACTOR";

	/* Obtener Canales */
	public static final String NOMBRE_SP_OBTENER_CANALES = NOMBRE_PACKAGE + "PRC_OBTENER_CANAL";
	public static final String ID_CANAL = "ID_CANAL";
	public static final String NOMBRE_CANAL = "NOMBRE_CANAL";
	public static final String CURSOR_CANAL = "P_C_CANAL";

	/* Obtener Intermediarios */
	public static final String NOMBRE_SP_OBTENER_SOCIO = NOMBRE_PACKAGE + "PRC_OBTENER_SOCIO";
	public static final String CANAL_SOCIO = "P_N_ID_CANAL";
	public static final String ID_SOCIO = "ID_SOCIO";
	public static final String NOMBRE_SOCIO = "NOMBRE_SOCIO";
	public static final String ESTADO_SOCIO = "ESTADO";
	public static final String CURSOR_SOCIO = "P_C_SOCIO";

	/* Obtener Productos */
	public static final String NOMBRE_SP_OBTENER_PRODUCTOS = NOMBRE_PACKAGE + "PRC_OBTENER_PRODUCTO";
	public static final String PRODUCTO_SOCIO_PRODUCTO = PN_ID_SOCIO;
	public static final String PRODUCTO_ID_PRODUCTO = "ID_PRODUCTO";
	public static final String PRODUCTO_NOMBRE_PRODUCTO = "NOMBRE_PRODUCTO";
	public static final String PRODUCTO_ESTADO_PRODUCTO = "ESTADO_PRODUCTO";
	public static final String CURSOR_PRODUCTO = "P_C_PRODUCTO";

	/* Obtener Marcas */
	public static final String NOMBRE_SP_OBTENER_MARCAS = NOMBRE_PACKAGE_EXTERNO + "PRC_GETMARCAS";
	public static final String MARCAS_ID_MARCA = "ID";
	public static final String MARCAS_CODIGO_MARCA = "CODIGO";
	public static final String MARCAS_DESCRIPCION_MARCA = "DESCRIPCION";
	public static final String MARCAS_CURSOR_MARCA = "MARCAS";

	/* Obtener Modelos */
	public static final String NOMBRE_SP_OBTENER_MODELOS = NOMBRE_PACKAGE_EXTERNO + "PRC_GETMODELOS";
	public static final String MODELOS_ID_MARCA = "P_MARCA";
	public static final String MODELOS_ID_MODELO = "ID";
	public static final String MODELOS_CODIGO_MODELO = "CODIGO";
	public static final String MODELOS_DESCRIPCION_MODELO = "DESCRIPCION";
	public static final String MODELOS_CURSOR_MODELO = "MODELOS";

	/* Obtener Version */
	public static final String NOMBRE_SP_OBTENER_VERSION = NOMBRE_PACKAGE_EXTERNO + "PRC_GETVERSION";
	public static final String VERSION_ID_MARCA = "P_MARCA";
	public static final String VERSION_ID_MODELO = "P_MODELO";
	public static final String VERSION_ID_VERSION = "ID";
	public static final String VERSION_CODIGO_VERSION = "CODIGO";
	public static final String VERSION_DESCRIPCION_VERSION = "DESCRIPCION";
	public static final String VERSION_CURSOR_VERSION = "VERSIONES";

	/* Obtener Factor AACH */
	public static final String NOMBRE_SP_OBTENER_FACTOR_AACH = NOMBRE_PACKAGE + "PRC_OBTENER_FACTOR_AACH ";
	public static final String FACTOR_AACH_RUT_CLIENTE = "P_N_RUT_CLIENTE";
	public static final String FACTOR_AACH_CANT_SINIESTRO = "P_N_CANT_SINIESTRO";
	public static final String FACTOR_AACH_MONTO_SINIESTRO = "P_N_MONTO_SINIESTRO";
	public static final String FACTOR_AACH_FACTOR = "P_N_FACTOR";

	/* Obtener Socio */
	public static final String NOMBRE_SP_OBTENER_DATOS_EQUIFAX = NOMBRE_PACKAGE + "PRC_OBTENER_DATOS_EQUIFAX";
	public static final String EQUIFAX_RUT = "P_V_RUT";
	public static final String EQUIFAX_CURSOR_EQUIFAX = "P_C_EQUIFAX";
	/* Datos del cursor P_C_EQUIFAX */
	public static final String EQUIFAX_EQUIFAX = "EQUIFAX";
	public static final String EQUIFAX_CRUT = "RUT";
	public static final String EQUIFAX_NOMBRE = "NOMBRE";
	public static final String EQUIFAX_FECHA_NACIMIENTO = "FECHA_NACIMIENTO";
	public static final String EQUIFAX_SEXO = "SEXO";
	public static final String EQUIFAX_ESTADO_CIVIL = "ESTADO_CIVIL";
	public static final String EQUIFAX_PROFESION_OFICIO = "PROFESION_OFICIO";
	public static final String EQUIFAX_CANTIDAD_HIJOS = "CANT_HIJOS";
	public static final String EQUIFAX_BANCO = "BANCO";
	public static final String EQUIFAX_GLOSA_GSE = "GLOSA_GSE";
	public static final String EQUIFAX_CALLE_PARTICULAR = "CALLE_PARTICULAR";
	public static final String EQUIFAX_NUMERO_PARTICULAR = "NUMERO_PARTICULAR";
	public static final String EQUIFAX_TIPO_PROPIEDAD_PARTICULAR = "TIPO_PROPIEDAD_PARTICULAR";
	public static final String EQUIFAX_NUMERO_PROPIEDAD_PARTICULAR = "NUMERO_PROPIEDAD_PARTICULAR";
	public static final String EQUIFAX_RESTO_DIRECCION_PARTICULAR = "RESTO_DIRECCION_PARTICULAR";
	public static final String EQUIFAX_COMUNA_PARTICULAR = "COD_COMUNA";
	public static final String EQUIFAX_CIUDAD_PARTICULAR = "CIUDAD_PARTICULAR";
	public static final String EQUIFAX_REGION_PARTICULAR = "COD_REGION";
	public static final String EQUIFAX_COD_PROFESION = "COD_PROFESION";
	public static final String EQUIFAX_COD_GSE = "COD_GSE";


	/* Obtener Tarifa Base */
	public static final String NOMBRE_SP_OBTENER_TARIFA_BASE = NOMBRE_PACKAGE + "PRC_OBTENER_TARIFA_BASE";
	public static final String TBASE_CANAL = "P_N_CANAL";
	public static final String TBASE_SOCIO = "P_N_SOCIO";
	public static final String TBASE_PRODUCTO = "P_N_PRODUCTO";
	public static final String TBASE_MARCA = "P_N_MARCA";
	public static final String TBASE_MODELO = "P_N_MODELO";
	public static final String TBASE_VERSION = "P_N_VERSION";
	public static final String TBASE_CURSOR_TARIFA_BASE = "P_C_TARIFA_BASE";
	/* Datos del cursor P_C_TARIFA_BASE */
	public static final String TBASE_ID_CANAL = "ID_CANAL";
	public static final String TBASE_NOMBRE_CANAL = "NOMBRE_CANAL";
	public static final String TBASE_ID_SOCIO = "ID_SOCIO";
	public static final String TBASE_NOMBRE_SOCIO = "NOMBRE_SOCIO";
	public static final String TBASE_ID_PRODUCTO = "ID_PRODUCTO";
	public static final String TBASE_NOMBRE_PRODUCTO = "NOMBRE_PRODUCTO";
	public static final String TBASE_ID_MARCA = "ID_MARCA";
	public static final String TBASE_ID_MODELO = "ID_MODELO";
	public static final String TBASE_ID_VERSION = "ID_VERSION";
	public static final String TBASE_ID_DEDUCIBLE = "ID_DEDUCIBLE";
	public static final String TBASE_NOMBRE_DEDUCIBLE = "NOMBRE_DEDUCIBLE";
	public static final String TBASE_VALOR = "VALOR";

	/* Obtener Formula */
	public static final String NOMBRE_SP_OBTENER_FORMULA = NOMBRE_PACKAGE + "PRC_OBTENER_FORMULA";
	public static final String FORMULA_ID_SOCIO = PN_ID_SOCIO;
	public static final String FORMULA_ID_PRODUCTO = PN_ID_PRODUCTO;
	public static final String FORMULA_CURSOR_FORMULA = "P_C_FORMULA";
	/* Datos del cursor P_C_FORMULA */
	public static final String FORMULA_ID_FORMULA = "ID_FORMULA";
	public static final String FORMULA_ID_PROD = "ID_PRODUCTO";
	public static final String FORMULA_NOMBRE_PRODUCTO = "NOMBRE_PRODUCTO";
	public static final String FORMULA_ID_FACTOR = "ID_FACTOR";
	public static final String FORMULA_NOMBRE_FACTOR = "NOMBRE_FACTOR";
	public static final String FORMULA_ID_TIPO_FACTOR = "ID_TIPO_FACTOR";
	public static final String FORMULA_OPERADOR = "OPERADOR";

	/* Obtener Valor Factor */
	public static final String NOMBRE_SP_VALOR_FACTOR = NOMBRE_PACKAGE + "PRC_OBTENER_VALOR_FACTOR";
	public static final String FACTOR_ID_SOCIO = PN_ID_SOCIO;
	public static final String FACTOR_ID_FACTOR = PN_ID_FACTOR;
	public static final String FACTOR_LLAVE_FACTOR = "P_V_LLAVE_FACTOR";
	public static final String FACTOR_VALOR_FACTOR = "P_N_VALOR_FACTOR";

	/* Insertar Log */
	public static final String NOMBRE_SP_INSERT_LOG = NOMBRE_PACKAGE + "PRC_INSERT_LOG";
	public static final String LOG_ID_CANAL = "P_N_ID_CANAL";
	public static final String LOG_ID_SOCIO = PN_ID_SOCIO;
	public static final String LOG_ID_PRODUCTO = PN_ID_PRODUCTO;
	public static final String LOG_ID_MARCA = "P_N_ID_MARCA";
	public static final String LOG_ID_MODELO = "P_N_ID_MODELO";
	public static final String LOG_ID_VERSION = "P_N_ID_VERSION";
	public static final String LOG_PATENTE = "P_V_PATENTE";
	public static final String LOG_ANIO = "P_N_ANIO";
	public static final String LOG_RUT = "P_N_RUT";
	public static final String LOG_NOMBRES = "P_V_NOMBRES";
	public static final String LOG_FECHA_NACIMIENTO = "P_V_FECHA_NACIMIENTO";
	public static final String LOG_SEXO = "P_V_SEXO";
	public static final String LOG_ESTADO_CIVIL = "P_V_ESTADO_CIVIL";
	public static final String LOG_REGION = "P_N_REGION";
	public static final String LOG_COMUNA = "P_N_COMUNA";
    public static final String LOG_RESPUESTA = "P_V_RESPUESTA";
    public static final String LOG_COTIZACION_EXTERNO = "P_V_ID_COTIZACION_EXTERNO";
	public static final String LOG_ID_COTIZACION_SOCIO = "P_N_ID_COTIZACION_SOCIO";

	/* Obtener Factores */
	public static final String NOMBRE_SP_OBTENER_FACTORES = NOMBRE_PACKAGE + "PRC_OBTENER_FACTORES";
	public static final String LIST_FACT_ID_PRODUCTO = "P_N_PRODUCTO";
	public static final String LIST_FACT_CURSOR_FACTORES = "P_C_FACTORES";
	/* Datos del cursor P_C_FACTORES */
	public static final String LIST_FACT_ID_FACTOR = "ID_FACTOR";
	public static final String LIST_FACT_NOMBRE_FACTOR = "NOMBRE_FACTOR";
	public static final String LIST_FACT_OPERADOR = "OPERADOR";
	public static final String LIST_FACT_ESTADO_FORMULA = "ESTADO_FORMULA";

	/* Editar Formula */
	public static final String NOMBRE_SP_EDITAR_FORMULA = NOMBRE_PACKAGE + "PRC_EDITAR_FORMULA";
	public static final String EDIT_FORMULA_ID_PRODUCTO = PN_ID_PRODUCTO;
	public static final String EDIT_FORMULA_ID_FACTOR = PN_ID_FACTOR;

	/* Listar Valor Factor */
	public static final String NOMBRE_SP_LISTAR_VALOR_FACTOR = NOMBRE_PACKAGE + "PRC_LISTAR_VALOR_FACTOR";
	public static final String VALOR_FACTOR_ID_SOCIO = PN_ID_SOCIO;
	public static final String VALOR_FACTOR_ID_FACTOR = PN_ID_FACTOR;
	public static final String VALOR_FACTOR_CURSOR_LIST_FACTORES = "P_C_LIST_FACTORES";

	public static final String VALOR_FACTOR_ID_FACTOR_DETALLE = "ID_FACTOR_DETALLE";
	public static final String VALOR_FACTOR_LLAVE_FACTOR = "LLAVE_FACTOR";
	public static final String VALOR_FACTOR_VALOR_FACTOR = "VALOR_FACTOR";

	/* Actualizar Valor Factor */
	public static final String NOMBRE_SP_ACTUALIZAR_VALOR_FACTOR = NOMBRE_PACKAGE + "PRC_ACTUALIZAR_VALOR_FACTOR";
	public static final String ACT_VALOR_FACTOR_ID_FACTOR_DETALLE = "P_N_ID_FACTOR_DETALLE";
	public static final String ACT_VALOR_FACTOR_ID_SOCIO = PN_ID_SOCIO;
	public static final String ACT_VALOR_FACTOR_ID_FACTOR = PN_ID_FACTOR;
	public static final String ACT_VALOR_FACTOR_LLAVE_FACTOR = "P_V_LLAVE_FACTOR";
	public static final String ACT_VALOR_FACTOR_VALOR_FACTOR = "P_N_VALOR_FACTOR";

	/* Obtener Usuario */
	public static final String NOMBRE_SP_OBTENER_USUARIO = NOMBRE_PACKAGE + "PRC_OBTENER_USUARIO";
	public static final String USUARIO_NOMBRE = "P_V_NOMBRE_USUARIO";
	public static final String ID_USUARIO_CARDIF = "P_V_ID_USUARIO_CARDIF";
	public static final String CURSOR_USUARIOS = "P_C_USUARIOS";

	/* Datos del cursor P_C_USUARIOS */
	public static final String USUARIO_CURSOR_ID_USUARIO = "ID_USUARIO";
	public static final String USUARIO_CURSOR_ID_USUARIO_CARDIF = "ID_USUARIO_CARDIF";
	public static final String USUARIO_CURSOR_NOMBRE_USUARIO = "NOMBRE_USUARIO";
	public static final String USUARIO_CURSOR_ESTADO_USUARIO = "ESTADO_USUARIO";
	public static final String USUARIO_CURSOR_FECHA_CREACION = "FECHA_CREACION";

	/* Carga Archivos */
	public static final String NOMBRE_SP_INSERT_PROCESO_CARGA_TARIFA = NOMBRE_PACKAGE + "PRC_INSERT_CARGA_TARIFA_BASE";
	public static final String CARGA_CODIGO_PROCESO = "P_N_ID_CARGA";
	public static final String CARGA_NOMBRE_ARCHIVO = "P_V_NOMBRE";

	/* Carga Tarifas */
	public static final String NOMBRE_SP_INSERT_TARIFA = NOMBRE_PACKAGE + "PRC_INSERT_CARGA_TARIFA_DETA";
	public static final String CARGA_TARIFA_ID_PROCESO = "P_N_ID_CARGA";
	public static final String CARGA_TARIFA_ID_PRODUCTO = PN_ID_PRODUCTO;
	public static final String CARGA_TARIFA_ID_MARCA = "P_N_ID_MARCA";
	public static final String CARGA_TARIFA_ID_MODELO = "P_N_ID_MODELO";
	public static final String CARGA_TARIFA_ID_VERSION = "P_N_ID_VERSION";
	public static final String CARGA_TARIFA_ID_DEDUCIBLE = "P_N_ID_DEDUCIBLE";
	public static final String CARGA_TARIFA_ID_VALOR = "P_N_VALOR";
	
	/* Traspaso carga tarifas */
	public static final String NOMBRE_SP_TRASPASO_CARGA_TARIFA =  NOMBRE_PACKAGE + "PRC_TRASVASIJAR_TARIFA_BASE";
	public static final String TRASPASO_CARGA_ID_PROCESO = "P_N_CARGA";
	public static final String TRASPASO_CARGA_ID_PRODUCTO = "P_N_PRODUCTO";
	public static final String TRASPASO_CARGA_REG_ELIMINADOS = "P_CANT_REG_ELIM";
	public static final String TRASPASO_CARGA_REG_INSERTADOS = "P_CANT_REG_INSER";
	
	/*Cambio estado carga */
	public static final String NOMBRE_SP_CAMBIO_ESTADO_CARGA =  NOMBRE_PACKAGE + "PRC_ACTUALIZA_ESTADO_CARGA";
	public static final String ESTADO_CARGA_ID_PROCESO = "P_N_CARGA";
	public static final String ESTADO_CARGA_ID_ESTADO = "P_N_ESTADO";
	
	/*Obtener cargas tarifa */
	public static final String NOMBRE_SP_OBTENER_CARGAS =  NOMBRE_PACKAGE + "PRC_OBTENER_CARGA_TARIFA";
	public static final String OBTENER_CARGA_CURSOR = "P_C_CARGA_TARIFA";
	public static final String CARGA_CURSOR_ID_CARGA = "ID_CARGA";
	public static final String CARGA_CURSOR_NOMBRE = "NOMBRE_ARCHIVO";
	public static final String CARGA_CURSOR_FECHA = "FECHA_OPERACION";
	public static final String CARGA_CURSOR_ESTADO = "ESTADO";
	
	
	/*Obtener glosa vehiculo */
	public static final String NOMBRE_SP_OBTENER_GLOSA_VEHICULO =  NOMBRE_PACKAGE_EXTERNO + "PRC_GETMARCABYCOD";
	public static final String P_MARCA = "P_MARCA";
	public static final String P_MODELO = "P_MODELO";
	public static final String COD_ERROR = "COD_ERROR";
	public static final String COD_DESC = "COD_DESC";
	public static final String SALIDA_MARCA = "salidaMarca";
	public static final String SALIDA_MODELO = "salidaModelo";

}
