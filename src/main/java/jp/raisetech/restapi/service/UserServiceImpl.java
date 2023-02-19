package jp.raisetech.restapi.service;

import jp.raisetech.restapi.entity.CreateForm;
import jp.raisetech.restapi.entity.Users;
import jp.raisetech.restapi.exception.ResourceNotFoundException;
import jp.raisetech.restapi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Users create(CreateForm form) {
        Users user = new Users(null, form.getUserName(), form.getBirthdate(), form.getPin());
        userMapper.insertUser(user);

        return user;
    }
}
