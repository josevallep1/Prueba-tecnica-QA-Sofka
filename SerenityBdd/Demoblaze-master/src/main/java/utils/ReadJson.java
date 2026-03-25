package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;

public class ReadJson {
    public static Map<String, String> getTestData(String escenario) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Map<String, String>> data = mapper.readValue(
                    new File("src/test/resources/data/datosCompra.json"), Map.class);
            return data.get(escenario);
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el JSON de datos");
        }
    }

    //Metodo para obtener un valor específico del JSON sin importar si tiene una estructura de escenarios o no
    public static String getRootValue(String key) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> data = mapper.readValue(
                    new File("src/test/resources/data/datosCompra.json"), Map.class);
            return data.get(key);
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el JSON de datos");
        }
    }
}