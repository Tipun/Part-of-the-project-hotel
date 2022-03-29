package senla.cources.menu.actions;

import senla.cources.servise.RoomService;
import senla.cources.servise.RoomServiceImpl;

public class GetAllRoomsByCapacityAction implements IAction{
    RoomService roomService = RoomServiceImpl.getInstance();
    @Override
    public void execute() {
        roomService.getAllRoomsByCapacity().forEach(System.out::println);
    }
}
