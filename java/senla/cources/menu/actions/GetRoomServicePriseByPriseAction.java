package senla.cources.menu.actions;

import senla.cources.servise.RoomService;
import senla.cources.servise.RoomServiceImpl;
import senla.cources.servise.RoomServiceService;
import senla.cources.servise.RoomServiceServiceImpl;

public class GetRoomServicePriseByPriseAction implements IAction {
    RoomServiceService roomServiceService = RoomServiceServiceImpl.getInstance();
    @Override
    public void execute() {
        roomServiceService.getRoomServicePriseByPrise().forEach(System.out::println);
    }
}
