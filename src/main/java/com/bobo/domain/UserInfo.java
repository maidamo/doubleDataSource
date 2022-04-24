package com.bobo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserInfo {

    private String name;

    private String phoneNo;

    private int id;
}
