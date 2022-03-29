package senla.cources.storage;

import senla.cources.model.Room;

public class RoomStorage extends BaseStorage<Room> {

    private static RoomStorage instance;

    private RoomStorage(){

    }
    public static RoomStorage getInstance(){
        if(instance == null){
            instance = new RoomStorage();
        }
        return instance;
    }

}
