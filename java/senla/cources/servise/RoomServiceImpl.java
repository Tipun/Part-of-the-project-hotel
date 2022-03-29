package senla.cources.servise;

import senla.cources.comporators.CompRoomsByCapacity;
import senla.cources.comporators.CompRoomsByPrise;
import senla.cources.comporators.CompRoomsByStars;
import senla.cources.model.Room;
import senla.cources.storage.BookingStorage;
import senla.cources.storage.RoomStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RoomServiceImpl implements RoomService {

    private RoomStorage roomStorage;

    private RoomServiceImpl() {
        this.roomStorage = roomStorage.getInstance();
    }

    private static RoomServiceImpl instance;

    public static RoomServiceImpl getInstance() {
        if (instance == null) {
            instance = new RoomServiceImpl();
        }
        return instance;
    }

    // возвращает список всех номеров задание 4.1
    @Override
    public List<Room> getAllRooms() {       //есть Action
        return roomStorage.getStorage();
    }


    // выводит список всех номеров к заданию 4.1
    @Override
    public void printGetAllRooms() {
        List<Room> list = getAllRooms();
        for (Room room : list) {
            System.out.println(room);
        }
    }

    // возвращает список всех номеров отсотрированный по цене задание 4.1
    @Override
    public List<Room> getAllRoomsByPrice() {        //есть Action
        List<Room> list = roomStorage.getStorage();
        List<Room> list1 = new ArrayList<>();
        for (Room room : list) {
            list1.add(room);
        }
        Collections.sort(list1, new CompRoomsByPrise());
        return list1;
    }

    //выводит список всех номеров отсотрированный по цене к заданию 4.1
    @Override
    public void printAllRoomsByPrice() {
        List<Room> list = getAllRoomsByPrice();
        for (Room room : list) {
            System.out.println(room);
        }
    }

    // возвращает список всех номеров отсотрированный по вместимости задание 4.1
    @Override
    public List<Room> getAllRoomsByCapacity() {     //есть Action
        List<Room> list = roomStorage.getStorage();
        List<Room> list1 = new ArrayList<>();
        for (Room room : list) {
            list1.add(room);
        }
        Collections.sort(list1, new CompRoomsByCapacity());
        return list1;
    }

    // выводит список всех номеров отсотрированный по вместимости к заданию 4.1
    @Override
    public void printAllRoomsByCapacity() {
        List<Room> list = getAllRoomsByCapacity();
        for (Room room : list) {
            System.out.println(room);
        }
    }

    // возвращает список всех номеров отсотрированный по количеству звезд задание 4.1
    @Override
    public List<Room> getAllRoomsByStars() {        //есть Action
        List<Room> list = roomStorage.getStorage();
        List<Room> list1 = new ArrayList<>();
        for (Room room : list) {
            list1.add(room);
        }
        Collections.sort(list1, new CompRoomsByStars());
        return list1;
    }

    // выводит список всех номеров отсотрированный по количеству звезд к заданию 4.1
    @Override
    public void printAllRoomsByStars() {
        List<Room> list = getAllRoomsByStars();
        for (Room room : list) {
            System.out.println(room);
        }
    }

    //возвращает список свободных номеров задание 4.2
    @Override
    public List<Room> getEmptyRooms() {             //есть Action
        return roomStorage.getStorage().stream()
                .filter(x -> x.getGuests().isEmpty())
                .collect(Collectors.toList());
    }

    //возвращает число свободных номеров задание 4.4
    @Override
    public Integer getEmptyRoomsCount() {               //есть Action
        return this.getEmptyRooms().size();
    }

    // возвращает цены всех номеров отсотрированный по цене задание 4.10
    @Override
    public List<Room> getAllRoomsPriseByPrice() {         //есть Action
        List<Room> list = roomStorage.getStorage();
        List<Room> list1 = new ArrayList<>();
        for (Room room : list) {
            list1.add(room);
        }
        Collections.sort(list1, new CompRoomsByPrise());
        return list1;
    }

    //просмотр деталей отдельного номера
    @Override
    public Room getOneRoomDetals(Room room) {           //есть Action
        List<Room> list = roomStorage.getStorage();
        for (Room room1 : list) {
            if (room1.equals(room)) {
                return room;
            }
        }
        return null;
    }

    public RoomStorage getRoomStorage() {
        return roomStorage;
    }

    public void setRoomStorage(RoomStorage roomStorage) {
        this.roomStorage = roomStorage;
    }
}

