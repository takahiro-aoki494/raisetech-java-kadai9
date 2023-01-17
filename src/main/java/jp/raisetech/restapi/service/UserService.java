package jp.raisetech.restapi.service;

import jp.raisetech.restapi.entity.Users;

import java.util.List;

public interface UserService {

    List<Users> findAll();

    Users findById(int id) throws Exception;

}
