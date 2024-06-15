#include <vector>
#include <string>
#include <unordered_set>
#include <queue>

using namespace std;

class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        unordered_set<string> visited;
        queue<string> q;
        vector<string> result;

        q.push(s);
        visited.insert(s);
        bool found = false;

        while (!q.empty()) {
            string curr = q.front();
            q.pop();

            if (isValid(curr)) {
                result.push_back(curr);
                found = true;
            }

            if (found) continue; // If found valid at the current level, skip further levels

            for (int i = 0; i < curr.size(); ++i) {
                if (isalpha(curr[i])) continue;

                string next = curr.substr(0, i) + curr.substr(i + 1);
                if (visited.find(next) == visited.end()) {
                    q.push(next);
                    visited.insert(next);
                }
            }
        }

        return result.empty() ? vector<string>{""} : result;
    }

private:
    bool isValid(const string &s) {
        int balance = 0;
        for (char ch : s) {
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                if (balance == 0) return false;
                balance--;
            }
        }
        return balance == 0;
    }
};
