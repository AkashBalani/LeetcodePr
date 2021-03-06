import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution{
    public String countFrequency(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        StringBuilder sb = new StringBuilder();

        for(char c : list){
            int count = map.get(c);
            for(int i = 0; i < count; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

class Solution1{
    public String countFrequency(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(chars[i]);
        for(int i = 1; i < chars.length; i++){
            if(chars[i] != chars[i - 1]){
                list.add(sb.toString());
                sb = new StringBuilder();
            }
            sb.append(chars[i]);
        }

        Collections.sort(list, (a, b) -> b.length() - a.length());

        StringBuilder result = new StringBuilder();
        for(String str : list)result.append(str);
        return result.toString();
    }
}

class Solution2{
    public String frequencyString(String s){
        if(s == null || s.isEmpty()) return s;

        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int maxF = Collections.max(map.values());

        List<List<Character>> buckets = new ArrayList<>();
        for(int i = 0; i <= maxF; i++){
            buckets.add(new ArrayList<Character>());
        }

        for(Character key : map.keySet()){
            int freq = map.get(key);
            buckets.get(freq).add(key);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = buckets.size() - 1; i >= 0; i--){
            for(Chracter c : buckets.get(i)){
                for(int j = 0; j < i; j++){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}