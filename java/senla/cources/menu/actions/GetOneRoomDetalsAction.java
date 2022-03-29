package senla.cources.menu.actions;

import senla.cources.model.Room;
import senla.cources.servise.RoomService;
import senla.cources.servise.RoomServiceImpl;

import java.util.List;
import java.util.Scanner;

public class GetOneRoomDetalsAction implements IAction {
    RoomService roomService = RoomServiceImpl.getInstance();
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер комнаты");
        Integer number = scanner.nextInt();
        List<Room> listRoom = roomService.getAllRooms();
        for(Room room : listRoom){
            if(number == room.getNumber()){
                System.out.println(roomService.getOneRoomDetals(room));
                break;
            }
        }

    }
}
