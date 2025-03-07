import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HDT6_Tests {
    
        @Test
    public void testLecturaArchivo() {
        Database lector = new Database();
        try {
            
            assertNotNull("El archivo no debería ser nulo");
            assertFalse("El archivo no debería estar vacío",  .isEmpty());

        } catch (IOException e) {
            fail("No debería lanzarse una excepción al leer el archivo.");
        }
    }
}
