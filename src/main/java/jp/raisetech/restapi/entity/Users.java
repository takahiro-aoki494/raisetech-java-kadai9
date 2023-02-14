package jp.raisetech.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Users {
    private int id;
    private String name;
    private String birthdate;
    private int pin;
}
