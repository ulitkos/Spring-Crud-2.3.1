package web.model;

public class Car {
    private final int id;
    private final String manufacturer;
    private final String model;

    public Car(int id, String manufacturer, String model) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }
}
