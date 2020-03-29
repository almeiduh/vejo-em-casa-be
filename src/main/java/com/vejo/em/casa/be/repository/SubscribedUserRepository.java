package com.vejo.em.casa.be.repository;

import com.vejo.em.casa.be.entity.SubscribedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscribedUserRepository extends JpaRepository<SubscribedUser, Long>, JpaSpecificationExecutor<SubscribedUser> {
}
