package com.library.app.controller;

import com.library.app.model.User;
import com.library.app.resources.PasswordUtils;
import com.library.app.response.ApiOutput;
import com.library.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/vi/auth")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/user/{id}")
    User findUserByID(@PathVariable("id") Long id){
      return  service.findUserByID(id);
    }

    /*
    @GetMapping("/user/email/{email}")
    User findUserByEmail(@PathVariable("email") String email){
        return  service.findUserByEmail(email);
    }
    */
    @GetMapping("/user/email/{email}")
    ResponseEntity<ApiOutput> findUserByEmail(@PathVariable("email") String email){
        User user= service.findUserByEmail(email);
        ApiOutput output= new ApiOutput();
        if (user == null) {
            output.setResponse("Transaction failed");
            output.setCode(404);
            output.setData(null);
        } else {
            output.setResponse("Transaction successful");
            output.setCode(200);
            output.setData(user);
        }
        return  ResponseEntity.ok().body(output);
    }

    /*
    @GetMapping("/user/tel/{phoneNumber}")
    User findUserByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber){
        return  service.findUserByPhoneNumber(phoneNumber);
    }
     */
    @GetMapping("/login/{email}")
    ResponseEntity<ApiOutput> loginAuthentication(@PathVariable("email") String email){
        String[] emailAndPassword = email.split(",");
        String loginEmail = emailAndPassword[0];
        String loginpassword = emailAndPassword[1];
        User user= service.findUserByEmail(loginEmail);
        ApiOutput output= new ApiOutput();
        if(user!=null){
            if(PasswordUtils.verifyUserPassword(loginpassword, user.getPassword(), user.getPasswordSalt()))
            {
                System.out.println("PERMISSION GRANTED!");
                output.setResponse("PERMISSION GRANTED!");
                output.setCode(200);
                output.setData(user);
            } else {
                System.out.println("INVALID PASSWORD!");
                output.setResponse("INVALID PASSWORD!");
                output.setCode(500);
                output.setData(user);
            }
        }else {
            System.out.println("INVALID EMAIL!");
            output.setResponse("INVALID EMAIL!");
            output.setCode(404);
            output.setData(user);
        }
        return  ResponseEntity.ok().body(output);
    }
    @GetMapping("/user/tel/{phoneNumber}")
    ResponseEntity<ApiOutput> findUserByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber){
        User user= service.findUserByPhoneNumber(phoneNumber);
        ApiOutput output= new ApiOutput();
        if(user!=null){
            output.setResponse("Transaction successful");
            output.setCode(200);
            output.setData(user);
        }else {
            output.setResponse("Transaction failed");
            output.setCode(404);
            output.setData(null);
        }
        return  ResponseEntity.ok().body(output);
        //return  service.findUserByPhoneNumber(phoneNumber);
    }

    @GetMapping("/user")
    List<User> findAllUser(){
        return service.findAllUser();
    }

    @DeleteMapping("/user/{id}")
    void deleteUserByID(@PathVariable("id") Long id){
        service.deleteUserByID(id);
    }

    @PutMapping("/updateUser")
    ResponseEntity<User> updateUser(@RequestBody @Valid User u){
        User user= service.updateUser(u);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/saveUser")
    ResponseEntity<ApiOutput> saveUser(@RequestBody @Valid User u){
        User updatedUser= u;
        String password= u.getPassword();
        String passwordSalt = PasswordUtils.getSalt(25);
        // Protect user's password. The generated value can be stored in DB.
        String mySecurePassword = PasswordUtils.generateSecurePassword(password, passwordSalt);
        String token = "" + (new Random((long) ((u.getEmail().length() + u.getName().length()) + u.getPhoneNumber().length() + 487284) + u.getRole().length()).toString().replaceAll("java.util.Random@", "")) + "";

        updatedUser.setPassword(mySecurePassword);
        updatedUser.setPasswordSalt(passwordSalt);
        updatedUser.setToken(token);
        User user= service.saveUser(updatedUser);
        ApiOutput output= new ApiOutput();
        output.setCode(200);
        output.setData(user);
        output.setResponse("User saved successfully!");
        return  ResponseEntity.ok().body(output);
    }

}
