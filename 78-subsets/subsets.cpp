class Solution {
public:
    vector<vector<int>>subs;
    void findSubset(int i,int n,vector<int>&nums,vector<int>&sub){
        if(i>=n){
            subs.push_back(sub);
            return;
        }
       
        
        findSubset(i+1,n,nums,sub);
        sub.push_back(nums[i]);
        findSubset(i+1,n,nums,sub);
        sub.pop_back();
    }
    
    vector<vector<int>> subsets(vector<int>& nums) {
       vector<int>sub;
       int n=nums.size();
      findSubset(0,n,nums,sub) ;
      return subs;
    }
};