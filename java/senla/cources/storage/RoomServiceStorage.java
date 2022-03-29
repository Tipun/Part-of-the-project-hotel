package senla.cources.storage;

import senla.cources.model.RoomService;

public class RoomServiceStorage extends BaseStorage<RoomService> {

    private static RoomServiceStorage instance;

    private RoomServiceStorage(){

    }
    public static RoomServiceStorage getInstance(){
        if(instance == null){
            instance = new RoomServiceStorage();
        }
        return instance;
    }
}
