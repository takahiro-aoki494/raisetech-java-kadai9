package jp.raisetech.restapi.service;

import jp.raisetech.restapi.entity.CreateForm;
import jp.raisetech.restapi.entity.UpdateForm;
import jp.raisetech.restapi.entity.Users;
import jp.raisetech.restapi.exception.ResourceNotFoundException;
import jp.raisetech.restapi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public List<Users> findAll() {
        return userMapper.findAll();
    }

    @Override
    public Users findById(int id) {
        Optional<Users> user = this.userMapper.findById(id);

        return user.orElseThrow(() -> new ResourceNotFoundException("resource not found"));
    }

    @Override
    public Users createUser(CreateForm form) {
        Users user = new Users(null, form.getUserName(), form.getBirthdate(), form.getPin());
        userMapper.insertUser(user);

        return user;
    }

    @Override
    public void updateUser(int id, UpdateForm form) {

        //指定されたidが存在しない場合ResourceNotFoundExceptionを投げる
        Optional<Users> user = userMapper.findById(id);
        user.orElseThrow(() -> new ResourceNotFoundException("resource not found"));

        //formの各要素がデフォルトの値でない場合は更新処理を行う
        if (!(Objects.equals(form.getUserName(), null))) {
            userMapper.updateUserName(id, form.getUserName());
        }

        if (!(Objects.equals(form.getBirthdate(), "0000/01/01"))) {
            userMapper.updateUserBirthdate(id, form.getBirthdate());
        }

        if (!(Objects.equals(form.getPin(), 1))) {
            userMapper.updateUserPin(id, form.getPin());
        }
    }

    @Override
    public void deleteUser(int id) {

        //指定されたidが存在しない場合ResourceNotFoundExceptionを投げる
        Optional<Users> user = userMapper.findById(id);
        user.orElseThrow(() -> new ResourceNotFoundException("resource not found"));

        userMapper.deleteUser(id);
    }
}
