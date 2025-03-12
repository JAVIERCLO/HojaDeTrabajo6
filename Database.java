import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Database {
    private Map<String, Pokemon> pokemonData;

    public Database(Map<String, Pokemon> pokemonData) {
        this.pokemonData = pokemonData;
    }

    public void leerData(String nombreArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            br.readLine();

            while ((linea = br.readLine()) != null) {
                // Expresión regular para dividir por comas que NO están dentro de comillas
                String[] datos = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if (datos.length < 10) {
                    System.err.println("Línea con datos insuficientes: " + linea);
                    continue;
                }

                try {
                    int numeroPokedex = Integer.parseInt(datos[1].trim());
                    float altura = Float.parseFloat(datos[5].trim());
                    float peso = Float.parseFloat(datos[6].trim());
                    int generacion = Integer.parseInt(datos[8].trim());
                    boolean statusLegendario = datos[9].trim().equalsIgnoreCase("Yes") || datos[9].trim().equalsIgnoreCase("True");

                    String habilidades = datos[7].trim().replace("\"", "");

                    Pokemon pokemon = new Pokemon(
                        datos[0].trim(), // Nombre
                        numeroPokedex,
                        datos[2].trim(), // Tipo 1
                        datos[3].isEmpty() ? null : datos[3].trim(), // Tipo 2
                        datos[4].trim(), // Clasificación
                        altura,
                        peso,
                        habilidades, // Habilidades
                        generacion,
                        statusLegendario
                    );

                    pokemonData.put(pokemon.getNombre(), pokemon);
                } catch (NumberFormatException e) {
                    System.err.println("Error al convertir datos en línea: " + linea);
                }
            }
        }
    }
}
