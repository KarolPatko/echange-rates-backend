package com.example.exchangeratesbackend.repository;

import com.example.exchangeratesbackend.entitie.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {


}
