package com.example.usermanagementsoftware.Controller;

import com.example.usermanagementsoftware.ApiResponse.ApiResponse;
import com.example.usermanagementsoftware.Model.User;
import com.example.usermanagementsoftware.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("user added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.updateUser(id, user);
        return ResponseEntity.status(200).body("user updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("user deleted successfully"));
    }

    @GetMapping("/check/username/{username}")
    public ResponseEntity checkUserName(@PathVariable String username){
        userService.checkUserName(username);
        return ResponseEntity.status(200).body(new ApiResponse("username correct"));
    }
    @GetMapping("/check/password/{password}")
    public ResponseEntity checkPassword(@PathVariable String password){
        userService.checkPassword(password);
        return ResponseEntity.status(200).body(new ApiResponse("passowrd correct"));
    }

    @GetMapping("/get/by/email/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email){
        User user = userService.getUserByEmail(email);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/get/same/role/{role}")
    public ResponseEntity getSameUsersRole(@PathVariable String role){
        List<User> sameRoleUsers = userService.getSameUsersRole(role);
        return ResponseEntity.status(200).body(sameRoleUsers);
    }

    @GetMapping("/get/by/same/age/{age}")
    public ResponseEntity findSameAgeOrAboveUsers(@PathVariable Integer age){
        List<User> sameAgeOrAboveUsers = userService.findSameAgeOrAboveUsers(age);
        return ResponseEntity.status(200).body(sameAgeOrAboveUsers);
    }

    @GetMapping("/check/username/{username}/and/password/{password}")
    public ResponseEntity checkUsernameAndPassword(@PathVariable String username, @PathVariable String password){
       userService.checkUsernameAndPassword(username, password);
        return ResponseEntity.status(200).body(new ApiResponse("correct username and password"));
    }

}




















































