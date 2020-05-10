
// Accepted Solution
class Solution{
    public boolean isValidPalindrome(String s){
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch))
                sb.append(Character.toLowerCase(ch));
        }

        String s1 = sb.toString();
        String s2 = sb.reverse().toString();

        return s1.equals(s2);
    }
}

// Two Pointer Solution
class Solution1{
    public boolean isValidPalindrome(String s){
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            while(i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
}