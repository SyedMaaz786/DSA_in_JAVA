public class g_DivideAndConquer {
    //Merge Sort
    //1st
    public static void mergeSort(int arr[], int si, int ei) {
        //Base case
        if (si >= ei) {
            return;
        }
        //implementation
        int mid = si + (ei - si)/2;  //getting the mid value idx
        mergeSort(arr, si, mid);   //left side calling
        mergeSort(arr, mid+1, ei);  //right side calling
        
        helper(arr, si, mid, ei); //sorting logic is in this fnx
    }
    //2nd
    public static void helper(int arr[], int si, int mid, int ei) {
        int temp[] = new int [ei-si+1]; //ex si = (0,3) ei = (4,6) -> 6-0+1=7 this creates a arr of length 7
        int i = si;  //iterator for left part
        int j = mid+1;  //iterator for right part
        int k = 0;  //iterator for temp[]

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            }
            else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        //for the left over elements on the left part 
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        //for the left over elements on thr right part
        while (j <= ei) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        //copy the temp[] in the og arr[]
        for (k=0, i=si; k<temp.length; k++, i++) {
            arr[i] = temp[k];  //copy in arr[i] from temp[k]
    }
    }
    //3rd
    public static void printArr( int arr[]) {
        for (int i=0; i<=arr.length-1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    
    //Quick Sort 
    //1st
    public static void quickSort (int arr[], int si, int ei) {
        //Base case
        //4th
        if (si >= ei) {
            return;
        }
        //Last element
        //3rd
        int pIdx = helper(arr, si, ei);  //pivot index
        quickSort(arr, si, pIdx-1);  //left  pIdx-1 is the ending index for left
        quickSort(arr, pIdx+1, ei);  //right pIdx+1 is the starting index for right

    }
    //2nd
    public static int helper(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si-1; //iterator to make place for elements smaller than pivot

        for (int j=si; j<ei; j++) {
            if (arr[j] <= pivot) {
                i++; 
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp; 
            }
        }
        //swap
        i++;  //used to increment i=-1 to next i = 0, 1, 2 and so on
        int temp = pivot;  //here pivot is ei element check above
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;  //i = pIdx.
    }
    public static void printArr( int arr[]) {
    for (int i=0; i<=arr.length-1; i++) {
        System.out.print(arr[i] + " ");
    }
        System.out.println();
    }


    //Search in rotated sorted arr
    public static int search(int arr[], int target, int si, int ei) {
        //Base case (Check GPT for this base case if dought explains clearly)
        if (si > ei) {
            return -1;
        }
        //finding mid 
        int mid = si + (ei - si) / 2;
        //case FOUND
        if (arr[mid] == target) {
            return mid;
        }
        //mid on L1
        if (arr[si] <= arr[mid]) {
            //case : a (left side of L1)
            if (arr[si] <= target && target <= arr[mid]) {
                return search(arr, target, si, mid-1);
            }
            //case : b (right side of L1)
            else {
                return search(arr, target, mid+1, ei);
            }
        }
        //mid on L2
        else {
            //case : c (right side of L2)
            if (arr[mid] <=target && target <= arr[ei]) {
                return search(arr, target, mid+1, ei);
            }
            //case : d (left side of L2)
            else {
                return search(arr, target, si, mid-1);
            }
        }
        
    }


    //majority element
    public static int majorityEls(int nums[]){
        int n = nums.length;
        int freq = 0;
        int ans = 0;
        for(int i=0; i<n; i++){
            if(freq == 0){
                ans = nums[i];
            }
            if(ans == nums[i]){
                freq++;
            }
            else{
                freq--;
            }
        }
        return ans;
    }
    //Imp - check leetcode hard problem using merge sort(Q.493)
    public static void main(String args[]) {
        // int arr[] = {6,5,4,3,2,1};
        // mergeSort(arr, 0, arr.length-1);
        // printArr(arr);
        // quickSort(arr, 0, arr.length-1);
        // printArr(arr);
        // int arr[] = {4,5,6,7,0,1,2};
        // int target = 0;
        // int tarIdx = search(arr, target, 0, arr.length-1);
        // System.out.println(tarIdx);
        int nums[] = {2,2,1,1,1,2,2,1,1};
        System.out.println(majorityEls(nums));

    }
}
