package com.example.demo.repository;

import com.example.demo.model.Preceptor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreceptorRepository extends CrudRepository<Preceptor, Long> {
}
