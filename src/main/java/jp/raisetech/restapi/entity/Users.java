package jp.raisetech.restapi.entity;

public class Users {
    private int id;
    private String name;
    private String birthdate;
    private int pin;

    public Users(int id, String name, String birthdate, int pin) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public int getPin() {
        return pin;
    }
}
