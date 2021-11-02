class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> res(nums.size());
        res[0]=1;
        //finding the product of the left
        for(int i=1;i<nums.size();i++){
            res[i]=nums[i-1]*res[i-1];
        }
        
        //finding the product of right
        int right=1;
        for(int i=nums.size()-1;i>=0;i--){
            res[i]*=right;
            right*=nums[i];
        }
        return res;
    }
};
