import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class Factory {
    //completar y averiguar qué tipo de datos usar para la clave y el valor
    public Map createMap(String nombre){

        switch(nombre){
            
            case "hashmap":
            HashMap<String, Integer> hm = new HashMap<>();

            case "treemap":
            TreeMap<String, Integer> tm = new TreeMap<>();

            case "linkedhashmap":
            LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        }
                return null;

    }
}
