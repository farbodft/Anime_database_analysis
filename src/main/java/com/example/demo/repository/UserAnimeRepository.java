package com.example.demo.repository;

import com.example.demo.entity.UserAnime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnimeRepository extends JpaRepository<UserAnime, String> {
}
