package com.example.demo.repository;

import com.example.demo.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository <Anime,String> {
}
