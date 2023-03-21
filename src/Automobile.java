public class Automobile {
    private String brand;
    private int yearRelease;

    public Automobile(String brand, int yearRelease) {
        this.brand = brand;
        this.yearRelease = yearRelease;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }

    @Override
    public String toString() {
        return "Автомобиль " +
                "марка " + brand +
                ", год выпуска " + yearRelease;
    }
}
