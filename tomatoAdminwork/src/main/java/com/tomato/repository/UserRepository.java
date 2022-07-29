package com.tomato.repository;

import com.tomato.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String email);
    public User findByPhoneNumber(String phoneNumber);

    public User findByUserId(long userId);
}
