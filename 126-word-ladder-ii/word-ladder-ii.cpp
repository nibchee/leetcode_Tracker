#include <vector>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <queue>

using namespace std;

class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        vector<vector<string>> ans;
        unordered_set<string> dict(wordList.begin(), wordList.end());
        if (dict.find(endWord) == dict.end()) {
            return ans;
        }

        // Step 1: Use BFS to find the shortest path
        unordered_map<string, unordered_set<string>> parents;
        unordered_map<string, int> distance;
        queue<string> q;
        q.push(beginWord);
        distance[beginWord] = 0;
        int level = 0;
        bool found = false;

        while (!q.empty() && !found) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                string word = q.front();
                q.pop();
                string originalWord = word;

                for (int j = 0; j < word.size(); ++j) {
                    char originalChar = word[j];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (word[j] == c) continue;
                        word[j] = c;
                        if (word == endWord) {
                            parents[word].insert(originalWord);
                            found = true;
                        } else if (dict.find(word) != dict.end() && distance.find(word) == distance.end()) {
                            distance[word] = level;
                            parents[word].insert(originalWord);
                            q.push(word);
                        } else if (distance[word] == level) {
                            parents[word].insert(originalWord);
                        }
                    }
                    word[j] = originalChar;
                }
            }
        }

        // Step 2: Use DFS to find all paths from endWord to beginWord
        if (found) {
            vector<string> path;
            dfs(endWord, beginWord, parents, path, ans);
        }

        return ans;
    }

private:
    void dfs(const string& word, const string& beginWord, unordered_map<string, unordered_set<string>>& parents, vector<string>& path, vector<vector<string>>& ans) {
        path.push_back(word);
        if (word == beginWord) {
            ans.push_back(vector<string>(path.rbegin(), path.rend()));
        } else {
            for (const string& parent : parents[word]) {
                dfs(parent, beginWord, parents, path, ans);
            }
        }
        path.pop_back();
    }
};
