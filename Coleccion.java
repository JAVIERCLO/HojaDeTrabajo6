import java.util.*;

public class Coleccion {
    private Set<Pokemon> coleccionUsuario;

    public Coleccion() {
        this.coleccionUsuario = new HashSet<>();
    }

    public boolean agregarPokemon(Pokemon pokemon) {
        if (coleccionUsuario.contains(pokemon)) {
            System.out.println("¡Este Pokémon ya está en tu colección!");
            return false;
        }
        coleccionUsuario.add(pokemon);
        return true;
    }

    public void mostrarColeccion() {
        for (Pokemon p : coleccionUsuario) {
            System.out.println(p.getNombre() + " - Tipo: " + p.getTipo1());
        }
    }

    public boolean contienePokemon(String nombre) {
        return coleccionUsuario.stream().anyMatch(p -> p.getNombre().equalsIgnoreCase(nombre));
    }
}
