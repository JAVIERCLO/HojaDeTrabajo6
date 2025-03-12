import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion < 1 || opcion > 3) {
            System.out.println("Seleccione la implementación de Map:");
            System.out.println("1. HashMap\n2. TreeMap\n3. LinkedHashMap");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            } else {
                scanner.next();
            }
        }

        // Crear el mapa seleccionado
        Map<String, Pokemon> pokemonMap = Factory.createMap(opcion);
        Database database = new Database(pokemonMap);

        // Medir tiempo de carga del CSV con Profiler
        Profiler profiler = new Profiler();
        profiler.startTime();
        try {
            database.leerData("pokemon_data_pokeapi.csv");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return;
        }
        profiler.stopTime();
        System.out.println("Tiempo de carga de datos: " + profiler.getTime() + " ms");

        // Medir tiempo de inserción en el Map
        profiler.startTime();
        for (int i = 0; i < 10000; i++) {
            pokemonMap.put("Test" + i, new Pokemon("Test" + i, i, "Normal", null, "Test Pokémon", 1.0f, 10.0f, "Ability", 1, false));
        }
        profiler.stopTime();
        System.out.println("Tiempo de inserción de datos en " + pokemonMap.getClass().getSimpleName() + ": " + profiler.getTime() + " ms");

        Coleccion coleccion = new Coleccion();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar Pokémon a la colección");
            System.out.println("2. Mostrar datos de un Pokémon");
            System.out.println("3. Mostrar colección ordenada por tipo");
            System.out.println("4. Mostrar todos los Pokémon ordenados por tipo");
            System.out.println("5. Buscar Pokémon por habilidad");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                int seleccion = scanner.nextInt();
                scanner.nextLine();

                switch (seleccion) {
                    case 1:
                        System.out.print("Ingrese el nombre del Pokémon: ");
                        String nombre = scanner.nextLine();
                        Pokemon pokemon = pokemonMap.get(nombre);
                        if (pokemon != null) {
                            if (coleccion.agregarPokemon(pokemon)) {
                                System.out.println(nombre + " agregado a la colección.");
                            }
                        } else {
                            System.out.println("Pokémon no encontrado.");
                        }
                        break;

                    case 2:
                        System.out.print("Ingrese el nombre del Pokémon: ");
                        nombre = scanner.nextLine();
                        pokemon = pokemonMap.get(nombre);
                        System.out.println(pokemon != null ? pokemon : "Pokémon no encontrado.");
                        break;

                    case 3:
                        System.out.println("Pokémon en tu colección:");
                        coleccion.mostrarColeccion();
                        break;

                    case 4:
                        System.out.println("Pokémon ordenados por tipo:");
                        pokemonMap.values().stream()
                            .sorted((p1, p2) -> p1.getTipo1().compareTo(p2.getTipo1()))
                            .forEach(p -> System.out.println(p.getNombre() + " - " + p.getTipo1()));
                        break;

                    case 5:
                        System.out.print("Ingrese la habilidad: ");
                        String habilidad = scanner.nextLine();
                        pokemonMap.values().stream()
                            .filter(p -> p.getHabilidades().contains(habilidad))
                            .forEach(p -> System.out.println(p.getNombre() + " - " + p.getHabilidades()));
                        break;

                    case 6:
                        System.out.println("Gracias por usar el programa");
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            } else {
                scanner.next();
                System.out.println("Entrada no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}
