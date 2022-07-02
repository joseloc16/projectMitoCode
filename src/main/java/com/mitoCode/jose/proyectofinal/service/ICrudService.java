package com.mitoCode.jose.proyectofinal.service;

import java.util.List;

public interface ICrudService<T, ID> {
  T register(T t) throws Exception;

  T update(T t) throws Exception;

  List<T> readAll() throws Exception;

  T readById(ID id) throws Exception;

  void remove(ID id) throws Exception;
}
