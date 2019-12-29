// Initial Attempt
// Accepted Answer
// Time Complexity --> O(n)
// This one uses two pointer approach

class Solution {
    public void reverseString(char[] s) {
        for(int i = 0, j = s.length-1; i < j; i++, j--){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}

// Second commit
// Accepted Answer
// Uses one pointer

public class Solution {
    public String reverseString(String s) {
        char[] a=s.toCharArray();
        int n=s.length();
        for(int i=0;i<(n/2);i++){
            char temp=a[i];
            a[i]=a[n-i-1];
            a[n-i-1]=temp;
        }
        s=new String(a);
        return s;
    }
}