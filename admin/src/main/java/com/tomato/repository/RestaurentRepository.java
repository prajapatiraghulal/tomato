package com.tomato.repository;

import com.tomato.model.Restaurent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurentRepository  extends JpaRepository<Restaurent,Long> {

    public Restaurent findByRestaurentId(String RestaurentId);

    public Restaurent deleteRestaurentByRestaurentId(String RestaurentId);
}
