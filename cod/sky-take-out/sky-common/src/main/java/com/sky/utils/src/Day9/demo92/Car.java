package Day9.demo92;

public class Car {
    private  int price;
    private  String brand;
    private  String color;
    public Car() {
    }
    public Car(int price, String brand, String color) {
        this.price = price;
        this.brand = brand;
        this.color = color;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String toString() {
        return "Car{price = " + price + ", brand = " + brand + ", color = " + color + "}";
    }
}
