public class x_SegmentTrees01 {
    static int tree[];
    public static void init(int n){
        tree = new int[4*n];
    }
    public static int buildST(int arr[], int sti, int start, int end){
        if(start == end){
            tree[sti] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2;
        buildST(arr, 2*sti+1, start, mid);
        buildST(arr, 2*sti+2, mid+1, end);
        tree[sti] = tree[2*sti+1] + tree[2*sti+2];
        return tree[sti];
    }
    //query O(logn)
    public static int getSumUtil(int sti, int si, int sj, int qi, int qj){
        if(qi >= sj || qj <= si){ //non overlapping 
            return 0;
        }
        else if(si >= qi && sj <= qj){ //complete overlapping
            return tree[sti];
        }
        else{ //partial overlapping
            int mid = (si+sj)/2;
            int left = getSumUtil(2*sti+1, si, mid, qi, qj);
            int right = getSumUtil(2*sti+2, mid+1, sj, qi, qj);
            return left + right;
        }
    }
    public static int getSum(int arr[], int qi, int qj){
        int n = arr.length;
        return getSumUtil(0, 0, n-1, qi, qj);
    }
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);  

        for(int i=0; i<tree.length; i++){
            System.out.print(tree[i] + " ");
        }
        System.out.println();
        
        System.out.println(getSum(arr, 2, 5));
    }
}