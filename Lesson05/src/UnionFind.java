import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {
    public static class Node{
        public int value;
        public Node(int data){
            this.value = data;
        }
    }

    public static class UnionFindSet{
        public HashMap<Node, Node> fatherMap;
        public HashMap<Node, Integer> sizeMap;

        public UnionFindSet(){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        public void makeSets(List<Node> nodes){
            fatherMap.clear();
            sizeMap.clear();
            for(Node node: nodes){
                fatherMap.put(node, node);
                sizeMap.put(node,1);
            }
        }

        private Node findHead(Node node){
            Node father = fatherMap.get(node);
            if(father != node){
                father = findHead(father);
            }
            fatherMap.put(node, father);
            return father;
        }

        private Node findHead2(Node node){
            Stack<Node> stack = new Stack<Node>();
            Node cur = node;
            Node parent = fatherMap.get(cur);
            while(cur!=parent){
                stack.push(cur);
                cur = parent;
                parent = fatherMap.get(cur);
            }
            while(!stack.isEmpty()){
                fatherMap.put(stack.pop(),parent);
            }
            return parent;
        }

        public boolean isSameSet(Node a, Node b){
            return findHead(a)==findHead(b);
        }

        public void union (Node a , Node b){
            if(a==null || b==null){
                return;
            }
            Node ahead = findHead(a);
            Node bhead = findHead(b);
            if(ahead != bhead){
                int aSetSize = sizeMap.get(ahead);
                int bSetSize = sizeMap.get(bhead);
                if(aSetSize > bSetSize){
                    fatherMap.put(bhead, ahead);
                    sizeMap.put(ahead, aSetSize+bSetSize);
                }else{
                    fatherMap.put(ahead,bhead);
                    sizeMap.put(bhead, bSetSize+aSetSize);
                }
            }
        }
    }

    public static void main(String[] args){


    }

}
