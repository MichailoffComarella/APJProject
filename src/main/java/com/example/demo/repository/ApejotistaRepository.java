package com.example.demo.repository;

import com.example.demo.model.Apejotista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApejotistaRepository extends CrudRepository<Apejotista, Long> {
}
