package senla.cources.model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    //класс Комната
    private int number;
    private List<Guest> guest;
    private int capacity;
    private double stars;
    private RoomStatus status;
    private Double price;

    public Room() {
    }

    public Room(int number, List<Guest> guest, int capacity, double stars, RoomStatus status, double price) {
        this.number = number;
        this.guest = guest;
        this.capacity = capacity;
        this.stars = stars;
        this.status = status;
        this.price = price;
    }
    public Room(int number, List<Guest> guest, int capacity, double stars, double price) {
        this.number = number;
        this.guest = guest;
        this.capacity = capacity;
        this.stars = stars;
        this.status = RoomStatus.SERVICED;
        this.price = price;
    }


    public Room(int number, int capacity, double stars, double price) {
        this.number = number;
        this.guest = new ArrayList<>();
        this.capacity = capacity;
        this.stars = stars;
        this.status = RoomStatus.SERVICED;
        this.price = price;
    }
// метод позволяет проверить статус комнаты к заданию 3.3
    public void CheckStatus(){
        RoomStatus current = this.status;
                System.out.println(current);
    }
// метод позволяет изменить статус номера на ремонтируемый/обслуживаемый задание 3.3
    public void ChangeStatus (){
    if (this.status == RoomStatus.SERVICED){
        this.status = RoomStatus.REPAIR;
    }
    else
        this.status = RoomStatus.SERVICED;
    }
    //сеттер позволяет изменить цену номера задание 3.4
    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public List<Guest> getGuests() {
        return guest;
    }
// добавляет гостя в номер
    public void addGuest(Guest guest){
        this.guest.add(guest);
    }
 //выселяет гостя из номера
    public void removeGuest(Guest guest){
        this.guest.remove(guest);
    }
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", capacity=" + capacity +
                ", stars=" + stars +
                ", RoomStatus=" + status +
                ", price=" + price +
                '}';
    }
}
