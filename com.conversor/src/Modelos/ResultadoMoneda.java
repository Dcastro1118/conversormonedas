package Modelos;

import java.util.Map;

public record ResultadoMoneda(
        String baseCode,
        Map<String, Double> conversionRates) {
    @Override
    public String toString() {
        return conversionRates.get("USD").toString();
    }
}
