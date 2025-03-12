import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class HDT6_Tests {
    
    @Test
    public void testLecturaArchivo() {
        Map<String, Pokemon> pokemonMap = new HashMap<>();
        Database lector = new Database(pokemonMap);
        try {
            lector.leerData("pokemon_data_pokeapi.csv");
            assertFalse(pokemonMap.isEmpty(), "El mapa de Pokémon no debería estar vacío.");
        } catch (Exception e) {
            fail("Error al leer el archivo: " + e.getMessage());
        }
    }

    @Test
    public void testAgregarPokemon() {
        Coleccion coleccion = new Coleccion();
        Pokemon pikachu = new Pokemon("Pikachu", 25, "Electric", null, "Ratón", 
                                      0.4f, 6.0f, "Static", 1, false);

        assertTrue(coleccion.agregarPokemon(pikachu), "Pikachu debería agregarse correctamente.");
        assertFalse(coleccion.agregarPokemon(pikachu), "No debería permitir agregar el mismo Pokémon dos veces.");
    }
}
