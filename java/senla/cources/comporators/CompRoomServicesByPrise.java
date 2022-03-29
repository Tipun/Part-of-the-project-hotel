package senla.cources.comporators;

import senla.cources.model.RoomService;

import java.util.Comparator;

public class CompRoomServicesByPrise implements Comparator<RoomService> {
    public int compare(RoomService o1, RoomService o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }


}
