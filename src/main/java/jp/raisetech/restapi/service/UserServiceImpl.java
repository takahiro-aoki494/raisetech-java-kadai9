package jp.raisetech.restapi.service;

import jp.raisetech.restapi.entity.Users;
import jp.raisetech.restapi.exception.ResourceNotFoundException;
import jp.raisetech.restapi.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<Users> findAll() {
        return userMapper.findAll();
    }

    @Override
    public Users findById(int id) {
        Optional<Users> user = this.userMapper.findById(id);

        return user.orElseThrow(() -> new ResourceNotFoundException("resource not found"));
    }
}
