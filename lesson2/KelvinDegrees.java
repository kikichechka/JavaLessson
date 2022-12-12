package lesson2;

public class KelvinDegrees implements Converter{
    Double degrees;

    public KelvinDegrees(Double degrees) {
        this.degrees = degrees;
        convertValue();
    }

    public void setDegrees(Double degrees) {
        this.degrees = degrees;
    }

    public double getDegrees() {
        return degrees;
    }

    @Override
    public void convertValue() {
        degrees = getDegrees() + 273.15;
        setDegrees(degrees);
    }

    @Override
    public String toString() {
        return degrees + " (°К) градусов по Кельвину.";
    }

}
