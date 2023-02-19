package jp.raisetech.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Users {
    private Long id;
    private String name;
    private String birthdate;
    private int pin;
}
