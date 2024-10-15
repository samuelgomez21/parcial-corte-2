package org.example.repository;

import org.example.domain.Fruta;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FrutaRepositoryImpl implements FrutaRepository {
    private static final String FILE_NAME = "frutas.ser";

    @Override
    public void save(Fruta fruta) {
        List<Fruta> frutas = findAll();
        frutas.add(fruta);
        serialize(frutas);
    }

    @Override
    public Fruta findById(int id) {
        return findAll().stream().filter(fruta -> fruta.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Fruta> findAll() {
        return deserialize();
    }

    @Override
    public void update(Fruta fruta) {
        List<Fruta> frutas = findAll();
        for (int i = 0; i < frutas.size(); i++) {
            if (frutas.get(i).getId() == fruta.getId()) {
                frutas.set(i, fruta);
                break;
            }
        }
        serialize(frutas);
    }

    @Override
    public void delete(int id) {
        List<Fruta> frutas = findAll();
        frutas.removeIf(fruta -> fruta.getId() == id);
        serialize(frutas);
    }

    private void serialize(List<Fruta> frutas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(frutas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private List<Fruta> deserialize() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Fruta>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}