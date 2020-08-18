package com.example.hotel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    String cid;
    int rid;
    float reciepts;
    float deposit;
}
