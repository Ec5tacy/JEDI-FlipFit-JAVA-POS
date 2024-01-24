package com.flipkart.dao;





import com.flipkart.bean.Slots;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SlotDAO implements com.flipkart.dao.SlotInterfaceDAO {
    public SlotDAO(){
    }

    public List<Slots> getSlotList() {
        List<Slots> slotList = new ArrayList<>();


        return slotList;
    }

    public List<Slots> getSlotByCentreId(String gymCentreId){
        List<Slots> slotList = new ArrayList<>();

        return slotList;
    }

    public void addSlot(Slots slot){

    }

    public Slots getSlotById(String slotID) {
        Slots slot = null;
        return slot;
    }

    public Slots getSlotByIdAndCentreId(String slotID,String centreID) {
        Slots slot = null;
        return slot;
    }
}