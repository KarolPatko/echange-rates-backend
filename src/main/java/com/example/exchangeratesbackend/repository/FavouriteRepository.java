package com.example.exchangeratesbackend.repository;

import com.example.exchangeratesbackend.entitie.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
    @Query("SELECT f.currencyId FROM Favourite f where f.userId=:usId")
    ArrayList<Long> getCurrencyIdByUserId(Long userId);
}
