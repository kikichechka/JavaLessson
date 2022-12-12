package lesson2;

public class FahrenheitDegrees implements Converter{
    double degrees;

    public FahrenheitDegrees(double degrees) {
        this.degrees = degrees;
        convertValue();
    }

    public double getDegrees() {
        return degrees;
    }

    public void setDegrees(double degrees) {
        this.degrees = degrees;
    }

    @Override
    public void convertValue() {
        degrees = (getDegrees() * 9/5) + 32;
        setDegrees(degrees);
    }

    @Override
    public String toString() {
        return degrees + " (°F) градусов по Фаренгейту.";
    }
}
