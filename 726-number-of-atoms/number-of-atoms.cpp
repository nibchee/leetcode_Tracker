class Solution {
public:
    string countOfAtoms(string formula) {
           stack<map<string, int>> stack;
        stack.push(map<string, int>());
        int n = formula.length();
        int i = 0;

        while (i < n) {
            char c = formula[i];
            if (c == '(') {
                stack.push(map<string, int>());
                i++;
            } else if (c == ')') {
                map<string, int> top = stack.top();
                stack.pop();
                i++;
                //Creating countString after closing racket
                string countStr;
                while (i < n && formula[i]>='0' && formula[i]<='9') {
                    countStr += formula[i];
                    i++;
                }
                int count = countStr.empty() ? 1 : stoi(countStr);
                map<string, int>& current = stack.top();
                for (auto& pair : top) {
                    current[pair.first] += pair.second * count;
                }
            } else {
                int stringbeg = i;
                i++;
                while (i < n && formula[i]>='a' && formula[i]<='z') {
                    i++;
                }
                string atom = formula.substr(stringbeg, i - stringbeg);
                string countStr;
                while (i < n && formula[i]>='0' && formula[i]<='9') {
                    countStr += formula[i];
                    i++;
                }
                int count = countStr.empty() ? 1 : stoi(countStr);
                map<string, int>& current = stack.top();
                current[atom] += count;
            }
        }

        map<string, int> finalAns = stack.top();
        stack.pop();
        string  ans;;
        for (auto& pair : finalAns) {
            ans+=pair.first;
            if (pair.second > 1) {
                ans+= to_string(pair.second);
            }
        }
        return ans;
    }
};