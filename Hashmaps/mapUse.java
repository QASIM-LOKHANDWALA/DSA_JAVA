package Hashmaps;
import java.util.*;

public class mapUse {
    public static void main(String[] args) {

        // Majority of the functions are completed in O(n) complexity
        HashMap<String,Integer> map = new HashMap<>();
        // Adding key,value pair in map
        map.put("abc", 1);
        map.put("def", 2);

        System.out.println(map.containsKey("ghi")); // Returns true or false respectively
        System.out.println(map);                        // Prints whole map
        System.out.println(map.get("abc1"));        // Prints null if not found as Integer is an object not primitive type
        System.out.println(map.remove("def"));      // Returns deleted value
        System.out.println(map.containsValue(2)); // Operations on value will be slow
        System.out.println(map.size());                 // Returns size of hashmap

        // Iterate the map
        Set<String> keys = map.keySet();
        for (String string : keys) {
            System.out.println(string);                 // Prints all keys not necessarily in order of put
        }
    }
}
