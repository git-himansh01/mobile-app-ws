package com.learning.mobileappws.ui.model.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRequestModel {
    @Size(min=2, max=16, message="Enter a name of 3 to 16 characters")
    @NotNull(message = "First Name cannot be Null, please provide a valid name") //Below Field cannot be null like field only not given in the body or given null value
    private String firstName;
    @NotBlank(message = "Last Name cannot be Blank, please provide a valid surname") //Below Field cannot be blank like ""
    private String lastName;
    @NotEmpty(message = "Email cannot be empty, please provide a valid email")
    @Email
    private String email;
    @Size(min=8, max=16, message="Enter a password of 8 to 16 characters")
    private String password;
}
