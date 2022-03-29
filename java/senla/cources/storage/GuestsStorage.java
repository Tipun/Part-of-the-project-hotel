package senla.cources.storage;

import senla.cources.model.Guest;

public class GuestsStorage extends BaseStorage<Guest>{

    private static GuestsStorage instance;

    private GuestsStorage(){

    }
    public static GuestsStorage getInstance(){
        if(instance == null){
            instance = new GuestsStorage();
        }
        return instance;
    }
}
