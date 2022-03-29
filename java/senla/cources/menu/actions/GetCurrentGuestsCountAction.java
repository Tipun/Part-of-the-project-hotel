package senla.cources.menu.actions;

import senla.cources.servise.BookingService;
import senla.cources.servise.BookingServiceImpl;

public class GetCurrentGuestsCountAction implements IAction {
    BookingService bookingService = BookingServiceImpl.getInstance();
    @Override
    public void execute() {
        System.out.println("Количество гостей сейчас: " + bookingService.getCurrentGuestsCount());
    }
}
