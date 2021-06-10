package algo.external.udemy;

import java.util.HashMap;
import java.util.Map;

public class CheckAnagram {

    public boolean isAnagram(String string1, String string2) {
        Map<Character, Integer> string1Map = createCharCountMap(string1);
        Map<Character, Integer> string2Map = createCharCountMap(string2);

        if(string1Map.size() != string2Map.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : string1Map.entrySet()) {

            if(!string2Map.containsKey(entry.getKey())) {
                return false;
            }

            if(!string2Map.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> createCharCountMap(String str) {
        String strLowerCase = str.toLowerCase();

        Map<Character, Integer> stringMap = new HashMap<>();
        for (int i = 0; i < strLowerCase.length(); i++) {
            var charAt = strLowerCase.charAt(i);

            if(charAt < 'a' || charAt > 'z') {
                continue;
            }

            var counter = 1;
            if(stringMap.containsKey(charAt)) {
                counter = stringMap.get(charAt);
                counter++;
            }
            stringMap.put(charAt, counter);
        }
        return stringMap;
    }
}
