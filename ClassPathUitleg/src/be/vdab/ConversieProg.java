package be.vdab;

public class ConversieProg {
    public static void main(String[] args) {
        var converter = new Converter();
        for (var centimeters = 1; centimeters <= 10; centimeters++){
            System.out.println(centimeters + "cm = " + converter.centimetersToInches(centimeters) + " inches");
        }
    }
}
