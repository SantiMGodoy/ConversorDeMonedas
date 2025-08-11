package org.ejercicio;

import java.math.BigDecimal;

public class Moneda {
    private String moneda1;
    private String moneda2;
    private BigDecimal valorIngresado;
    private BigDecimal resultado;
    private BigDecimal valorConversion;

    public Moneda(String moneda1, String moneda2, BigDecimal valorIngresado, BigDecimal resultado, BigDecimal valorConversion) {
        this.moneda1 = moneda1;
        this.moneda2 = moneda2;
        this.valorIngresado = valorIngresado;
        this.resultado = resultado;
        this.valorConversion = valorConversion;
    }

    public Moneda(MonedaRecord monedaRecord, BigDecimal valorIngresado) {
        this.moneda1 = monedaRecord.baseCode();
        this.moneda2 = monedaRecord.targetCode();
        this.resultado = monedaRecord.conversionResult();
        this.valorIngresado = valorIngresado;
        this.valorConversion = monedaRecord.conversionRate();
    }

    public String getMoneda1() {
        return moneda1;
    }

    public String getMoneda2() {
        return moneda2;
    }

    public BigDecimal getValorIngresado() {
        return valorIngresado;
    }

    public BigDecimal getResultado() {
        return resultado;
    }

    public BigDecimal getValorConversion() {
        return valorConversion;
    }

    @Override
    public String toString() {
        return "Resultado de la conversión de " + moneda1 + " a " + moneda2 + ": \n" +
                "Se ingresaron " + valorIngresado + " " + moneda1 + ", con un valor de conversión de " + valorConversion +
                " por " + moneda1 + ", lo que se convierte en " + resultado + " " + moneda2 + ".\n";
    }

}
