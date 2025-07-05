import java.util.*;
class Node { 
    int data; 
    Node left, right; 
    public Node(int item)
    { 
        data = item; 
        left = right = null; 
    } 
}

class BSTLeftBoundary
{ 
    Node root; 
   public BSTLeftBoundary()
   { 
        root=null; 
   } 
   public void insertRe(int data)
   {
	root=insert(root,data);
    }
    public Node insert(Node root ,int data)
    { 
       if (root == null)
       { 
            root = new Node(data); 
            return root; 
        } 
        if (data < root.data)
	{ 
            root.left = insert(root.left, data); 
        } 
	else if (data > root.data) 
	{ 
            root.right = insert(root.right, data); 
        } 
        return root; 
 
    } 
    public void leftBoundaryOrder()
    { 
        Queue<Node>q=new LinkedList<>();
	q.add(root);
	while(!q.isEmpty())
	{
		int s=q.size();
		for(int i=0;i<s;i++)
		{
			Node curr=q.poll();
			if(i==0)
				System.out.print(curr.data+" ");		
			if(curr.left!=null)
				q.add(curr.left);
			if(curr.right!=null)
				q.add(curr.right);
		}
	}
		
    } 
}

public class BSTLeftBoundary1 { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        BSTLeftBoundary tree = new BSTLeftBoundary(); 
        System.out.print("Enter the number of nodes in the BST: "); 
        int n = scanner.nextInt(); 
        System.out.println("Enter the elements of the BST:");
        for (int i = 0; i < n; i++) { 
            int value = scanner.nextInt(); 
            tree.insertRe(value); 
        } 
        System.out.println("Reverse left boundary of the BST:"); 
        tree.leftBoundaryOrder();
    } 
}
