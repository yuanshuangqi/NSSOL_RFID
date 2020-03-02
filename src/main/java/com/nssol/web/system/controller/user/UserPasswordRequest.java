package com.nssol.web.system.controller.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPasswordRequest {
    private String oldPassword;
    private String newPassword;
}
