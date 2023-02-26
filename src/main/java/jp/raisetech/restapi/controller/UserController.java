package jp.raisetech.restapi.controller;

import jp.raisetech.restapi.entity.CreateForm;
import jp.raisetech.restapi.entity.UpdateForm;
import jp.raisetech.restapi.entity.Users;
import jp.raisetech.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<Users> getUsers() {
        List<Users> users = userService.findAll();
        return users;
    }

    @GetMapping("/users/{id}")
    public Users getUser(@PathVariable int id) throws Exception {
        return userService.findById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Map<String, String>> createUser(@RequestBody @Validated CreateForm form, BindingResult result,
                                                          UriComponentsBuilder builder) {

        //バリデーションでエラーがでたら、エラーメッセージをレスポンスする
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.status(400).body(errors);
        }

        // 登録処理
        Users user = userService.createUser(form);
        URI url = builder.path("/users/" + user.getId()) // id部分は実際に登録された際に発⾏したidを設定する
                .build().toUri();

        return ResponseEntity.created(url).body(Map.of("message", "user successfully created"));
    }


    @PatchMapping("/users/{id}")
    public ResponseEntity<Map<String, String>> updateUser(@PathVariable("id") int id,
                                                          @RequestParam(defaultValue = "null", required = false) String userName,
                                                          @RequestParam(defaultValue = "0000/1/1", required = false) String birthdate,
                                                          @RequestParam(defaultValue = "0", required = false) Integer pin) {

        //受け取ったパラメータ使ってformを作成
        UpdateForm form = new UpdateForm(userName, birthdate, pin);

        //更新処理
        userService.updateUser(id, form);

        return ResponseEntity.ok(Map.of("message", "user successfully updated"));
    }
}
