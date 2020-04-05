import java.util.Stack;

public class PreInPosTraversal {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }
    //递归
    public static void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.value+"");
        preOrderRecur(head.left);
        preOrderRecur((head.right));
    }
    public static void inOrderRecur(Node head){
        if(head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value+"");
        inOrderRecur(head.right);
    }
    public static void posOrderRecur(Node head){
        if(head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur((head.right));
        System.out.print(head.value+"");
    }

    public static void preOrderUnRecur(Node head){
        System.out.println("pre-order:");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            Node top = null;
            while(! stack.isEmpty()){
                top = stack.pop();
                System.out.print(top.value+" ");
                if(top.right != null){
                    stack.push(top.right);
                }
                if(top.left != null){
                    stack.push(top.left);
                }
            }
        }
        System.out.println();
    }
    public static void inOrderUnRecur(Node head){
        System.out.println("inOder:");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while( !stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.print(head.value+" ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }
    public static void posOrderUnRecur(Node head){
        System.out.println("pos-order:");
        if(head!=null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while(!stack1.isEmpty()){
                head = stack1.pop();
                stack2.push(head);
                if(head.left != null){
                    stack1.push(head.left);
                }
                if(head.right != null){
                    stack1.push(head.right);
                }
            }while( !stack2.isEmpty()){
                System.out.print(stack2.pop().value+" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur(head);

    }
}
