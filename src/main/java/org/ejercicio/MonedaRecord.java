package org.ejercicio;

import java.math.BigDecimal;

public record MonedaRecord(
        String baseCode,
        String targetCode,
        BigDecimal conversionRate,
        BigDecimal conversionResult) {
}
