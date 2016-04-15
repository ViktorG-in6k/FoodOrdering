package com.DTOLayer.DTOEntity.orderDTO;

import com.DTOLayer.DTOEntity.ItemDTO;
import com.model.Entity.Item;

class OrderDTOItemCount {
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

    public OrderDTOItemCount(Item item){
        this.item = new ItemDTO(item);
        count = 1;
    }
}
