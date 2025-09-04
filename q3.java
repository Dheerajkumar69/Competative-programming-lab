// 3. Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses. 
  
// Example 1: 
// Input: n = 3 
// Output: ["((()))","(()())","(())()","()(())","()()()"] 
// Example 2: 
// Input: n = 1 
// Output: ["()"] 
  
// Constraints: 
// 1 <= n <= 8
import java.util.*;

public class q3 {
    public List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        q3 solution = new q3();
        System.out.println(solution.generateParentheses(3)); 
        System.out.println(solution.generateParentheses(1)); 
    }
}
