package com.vejo.em.casa.be.service;

import com.vejo.em.casa.be.entity.User;
import com.vejo.em.casa.be.entity.User_;
import com.vejo.em.casa.be.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Save email if it doesn't exists
     *
     * @param email
     */
    public User save(String email) {
        Optional<User> user = userRepository.findOne(Specification.where(hasEmail(email)));
        return user.orElseGet(() -> userRepository.save(new User(email)));
    }

    /**
     * @return
     */
    public Page<User> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }


    ////////////////////////////////////////////////
    /// Specifications for Users                //
    ///////////////////////////////////////////////

    /**
     * @param email can be {@literal null}.
     * @return
     */
    static Specification<User> hasEmail(String email) {
        if (email == null) return (user, cq, cb) -> null;

        return (event, cq, cb) -> cb.equal(event.get(User_.email), email);
    }
}
