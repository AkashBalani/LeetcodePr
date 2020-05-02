import java.util.HashMap;
import java.util.Map;

class Solution{
    public int jewelsAndStones(String J, String S){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < J.length(); i++){
            map.put(J.charAt(i), map.getOrDefault(J.charAt(i), 0) + 1);
        }
        int jewels = 0;
        for(int i = 0; i < S.length(); i++){
            if(map.containsKey(S.charAt(i)))
                jewels += 1;
        }
        return jewels;
    }
}