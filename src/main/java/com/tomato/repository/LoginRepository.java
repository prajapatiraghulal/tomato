package com.tomato.repository;

import com.tomato.model.LoginActivity;
import com.tomato.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginActivity,Long> {
    public LoginActivity findByTokenId(long tokenId);
    public LoginActivity findByLoginToken(String loginToken);
}
