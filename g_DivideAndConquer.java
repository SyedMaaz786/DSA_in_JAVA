public class g_DivideAndConquer {
    // //Merge Sort
    // public static void mergeSort(int arr[], int si, int ei) {
    //     //Base case
    //     if (si >= ei) {
    //         return;
    //     }
    //     //implementation
    //     int mid = si + (ei - si)/2;  //getting the mid value idx
    //     mergeSort(arr, si, mid);   //left side calling
    //     mergeSort(arr, mid+1, ei);  //right side calling
        
    //     merge(arr, si, mid, ei);
    // }
    // public static void merge(int arr[], int si, int mid, int ei) {
    //     int temp[] = new int [ei-si+1]; //ex si = (0,3) ei = (4,6) -> 6-0+1=7 this creates a arr of length 7
    //     int i = si;  //iterator for left part
    //     int j = mid+1;  //iterator for right part
    //     int k = 0;  //iterator for temp[]

    //     while (i <= mid && j <= ei) {
    //         if (arr[i] < arr[j]) {
    //             temp[k] = arr[i];
    //             i++;
    //         }
    //         else {
    //             temp[k] = arr[j];
    //             j++;
    //         }
    //         k++;
    //     }
    //     //for the left over elements on the left part 
    //     while (i <= mid) {
    //         temp[k] = arr[i];
    //         i++;
    //         k++;
    //     }
    //     //for the left over elements on thr right part
    //     while (j <= ei) {
    //         temp[k] = arr[j];
    //         j++;
    //         k++;
    //     }
    //     //copy the temp[] in the og arr[]
    //     for (k=0, i=si; k<temp.length; k++, i++) {
    //         arr[i] = temp[k];  //copy in arr[i] from temp[k]
    // }
    // }
    // public static void printArr( int arr[]) {
    //     for (int i=0; i<=arr.length-1; i++) {
    //         System.out.print(arr[i] + " ");
    //     }
    //     System.out.println();
    // }

    
    //Quick Sort 
    public static void quickSort (int arr[], int si, int ei) {
        //Base case
        if (si >= ei) {
            return;
        }
        //Last element
        int pIdx = partition(arr, si, ei);  //pivot index
        quickSort(arr, si, pIdx-1);  //left  pIdx-1 is the ending index for left
        quickSort(arr, pIdx+1, ei);  //right pIdx+1 is the starting index for right

    }
    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si-1; //iterator to make place for elements smaller than pivot

        for (int j=si; j<ei; j++) {
            if (arr[j] <= pivot) {
                i++; 
                //swap
                int temp = arr[j];
                arr[i] = arr[j];
                arr[j] = temp; 
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
    public static void main(String args[]) {
        int arr[] = {6,5,4,3,2,1};
        // mergeSort(arr, 0, arr.length-1);
        // printArr(arr);
        quickSort(arr, 0, arr.length-1);
        printArr(arr);

    }
}
