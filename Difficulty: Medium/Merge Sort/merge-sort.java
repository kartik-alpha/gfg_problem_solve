class Solution {
    static void merge(int arr[] , int s , int e , int mid) {
        
        int n1 = mid - s + 1;
        int n2 = e - mid;
        
        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];
    
        int k = s;
        
        for(int i = 0;i<n1;i++) {
            leftArr[i] = arr[k];
            k++;
        }
        
        k = mid + 1;
        for(int j = 0; j<n2;j++) {
            rightArr[j] = arr[k];
            k++;
        }
        
        int i = 0;
        int j = 0;
        k = s;
        
        while(i < n1 && j < n2){
            if(leftArr[i] < rightArr[j]) {
               arr[k] = leftArr[i];
                k++;
                i++;
            }
            
            else {
              arr[k] = rightArr[j];
                k++;
                j++;
            }
        }
        
        //remaining element store 
        
        while(i<n1){
             arr[k] = leftArr[i];
                i++;
                k++;
            
        }
        
        while(j<n2){
          arr[k] = rightArr[j];
                k++;
                j++;
            
        }
        
    }
    public void mergeSort(int arr[], int l, int r) {
        
        
        int s = l;
        int e = r;
        
        if(s >= e ) {
            return;
        }
        
        int mid = (s+e)/2;
        
        mergeSort(arr , s , mid);
        mergeSort(arr , mid + 1 , e);
        
        merge(arr , s , e , mid);
        
    }
}