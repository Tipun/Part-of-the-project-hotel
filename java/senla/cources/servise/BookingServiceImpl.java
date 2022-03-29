package senla.cources.servise;

import senla.cources.comporators.CompGuestsByLastName;
import senla.cources.comporators.CompRoomServicesByPrise;
import senla.cources.model.Booking;
import senla.cources.model.Guest;
import senla.cources.model.RoomService;
import senla.cources.storage.BookingStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookingServiceImpl implements BookingService {

    private BookingStorage bookingStorage;

    private BookingServiceImpl() {
        this.bookingStorage = BookingStorage.getInstance();
    }

    private static BookingServiceImpl instance;

    public static BookingServiceImpl getInstance(){
        if(instance == null){
            instance = new BookingServiceImpl();
        }
        return instance;
    }
//возвращает список постояльцев задание 4.3
    @Override
    public List<Guest> getCurrentGuests() {      // есть Action
        List<Guest> guests = new ArrayList<>();
        for (Booking booking : bookingStorage.getStorage()){
            if(booking.getEndDate().isAfter(LocalDate.now()))
            guests.addAll(booking.getGuests());
        }
        Collections.sort(guests,new CompGuestsByLastName());
        return guests;
    }
//возвращает общее число постояльцев задание 4.5    // есть Action
    @Override
    public Integer getCurrentGuestsCount() {
        return this.getCurrentGuests().size();
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingStorage.getStorage();
    }
    @Override
    public BookingStorage getBookingStorage() {
        return bookingStorage;
    }

    public void setBookingStorage(BookingStorage bookingStorage) {
        this.bookingStorage = bookingStorage;
    }
 // проживает ли постоялец в гостинице в данный момент к заданию 4.9
    @Override
    public boolean isGuestCurrent (Guest guest){                    // есть Action
        for(Booking booking : bookingStorage.getStorage()){
            for(Guest guest1 : booking.getGuests()) {
                if(guest1.equals(guest) && booking.getEndDate().isAfter(LocalDate.now()) && booking.getStartDate().isBefore(LocalDate.now())){
                    return true;
                }
            }
        }
        return false;
    }
    //возвращает список услуг постояльца и их цену задание 4.9
    @Override
    public List<RoomService> getGuestsRoomServices(Guest guest) {       // есть Action
        List <RoomService> list = new ArrayList<>();

        if (isGuestCurrent(guest) == true) {
            for (Booking booking : bookingStorage.getStorage()) {
                for (Guest guest1 : booking.getGuests()) {
                    if (guest1.equals(guest)) {
                        for(RoomService service : booking.getServices()){
                            list.add(service);
                        }
                        Collections.sort(list,new CompRoomServicesByPrise());
                        return list;
                    }
                }
            }
        }
        return null;
    }
}
