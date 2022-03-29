package senla.cources.servise;

import senla.cources.model.Booking;
import senla.cources.model.Guest;
import senla.cources.model.RoomService;
import senla.cources.storage.BookingStorage;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();
    List<Guest> getCurrentGuests();
    Integer getCurrentGuestsCount();
    BookingStorage getBookingStorage();
    List<RoomService> getGuestsRoomServices(Guest guest);
    boolean isGuestCurrent (Guest guest);


}
