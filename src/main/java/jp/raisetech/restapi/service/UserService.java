package jp.raisetech.restapi.service;

import jp.raisetech.restapi.entity.CreateForm;
import jp.raisetech.restapi.entity.UpdateForm;
import jp.raisetech.restapi.entity.Users;

import java.util.List;

public interface UserService {

    List<Users> findAll();

    Users findById(int id) throws Exception;

    Users createUser(CreateForm form);

    void updateUser(int id, UpdateForm form);

    void deleteUser(int id);
}
