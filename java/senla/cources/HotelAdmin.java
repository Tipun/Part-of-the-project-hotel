package senla.cources;

import senla.cources.model.Booking;
import senla.cources.model.Guest;
import senla.cources.model.Room;
import senla.cources.servise.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelAdmin {

    private BookingService bookingService;
    private RoomService roomService;

    private static HotelAdmin instance;

    public static HotelAdmin getInstance() {
        if(instance == null) {
            instance = new HotelAdmin();
        }
        return instance;
    }

    private HotelAdmin() {
        this.bookingService = BookingServiceImpl.getInstance();
        this.roomService = RoomServiceImpl.getInstance();
    }
// возвращает список из трех последих постояльцев комнаты задание 4.8
    public List<Guest> getLastThreeGuests(Room room){
        List<Booking> bookings = bookingService.getAllBookings().stream()
                .filter(x -> x.getRoom().equals(room))
                .collect(Collectors.toList());
        List<Guest> guests = new ArrayList<>();
        if (bookings.size() < 4) {
            for (Booking booking: bookings){
                guests.addAll(booking.getGuests());
            }
            return guests;
        }
        return guests;
    }
    // возвращает список номеров свободных после определенной даты задание 4.6
    public List<Room> getRoomsFreeAfterDate(LocalDate Date){
        List<Booking> listBooking = bookingService.getBookingStorage().getStorage();
        List<Room> listFreeAfter = new ArrayList<>();
        for(Booking booking : listBooking){
            if(booking.getEndDate().isBefore(Date)){
                listFreeAfter.add(booking.getRoom());
            }
        }

        List<Room>listContInBookings = new ArrayList<>();
        for(Booking booking : listBooking){
            listContInBookings.add(booking.getRoom());
        }

        List<Room>listFree = roomService.getAllRooms();
        List<Room>listFree1 = new ArrayList<>();
        for(Room room : listFree){
            listFree1.add(room);
        }
        for(Room room : listFree){
        for(Room room1 : listContInBookings){
            if(room.equals(room1)){
                listFree1.remove(room);
                break;
            }
        }
        }

        listFreeAfter.addAll(listFree1);
        return listFreeAfter;
    }
}
