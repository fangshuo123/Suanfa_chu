import java.util.Comparator;
import java.util.PriorityQueue;

/*有连个数组，一个是代价数组cost[],一个是利润数组profit[]，
分别表示每个项目的代价和利润。
给一个启动资金W，一次只能做一个项目。最多能做K个项目。
问:最终最多能剩下多少钱?*/
public class IPO {
    public static class Node{
        public int p;
        public int c;
        public Node(int p, int c){
            this.p = p;
            this.c = c;
        }
    }
    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2){
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2){
            return o2.p - o1.p;
        }
    }
    public static int findMaximizedCapital(int k, int W, int[] profit, int[] cost){
        Node[] nodes = new Node[profit.length];
        for(int i = 0; i<profit.length; i++){
            nodes[i] = new Node(profit[i], cost[i]);
        }
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for(int i = 0; i<nodes.length; i++){
            minCostQ.add(nodes[i]);
        }
        for(int i = 0; i<k; i++){
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W){
                maxProfitQ.add(minCostQ.poll());
            }
            if(maxProfitQ.isEmpty()){
                return W;
            }
            W+=maxProfitQ.poll().p;
        }
        return W;
    }


}
