// Initial Attempt 
// Passed a few test cases

class Solution {
    public int firstUniqChar(String s) {
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length-1; i++){
            for(int j = i; j < ch.length-1; j++){
                if(ch[i] == ch[j]){
                    return i;
                }
            }
        }
        return -1;
    }
}

// Accepted Solution

class Solution {
	public int firstUniqChar(String s) {
		HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		int n = s.length();
		for(int i = 0; i < n; i++){
			char c = s.charAt(i);
			count.put(c, count.getOrDefault(c, 0) + 1);
		}

		for(int i = 0; i < n; i++){
			if(count.get(s.charAt(i)) == 1)
				return i;
		}
		return -1;
	}
}
