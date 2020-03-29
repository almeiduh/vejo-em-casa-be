package com.vejo.em.casa.be.rest;

import com.vejo.em.casa.be.entity.SubscribedUser;
import com.vejo.em.casa.be.rest.request.SubscribeUserRequest;
import com.vejo.em.casa.be.service.SubscribedUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping("/subscribeUser")
public class SubscribedUserController {

    @Autowired
    private SubscribedUserService subscribedUserService;

    @PostMapping
    public SubscribedUser save(@Valid @RequestBody SubscribeUserRequest subscribeUserRequest) {
        log.debug("Received request to save subscribed user {}", subscribeUserRequest.toString());
        return this.subscribedUserService.save(new SubscribedUser(subscribeUserRequest.getEmail()));
    }

}
