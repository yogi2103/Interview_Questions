class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        vector<int> leftMax(arr.size()+1);
        vector<int> rightMin(arr.size()+1);
        rightMin[leftMax.size()-1]=INT_MAX;
        for(int i=arr.size()-1;i>=0;i--){
            rightMin[i]=min(rightMin[i+1],arr[i]);
        }
        
        int maxi=INT_MIN;
        int count=0;
        for(int i=0;i<arr.size();i++){
            maxi=max(arr[i],maxi);
            if(maxi<=rightMin[i+1]){
                count++;
            }
        }
        return count;
    }
};
