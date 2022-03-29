package senla.cources.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Guest> guests;
    private List<RoomService> services;

    public Booking(Room room, LocalDate startDate, LocalDate endDate, List<Guest> guests, List<RoomService> services) {
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guests = guests;
        this.services = services;
    }
    public Booking(Room room, LocalDate startDate, LocalDate endDate) {
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guests = new ArrayList<Guest>();
        this.services = new ArrayList<RoomService>();
    }

    //добавляем гостя в номер(селим человека) задание 3.1
    public void putGuest(Guest guest){
        this.guests.add(guest);
    }
    //выселяем гостя из номера задание 3.2
    public  void evictGuest() {
        this.guests = new ArrayList<>();
    }
    //добавляем услугу в номер к заданию 3
    public void putService(RoomService service){
        this.services.add(service);
    }
    //удаляем услугу из номера к заданию 3
    public  void evictService(RoomService service) {
        this.services.remove(service);
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public List<RoomService> getServices() {
        return services;
    }

    // считает цену заказа
    public Double getBookingPrice() {
        if (startDate.equals(endDate)){
            return room.getPrice().doubleValue();
        }
        return ChronoUnit.DAYS.between(startDate, endDate) * room.getPrice();
    }
//считает цену услуг
    public Double getServicePrice(){
        return services.stream().mapToDouble(RoomService::getPrice).sum() * ChronoUnit.DAYS.between(startDate, endDate);
    }
    //считает общую стоимость заказа задание 4.7
    public Double getCommonPrice(){
        return getBookingPrice() + getServicePrice();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "room=" + room +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", guests=" + guests +
                ", services=" + services +
                '}';
    }
}
