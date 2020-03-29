package com.vejo.em.casa.be.rest;

import com.vejo.em.casa.be.entity.SubscribedUser;
import com.vejo.em.casa.be.rest.request.SubscribeUserRequest;
import com.vejo.em.casa.be.service.SubscribedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/subscribeUser")
@Validated
@CrossOrigin
public class SubscribedUserController {

    @Autowired
    private SubscribedUserService subscribedUserService;

    @PostMapping
    public SubscribedUser save(@Valid @RequestBody SubscribeUserRequest subscribeUserRequest) {
        return this.subscribedUserService.save(new SubscribedUser(subscribeUserRequest.getEmail()));
    }

}
