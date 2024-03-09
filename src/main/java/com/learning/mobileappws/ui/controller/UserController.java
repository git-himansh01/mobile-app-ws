package com.learning.mobileappws.ui.controller;

import com.learning.mobileappws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
//required = false making the request param optional
    @GetMapping
    public String getUsers(@RequestParam(value="page", defaultValue="1") int page, @RequestParam(value="limit", defaultValue="25") int limit, @RequestParam(value="sort", defaultValue="desc", required=false ) String sort){
        return "Get Users was called with page = ."+ page +" and limit ="+limit+" and sort = "+sort;
    }
    //since var name in path and argument is same hence mentioning it in path variable argument is optional
//    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
//    public UserRest getUser(@PathVariable(value="userId") String userId){
//        UserRest userRest= new UserRest();
//        userRest.setFirstName("Himanshu");
//        userRest.setLastName("Gupta");
//        userRest.setEmail("waystohimanshu@gmail.com");
//        userRest.setUserId(userId);
//        return userRest;
//    }

@GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public ResponseEntity<UserRest> getUser(@PathVariable(value="userId") String userId) {
    UserRest userRest = new UserRest();
    userRest.setFirstName("Himanshu");
    userRest.setLastName("Gupta");
    userRest.setEmail("waystohimanshu@gmail.com");
    userRest.setUserId(userId);
    return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);
}
    @PostMapping
    public String createUser(){
        return "Create User was called";
    }
    @PutMapping
    public String updateUser(){
        return "Update user was called";
    }
    @DeleteMapping
    public String deleteUser(){
        return "Delete user was called";
    }

}
