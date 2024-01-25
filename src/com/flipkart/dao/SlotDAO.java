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

    public void updateSlot(Slots slot, String slotId)
    {
        Slots slotnew = getSlotById(slotId);
        //update the slot
    }
    public void addSlot(Slots slot){

    }

    public boolean isSlotAvailable(String slotId)
    {
        //fetch api
        return true;

    }
    public Slots getSlotById(String slotID) {
        Slots slot = null;
        return slot;
    }
}