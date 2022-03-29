package senla.cources.menu.actions;

import senla.cources.model.Guest;
import senla.cources.servise.BookingService;
import senla.cources.servise.BookingServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IsGuestCurrentAction implements IAction{
    BookingService bookingService = BookingServiceImpl.getInstance();
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию постояльца");
        String surname = scanner.nextLine();
        System.out.println("Введите имя постояльца");
        String name = scanner.nextLine();

        List<Guest> listOfGuests = bookingService.getCurrentGuests();
        boolean y = false;
        for(Guest guest : listOfGuests){
            if(guest.getSecondName().toLowerCase().equals(surname.trim().toLowerCase())
                    && guest.getFirstName().toLowerCase().equals(name.trim().toLowerCase())){
                y = bookingService.isGuestCurrent(guest);
                break;
            }
        }
        if(y == true){
            System.out.println("В данный момент гость проживает в гостинице");
        }
        else {
            System.out.println("В данный момент гость не проживает в гостинице");
        }
        scanner.close();
    }
}
