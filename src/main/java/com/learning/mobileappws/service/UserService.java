package com.learning.mobileappws.service;

import com.learning.mobileappws.ui.model.request.UserRequestModel;
import com.learning.mobileappws.ui.model.response.UserRest;
import org.springframework.stereotype.Service;


public interface UserService {
    UserRest createUser(UserRequestModel userRequestModel);
}
