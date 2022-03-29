package senla.cources.menu.actions;

import senla.cources.servise.BookingService;
import senla.cources.servise.BookingServiceImpl;

public class GetCurrentGuestsAction implements IAction{
    BookingService bookingService = BookingServiceImpl.getInstance();
    @Override
    public void execute() {
        bookingService.getCurrentGuests().forEach(System.out::println);
    }
}
