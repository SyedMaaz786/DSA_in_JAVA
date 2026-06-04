public class j {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            arr.add(data);
            int x = arr.size()-1;
            int y = (x-1) / 2;
            while(arr.get(x) < arr.get(y)){
                int temp = arr.get(x);
                arr.set(x, arr.get(y));
                arr.set(y, temp);

                x = y;
                y = (x-1) / 2;
            }
        }
        public void peek(){
            return arr.get(0);
        }
    }
    public static void mian(String args[]){

    }
}