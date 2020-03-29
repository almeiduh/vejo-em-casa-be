package com.vejo.em.casa.be.service;

import com.vejo.em.casa.be.entity.SubscribedUser;
import com.vejo.em.casa.be.repository.SubscribedUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscribedUserService {

    @Autowired
    private SubscribedUserRepository subscribedUserRepository;

    /**
     * Save subscribedUser
     *
     * @param subscribedUser
     */
    public SubscribedUser save(SubscribedUser subscribedUser) {
        return subscribedUserRepository.save(subscribedUser);
    }

}
