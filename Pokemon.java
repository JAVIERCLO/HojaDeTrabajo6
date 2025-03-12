import java.util.ArrayList;
import java.util.List;

public class Pokemon{
    //Atributos
    private String nombre;
    private int numeroPokedex;
    private String tipo1;
    private String tipo2;
    private String clasificacion;
    private float altura;
    private float peso;
    private ArrayList<String> habilidades = new ArrayList<>();
    private int generacion;
    private boolean statusLegendario;

public Pokemon(String nombre, int numeroPokedex, String tipo1, String tipo2, String clasificacion, 
               float altura, float peso, String habilidades, int generacion, boolean statusLegendario) {
    this.nombre = nombre;
    this.numeroPokedex = numeroPokedex;
    this.tipo1 = tipo1;
    this.tipo2 = tipo2;
    this.clasificacion = clasificacion;
    this.altura = altura;
    this.peso = peso;
    this.habilidades = new ArrayList<>(List.of(habilidades.split(";")));
    this.generacion = generacion;
    this.statusLegendario = statusLegendario;
}

    //nombre
    public String getNombre() {
        return nombre;
    }
    //numero de pokedex
    public int getNumeroPokedex() {
        return numeroPokedex;
    }
    //tipo 1
    public String getTipo1() {
        return tipo1;
    }
    //tipo2
    public String getTipo2() {
        return tipo2;
    }
    //Clasificacion
    public String getClasificacion() {
        return clasificacion;
    }
    //Altura
    public float getAltura() {
        return altura;
    }
    //Peso
    public float getPeso() {
        return peso;
    }
    //Habilidades
    public ArrayList<String> getHabilidades() {
        return habilidades;
    }
    //Generacion
    public int getGeneracion() {
        return generacion;
    }
    //Status legendario
    public boolean isStatusLegendario() {
        return statusLegendario;
    }

}