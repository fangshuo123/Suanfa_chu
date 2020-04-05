import java.util.Stack;

public class GetMinStack {
    public static class MyStack{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack(){
            stackData = new Stack<Integer>();
            stackMin = new Stack<Integer>();
        }

        public void push(int newNum){
            if(this.stackMin.isEmpty()){
                this.stackMin.push(newNum);
            }else if(newNum < this.getMin()){
                this.stackMin.push(newNum);
            }else{
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
            this.stackData.push(newNum);
        }

        public int pop(){
            if(this.stackData.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getMin(){
            if(this.stackMin.isEmpty()){
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }
    public static void main(String[] args) {


        MyStack stack2 = new MyStack();
        stack2.push(3);
        System.out.println(stack2.getMin());
        stack2.push(4);
        System.out.println(stack2.getMin());
        stack2.push(1);
        System.out.println(stack2.getMin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getMin());
    }


}

