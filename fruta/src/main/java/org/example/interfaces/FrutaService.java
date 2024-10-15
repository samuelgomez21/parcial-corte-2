package org.example.interfaces;

import org.example.domain.Fruta;

import java.util.List;

import java.util.List;

public interface FrutaService {
    void addFruta(Fruta fruta);
    Fruta getFruta(int id);
    List<Fruta> getAllFrutas();
    void updateFruta(Fruta fruta);
    void deleteFruta(int id);
}