package jp.raisetech.restapi.mapper;

import jp.raisetech.restapi.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

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
}
