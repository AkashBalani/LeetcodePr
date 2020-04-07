import java.util.Map;
import java.util.HashMap;

// Accepted Solution
class Solution1 {
    public boolean isValidAnagram(String s, String t){
        if(t.length() < s.length()) return isValidAnagram(t, s);
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < t.length(); i++){
            int res = map.getOrDefault(t.charAt(i), 0);
            if(res < 1) return false;
            else map.put(t.charAt(i), map.get(s.charAt(i)) - 1);
        }

        return true;
    }
}