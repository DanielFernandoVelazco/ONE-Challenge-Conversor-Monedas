public class CurrencyConverter {

    public double convertCurrency(double originalValue, double fromRate, double toRate) {
        return originalValue * (toRate / fromRate);
    }
}