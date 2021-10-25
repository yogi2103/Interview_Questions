vector<int> sortedSquares(vector<int>& nums) {
        vector<int>v(nums.size());
        int l=0;
        int r=nums.size()-1;
        int k=0;
        while(l<=r){
            if(abs(nums[l])<abs(nums[r])){
                v[nums.size()-k-1]=nums[r]*nums[r];
                r--;
            }
            else{
                v[nums.size()-k-1]=nums[l]*nums[l];
                l++;
            }
            k++;
        }
        return v;
    }
