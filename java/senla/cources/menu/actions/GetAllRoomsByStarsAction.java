package senla.cources.menu.actions;

import senla.cources.servise.RoomService;
import senla.cources.servise.RoomServiceImpl;

public class GetAllRoomsByStarsAction implements IAction {
    RoomService roomService = RoomServiceImpl.getInstance();
    @Override
    public void execute() {
        roomService.getAllRoomsByStars().forEach(System.out::println);
    }
}
