class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int local_maxi=INT_MIN;
        int sum=0;
        for(int i=0;i<nums.size();i++){
            sum+=nums[i];
            local_maxi=max(sum,local_maxi);
            if(sum < 0){
                sum=0;
            }
        }
        return local_maxi;
    }
};
