class Solution {
    
    static int merge (int arr[] , int s , int e , int mid) {
        
        // leftArray and rightarray
        
        int n1 = mid - s + 1;
        int n2 = e - mid;
        
        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];
        
        int k = s;
        for(int i = 0;i<n1;i++){
            leftArr[i] = arr[k];
            k++;
        }
        
        k = mid + 1;
        for(int j = 0;j<n2;j++){
            rightArr[j] = arr[k];
            k++;
        }
        
        int i = 0;
        int j = 0;
        k = s;
        
        int invCount = 0;
        
        while(i<n1 && j < n2){
            if(leftArr[i] <= rightArr[j]){
                arr[k]  = leftArr[i];
                k++;
                i++;
            }
            else{
                
                arr[k] = rightArr[j];
                k++;
                j++;
                
                invCount = invCount + (n1 - i);
            }
            
            
        }
        
        //remaining arr left or right ko copy krna hai 
        
        while(i<n1){
            arr[k] = leftArr[i];
            k++;
            i++;
        }
        
        while(j<n2){
            arr[k] = rightArr[j];
            k++;
            j++;
        }
        
        return invCount;
 
    }
    
    
    public int mergeSort(int arr[] , int s , int e) {
        
        if(s>=e) {
            return 0;
        }
        
     
        
        int mid = (s + e)/2;
        
        
        int leftInversion = mergeSort(arr,s,mid);
        int rightInversion = mergeSort(arr,mid+1,e);
        int intermid = merge(arr, s , e ,mid);
        int invCount = leftInversion + rightInversion + intermid;
        
        return invCount;
    }
        
    public int inversionCount(int arr[]) {
        
        int s = 0;
        int e = arr.length - 1;
        
        int ans = mergeSort(arr,s,e);
        return ans;

    }
}