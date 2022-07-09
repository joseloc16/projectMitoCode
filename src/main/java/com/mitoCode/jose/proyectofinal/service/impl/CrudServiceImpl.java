package com.mitoCode.jose.proyectofinal.service.impl;

import com.mitoCode.jose.proyectofinal.repository.IGenericRepository;
import com.mitoCode.jose.proyectofinal.service.ICrudService;

import java.util.List;

public abstract class CrudServiceImpl<T, ID> implements ICrudService<T, ID> {

  protected abstract IGenericRepository<T, ID> getRepo();

  @Override
  public T register(T t) throws Exception {
    return getRepo().save(t);
  }

  @Override
  public T update(T t) throws Exception {
    return getRepo().save(t);
  }

  @Override
  public List<T> readAll() throws Exception {
    return getRepo().findAll();
  }

  @Override
  public T readById(ID id) throws Exception {
    return getRepo().findById(id).orElse(null);
  }

  @Override
  public void remove(ID id) throws Exception {
    getRepo().deleteById(id);
  }

  @Override
  public boolean isExist(ID id) {
    return getRepo().existsById(id);
  }
}
