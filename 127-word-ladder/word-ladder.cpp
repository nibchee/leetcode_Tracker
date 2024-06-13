class Solution {
public:
      int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        // Check if the endWord is in the wordList
        set<string> wordSet(wordList.begin(), wordList.end());
        if (wordSet.find(endWord) == wordSet.end()) {
            return 0;
        }
        
        // Add the beginWord to the wordList set
        wordSet.insert(beginWord);
        
        // Create a graph
        unordered_map<string, vector<string>> graph;
        for (auto word : wordSet) {
            for (int i = 0; i < word.size(); i++) {
                string pattern = word;
                pattern[i] = '*';
                graph[pattern].push_back(word);
            }
        }
        
        // BFS initialization
        queue<pair<string, int>> q;
        q.push({beginWord, 1});
        set<string> visited;
        visited.insert(beginWord);
        
        // BFS loop
        while (!q.empty()) {
            string currentWord = q.front().first;
            int level = q.front().second;
            q.pop();
            
            for (int i = 0; i < currentWord.size(); i++) {
                string pattern = currentWord;
                pattern[i] = '*';
                for (auto neighbor : graph[pattern]) {
                    if (neighbor == endWord) {
                        return level + 1;
                    }
                    if (visited.find(neighbor) == visited.end()) {
                        visited.insert(neighbor);
                        q.push({neighbor, level + 1});
                    }
                }
            }
        }
        
        return 0;
    }
};