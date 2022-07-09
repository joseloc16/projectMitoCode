package com.mitoCode.jose.proyectofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericRepository<T, ID> extends JpaRepository<T, ID> {
  boolean existsById(Integer id);
}
