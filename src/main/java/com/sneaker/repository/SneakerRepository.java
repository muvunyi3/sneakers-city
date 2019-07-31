package com.sneaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sneaker.model.Sneaker;

public interface SneakerRepository extends JpaRepository<Sneaker, Long> {

}
