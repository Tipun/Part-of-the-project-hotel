package senla.cources.menu.actions;

import senla.cources.servise.RoomService;
import senla.cources.servise.RoomServiceImpl;

public class GetAllRoomsAction implements IAction{
    RoomService roomService = RoomServiceImpl.getInstance();
    @Override
    public void execute() {
        roomService.getAllRooms().forEach(System.out::println);
    }

}
