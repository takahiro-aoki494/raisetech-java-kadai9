package jp.raisetech.restapi.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;


@Getter
@RequiredArgsConstructor
public class UpdateForm {
    @Length(max = 20)
    private final String userName;

    @Pattern(regexp = "^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[1-2][0-9]|3[0-1])$")
    //YYYY/mm/ddの形式。mmは01〜12、ddは01〜31でないとエラー
    private final String birthdate;

    @Positive//数値が正でないとエラー
    private final Integer pin;
}

