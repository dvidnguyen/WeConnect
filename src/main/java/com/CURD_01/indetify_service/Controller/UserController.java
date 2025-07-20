package com.CURD_01.indetify_service.Controller;

import com.CURD_01.indetify_service.dto.request.ApiResponse;
import com.CURD_01.indetify_service.entity.User;
import com.CURD_01.indetify_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid dto.request.UserCreationRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setData(userService.createUser(request));
        return apiResponse;
    }
    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("/{id}")
        User getUser(@PathVariable("id") String id) {
        return userService.getUser(id);
        }
    @PutMapping("/{id}")
      User updateUser(@PathVariable("id") String id,@RequestBody dto.request.UserCreationRequest request){

        return userService.updateUser(id, request);
    }
    @DeleteMapping("/{id}")
        String deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return "User deleted successfully";
    }


}
