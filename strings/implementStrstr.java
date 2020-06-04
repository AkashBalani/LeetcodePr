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

class Solution{
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