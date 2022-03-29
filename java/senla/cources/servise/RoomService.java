package senla.cources.servise;

import senla.cources.model.Room;

import java.util.List;

public interface RoomService {

    List<Room> getAllRooms();
    void printGetAllRooms();
    List<Room> getAllRoomsByPrice();
    void printAllRoomsByPrice();
    List<Room> getAllRoomsByCapacity();
    void printAllRoomsByCapacity();
    List<Room> getAllRoomsByStars();
    void printAllRoomsByStars();
    List<Room> getEmptyRooms();
    Integer getEmptyRoomsCount();
    List<Room> getAllRoomsPriseByPrice();
    Room getOneRoomDetals(Room room);
}
