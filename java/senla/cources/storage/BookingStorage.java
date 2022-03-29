package senla.cources.storage;

import senla.cources.model.Booking;

public class BookingStorage extends BaseStorage<Booking> {

    private static BookingStorage instance;

    private BookingStorage(){

    }
    public static BookingStorage getInstance(){
        if(instance == null){
            instance = new BookingStorage();
        }
        return instance;
    }

}
