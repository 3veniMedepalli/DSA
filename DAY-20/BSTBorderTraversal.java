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

class BST
{ 
    Node root; 
   public BST()
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
			if(i==0&&(curr.left!=null||curr.right!=null))
				System.out.print(curr.data+" ");		
			if(curr.left!=null)
				q.add(curr.left);
			if(curr.right!=null)
				q.add(curr.right);
		}
	}
		
    } 
 
 public void rightBoundaryOrder()
    { 
        Queue<Node>q=new LinkedList<>();
	q.add(root);
	Node t=q.poll();
	if(t.left!=null)
		q.add(t.left);
	if(t.right!=null)
		q.add(t.right);
	while(!q.isEmpty())
	{
		int s=q.size();
		for(int i=0;i<s;i++)
		{
			Node curr=q.poll();
			if(i==s-1&&(curr.left!=null||curr.right!=null))
				System.out.print(curr.data+" ");		
			if(curr.left!=null)
				q.add(curr.left);
			if(curr.right!=null)
				q.add(curr.right);
		}
	}
		
    } 

    public void leafOrder()
    { 
        Queue<Node>q=new LinkedList<>();
	q.add(root);
	while(!q.isEmpty())
	{
		int s=q.size();
		for(int i=0;i<s;i++)
		{
			Node curr=q.poll();
			if(curr.left==null&&curr.right==null)
				System.out.print(curr.data+" ");		
			if(curr.left!=null)
				q.add(curr.left);
			if(curr.right!=null)
				q.add(curr.right);
		}
	}
		
    } 
	public void borderTraversal()
	{
		leftBoundaryOrder();
		leafOrder();
		rightBoundaryOrder();
	}
}

public class BSTBorderTraversal { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        BST tree = new BST(); 
        System.out.print("Enter the number of nodes in the BST: "); 
        int n = scanner.nextInt(); 
        System.out.println("Enter the elements of the BST:");
        for (int i = 0; i < n; i++) { 
            int value = scanner.nextInt(); 
            tree.insertRe(value); 
        } 
        System.out.println("Boundary traversal of BST:"); 
        tree.borderTraversal();
    } 
}
