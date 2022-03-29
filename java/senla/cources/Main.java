package senla.cources;

import senla.cources.model.*;
import senla.cources.servise.BookingServiceImpl;
import senla.cources.servise.RoomServiceImpl;
import senla.cources.servise.RoomServiceServiceImpl;
import senla.cources.storage.BookingStorage;
import senla.cources.storage.GuestsStorage;
import senla.cources.storage.RoomServiceStorage;
import senla.cources.storage.RoomStorage;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Guest guest1 = new Guest("Иван", "Иванов", 36);
        Guest guest2 = new Guest("Ирина", "Иванова", 33);
        Guest guest3 = new Guest("Петр", "Петров", 52);
        Guest guest4 = new Guest("Степан", "Сидоров", 23);
        Guest guest5 = new Guest("Семен", "Шпак", 23);

        RoomService service1 = new RoomService(25.0, "Питание");
        RoomService service2 = new RoomService(3.5, "Интернет");
        RoomService service3 = new RoomService(4.5, "Корреспонденция");


        Room room1 = new Room(12, 2, 4.5, 280.0);
        Room room2 = new Room(14, 1, 3.5, 130.0);
        Room room3 = new Room(22, 1, 3, 110.0);
        Room room4 = new Room(24, 1, 3.5, 150.0);
        Room room5 = new Room(37, 3, 2.0, 520.0);


//Добавляем в отель комнаты, жильцов, услуги
        RoomStorage roomStorage = RoomStorage.getInstance();
        roomStorage.addToStorage(room1);
        roomStorage.addToStorage(room2);
        roomStorage.addToStorage(room3);
        roomStorage.addToStorage(room4);
        roomStorage.addToStorage(room5);
        GuestsStorage guestsStorage = GuestsStorage.getInstance();
        guestsStorage.addToStorage(guest1);
        guestsStorage.addToStorage(guest2);
        guestsStorage.addToStorage(guest3);
        guestsStorage.addToStorage(guest4);
        RoomServiceStorage roomServiceStorage = RoomServiceStorage.getInstance();
        roomServiceStorage.addToStorage(service1);
        roomServiceStorage.addToStorage(service2);
        roomServiceStorage.addToStorage(service3);

//создаем заказы : заселяем гостей и добавляем услуги в комнаты при помощи методов
        Booking booking1 = new Booking(room1, LocalDate.of(2022, Month.JANUARY, 07), LocalDate.of(2022, Month.JANUARY, 25));
        booking1.putGuest(guest1);
        booking1.putGuest(guest2);
        booking1.putService(service2);
        room1.addGuest(guest1);
        room1.addGuest(guest2);
        //System.out.println(booking1);
        //System.out.println(booking1.getCommonPrice() + " руб.");
        Booking booking2 = new Booking(room2, LocalDate.of(2022, Month.JANUARY, 05), LocalDate.of(2022, Month.JANUARY, 22));
        booking2.putGuest(guest3);
        booking2.putService(service1);
        room2.addGuest(guest3);
        // System.out.println(booking2);
        // System.out.println(booking2.getCommonPrice() + " руб.");
        Booking booking3 = new Booking(room3, LocalDate.of(2022, Month.JANUARY, 05), LocalDate.of(2022, Month.JANUARY, 18));
        booking3.putGuest(guest4);
        booking3.putService(service3);
        room3.addGuest(guest3);
        // System.out.println(booking3);
        // System.out.println(booking3.getCommonPrice() + " руб.");
//Создаем базу заказов
        BookingStorage bookingStorage = BookingStorage.getInstance();
        bookingStorage.addToStorage(booking1);
        bookingStorage.addToStorage(booking2);
        bookingStorage.addToStorage(booking3);

        RoomServiceImpl roomService = RoomServiceImpl.getInstance();
        //выведем список всех номеров
        System.out.println("All rooms");
        roomService.printGetAllRooms();
        //выведем список всех номеров сортируя по цене
        System.out.println("All rooms by Prise");
        roomService.printAllRoomsByPrice();
        System.out.println("--------------");
        roomService.printGetAllRooms();
        System.out.println("-------------");
        //выведем список всех номеров сортируя по вместимости
        System.out.println("All rooms by Capacity");
        roomService.printAllRoomsByCapacity();
        //выведем список всех номеров сортируя по количеству звезд
        System.out.println("All rooms by Stars");
        roomService.printAllRoomsByStars();
        System.out.println("--------------");
        roomService.printGetAllRooms();
        System.out.println("-------------");
        //покажем список всех свободных номеров
        System.out.println(roomService.getEmptyRooms());
        //количество свободных номеров
        System.out.println(roomService.getEmptyRoomsCount());

        BookingServiceImpl bookingService = BookingServiceImpl.getInstance();
        // постояльцы отсортировано по фамилии
        System.out.println(bookingService.getCurrentGuests());
        // общее число постояльцев
        System.out.println(bookingService.getCurrentGuestsCount());

        HotelAdmin hotelAdmin = HotelAdmin.getInstance();
        //последние три гостя комнаты
        System.out.println(hotelAdmin.getLastThreeGuests(room1));
        //список номеров свободных после 19,01,2022.
        System.out.println(hotelAdmin.getRoomsFreeAfterDate(LocalDate.of(2022, Month.JANUARY, 23)));
        roomService.printGetAllRooms();
        //список услуг постояльца и их цена
        System.out.println(bookingService.getGuestsRoomServices(guest1));

        RoomServiceServiceImpl roomServiceService = RoomServiceServiceImpl.getInstance();
        //цены услуг отсортировано по цене
        System.out.println(roomServiceService.getRoomServicePriseByPrise());
        //выведем детали отдельной комнаты
        System.out.println(roomService.getOneRoomDetals(room5));
    }
}
