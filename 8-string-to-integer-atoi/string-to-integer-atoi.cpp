class Solution {
public:
    int myAtoi(string s) {
        int i = 0;
        int flag = 1;  // Initialize flag to 1 for positive numbers
        
        // Skip leading whitespace
        while (i < s.size() && s[i] == ' ') {
            i++;
        }
        
        // Check for sign
        if (i < s.size() && s[i] == '-') {
            flag = -1;
            i++;
        } else if (i < s.size() && s[i] == '+') {
            i++;
        }
        
        int n = 0;
        
        // Convert digits to number
        while (i < s.size() && isdigit(s[i])) {
            int digit = s[i] - '0';
            
            // Check for overflow before multiplying and adding
            if (n > (INT_MAX - digit) / 10) {
                return flag == -1 ? INT_MIN : INT_MAX;
            }
            
            n = n * 10 + digit;
            i++;
        }
        
        return flag * n;
    }
};
