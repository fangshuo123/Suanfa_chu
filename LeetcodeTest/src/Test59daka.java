import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test59daka {

        public Queue<Integer> data;
        public Deque<Integer> help;
        public Test59daka() {
            data = new LinkedList<>();
            help = new LinkedList<>();
        }

        public int max_value() {
            if(help.isEmpty()){
                return -1;
            }
            return help.peek();

        }

        public void push_back(int value) {
            data.add(value);
            while(!help.isEmpty() && help.getLast()<value){
                help.pollLast();
            }
            help.add(value);

        }

        public int pop_front() {
            if(data.isEmpty()){
                return -1;
            }
            int ans = data.peek();
            if( ans== help.peek()){
                help.poll();
            }
            return data.poll();

        }


    public static void main(String[] args) {
        Test59daka obj = new Test59daka();
        obj.push_back(46);
        int max = obj.max_value();
        int p = obj.pop_front();
        max = obj.max_value();
        p = obj.pop_front();
        obj.push_back(868);
        p = obj.pop_front();
        p = obj.pop_front();
        p = obj.pop_front();
        obj.push_back(525);
        p = obj.pop_front();
        max = obj.max_value();



    }
}
