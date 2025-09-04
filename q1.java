// 1. Given a string s, return the longest palindromic substring in s.
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        
        int start = 0, maxLength = 1;
        
        for (int i = 0; i < s.length(); i++) {
            
            int len1 = expandAroundCenter(s, i, i);
          
            int len2 = expandAroundCenter(s, i, i + 1);
            
            int len = Math.max(len1, len2);
            if (len > maxLength) {
                start = i - (len - 1) / 2;
                maxLength = len;
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
public  class q1{
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "babad";
        System.out.println("Longest Palindromic Substring of " + s + " is: " + sol.longestPalindrome(s));
    }
}
// Example 1: 
// Input: s = "babad" 
// Output: "bab" 
// Explanation: "aba" is also a valid answer. 
// Example 2: 
// Input: s = "cbbd" 
// Output: "bb"  
// Constraints: 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters.