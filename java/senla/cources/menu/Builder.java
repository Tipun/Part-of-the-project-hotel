package senla.cources.menu;

import senla.cources.menu.actions.*;

public class Builder {
    private Menu rootMenu;

    public Menu getRootMenu() {
        this.buildMenu();
        return rootMenu;
    }

    private void buildMenu(){
        rootMenu = new Menu("Root menu");
        rootMenu.addMenuItem(
                new MenuItem("",
                        () -> System.out.println("Exit"),
                        createBookingMenu()));
        rootMenu.addMenuItem(
                new MenuItem("1 - Booking Menu",
                        () -> System.out.println("Go to booking menu"),
                        createBookingMenu()));
    }

    private Menu createBookingMenu() {
        Menu bookingMenu = new Menu("Booking Menu");
        bookingMenu.addMenuItem(new MenuItem("0 - go to main menu",
                () -> System.out.println("Go to main menu"),
                rootMenu));
        bookingMenu.addMenuItem(new MenuItem("1 - get current guests",
                new GetCurrentGuestsAction(),
                bookingMenu));
        bookingMenu.addMenuItem(new MenuItem("2 - get current guests count",
                new GetCurrentGuestsCountAction(),
                bookingMenu));
        bookingMenu.addMenuItem(new MenuItem("3 - is guest current",
                new IsGuestCurrentAction(),
                bookingMenu));
        bookingMenu.addMenuItem(new MenuItem("4 - get guests room services",
                new GetGuestsRoomServicesAction(),
                bookingMenu));
        bookingMenu.addMenuItem(new MenuItem("5 - get all rooms",
                new GetAllRoomsAction(),
                bookingMenu));
        bookingMenu.addMenuItem(new MenuItem("6 - get all rooms by price",
                new GetAllRoomsByPriceAction(),
                bookingMenu));
        bookingMenu.addMenuItem(new MenuItem("7 - get all rooms by capacity",
                new GetAllRoomsByCapacityAction(),
                bookingMenu));
        bookingMenu.addMenuItem(new MenuItem("8 - get all rooms by stars",
                new GetAllRoomsByStarsAction(),
                bookingMenu));
        bookingMenu.addMenuItem(new MenuItem("9 - get empty rooms",
                new GetEmptyRoomsAction(),
                bookingMenu));
        bookingMenu.addMenuItem(new MenuItem("10 - get empty rooms count",
                new GetEmptyRoomsCountAction(),
                bookingMenu));
        bookingMenu.addMenuItem(new MenuItem("11 - get all rooms prise by price",
                new GetAllRoomsPriseByPriceAction(),
                bookingMenu));
        bookingMenu.addMenuItem(new MenuItem("12 - get one room detals",
                new GetOneRoomDetalsAction(),
                bookingMenu));
        bookingMenu.addMenuItem(new MenuItem("13 - get room service prise by prise",
                new GetRoomServicePriseByPriseAction(),
                bookingMenu));
        return bookingMenu;
    }
}
