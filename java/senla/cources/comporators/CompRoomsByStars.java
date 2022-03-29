package senla.cources.comporators;

import senla.cources.model.Room;

import java.util.Comparator;

public class CompRoomsByStars implements Comparator<Room> {
    public int compare(Room o1, Room o2) {
        return Double.compare(o1.getStars(), o2.getStars());
    }
}

