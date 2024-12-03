package com.example.usermanagementsoftware.Service;

import com.example.usermanagementsoftware.ApiResponse.ApiException;
import com.example.usermanagementsoftware.Model.User;
import com.example.usermanagementsoftware.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user){
        User oldUser = userRepository.findUserById(id);
        if(oldUser==null){
            throw new ApiException("user not found");
        }
        oldUser.setName(user.getName());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setAge(user.getAge());
        userRepository.save(oldUser);
    }

    public void deleteUser(Integer id){
        // check if id exist
        User user = userRepository.findUserById(id);
        if(user==null){
            throw new ApiException("user not found");
        }
        userRepository.delete(user);
    }

    public void checkUserName(String username){
        User user = userRepository.checkUserName(username);
        if(user==null){
            throw new ApiException("username not found");
        }
    }

    public void checkPassword(String password){
        User user = userRepository.checkPassword(password);
        if(user==null){
            throw new ApiException("password not found");
        }
    }

    public User getUserByEmail(String email){
       User user = userRepository.findUserByEmail(email);
       if(user==null){
           throw new ApiException("user not found");
       }
       return user;
    }

    public List<User> getSameUsersRole(String role){
        List<User> sameRoleUsers = userRepository.findUsersByRole(role);
        if(sameRoleUsers.isEmpty()){
            throw new ApiException("incorrect role");
        }
        return sameRoleUsers;
    }

    public List<User> findSameAgeOrAboveUsers(Integer age){
        List<User> sameAgeOrAboveUsers = userRepository.findSameAgeOrAboveUsers(age);
        if(sameAgeOrAboveUsers.isEmpty()){
            throw new ApiException("list not found");
        }
        return sameAgeOrAboveUsers;
    }

}






















