class Solution{
    public boolean isPermuationString(String s1, String s2){
        int ns1 = s1.length();
        int ns2 = s2.length();
        if(ns1 > ns2) return false;

        Map<Character, Integer> s1map = new HashMap();
        Map<Character, Integer> s2map = new HashMap();
        for(char ch : s1.toCharArray()){
            if(s1map.containsKey(ch))
                s1map.put(ch, s1map.get(ch) + 1);
            else
                s1map.put(ch, 1);
        }
        for(int i = 0; i < ns2; i++){
            char ch = s2.charAt(i);
            if(s2map.containsKey(ch))
                s2map.put(ch, s2map.get(ch) + 1);
            else
                s2map.put(ch, 1);
            if(i >= ns1){
                ch = s2.charAt(i - ns1);
                if(s2map.get(ch) == 1)
                    s2map.remove(ch);
                else
                    s2map.put(ch, s2map.get(ch) - 1);
            }
            if(s1map.equals(s2map))
                return true;
        }
        return false;
    }
}