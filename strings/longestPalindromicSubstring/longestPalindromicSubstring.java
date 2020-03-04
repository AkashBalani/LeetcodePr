// Accepted Solution
// Works around the ides that we are expanding from every element

class Solution {
    public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        System.out.println("Len1 : " + len1 + " Len2 : " + len2);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
            // System.out.println("Start : " + start);
            // System.out.println("End : " + end);
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
        // System.out.println("L : " + L);
        // System.out.println("R : " + R);
    }
    return R - L - 1;
}
}
