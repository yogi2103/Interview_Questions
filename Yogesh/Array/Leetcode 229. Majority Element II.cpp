class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int ele1=-999;
        int ele2=-999;
        int count1=0;
        int count2=0;
        vector<int>v;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==ele1){
                count1++;
            }
            else if(nums[i]==ele2){
                count2++;
            }
            else if(count1==0){
                ele1=nums[i];
                count1=1;
            }
            else if(count2==0){
                ele2=nums[i];
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        int size1=0;
        int size2=0;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==ele1 && ele1!=-999){
                size1++;
            }
            if(nums[i]==ele2 && ele2!=-999){
                size2++;
            }
        }
        int n=nums.size();
        if(size1>n/3){
            v.push_back(ele1);
        }
        if(size2>n/3){
            v.push_back(ele2);
        }
        return v;
    }
};
