package com.choppernews.ChopperNews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.choppernews.ChopperNews.entity.Noticia;

@Repository
public interface NoticiaRepo extends JpaRepository<Noticia, Long> {

}
