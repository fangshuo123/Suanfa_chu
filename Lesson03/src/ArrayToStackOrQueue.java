public class ArrayToStackOrQueue {

    public static class ArrayStack{
        private Integer[] arr;
        private Integer index;

        public ArrayStack(int initSize){
            if(initSize<0){
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            index = 0;
        }
        public Integer peek(){
            if(index==0){
                return null;
            }
            return arr[index-1];
        }
        public void push(int obj){
            if(index == arr.length){
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            arr[index++] = obj;
        }
        public Integer pop(){
            if(index == 0){
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            return arr[--index];
        }
    }
    public static class ArrayQueue{
        private Integer[] arr;
        private Integer size;
        private Integer first;
        private Integer last;

        public ArrayQueue(int initSize){
            if(initSize==0){
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            first = 0;
            last = 0;
        }

        public Integer peek(){
            if(size==0){
                return null;
            }
            return arr[first];
        }

        public void push(int obj){
            if(size==arr.length){
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            arr[last] = obj;
            size++;
            last = last==arr.length-1 ? 0 : last+1;
        }
        public Integer poll(){
            if(size==0){
                return null;
            }
            int tmp = first;
            size--;
            first = first==arr.length-1 ? 0 : first+1;
            return arr[tmp];


        }

    }

    public static void main(String[] args) {

    }



}
