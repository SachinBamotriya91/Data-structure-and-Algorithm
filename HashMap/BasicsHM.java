import java.util.HashMap;
import java.util.Set;

public class BasicsHM {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        // all operation are done in O(1);

        // put() will put data into HashMap as pair of key and value if data is not
        // present into hashmap otherwise it will update it
        // put function doen't maintain insetion order
        hm.put("india", 135);
        hm.put("china", 150);
        hm.put("Pak", 50);
        hm.put("USA", 30);
        hm.put("UK", 25);
        System.out.println(hm);
        hm.put("Korea", 15);
        hm.put("china", 160);

        System.out.println(hm);

        // get function take key as argument and return the value of key if its present
        // otherwise return null;
        System.out.println(hm.get("india"));
        System.out.println(hm.get("nepal"));

        // containsKey return true if key is present otherise returns false;
        System.out.println(hm.containsKey("india"));
        System.out.println(hm.containsKey("nepal"));
        // keySet returns the set of all keys which can be used to iterate hashmap
        Set<String> keyset = hm.keySet();
        System.out.println(keyset);
        for (String key : hm.keySet()) {
            System.out.println(key);
        }
    }
}
