package senla.cources.comporators;

import senla.cources.model.Guest;

import java.util.Comparator;

public class CompGuestsByLastName implements Comparator<Guest> {
    public int compare(Guest o1, Guest o2) {
        return o1.getSecondName().compareTo(o2.getSecondName());}
}

