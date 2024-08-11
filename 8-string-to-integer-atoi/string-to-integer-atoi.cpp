class Solution {
public:
    int myAtoi(string s) {
        int i = 0;
        int flag = 1;

        while (i < s.size() && s[i] == ' ') {
            i++;
        }

        if (i < s.size() && s[i] == '-') {
            flag = -1;
            i++;
        } else if (i < s.size() && s[i] == '+') {
            i++;
        }

        int n = 0;

        while (i < s.size() && isdigit(s[i])) {
            int digit = s[i] - '0';

            if (n > ((INT_MAX) / 10) ||
                (n == (INT_MAX / 10) && digit > 7)) {
                return flag == -1 ? INT_MIN : INT_MAX;
            }

            n = n * 10 + (s[i]-'0');
            i++;
        }

        return flag * n;
    }
};