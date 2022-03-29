package senla.cources.model;


//класс Услуга
public class RoomService {
    private Double price;
    private String name;

    public RoomService(Double price, String name) {
        this.price = price;
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    // изменяет стоимость услуги задание 3.4
    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "RoomService{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
