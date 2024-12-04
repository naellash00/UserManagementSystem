package com.example.usermanagementsoftware.Repository;

import com.example.usermanagementsoftware.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
     User findUserById(Integer id);

     @Query("select u from User u where u.username = ?1")
     User checkUserName(String username);
     //the other way
     User findUserByUsername(String username);

     @Query("select u from User u where u.password = ?1")
     User checkPassword(String password);

     @Query("select u from User u where u.username = ?1 and u.password = ?2")
     User checkUsernameAndPassword(String username, String password);

     User findUserByEmail(String email);

     @Query("select u from User u where u.role = ?1")
     List<User> findUsersByRole(String role);

     @Query("select u from User u where u.age >= ?1")
     List<User> findSameAgeOrAboveUsers(Integer age);
}










