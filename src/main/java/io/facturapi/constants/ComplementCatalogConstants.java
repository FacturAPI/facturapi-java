package io.facturapi.constants;

import java.util.Map;

public final class ComplementCatalogConstants {

  public enum CustomsRegimes {
    DEFINITIVE_IMPORT("IMD"),
    DEFINITIVE_EXPORT("EXD"),
    INTERNAL_MERCHANDISE_TRANSIT("ITR"),
    INTERNAL_MERCHANDISE_TRANSIT_FOR_EXPORT("ITE"),
    EXTERNAL_MERCHANDISE_TRANSIT("ETR"),
    EXTERNAL_MERCHANDISE_TRANSIT_FOR_EXPORT("ETE"),
    FISCAL_WAREHOUSE("DFI"),
    STRATEGIC_FISCAL_ENCLOSURE("RFE"),
    FISCAL_ENCLOSURE("RFS"),
    CUSTOMS_TRANSIT("TRA");

    private final String code;

    CustomsRegimes(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<CustomsRegimes, String> CUSTOMS_REGIMES_DESCRIPTION = Map.ofEntries(
    Map.entry(CustomsRegimes.DEFINITIVE_IMPORT, "Importacion definitiva"),
    Map.entry(CustomsRegimes.DEFINITIVE_EXPORT, "Exportacion definitiva"),
    Map.entry(CustomsRegimes.INTERNAL_MERCHANDISE_TRANSIT, "Transito interno de mercancias"),
    Map.entry(
      CustomsRegimes.INTERNAL_MERCHANDISE_TRANSIT_FOR_EXPORT,
      "Transito interno de mercancias para exportacion"
    ),
    Map.entry(CustomsRegimes.EXTERNAL_MERCHANDISE_TRANSIT, "Transito externo de mercancias"),
    Map.entry(
      CustomsRegimes.EXTERNAL_MERCHANDISE_TRANSIT_FOR_EXPORT,
      "Transito externo de mercancias para exportacion"
    ),
    Map.entry(CustomsRegimes.FISCAL_WAREHOUSE, "Deposito fiscal"),
    Map.entry(CustomsRegimes.STRATEGIC_FISCAL_ENCLOSURE, "Recinto fiscalizado estrategico"),
    Map.entry(CustomsRegimes.FISCAL_ENCLOSURE, "Recinto fiscalizado"),
    Map.entry(CustomsRegimes.CUSTOMS_TRANSIT, "Transito aduanero")
  );

  public enum CveTransporteEnum {
    AUTOTRANSPORT("01"),
    NAVY_TRANSPORT("02"),
    AIRLINE_TRANSPORT("03"),
    RAIL_TRANSPORT("04"),
    OTHER("05");

    private final String code;

    CveTransporteEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<CveTransporteEnum, String> CVE_TRANSPORT_DESCRIPTION = Map.ofEntries(
    Map.entry(CveTransporteEnum.AUTOTRANSPORT, "Autotransporte"),
    Map.entry(CveTransporteEnum.NAVY_TRANSPORT, "Transporte Maritimo"),
    Map.entry(CveTransporteEnum.AIRLINE_TRANSPORT, "Transporte Aereo"),
    Map.entry(CveTransporteEnum.RAIL_TRANSPORT, "Transporte Ferroviario"),
    Map.entry(CveTransporteEnum.OTHER, "Otro")
  );

  public enum TipoEstacionEnum {
    NATIONAL_ORIGIN("01"),
    INTERMEDIATE("02"),
    FINAL_DESTINATION("03");

    private final String code;

    TipoEstacionEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<TipoEstacionEnum, String> TIPO_ESTACION_DESCRIPTION = Map.ofEntries(
    Map.entry(TipoEstacionEnum.NATIONAL_ORIGIN, "Origen Nacional"),
    Map.entry(TipoEstacionEnum.INTERMEDIATE, "Intermedia"),
    Map.entry(TipoEstacionEnum.FINAL_DESTINATION, "Destino Final Nacional")
  );

  public enum PermisoSctEnum {
    FEDERAL_TRANSPORT_OF_LOAD("TPAF01"),
    PRIVATE_TRANSPORT_OF_LOAD("TPAF02"),
    FEDERAL_SPECIALIZED_HAZARDOUS_MATERIALS("TPAF03"),
    TRANSPORT_OF_AUTOMOBILES("TPAF04"),
    TRANSPORT_OF_HEAVY_LOAD_UP_TO_90_TONS("TPAF05"),
    TRANSPORT_OF_SPECIALIZED_HEAVY_LOAD_OVER_90_TONS("TPAF06"),
    PRIVATE_HAZARDOUS_MATERIALS_TRANSPORT("TPAF07"),
    INTERNATIONAL_LONG_HAUL_TRANSPORT("TPAF08"),
    INTERNATIONAL_SPECIALIZED_HAZARDOUS_LONG_HAUL("TPAF09"),
    FEDERAL_TRANSPORT_US_BORDER_ZONE("TPAF10"),
    FEDERAL_SPECIALIZED_US_BORDER_ZONE("TPAF11"),
    AUXILIARY_TOWING_SERVICE("TPAF12"),
    AUXILIARY_TOWING_AND_STORAGE_SERVICE("TPAF13"),
    PACKAGING_AND_COURIER_SERVICE("TPAF14"),
    SPECIAL_TRANSPORT_INDUSTRIAL_CRANES_UP_TO_90_TONS("TPAF15"),
    FEDERAL_RENTAL_COMPANIES_SERVICE("TPAF16"),
    VEHICLE_MOVERS_NEW_VEHICLES("TPAF17"),
    MANUFACTURERS_DISTRIBUTORS_NEW_VEHICLES("TPAF18"),
    AUTHORIZATION_DOUBLE_ARTICULATED_TRUCK("TPAF19"),
    FEDERAL_SPECIALIZED_FUNDS_AND_VALUES("TPAF20"),
    TEMPORARY_CABOTAGE_NAVIGATION("TPTM01"),
    NATIONAL_INTERNATIONAL_REGULAR_SERVICE_MEXICAN("TPTA01"),
    FOREIGN_COMPANIES_REGULAR_AIR_SERVICE("TPTA02"),
    NATIONAL_INTERNATIONAL_CHARTER_SERVICE("TPTA03"),
    NATIONAL_INTERNATIONAL_AIR_TAXI_SERVICE("TPTA04"),
    NOT_IN_CATALOG("TPXX00");

    private final String code;

    PermisoSctEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<PermisoSctEnum, String> PERMISO_SCT_DESCRIPTIONS = Map.ofEntries(
    Map.entry(PermisoSctEnum.FEDERAL_TRANSPORT_OF_LOAD, "Autotransporte Federal de carga general."),
    Map.entry(PermisoSctEnum.PRIVATE_TRANSPORT_OF_LOAD, "Transporte privado de carga."),
    Map.entry(
      PermisoSctEnum.FEDERAL_SPECIALIZED_HAZARDOUS_MATERIALS,
      "Autotransporte Federal de Carga Especializada de materiales y residuos peligrosos."
    ),
    Map.entry(
      PermisoSctEnum.TRANSPORT_OF_AUTOMOBILES,
      "Transporte de automoviles sin rodar en vehiculo tipo gondola."
    ),
    Map.entry(
      PermisoSctEnum.TRANSPORT_OF_HEAVY_LOAD_UP_TO_90_TONS,
      "Transporte de carga de gran peso y/o volumen de hasta 90 toneladas."
    ),
    Map.entry(
      PermisoSctEnum.TRANSPORT_OF_SPECIALIZED_HEAVY_LOAD_OVER_90_TONS,
      "Transporte de carga especializada de gran peso y/o volumen de mas 90 toneladas."
    ),
    Map.entry(
      PermisoSctEnum.PRIVATE_HAZARDOUS_MATERIALS_TRANSPORT,
      "Transporte Privado de materiales y residuos peligrosos."
    ),
    Map.entry(
      PermisoSctEnum.INTERNATIONAL_LONG_HAUL_TRANSPORT,
      "Autotransporte internacional de carga de largo recorrido."
    ),
    Map.entry(
      PermisoSctEnum.INTERNATIONAL_SPECIALIZED_HAZARDOUS_LONG_HAUL,
      "Autotransporte internacional de carga especializada de materiales y residuos peligrosos de largo recorrido."
    ),
    Map.entry(
      PermisoSctEnum.FEDERAL_TRANSPORT_US_BORDER_ZONE,
      "Autotransporte Federal de Carga General cuyo ambito de aplicacion comprende la franja fronteriza con Estados Unidos."
    ),
    Map.entry(
      PermisoSctEnum.FEDERAL_SPECIALIZED_US_BORDER_ZONE,
      "Autotransporte Federal de Carga Especializada cuyo ambito de aplicacion comprende la franja fronteriza con Estados Unidos."
    ),
    Map.entry(
      PermisoSctEnum.AUXILIARY_TOWING_SERVICE,
      "Servicio auxiliar de arrastre en las vias generales de comunicacion."
    ),
    Map.entry(
      PermisoSctEnum.AUXILIARY_TOWING_AND_STORAGE_SERVICE,
      "Servicio auxiliar de servicios de arrastre, arrastre y salvamento, y deposito de vehiculos en las vias generales de comunicacion."
    ),
    Map.entry(
      PermisoSctEnum.PACKAGING_AND_COURIER_SERVICE,
      "Servicio de paqueteria y mensajeria en las vias generales de comunicacion."
    ),
    Map.entry(
      PermisoSctEnum.SPECIAL_TRANSPORT_INDUSTRIAL_CRANES_UP_TO_90_TONS,
      "Transporte especial para el transito de gruas industriales con peso maximo de 90 toneladas."
    ),
    Map.entry(
      PermisoSctEnum.FEDERAL_RENTAL_COMPANIES_SERVICE,
      "Servicio federal para empresas arrendadoras servicio publico federal."
    ),
    Map.entry(PermisoSctEnum.VEHICLE_MOVERS_NEW_VEHICLES, "Empresas trasladistas de vehiculos nuevos."),
    Map.entry(
      PermisoSctEnum.MANUFACTURERS_DISTRIBUTORS_NEW_VEHICLES,
      "Empresas fabricantes o distribuidoras de vehiculos nuevos."
    ),
    Map.entry(
      PermisoSctEnum.AUTHORIZATION_DOUBLE_ARTICULATED_TRUCK,
      "Autorizacion expresa para circular en los caminos y puentes de jurisdiccion federal con configuraciones de tractocamion doblemente articulado."
    ),
    Map.entry(
      PermisoSctEnum.FEDERAL_SPECIALIZED_FUNDS_AND_VALUES,
      "Autotransporte Federal de Carga Especializada de fondos y valores."
    ),
    Map.entry(PermisoSctEnum.TEMPORARY_CABOTAGE_NAVIGATION, "Permiso temporal para navegacion de cabotaje"),
    Map.entry(
      PermisoSctEnum.NATIONAL_INTERNATIONAL_REGULAR_SERVICE_MEXICAN,
      "Concesion y/o autorizacion para el servicio regular nacional y/o internacional para empresas mexicanas"
    ),
    Map.entry(
      PermisoSctEnum.FOREIGN_COMPANIES_REGULAR_AIR_SERVICE,
      "Permiso para el servicio aereo regular de empresas extranjeras"
    ),
    Map.entry(
      PermisoSctEnum.NATIONAL_INTERNATIONAL_CHARTER_SERVICE,
      "Permiso para el servicio nacional e internacional no regular de fletamento"
    ),
    Map.entry(
      PermisoSctEnum.NATIONAL_INTERNATIONAL_AIR_TAXI_SERVICE,
      "Permiso para el servicio nacional e internacional no regular de taxi aereo"
    ),
    Map.entry(PermisoSctEnum.NOT_IN_CATALOG, "Permiso no contemplado en el catalogo.")
  );

  public enum SectorCofeprisEnum {
    MEDICINE("01"),
    PRECURSORS_AND_DUAL_USE_CHEMICALS("02"),
    PSYCHOTROPIC_AND_NARCOTIC("03"),
    TOXIC_SUBSTANCES("04"),
    PESTICIDES_AND_FERTILIZERS("05");

    private final String code;

    SectorCofeprisEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<SectorCofeprisEnum, String> SECTOR_COFEPRIS_DESCRIPTIONS = Map.ofEntries(
    Map.entry(SectorCofeprisEnum.MEDICINE, "Medicamento"),
    Map.entry(SectorCofeprisEnum.PRECURSORS_AND_DUAL_USE_CHEMICALS, "Precursores y quimicos de uso dual"),
    Map.entry(SectorCofeprisEnum.PSYCHOTROPIC_AND_NARCOTIC, "Psicotropicos y estupefacientes"),
    Map.entry(SectorCofeprisEnum.TOXIC_SUBSTANCES, "Sustancias toxicas"),
    Map.entry(SectorCofeprisEnum.PESTICIDES_AND_FERTILIZERS, "Plaguicidas y fertilizantes")
  );

  public enum PharmaceuticalFormsEnum {
    TABLET("01"),
    CAPSULES("02"),
    COMPRESSED("03"),
    SUGAR_COATED("04"),
    SUSPENSION("05"),
    SOLUTION("06"),
    EMULSION("07"),
    SYRUP("08"),
    INJECTABLE("09"),
    CREAM("10"),
    OINTMENT("11"),
    AEROSOL("12"),
    MEDICINAL_GAS("13"),
    GEL("14"),
    IMPLANT("15"),
    OVULE("16"),
    PATCH("17"),
    PASTE("18"),
    POWDER("19"),
    SUPPOSITORY("20");

    private final String code;

    PharmaceuticalFormsEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<PharmaceuticalFormsEnum, String> PHARMACEUTICAL_FORM_DESCRIPTIONS = Map.ofEntries(
    Map.entry(PharmaceuticalFormsEnum.TABLET, "Tableta"),
    Map.entry(PharmaceuticalFormsEnum.CAPSULES, "Capsulas"),
    Map.entry(PharmaceuticalFormsEnum.COMPRESSED, "Comprimidos"),
    Map.entry(PharmaceuticalFormsEnum.SUGAR_COATED, "Grageas"),
    Map.entry(PharmaceuticalFormsEnum.SUSPENSION, "Suspension"),
    Map.entry(PharmaceuticalFormsEnum.SOLUTION, "Solucion"),
    Map.entry(PharmaceuticalFormsEnum.EMULSION, "Emulsion"),
    Map.entry(PharmaceuticalFormsEnum.SYRUP, "Jarabe"),
    Map.entry(PharmaceuticalFormsEnum.INJECTABLE, "Inyectable"),
    Map.entry(PharmaceuticalFormsEnum.CREAM, "Crema"),
    Map.entry(PharmaceuticalFormsEnum.OINTMENT, "Unguento"),
    Map.entry(PharmaceuticalFormsEnum.AEROSOL, "Aerosol"),
    Map.entry(PharmaceuticalFormsEnum.MEDICINAL_GAS, "Gas medicinal"),
    Map.entry(PharmaceuticalFormsEnum.GEL, "Gel"),
    Map.entry(PharmaceuticalFormsEnum.IMPLANT, "Implante"),
    Map.entry(PharmaceuticalFormsEnum.OVULE, "Ovulo"),
    Map.entry(PharmaceuticalFormsEnum.PATCH, "Parche"),
    Map.entry(PharmaceuticalFormsEnum.PASTE, "Pasta"),
    Map.entry(PharmaceuticalFormsEnum.POWDER, "Polvo"),
    Map.entry(PharmaceuticalFormsEnum.SUPPOSITORY, "Supositorio")
  );

  public enum SpecialConditionsEnum {
    FROZEN("01"),
    REFRIGERATED("02"),
    CONTROLLED_TEMPERATURE("03"),
    ROOM_TEMPERATURE("04");

    private final String code;

    SpecialConditionsEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<SpecialConditionsEnum, String> SPECIAL_CONDITION_DESCRIPTIONS = Map.ofEntries(
    Map.entry(SpecialConditionsEnum.FROZEN, "Congelados"),
    Map.entry(SpecialConditionsEnum.REFRIGERATED, "Refrigerados"),
    Map.entry(SpecialConditionsEnum.CONTROLLED_TEMPERATURE, "Temperatura controlada"),
    Map.entry(SpecialConditionsEnum.ROOM_TEMPERATURE, "Temperatura ambiente")
  );

  public enum MaterialTypeEnum {
    RAW_MATERIAL("01"),
    PROCESSED_MATERIAL("02"),
    FINISHED_MATERIAL("03"),
    MANUFACTURING_INDUSTRY_MATERIAL("04"),
    OTHER("05");

    private final String code;

    MaterialTypeEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<MaterialTypeEnum, String> MATERIAL_TYPE_DESCRIPTIONS = Map.ofEntries(
    Map.entry(MaterialTypeEnum.RAW_MATERIAL, "Materia prima"),
    Map.entry(MaterialTypeEnum.PROCESSED_MATERIAL, "Materia procesada"),
    Map.entry(MaterialTypeEnum.FINISHED_MATERIAL, "Materia terminada (producto terminado)"),
    Map.entry(MaterialTypeEnum.MANUFACTURING_INDUSTRY_MATERIAL, "Materia para la industria manufacturera"),
    Map.entry(MaterialTypeEnum.OTHER, "Otra")
  );

  public enum TypeOfCustomsDocumentEnum {
    PEDIMENT("01"),
    TEMPORARY_IMPORT_AUTHORIZATION("02"),
    TEMPORARY_IMPORT_AUTHORIZATION_VESSELS("03"),
    TEMPORARY_IMPORT_AUTHORIZATION_MAINTENANCE("04"),
    IMPORT_AUTHORIZATION_SPECIAL_VEHICLES("05"),
    TEMPORARY_EXPORT_NOTICE("06"),
    TRANSFER_NOTICE_IMMEX_RFE_AUTHORIZED_OPERATOR("07"),
    TRANSFER_NOTICE_AUTO_PARTS_BORDER_ZONE("08"),
    TEMPORARY_IMPORT_CONSTANCY_CONTAINERS("09"),
    MERCHANDISE_TRANSFER_CONSTANCY("10"),
    DONATION_AUTHORIZATION_FOREIGN_MERCHANDISE("11"),
    ATA_CARNET("12"),
    EXCHANGE_LISTS("13"),
    TEMPORARY_IMPORT_PERMIT("14"),
    TEMPORARY_IMPORT_PERMIT_RV("15"),
    TEMPORARY_IMPORT_PERMIT_VESSELS("16"),
    DONATION_REQUEST_EMERGENCIES_DISASTERS("17"),
    CONSOLIDATED_NOTICE("18"),
    CROSSING_NOTICE_MERCHANDISE("19"),
    OTHER("20");

    private final String code;

    TypeOfCustomsDocumentEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<TypeOfCustomsDocumentEnum, String> TYPE_OF_CUSTOMS_DOCUMENT_DESCRIPTIONS = Map.ofEntries(
    Map.entry(TypeOfCustomsDocumentEnum.PEDIMENT, "Pedimento"),
    Map.entry(TypeOfCustomsDocumentEnum.TEMPORARY_IMPORT_AUTHORIZATION, "Autorizacion de importacion temporal"),
    Map.entry(
      TypeOfCustomsDocumentEnum.TEMPORARY_IMPORT_AUTHORIZATION_VESSELS,
      "Autorizacion de importacion temporal de embarcaciones"
    ),
    Map.entry(
      TypeOfCustomsDocumentEnum.TEMPORARY_IMPORT_AUTHORIZATION_MAINTENANCE,
      "Autorizacion de importacion temporal de mercancias, destinadas al mantenimiento y reparacion de las mercancias importadas temporalmente"
    ),
    Map.entry(
      TypeOfCustomsDocumentEnum.IMPORT_AUTHORIZATION_SPECIAL_VEHICLES,
      "Autorizacion para la importacion de vehiculos especialmente construidos o transformados, equipados con dispositivos o aparatos diversos para cumplir con contrato derivado de licitacion publica"
    ),
    Map.entry(TypeOfCustomsDocumentEnum.TEMPORARY_EXPORT_NOTICE, "Aviso de exportacion temporal"),
    Map.entry(
      TypeOfCustomsDocumentEnum.TRANSFER_NOTICE_IMMEX_RFE_AUTHORIZED_OPERATOR,
      "Aviso de traslado de mercancias de empresas con Programa IMMEX, RFE u Operador Economico Autorizado"
    ),
    Map.entry(
      TypeOfCustomsDocumentEnum.TRANSFER_NOTICE_AUTO_PARTS_BORDER_ZONE,
      "Aviso para el traslado de autopartes ubicadas en la franja o region fronteriza a la industria terminal automotriz o manufacturera de vehiculos de autotransporte en el resto del territorio nacional"
    ),
    Map.entry(
      TypeOfCustomsDocumentEnum.TEMPORARY_IMPORT_CONSTANCY_CONTAINERS,
      "Constancia de importacion temporal, retorno o transferencia de contenedores"
    ),
    Map.entry(TypeOfCustomsDocumentEnum.MERCHANDISE_TRANSFER_CONSTANCY, "Constancia de transferencia de mercancias"),
    Map.entry(
      TypeOfCustomsDocumentEnum.DONATION_AUTHORIZATION_FOREIGN_MERCHANDISE,
      "Autorizacion de donacion de mercancias al Fisco Federal que se encuentren en el extranjero"
    ),
    Map.entry(TypeOfCustomsDocumentEnum.ATA_CARNET, "Cuaderno ATA"),
    Map.entry(TypeOfCustomsDocumentEnum.EXCHANGE_LISTS, "Listas de intercambio"),
    Map.entry(TypeOfCustomsDocumentEnum.TEMPORARY_IMPORT_PERMIT, "Permiso de Importacion Temporal"),
    Map.entry(TypeOfCustomsDocumentEnum.TEMPORARY_IMPORT_PERMIT_RV, "Permiso de importacion temporal de casa rodante"),
    Map.entry(TypeOfCustomsDocumentEnum.TEMPORARY_IMPORT_PERMIT_VESSELS, "Permiso de importacion temporal de embarcaciones"),
    Map.entry(
      TypeOfCustomsDocumentEnum.DONATION_REQUEST_EMERGENCIES_DISASTERS,
      "Solicitud de donacion de mercancias en casos de emergencias o desastres naturales"
    ),
    Map.entry(TypeOfCustomsDocumentEnum.CONSOLIDATED_NOTICE, "Aviso de consolidado"),
    Map.entry(TypeOfCustomsDocumentEnum.CROSSING_NOTICE_MERCHANDISE, "Aviso de cruce de mercancias"),
    Map.entry(TypeOfCustomsDocumentEnum.OTHER, "Otro")
  );

  public enum TransportTypeEnum {
    UNIT_TRUCK("PT01"),
    TRUCK("PT02"),
    TRACTOR_TRUCK("PT03"),
    TRAILER("PT04"),
    SEMI_TRAILER("PT05"),
    LIGHT_LOAD_VEHICLE("PT06"),
    CRANE("PT07"),
    AIRCRAFT("PT08"),
    SHIP_OR_VESSEL("PT09"),
    CAR_OR_WAGON("PT10"),
    CONTAINER("PT11"),
    LOCOMOTIVE("PT12");

    private final String code;

    TransportTypeEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<TransportTypeEnum, String> TRANSPORT_TYPE_DESCRIPTIONS = Map.ofEntries(
    Map.entry(TransportTypeEnum.UNIT_TRUCK, "Camion unitario"),
    Map.entry(TransportTypeEnum.TRUCK, "Camion"),
    Map.entry(TransportTypeEnum.TRACTOR_TRUCK, "Tractocamion"),
    Map.entry(TransportTypeEnum.TRAILER, "Remolque"),
    Map.entry(TransportTypeEnum.SEMI_TRAILER, "Semirremolque"),
    Map.entry(TransportTypeEnum.LIGHT_LOAD_VEHICLE, "Vehiculo ligero de carga"),
    Map.entry(TransportTypeEnum.CRANE, "Grua"),
    Map.entry(TransportTypeEnum.AIRCRAFT, "Aeronave"),
    Map.entry(TransportTypeEnum.SHIP_OR_VESSEL, "Barco o buque"),
    Map.entry(TransportTypeEnum.CAR_OR_WAGON, "Carro o vagon"),
    Map.entry(TransportTypeEnum.CONTAINER, "Contenedor"),
    Map.entry(TransportTypeEnum.LOCOMOTIVE, "Locomotora")
  );

  public enum TransportFigureEnum {
    OPERATOR("01"),
    OWNER("02"),
    LESSOR("03"),
    NOTIFIED("04"),
    COORDINATED_MEMBER("05");

    private final String code;

    TransportFigureEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<TransportFigureEnum, String> TRANSPORT_FIGURE_DESCRIPTIONS = Map.ofEntries(
    Map.entry(TransportFigureEnum.OPERATOR, "Operador"),
    Map.entry(TransportFigureEnum.OWNER, "Propietario"),
    Map.entry(TransportFigureEnum.LESSOR, "Arrendador"),
    Map.entry(TransportFigureEnum.NOTIFIED, "Notificado"),
    Map.entry(TransportFigureEnum.COORDINATED_MEMBER, "Integrante de Coordinados")
  );

  public enum RegistroIstmoEnum {
    COATZACOALCOS_I("01"),
    COATZACOALCOS_II("02"),
    TEXISTEPEC("03"),
    SAN_JUAN_EVANGELISTA("04"),
    SALINA_CRUZ("05"),
    SAN_BLAS_ATEMPA("06");

    private final String code;

    RegistroIstmoEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<RegistroIstmoEnum, String> REGISTRO_ISTMO_DESCRIPTIONS = Map.ofEntries(
    Map.entry(RegistroIstmoEnum.COATZACOALCOS_I, "Coatzacoalcos I"),
    Map.entry(RegistroIstmoEnum.COATZACOALCOS_II, "Coatzacoalcos II"),
    Map.entry(RegistroIstmoEnum.TEXISTEPEC, "Texistepec"),
    Map.entry(RegistroIstmoEnum.SAN_JUAN_EVANGELISTA, "San Juan Evangelista"),
    Map.entry(RegistroIstmoEnum.SALINA_CRUZ, "Salina Cruz"),
    Map.entry(RegistroIstmoEnum.SAN_BLAS_ATEMPA, "San Blas Atempa")
  );

  public enum LoadingKey {
    GENERAL_LOOSE_CARGO("CGS"),
    GENERAL_CONTAINERIZED_CARGO("CGC"),
    BULK_MINERAL("GMN"),
    AGRICULTURAL_BULK("GAG"),
    OTHER_FLUIDS("OFL"),
    OIL_AND_DERIVATIVES("PYD");

    private final String code;

    LoadingKey(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<LoadingKey, String> LOADING_KEY_DESCRIPTIONS = Map.ofEntries(
    Map.entry(LoadingKey.GENERAL_LOOSE_CARGO, "Carga General Suelta"),
    Map.entry(LoadingKey.GENERAL_CONTAINERIZED_CARGO, "Carga General Contenerizada"),
    Map.entry(LoadingKey.BULK_MINERAL, "Gran Mineral"),
    Map.entry(LoadingKey.AGRICULTURAL_BULK, "Granel Agricola"),
    Map.entry(LoadingKey.OTHER_FLUIDS, "Otros Fluidos"),
    Map.entry(LoadingKey.OIL_AND_DERIVATIVES, "Petroleo y Derivados")
  );

  public enum ConfigMaritimaEnum {
    SUPPLIER("B01"),
    BARGE("B02"),
    BULK_CARRIER("B03"),
    CONTAINER_SHIP("B04"),
    DREDGER("B05"),
    FISHING("B06"),
    GENERAL_CARGO("B07"),
    CHEMICAL_TANKER("B08"),
    FERRY("B09"),
    RO_RO("B10"),
    RESEARCH("B11"),
    TANKER("B12"),
    GAS_CARRIER("B13"),
    TUG("B14"),
    EXTRAORDINARY_SPECIALIZATION("B15");

    private final String code;

    ConfigMaritimaEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<ConfigMaritimaEnum, String> CONFIG_MARITIMA_DESCRIPTIONS = Map.ofEntries(
    Map.entry(ConfigMaritimaEnum.SUPPLIER, "Abastecedor"),
    Map.entry(ConfigMaritimaEnum.BARGE, "Barcaza"),
    Map.entry(ConfigMaritimaEnum.BULK_CARRIER, "Granelero"),
    Map.entry(ConfigMaritimaEnum.CONTAINER_SHIP, "Porta Contenedor"),
    Map.entry(ConfigMaritimaEnum.DREDGER, "Draga"),
    Map.entry(ConfigMaritimaEnum.FISHING, "Pesquero"),
    Map.entry(ConfigMaritimaEnum.GENERAL_CARGO, "Carga General"),
    Map.entry(ConfigMaritimaEnum.CHEMICAL_TANKER, "Quimiqueros"),
    Map.entry(ConfigMaritimaEnum.FERRY, "Transbordadores"),
    Map.entry(ConfigMaritimaEnum.RO_RO, "Carga RoRo"),
    Map.entry(ConfigMaritimaEnum.RESEARCH, "Investigacion"),
    Map.entry(ConfigMaritimaEnum.TANKER, "Tanquero"),
    Map.entry(ConfigMaritimaEnum.GAS_CARRIER, "Gasero"),
    Map.entry(ConfigMaritimaEnum.TUG, "Remolcador"),
    Map.entry(ConfigMaritimaEnum.EXTRAORDINARY_SPECIALIZATION, "Extraordinaria especializacion")
  );

  public enum RailTrafficTypeEnum {
    LOCAL_TRAFFIC("TT01"),
    INTERLINE_FORWARDED_TRAFFIC("TT02"),
    INTERLINE_RECEIVED_TRAFFIC("TT03"),
    INTERLINE_TRANSIT_TRAFFIC("TT04");

    private final String code;

    RailTrafficTypeEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<RailTrafficTypeEnum, String> RAIL_TRAFFIC_TYPE_DESCRIPTIONS = Map.ofEntries(
    Map.entry(RailTrafficTypeEnum.LOCAL_TRAFFIC, "Trafico local"),
    Map.entry(RailTrafficTypeEnum.INTERLINE_FORWARDED_TRAFFIC, "Trafico interlineal remitido"),
    Map.entry(RailTrafficTypeEnum.INTERLINE_RECEIVED_TRAFFIC, "Trafico interlineal recibido"),
    Map.entry(RailTrafficTypeEnum.INTERLINE_TRANSIT_TRAFFIC, "Trafico interlineal en transito")
  );

  public enum ContainerTypeEnum {
    CONTAINER_20FT("TC01"),
    CONTAINER_40FT("TC02"),
    CONTAINER_45FT("TC03"),
    CONTAINER_48FT("TC04"),
    CONTAINER_53FT("TC05");

    private final String code;

    ContainerTypeEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<ContainerTypeEnum, String> CONTAINER_TYPE_DESCRIPTIONS = Map.ofEntries(
    Map.entry(ContainerTypeEnum.CONTAINER_20FT, "Contenedor de 6.1 Mts de longitud"),
    Map.entry(ContainerTypeEnum.CONTAINER_40FT, "Contenedor de 12.2 Mts de longitud"),
    Map.entry(ContainerTypeEnum.CONTAINER_45FT, "Contenedor de 13.7 Mts de longitud"),
    Map.entry(ContainerTypeEnum.CONTAINER_48FT, "Contenedor de 14.6 Mts de longitud"),
    Map.entry(ContainerTypeEnum.CONTAINER_53FT, "Contenedor de 16.1 Mts de longitud")
  );

  public enum MaritimeContainerTypeEnum {
    REFRIGERATED_20FT("CM001"),
    REFRIGERATED_40FT("CM002"),
    STANDARD_8FT("CM003"),
    STANDARD_10FT("CM004"),
    STANDARD_20FT("CM005"),
    STANDARD_40FT("CM006"),
    OPEN_SIDE("CM007"),
    ISOTANK("CM008"),
    FLAT_RACKS("CM009"),
    TANKER_SHIP("CM010"),
    FERRY("CM011"),
    TOURIST_FERRY("CM012");

    private final String code;

    MaritimeContainerTypeEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<MaritimeContainerTypeEnum, String> MARITIME_CONTAINER_TYPE_DESCRIPTIONS = Map.ofEntries(
    Map.entry(MaritimeContainerTypeEnum.REFRIGERATED_20FT, "Contenedores refrigerados de 20FT"),
    Map.entry(MaritimeContainerTypeEnum.REFRIGERATED_40FT, "Contenedores refrigerados de 40FT"),
    Map.entry(MaritimeContainerTypeEnum.STANDARD_8FT, "Contenedores estandar de 8FT"),
    Map.entry(MaritimeContainerTypeEnum.STANDARD_10FT, "Contenedores estandar de 10FT"),
    Map.entry(MaritimeContainerTypeEnum.STANDARD_20FT, "Contenedores estandar de 20FT"),
    Map.entry(MaritimeContainerTypeEnum.STANDARD_40FT, "Contenedores estandar de 40FT"),
    Map.entry(MaritimeContainerTypeEnum.OPEN_SIDE, "Contenedores Open Side"),
    Map.entry(MaritimeContainerTypeEnum.ISOTANK, "Contenedor Isotanque"),
    Map.entry(MaritimeContainerTypeEnum.FLAT_RACKS, "Contenedor flat racks"),
    Map.entry(MaritimeContainerTypeEnum.TANKER_SHIP, "Buque tanque"),
    Map.entry(MaritimeContainerTypeEnum.FERRY, "Ferri"),
    Map.entry(MaritimeContainerTypeEnum.TOURIST_FERRY, "Ferri - Turistico y vacios")
  );

  public enum RailCarTypeEnum {
    BOXCAR("TC01"),
    GONDOLA("TC02"),
    HOPPER("TC03"),
    TANK("TC04"),
    INTERMODAL_PLATFORM("TC05"),
    GENERAL_PURPOSE_PLATFORM("TC06"),
    AUTOMOTIVE_PLATFORM("TC07"),
    LOCOMOTIVE("TC08"),
    SPECIAL_CAR("TC09"),
    PASSENGER("TC10"),
    TRACK_MAINTENANCE("TC11");

    private final String code;

    RailCarTypeEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<RailCarTypeEnum, String> RAIL_CAR_TYPE_DESCRIPTIONS = Map.ofEntries(
    Map.entry(RailCarTypeEnum.BOXCAR, "Furgon"),
    Map.entry(RailCarTypeEnum.GONDOLA, "Gondola"),
    Map.entry(RailCarTypeEnum.HOPPER, "Tolva"),
    Map.entry(RailCarTypeEnum.TANK, "Tanque"),
    Map.entry(RailCarTypeEnum.INTERMODAL_PLATFORM, "Plataforma Intermodal"),
    Map.entry(RailCarTypeEnum.GENERAL_PURPOSE_PLATFORM, "Plataforma de Uso General"),
    Map.entry(RailCarTypeEnum.AUTOMOTIVE_PLATFORM, "Plataforma Automotriz"),
    Map.entry(RailCarTypeEnum.LOCOMOTIVE, "Locomotora"),
    Map.entry(RailCarTypeEnum.SPECIAL_CAR, "Carro Especial"),
    Map.entry(RailCarTypeEnum.PASSENGER, "Pasajeros"),
    Map.entry(RailCarTypeEnum.TRACK_MAINTENANCE, "Mantenimiento de Via")
  );

  public enum RailServiceTypeEnum {
    RAILWAY_CARS("TS01"),
    INTERMODAL_RAILWAY_CARS("TS02"),
    UNIT_TRAIN_RAILWAY_CARS("TS03"),
    UNIT_TRAIN_INTERMODAL("TS04");

    private final String code;

    RailServiceTypeEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public enum MotivoTrasladoEnum {
    PRIORLY_INVOICED_GOODS_SHIPMENT("01"),
    RELOCATION_OF_OWN_GOODS("02"),
    CONSIGNMENT_CONTRACT_GOODS_SHIPMENT("03"),
    GOODS_SHIPMENT_FOR_SUBSEQUENT_SALE("04"),
    THIRD_PARTY_OWNED_GOODS_SHIPMENT("05"),
    OTHER("99");

    private final String code;

    MotivoTrasladoEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<MotivoTrasladoEnum, String> MOTIVO_TRASLADO_DESCRIPTION = Map.ofEntries(
    Map.entry(MotivoTrasladoEnum.PRIORLY_INVOICED_GOODS_SHIPMENT, "Envio de mercancias facturadas con anterioridad"),
    Map.entry(MotivoTrasladoEnum.RELOCATION_OF_OWN_GOODS, "Reubicacion de mercancias propias"),
    Map.entry(
      MotivoTrasladoEnum.CONSIGNMENT_CONTRACT_GOODS_SHIPMENT,
      "Envio de mercancias objeto de contrato de consignacion"
    ),
    Map.entry(MotivoTrasladoEnum.GOODS_SHIPMENT_FOR_SUBSEQUENT_SALE, "Envio de mercancias para posterior enajenacion"),
    Map.entry(MotivoTrasladoEnum.THIRD_PARTY_OWNED_GOODS_SHIPMENT, "Envio de mercancias propiedad de terceros"),
    Map.entry(MotivoTrasladoEnum.OTHER, "Otros")
  );

  public enum IncotermEnum {
    CFR("CFR"),
    CIF("CIF"),
    CPT("CPT"),
    CIP("CIP"),
    DAP("DAP"),
    DDP("DDP"),
    DPU("DPU"),
    EXW("EXW"),
    FCA("FCA"),
    FAS("FAS"),
    FOB("FOB");

    private final String code;

    IncotermEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<IncotermEnum, String> INCOTERM_DESCRIPTION = Map.ofEntries(
    Map.entry(IncotermEnum.CFR, "Coste y flete (puerto de destino convenido)."),
    Map.entry(IncotermEnum.CIF, "Coste, seguro y flete (puerto de destino convenido)."),
    Map.entry(IncotermEnum.CPT, "Transporte pagado hasta (el lugar de destino convenido)."),
    Map.entry(IncotermEnum.CIP, "Transporte y seguro pagados hasta (lugar de destino convenido)."),
    Map.entry(IncotermEnum.DAP, "Entregada en lugar."),
    Map.entry(IncotermEnum.DDP, "Entregada derechos pagados (lugar de destino convenido)."),
    Map.entry(IncotermEnum.DPU, "Entregada y descargada en lugar acordado."),
    Map.entry(IncotermEnum.EXW, "En fabrica (lugar convenido)."),
    Map.entry(IncotermEnum.FCA, "Franco transportista (lugar designado)."),
    Map.entry(IncotermEnum.FAS, "Franco al costado del buque (puerto de carga convenido)."),
    Map.entry(IncotermEnum.FOB, "Franco a bordo (puerto de carga convenido).")
  );

  public enum UnidadAduanaEnum {
    KILO("01"),
    GRAMO("02"),
    METRO_LINEAL("03"),
    METRO_CUADRADO("04"),
    METRO_CUBICO("05"),
    PIEZA("06"),
    CABEZA("07"),
    LITRO("08"),
    PAR("09"),
    KILOWATT("10"),
    MILLAR("11"),
    JUEGO("12"),
    KILOWATT_HORA("13"),
    TONELADA("14"),
    BARRIL("15"),
    GRAMO_NETO("16"),
    DECENAS("17"),
    CIENTOS("18"),
    DOCENAS("19"),
    CAJA("20"),
    BOTELLA("21"),
    CARAT("22"),
    SERVICIO("99");

    private final String code;

    UnidadAduanaEnum(String code) {
      this.code = code;
    }

    public String code() {
      return code;
    }
  }

  public static final Map<UnidadAduanaEnum, String> UNIDAD_ADUANA_DESCRIPTION = Map.ofEntries(
    Map.entry(UnidadAduanaEnum.KILO, "KILO"),
    Map.entry(UnidadAduanaEnum.GRAMO, "GRAMO"),
    Map.entry(UnidadAduanaEnum.METRO_LINEAL, "METRO LINEAL"),
    Map.entry(UnidadAduanaEnum.METRO_CUADRADO, "METRO CUADRADO"),
    Map.entry(UnidadAduanaEnum.METRO_CUBICO, "METRO CUBICO"),
    Map.entry(UnidadAduanaEnum.PIEZA, "PIEZA"),
    Map.entry(UnidadAduanaEnum.CABEZA, "CABEZA"),
    Map.entry(UnidadAduanaEnum.LITRO, "LITRO"),
    Map.entry(UnidadAduanaEnum.PAR, "PAR"),
    Map.entry(UnidadAduanaEnum.KILOWATT, "KILOWATT"),
    Map.entry(UnidadAduanaEnum.MILLAR, "MILLAR"),
    Map.entry(UnidadAduanaEnum.JUEGO, "JUEGO"),
    Map.entry(UnidadAduanaEnum.KILOWATT_HORA, "KILOWATT/HORA"),
    Map.entry(UnidadAduanaEnum.TONELADA, "TONELADA"),
    Map.entry(UnidadAduanaEnum.BARRIL, "BARRIL"),
    Map.entry(UnidadAduanaEnum.GRAMO_NETO, "GRAMO NETO"),
    Map.entry(UnidadAduanaEnum.DECENAS, "DECENAS"),
    Map.entry(UnidadAduanaEnum.CIENTOS, "CIENTOS"),
    Map.entry(UnidadAduanaEnum.DOCENAS, "DOCENAS"),
    Map.entry(UnidadAduanaEnum.CAJA, "CAJA"),
    Map.entry(UnidadAduanaEnum.BOTELLA, "BOTELLA"),
    Map.entry(UnidadAduanaEnum.CARAT, "CARAT"),
    Map.entry(UnidadAduanaEnum.SERVICIO, "SERVICIO")
  );

  private ComplementCatalogConstants() {
  }
}
