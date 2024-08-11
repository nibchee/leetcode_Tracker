class Solution {
public:
    int myAtoi(string s) {
        int i = 0;
        int flag = 0;
        while (s[i] == ' ') {
            i++;
        }
        if (s[i] == '-') {
            flag = -1;
            i++;
        } else if (s[i] == '+') {
            flag = 1;
            i++;
        }
        int n = 0;
        for (int j = i; j < s.size(); j++) {
            if (isdigit(s[j])) {
                int digit = s[j] - '0';
                if (n > ((INT_MAX - digit) / 10) ||
                    (n == (INT_MAX / 10) && digit > 7)) {
                    return flag == -1 ? INT_MIN : INT_MAX;
                }
                n = n * 10 + digit;

            } else {
                break;
            }
        }
        return flag == -1 ? flag * n : n;
    }
};