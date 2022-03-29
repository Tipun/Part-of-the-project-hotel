package senla.cources.comporators;


import senla.cources.model.Room;

import java.util.Comparator;

public class CompRoomsByPrise implements Comparator<Room> {
    public int compare(Room o1, Room o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
