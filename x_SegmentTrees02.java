public class x_SegmentTrees02 {
    static int tree[];
    public static void init(int n){
        tree = new int[4*n];
    }
    public static int buildST(int arr[], int sti, int si, int sj){
        if(si == sj){
            tree[sti] = arr[si];
            return tree[sti];
        }
        int mid = (si+sj)/2;
        buildST(arr, 2*sti+1, si, mid);
        buildST(arr, 2*sti+2, mid+1, sj);
        tree[sti] = Math.max(tree[2*sti+1], tree[2*sti+2]); // logic for max 
        return tree[sti];
    }
    //query
    public static int getMaxUtil(int sti, int si, int sj, int qi, int qj){
        if(sj < qi || si > qj){ //non overlap
            return Integer.MIN_VALUE;
        }
        else if(si >= qi && sj <= qj){
            return tree[sti];
        }
        else{
            int mid = (si+sj)/2;
            int left = getMaxUtil(2*sti+1, si, mid, qi, qj);
            int right = getMaxUtil(2*sti+2, mid+1, sj, qi, qj);
            return Math.max(left, right);
        }
    }
    public static int getMax(int arr[], int qi, int qj){
        int n = arr.length;
        return getMaxUtil(0, 0, n-1, qi, qj);
    }
    //update
    public static void updateUtil(int sti, int si, int sj, int ui, int newVal){
        if(ui < si || ui > sj){ //non overlapping
            return;
        }
        tree[sti] = Math.max(tree[sti], newVal); //complete overlapping
        if(si != sj){
            int mid = (si+sj)/2; //partial overlapping
            updateUtil(2*sti+1, si, mid, ui, newVal);
            updateUtil(2*sti+2, mid+1, sj, ui, newVal);
        }
    }
    public static void update(int arr[], int idx, int newVal){
        int n = arr.length;
        arr[idx] = newVal;
        updateUtil(0, 0, n-1, idx, newVal);
    }
    public static void main(String args[]){
        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);

        for(int i=0; i<tree.length; i++){
            System.out.print(tree[i] + " ");
        }
        System.out.println();

        System.out.println(getMax(arr, 0, 8));
        update(arr, 2, 20);
        System.out.println(getMax(arr, 0, 8));
    }
}
