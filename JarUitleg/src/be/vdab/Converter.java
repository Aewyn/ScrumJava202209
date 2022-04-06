package be.vdab;

public class Converter {
    private final static double CENTIMETERS_IN_ONE_INCH = 2.54;

    public double centimetersToInches(double centimeters){
        return centimeters / CENTIMETERS_IN_ONE_INCH;
    }
}
