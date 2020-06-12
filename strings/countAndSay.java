import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++){
            s = countIdx(s);
        }
        return s;
    }
    
    public String countIdx(String s){
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == c){
                count++;
            }
            else
            {
                System.out.println(count + " " + c);
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        System.out.println(count + " " + c + " outside ");
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}


class Solution1 {
  public String countAndSay(int n) {
    String currSeq = "1";

    // Pattern to match the repetitive digits
    String regexPattern = "(.)\\1*";
    Pattern pattern = Pattern.compile(regexPattern);

    for (int i = 1; i < n; ++i) {
      Matcher m = pattern.matcher(currSeq);
      StringBuffer nextSeq = new StringBuffer();

      // each group contains identical and adjacent digits
      while (m.find()) {
        nextSeq.append(m.group().length() + String.valueOf(m.group().charAt(0)));
      }
      // prepare for the next iteration
      currSeq = nextSeq.toString();
    }

    return currSeq;
  }
}