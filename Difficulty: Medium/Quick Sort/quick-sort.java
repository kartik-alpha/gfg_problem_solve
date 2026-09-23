class Solution {
    public void quickSort(int[] arr, int low, int high) {
        
        int s = low;
        int e = high;
        
        if(s>=e) {
            return;
        } 
        
        int pivotIndex = partition(arr,s,e);
        
        quickSort(arr,s , pivotIndex - 1);
        
        quickSort(arr,pivotIndex + 1 , e);
        
    }

    private int partition(int[] arr, int low, int high) {
        // code here
        
        int s = low;
        int e = high;
        
        int pivot = arr[s];
        
        int count = 0;
        
        for(int i = s+1;i<=e;i++) {
            if(arr[i] <= pivot){
                count++;
            }
        }
        int correctPosition = s + count;
        
        int temp = arr[correctPosition];
        arr[correctPosition] = arr[s];
        arr[s] = temp;
        
        
        int i = s;
        int j = e;
        
        
        while(i<correctPosition && j>correctPosition) {
            
            while(arr[i]  <= pivot) {
            i++;
            }
            
            while(arr[j] > pivot) {
                j--;
            }
        
        
        if(i<correctPosition && j>correctPosition) {
            int tempval = arr[i];
            arr[i]  = arr[j];
            arr[j] = tempval;
            i++;
            j--;
            
        }
        
        }
        
    
    
    return correctPosition;
}
}