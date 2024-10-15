package org.example.repository;

import org.example.domain.Fruta;

import java.util.List;

public interface FrutaRepository {
    void save(Fruta fruta);
    Fruta findById(int id);
    List<Fruta> findAll();
    void update(Fruta fruta);
    void delete(int id);
}