package senla.cources.menu.actions;

import senla.cources.servise.RoomService;
import senla.cources.servise.RoomServiceImpl;

public class GetAllRoomsByPriceAction implements IAction{
    RoomService roomService = RoomServiceImpl.getInstance();
    @Override
    public void execute() {
        roomService.getAllRoomsByPrice().forEach(System.out::println);
    }
}
