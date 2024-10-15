package org.example.aplication;

import org.example.interfaces.FrutaService;
import org.example.repository.FrutaRepository;
import org.example.repository.FrutaRepositoryImpl;
import org.example.service.FrutaServiceImpl;
import org.example.domain.Fruta;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        FrutaRepository frutaRepository = new FrutaRepositoryImpl();
        FrutaService frutaService = new FrutaServiceImpl(frutaRepository);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar fruta");
            System.out.println("2. Listar frutas");
            System.out.println("3. Buscar fruta por ID");
            System.out.println("4. Actualizar fruta");
            System.out.println("5. Eliminar fruta");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID de la fruta: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese nombre de la fruta: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese color de la fruta: ");
                    String color = scanner.nextLine();
                    frutaService.addFruta(new Fruta(id, nombre, color));
                    System.out.println("Fruta agregada exitosamente.");
                    break;

                case 2:
                    List<Fruta> frutas = frutaService.getAllFrutas();
                    System.out.println("Frutas en la base de datos:");
                    frutas.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Ingrese ID de la fruta a buscar: ");
                    int buscarId = scanner.nextInt();
                    Fruta frutaEncontrada = frutaService.getFruta(buscarId);
                    if (frutaEncontrada != null) {
                        System.out.println("Fruta encontrada: " + frutaEncontrada);
                    } else {
                        System.out.println("Fruta no encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese ID de la fruta a actualizar: ");
                    int actualizarId = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese nuevo nombre de la fruta: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese nuevo color de la fruta: ");
                    String nuevoColor = scanner.nextLine();
                    frutaService.updateFruta(new Fruta(actualizarId, nuevoNombre, nuevoColor));
                    System.out.println("Fruta actualizada exitosamente.");
                    break;

                case 5:
                    System.out.print("Ingrese ID de la fruta a eliminar: ");
                    int eliminarId = scanner.nextInt();
                    frutaService.deleteFruta(eliminarId);
                    System.out.println("Fruta eliminada exitosamente.");
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}