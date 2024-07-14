class Solution {
public:
    bool isDigit(char a) {
        return a >= '0' && a <= '9';
    }

    bool isLetter(char a) {
        return (a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z');
    }

    string countOfAtoms(string formula) {
        map<string, int> atomCount;
        stack<pair<string, int>> st;
        int n = formula.size();
        int i = 0;

        while (i < n) {
            if (formula[i] == '(') {
                st.push({"(", 0});
                i++;
            } else if (formula[i] == ')') {
                i++;
                int count = 0;
                while (i < n && isDigit(formula[i])) {
                    count = count * 10 + (formula[i] - '0');
                    i++;
                }
                count = (count == 0) ? 1 : count;
                stack<pair<string, int>> tempStack;
                while (!st.empty() && st.top().first != "(") {
                    auto top = st.top();
                    st.pop();
                    top.second *= count;
                    tempStack.push(top);
                }
                st.pop();  // remove '('
                while (!tempStack.empty()) {
                    st.push(tempStack.top());
                    tempStack.pop();
                }
            } else {
                string atom;
                atom += formula[i++];
                if (i < n && formula[i] >= 'a' && formula[i] <= 'z') {
                    atom += formula[i++];
                }
                int count = 0;
                while (i < n && isDigit(formula[i])) {
                    count = count * 10 + (formula[i] - '0');
                    i++;
                }
                count = (count == 0) ? 1 : count;
                st.push({atom, count});
            }
        }

        while (!st.empty()) {
            auto top = st.top();
            st.pop();
            atomCount[top.first] += top.second;
        }

        string result;
        for (const auto &pair : atomCount) {
            result += pair.first;
            if (pair.second > 1) {
                result += to_string(pair.second);
            }
        }

        return result;
    }
};