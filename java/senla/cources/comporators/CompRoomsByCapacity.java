package senla.cources.comporators;

import senla.cources.model.Room;

import java.util.Comparator;

public class CompRoomsByCapacity implements Comparator<Room> {
    public int compare(Room o1, Room o2) {
        return Integer.compare(o1.getCapacity(), o2.getCapacity());
    }
}
