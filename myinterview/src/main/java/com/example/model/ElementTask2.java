package com.example.model;

import lombok.Data;

@Data
public class ElementTask2 {

    private Integer value;
    private Integer index;
    private Integer previous;
    private Integer next;

    public ElementTask2(Integer index, Integer value, Integer next, Integer previous) {
        this.index = index;
        this.value = value;
        this.next = next;
        this.previous = previous;
    }
}
