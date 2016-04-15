package com.DTOLayer.DTOEntity;

import com.model.Entity.Item;

public class MyOrderDTO {
    private ItemDTO item;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public MyOrderDTO(Item item){
        this.item = new ItemDTO(item);
        count = 1;
    }
}
