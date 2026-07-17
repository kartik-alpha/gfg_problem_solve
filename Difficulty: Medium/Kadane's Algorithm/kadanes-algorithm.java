class Solution {
    int maxSubarraySum(int[] arr) {
        int res = arr[0];
        int current = arr[0];
        
        for(int i = 1; i < arr.length;i++) {
            
            current = Math.max(arr[i] , current + arr[i]);
            
            res = Math.max(res , current);
        }
        
        return res;
    }
}
