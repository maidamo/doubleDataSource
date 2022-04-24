package com.bobo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductOrder {

    private int id;

    private int uid;

    private String payWay;
}
