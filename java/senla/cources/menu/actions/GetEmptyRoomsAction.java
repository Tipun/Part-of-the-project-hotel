package senla.cources.menu.actions;

import senla.cources.servise.RoomService;
import senla.cources.servise.RoomServiceImpl;

public class GetEmptyRoomsAction implements IAction{
    RoomService roomService = RoomServiceImpl.getInstance();
    @Override
    public void execute() {
        roomService.getEmptyRooms().forEach(System.out::println);
    }
}
