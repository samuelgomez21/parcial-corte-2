package org.example.service;

import org.example.domain.Fruta;
import org.example.interfaces.FrutaService;
import org.example.repository.FrutaRepository;

import java.util.List;

public class FrutaServiceImpl implements FrutaService {
    private final FrutaRepository frutaRepository;

    public FrutaServiceImpl(FrutaRepository frutaRepository) {
        this.frutaRepository = frutaRepository;
    }

    @Override
    public void addFruta(Fruta fruta) {

        frutaRepository.save(fruta);
    }

    @Override
    public Fruta getFruta(int id) {
        return frutaRepository.findById(id);
    }

    @Override
    public List<Fruta> getAllFrutas() {
        return frutaRepository.findAll();
    }

    @Override
    public void updateFruta(Fruta fruta) {

        frutaRepository.update(fruta);
    }

    @Override
    public void deleteFruta(int id) {
        frutaRepository.delete(id);
    }
}