package io.facturapi.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentForm {
  EFECTIVO("01"),
  CHEQUE_NOMINATIVO("02"),
  TRANSFERENCIA_ELECTRONICA_DE_FONDOS("03"),
  TARJETA_DE_CREDITO("04"),
  MONEDERO_ELECTRONICO("05"),
  DINERO_ELECTRONICO("06"),
  VALES_DE_DESPENSA("08"),
  DACION_EN_PAGO("12"),
  PAGO_POR_SUBROGACION("13"),
  PAGO_POR_CONSIGNACION("14"),
  CONDONACION("15"),
  COMPENSACION("17"),
  NOVACION("23"),
  CONFUSION("24"),
  REMISION_DE_DEUDA("25"),
  PRESCRIPCION_O_CADUCIDAD("26"),
  A_SATISFACCION_DEL_ACREEDOR("27"),
  TARJETA_DE_DEBITO("28"),
  SERVICIO("29"),
  APLICACION_DE_ANTICIPOS("30"),
  INTERMEDIARIO_PAGOS("31"),
  POR_DEFINIR("99");

  private final String value;

  PaymentForm(String value) {
    this.value = value;
  }

  @JsonValue
  public String value() {
    return value;
  }

  @JsonCreator
  public static PaymentForm fromValue(String value) {
    for (PaymentForm item : values()) {
      if (item.value.equals(value)) {
        return item;
      }
    }
    throw new IllegalArgumentException("Unknown payment form: " + value);
  }
}
