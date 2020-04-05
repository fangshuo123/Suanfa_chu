import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvert {
    public static class TwoStacksQueue{
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue(){
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }
        public void push(int num){
            stackPush.push(num);
        }
        public int poll(){
            if(stackPop.empty() && stackPush.empty()){
                throw new RuntimeException("Queue is empty!");
            }
            dao();
            return stackPop.pop();
        }
        public int peek(){
            if(stackPop.empty() && stackPush.empty()){
                throw new RuntimeException("Queue is empty!");
            }
            dao();
            return stackPop.peek();
        }

        public void dao(){
            if(!stackPop.isEmpty()){
                return;
            }
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }


    public static class TwoQueuesStack{
        private Queue<Integer> data;
        private Queue<Integer> help;

        public TwoQueuesStack() {
            data = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }
        public void push(int num){
            data.add(num);
        }
        public int peek(){
            if(data.isEmpty()){
                throw new RuntimeException("Stack is empty!");
            }
            while (data.size() != 1){
                help.add(data.poll());
            }
            int res = data.poll();
            help.add(res);
            swap();
            return res;
        }
        public int pop(){
            if(data.isEmpty()){
                throw new RuntimeException("Stack is empty!");
            }
            while(data.size() != 1){
                help.add(data.poll());
            }
            int res = data.poll();
            swap();
            return res;
        }

        private void swap(){
            Queue<Integer> tmp = help;
            help = data;
            data = tmp;
        }
    }
}
