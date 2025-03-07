import java.util.ArrayList;

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

    @Override
    public String toString() {
        
        return
        "Nombre: " + this.nombre
        + "Número en la Pokedex: " + this.numeroPokedex
        + "Tipo 1: " + this.tipo1
        + "Tipo 2: " + this.tipo2
        + "Clasificación: " + this.clasificacion
        + "Altura: " + this.altura
        + "Peso: " + this.peso
        + "Habilidades: " + this.habilidades
        + "Generación: " + this.generacion
        + "Status legendario: " + this.statusLegendario
        ;
    }
}