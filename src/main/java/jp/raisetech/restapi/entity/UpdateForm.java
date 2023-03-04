package jp.raisetech.restapi.entity;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.Objects;


@Getter
public class UpdateForm {
    @Length(max = 20)
    private final String userName;

    @NotBlank @Pattern(regexp = "^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[1-2][0-9]|3[0-1])$")
    //YYYY/mm/ddの形式。mmは01〜12、ddは01〜31でないとエラー
    private final String birthdate;

    @Positive//数値が正でないとエラー
    private final int pin;

    //送信されたリクエストに値が設定されていない場合コンストラクタで変更判定用の初期値を設定する
    public UpdateForm(String userName, String birthdate, int pin) {
        if (Objects.equals(userName, null)) {
            this.userName = null;
        } else {
            this.userName = userName;
        }

        if (Objects.equals(birthdate, null)) {
            this.birthdate = "0000/01/01";
        } else {
            this.birthdate = birthdate;

        }

        if (pin == 0) {
            this.pin = 1;
        } else {
            this.pin = pin;
        }
    }
}

