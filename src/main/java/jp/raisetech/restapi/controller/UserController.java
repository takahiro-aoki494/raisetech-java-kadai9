package jp.raisetech.restapi.controller;

import jp.raisetech.restapi.entity.CreateForm;
import jp.raisetech.restapi.entity.UpdateForm;
import jp.raisetech.restapi.entity.Users;
import jp.raisetech.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<Users> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public Users getUser(@PathVariable int id) throws Exception {
        return userService.findById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Map<String, String>> createUser(@RequestBody @Validated CreateForm form,
                                                          UriComponentsBuilder builder) {

        // 登録処理
        Users user = userService.createUser(form);
        URI url = builder.path("/users/" + user.getId()) // id部分は実際に登録された際に発⾏したidを設定する
                .build().toUri();

        return ResponseEntity.created(url).body(Map.of("message", "user successfully created"));
    }


    @PatchMapping("/users/{id}")
    public ResponseEntity<Map<String, String>> updateUser(@PathVariable("id") int id,
                                                          @Validated @RequestBody UpdateForm updateForm) {

        //更新処理
        userService.updateUser(id, updateForm);

        return ResponseEntity.ok(Map.of("message", "user successfully updated"));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable("id") int id) {

        // 削除処理
        userService.deleteUser(id);

        return ResponseEntity.ok(Map.of("message", "user successfully deleted"));
    }
}
