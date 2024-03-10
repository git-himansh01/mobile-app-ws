package com.learning.mobileappws.service.impl;

import com.learning.mobileappws.service.UserService;
import com.learning.mobileappws.ui.model.request.UserRequestModel;
import com.learning.mobileappws.ui.model.response.UserRest;
import com.learning.mobileappws.utility.Utils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    Utils utils;

    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    Map<String,UserRest> userRestMap;
    @Override
    public UserRest createUser(UserRequestModel userRequestModel) {
        UserRest userRest = new UserRest();
        userRest.setFirstName(userRequestModel.getFirstName());
        userRest.setLastName(userRequestModel.getLastName());
        userRest.setEmail(userRequestModel.getEmail());
        //userRest.setUserId(userId);
        //below code for temporary storage
      //  String userId= UUID.randomUUID().toString();
        String userId =utils.generateUserId();
        userRest.setUserId(userId);
        if(userRestMap== null) userRestMap=new HashMap<>();
        userRestMap.put(userId, userRest);
        return userRest;
    }
}
