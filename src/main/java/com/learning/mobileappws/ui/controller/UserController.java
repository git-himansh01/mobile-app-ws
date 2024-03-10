package com.learning.mobileappws.ui.controller;

import com.learning.mobileappws.exception.UserServiceException;
import com.learning.mobileappws.service.UserService;
import com.learning.mobileappws.service.impl.UserServiceImpl;
import com.learning.mobileappws.ui.model.request.UpdateUserRequestModel;
import com.learning.mobileappws.ui.model.request.UserRequestModel;
import com.learning.mobileappws.ui.model.response.UserRest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
    @Autowired
     UserService userService;
    Map<String,UserRest> userRestMap;
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
//    UserRest userRest = new UserRest();
//    userRest.setFirstName("Himanshu");
//    userRest.setLastName("Gupta");
//    userRest.setEmail("waystohimanshu@gmail.com");
//    userRest.setUserId(userId);
//    return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);

    //Even if we don't make exception class, this message will override the default message
// if(true) throw new UserServiceException("A User Service Exception is thrown");
    if (userRestMap.containsKey(userId)) {
        return new ResponseEntity<UserRest>(userRestMap.get(userId), HttpStatus.OK);
    }else{
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@RequestBody @Valid UserRequestModel userRequestModel){
//        UserRest userRest = new UserRest();
//        userRest.setFirstName(userRequestModel.getFirstName());
//        userRest.setLastName(userRequestModel.getLastName());
//        userRest.setEmail(userRequestModel.getEmail());
//        //userRest.setUserId(userId);
//        //below code for temporary storage
//        String userId= UUID.randomUUID().toString();
//        userRest.setUserId(userId);
//        if(userRestMap== null) userRestMap=new HashMap<>();
//        userRestMap.put(userId, userRest);

        return new ResponseEntity<UserRest>(userService.createUser(userRequestModel), HttpStatus.CREATED);
    }
    @PutMapping(path = "/{userId}", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> updateUser(@PathVariable String userId, @RequestBody @Valid UpdateUserRequestModel updateUserRequestModel){
        UserRest storedUserDetails = userRestMap.get(userId);
        storedUserDetails.setFirstName(updateUserRequestModel.getFirstName());
        storedUserDetails.setLastName(updateUserRequestModel.getLastName());
        userRestMap.put(userId,storedUserDetails );
      //  return storedUserDetails;
        return new ResponseEntity<UserRest>(storedUserDetails, HttpStatus.OK);
    }
    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        userRestMap.remove(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
