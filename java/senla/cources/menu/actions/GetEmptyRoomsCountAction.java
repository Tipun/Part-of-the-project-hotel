package senla.cources.menu.actions;

import senla.cources.servise.RoomService;
import senla.cources.servise.RoomServiceImpl;

public class GetEmptyRoomsCountAction implements IAction{
    RoomService roomService = RoomServiceImpl.getInstance();
    @Override
    public void execute() {
        System.out.println(roomService.getEmptyRoomsCount());
    }
}
