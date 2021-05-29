package map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    private Map<String, String> testMap() {
        HashMap<String, String> newMap = new HashMap<>();
        ConcurrentHashMap<String, String> newConcurrentHashMap = new ConcurrentHashMap<>();
        newMap.put("1", "1");
        newConcurrentHashMap.put("1", "1");
        String cvaule = newConcurrentHashMap.get("1");
        String value = newMap.get("1");

        return newMap;
    }
}
