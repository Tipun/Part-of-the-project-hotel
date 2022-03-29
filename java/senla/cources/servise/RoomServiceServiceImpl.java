package senla.cources.servise;

import senla.cources.comporators.CompRoomServicesByPrise;
import senla.cources.model.RoomService;
import senla.cources.storage.RoomServiceStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoomServiceServiceImpl implements RoomServiceService {
    private RoomServiceStorage roomServiceStorage;


    private RoomServiceServiceImpl() {
        this.roomServiceStorage = roomServiceStorage.getInstance();
    }
    private static RoomServiceServiceImpl instance;

    public static RoomServiceServiceImpl getInstance() {
        if (instance == null) {
            instance = new RoomServiceServiceImpl();
        }
        return instance;
    }
    // возвращает цены всех услуг отсотрированный по цене задание 4.10
    @Override
    public List<RoomService> getRoomServicePriseByPrise() {
        List<senla.cources.model.RoomService> list = roomServiceStorage.getStorage();
        List<senla.cources.model.RoomService> list2 = new ArrayList<>();
        for(senla.cources.model.RoomService service : list){
            list2.add(service);
        }
        Collections.sort(list2,new CompRoomServicesByPrise());
        return list2;
    }
}
