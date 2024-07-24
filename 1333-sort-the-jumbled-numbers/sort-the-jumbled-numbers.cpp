class Solution {
public:
    int solve(int n,vector<int>&mapping){
        string number;
        if(n==0){
            return mapping[0];
        }
        while(n  != 0){
            int r=n%10;
            int a=mapping[r];
            number.push_back(a+'0');
            n=n/10;
        }
        reverse(number.begin(),number.end());
        long long int num=0;
        for(int i=0;i<number.size();i++){
            num=10*num+(number[i]-'0');
        }
        cout<<num<<endl;
   //   long  long int num=stoi(number);
        return  num;
    }
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums) {
        unordered_map<int,vector<int>>m;
        for(int i=0;i<nums.size();i++){
            int num=solve(nums[i],mapping);
            m[num].push_back(nums[i]);
            nums[i]=num;
        }
        sort(nums.begin(),nums.end());
        for(int i=0;i<nums.size();){
            int size=m[nums[i]].size();
            int j=0;
            while(size--){
                nums[i++]=m[nums[i]][j++];
            }
        }
        return nums;
    }
};