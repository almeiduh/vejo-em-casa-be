package com.vejo.em.casa.be.rest.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class SubscribeUserRequest implements Serializable {

    @NotNull
    @Email
    private String email;

}
