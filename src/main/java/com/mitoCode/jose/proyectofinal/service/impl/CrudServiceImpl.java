package com.mitoCode.jose.proyectofinal.service.impl;

import com.mitoCode.jose.proyectofinal.service.ICrudService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class CrudServiceImpl<T, ID> implements ICrudService<T, ID> {

  protected abstract JpaRepository<T, ID> getRepo();

  @Override
  public T register(T t) throws Exception {
    return null;
  }

  @Override
  public T update(T t) throws Exception {
    return null;
  }

  @Override
  public List<T> readAll() throws Exception {
    return null;
  }

  @Override
  public T readById(ID id) throws Exception {
    return null;
  }

  @Override
  public void remove(ID id) throws Exception {

  }
}
