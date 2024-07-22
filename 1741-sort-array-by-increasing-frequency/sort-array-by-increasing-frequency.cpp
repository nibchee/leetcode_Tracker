#include <iostream>
#include <vector>
#include <queue>
#include <unordered_map>

using namespace std;

class Solution {
public:
    // Comparator function
    static bool comparator(const pair<int, int>& a, const pair<int, int>& b) {
        return (a.first == b.first) ? a.second < b.second : a.first > b.first;
    }
    
    vector<int> frequencySort(vector<int>& nums) {
        // Using a lambda function for the custom comparator in priority queue
        auto comp = [](const pair<int, int>& a, const pair<int, int>& b) {
            return comparator(a, b);
        };

        // min heap with custom comparator
        priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(comp)> minH(comp);
        unordered_map<int, int> mp;
        vector<int> ans;
        
        // Count frequency of each element
        for(int i = 0; i < nums.size(); i++) {
            mp[nums[i]]++;
        }
        
        // Push elements into the heap
        for(auto& i : mp) {
            minH.push({i.second, i.first});
        }
        
        // Pop elements from the heap and build the result
        while(!minH.empty()) {
            int freq = minH.top().first;
            int num = minH.top().second;
            for(int i = 0; i < freq; i++) {
                ans.push_back(num);
            }
            minH.pop();
        }
        
        return ans;
    }
};