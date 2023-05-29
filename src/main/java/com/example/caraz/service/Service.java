package com.example.caraz.service;

import java.util.List;

public interface Service <E> {

    void add(E e);
    E getByID(Integer id);
    List<E> findAll(int page, int count);
    void deleteByID(int id);
}
