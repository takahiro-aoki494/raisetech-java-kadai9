package jp.raisetech.restapi.mapper;

import jp.raisetech.restapi.entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM names")
    List<Users> findAll();

    @Select("SELECT * FROM names WHERE id = #{id}")
    Optional<Users> findById(int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO names (name,birthdate,pin) values (#{name}, #{birthdate}, #{pin})")
    void insertUser(Users user);

    @Update("UPDATE names SET name=#{userName}  WHERE id = #{id}")
    void updateUserName(int id, String userName);

    @Update("UPDATE names SET birthdate=#{birthdate}  WHERE id = #{id}")
    void updateUserBirthdate(int id, String birthdate);

    @Update("UPDATE names SET pin=#{pin}   WHERE id = #{id}")
    void updateUserPin(int id, int pin);

    @Delete("DELETE FROM names WHERE id = #{id}")
    void deleteUser(int id);

}
