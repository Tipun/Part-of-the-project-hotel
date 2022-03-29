package senla.cources.storage;

import senla.cources.servise.BookingServiceImpl;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseStorage<T> {
    private List<T> storage;

   // private static BaseStorage instance;

    public BaseStorage(List<T> list) {
        this.storage = list;
    }

    public BaseStorage() {
        this.storage = new ArrayList<T>();
    }

    public void addToStorage(T object){
        this.storage.add(object);
    }

    public List<T> getStorage() {
        return storage;
    }


}
