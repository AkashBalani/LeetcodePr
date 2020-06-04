class Solution{
    public int strStr(String haystack, String needle){
        int L = needle.length(), N = haystack.length();
        for(int start = 0; start < N - L + 1; start++){
            if(haystack.substring(start, start + L).equals(needle))
                return start;
        }
        return -1;
    }
}

class Solution1{
    public int strStr(String haystack, String needle){
        int L = needle.length(), N = haystack.length();
        int pN = 0;
        while(pN < N - L + 1){
            while(pN < N - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pN;

            int currLen = 0, pL = 0;
            while(pL < L && pN < N && haystack.charAt(pN) == needle.charAt(pL)){
                ++pN;
                ++pL;
                ++currLen;
            }
            if(currLen == L) return pN - L;

            pN = pN - currLen + 1;
        }
        return -1;
    }
}

class Solution2 {
    // function to convert character to integer
    public int charToInt(int idx, String s) {
      return (int)s.charAt(idx) - (int)'a';
    }
  
    public int strStr(String haystack, String needle) {
      int L = needle.length(), n = haystack.length();
      if (L > n) return -1;
  
      // base value for the rolling hash function
      int a = 26;
      // modulus value for the rolling hash function to avoid overflow
      long modulus = (long)Math.pow(2, 31);
  
      // compute the hash of strings haystack[:L], needle[:L]
      long h = 0, ref_h = 0;
      for (int i = 0; i < L; ++i) {
        h = (h * a + charToInt(i, haystack)) % modulus;
        ref_h = (ref_h * a + charToInt(i, needle)) % modulus;
      }
      if (h == ref_h) return 0;
  
      // const value to be used often : a**L % modulus
      long aL = 1;
      for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;
  
      for (int start = 1; start < n - L + 1; ++start) {
        // compute rolling hash in O(1) time
        h = (h * a - charToInt(start - 1, haystack) * aL
                + charToInt(start + L - 1, haystack)) % modulus;
        if (h == ref_h) return start;
      }
      return -1;
    }
  }