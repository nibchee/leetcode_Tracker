bool comparator(const pair<int, int>& a, const pair<int, int>& b) {
    return (a.first == b.first) ? a.second < b.second : a.first > b.first;
}

class Solution {
public:
    

    vector<int> frequencySort(vector<int>& nums) {
        //kam freq ko upr rkhna hai to min heap bnayege
         priority_queue<pair<int, int>, vector<pair<int, int>>, bool(*)(const pair<int, int>&, const pair<int, int>&)> minH(comparator);
        unordered_map<int,int>mp;
     
        vector<int>ans;
        for(int i=0; i<nums.size(); i++){
            mp[nums[i]]++;
        }
        for(auto i:mp){
            minH.push({i.second,i.first});
        }
           
        while(minH.size()>0)
     {
            cout<<minH.top().second<<" ";
            for(int i=0;i<minH.top().first;i++)
          ans.push_back(minH.top().second);
        
        minH.pop();
     }

        return ans;
    }
};