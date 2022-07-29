package com.tomato.repository;

import com.tomato.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    public Admin findByEmail(String email);

    public Admin findByPhoneNumber(String phoneNumber);
}