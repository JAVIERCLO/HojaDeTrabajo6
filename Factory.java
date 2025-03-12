import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class Factory {
    public static Map<String, Pokemon> createMap(int opcion){

        switch(opcion){
            
            case 1:
            return new HashMap<>();

            case 2:
            return new TreeMap<>();

            case 3:
            return new LinkedHashMap<>();
            
            default:
            throw new IllegalArgumentException("Ingresa una opcion valida");

        }
    }
}
