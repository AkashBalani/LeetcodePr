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