import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class node{

    private int data;
    private node left,right;
    public node(int d)
    {
        this.data=d;
        left = null;
        right = null;
    }

    public void setData(int d)
    {
        this.data=d;
    }

    public int getData()
    {
        return this.data;
    }

    public void setLeft(node n)
    {
        left = n;
    }
    
    public node getLeft()
    {
        return left;
    }

    public void setRight(node n)
    {
        right =n;
    }

    public node getRight()
    {
        return right;
    }

    public node getroot() {
        return null;
    }

}

class BinaryTree{

    private node root;
    
    public BinaryTree()
    {
        root=null;
    }

    public void setRoot(node root)
    {
        this.root = root;
    }

    public node getroot ()
    {
        return root;
    }
    
    public node CreateNode (int d)
    {
        if (root == null)
        {
            root = new node(d);
            return root;
        }

        node n = new node(d);
        return n;
    }

    public void insert_levelwise(int d)
    {
        node n = new node(d);
        node iter;

        if (root == null)
        {
            root = n;
            return;
        }
        Queue <node> q = new LinkedList<node>();
        q.add(root);

        while(!q.isEmpty())
        {
            iter = q.remove();

            if(iter.getLeft()==null)
            {
                iter.setLeft(n);
                return;
            }
            else
            {
                q.add(iter.getLeft());
            }
            if(iter.getRight()==null )
            {
                iter.setRight(n);
                return;
            }
            else{
                q.add(iter.getRight());
            }
        }// end of while         
    }// end of fun

    public void levelwise_traversal(node root)
    {
        
        node iter = root;

        if (root == null)
        {
            System.out.println("Tree is Empty");
            return;
        }
        Queue <node> q = new LinkedList<node>();
        q.add(root);

        while(!q.isEmpty())
        {
            iter = q.remove();
                System.out.println(iter.getData()+" ");

            if(iter.getLeft()!=null)
            {
                q.add(iter.getLeft());
            }
            
            if(iter.getRight()!=null )
            {   
                q.add(iter.getRight());
            }
        }// end of while
    }// end of function

    public int sumofleafnode()
    {
        node iter;
        
        int sum = 0;

        if (root == null)
        {
            System.out.println("Tree is Empty");
            return -1;
        }


        Queue <node> q = new LinkedList<node>();
        q.add(root);

        while(!q.isEmpty())
        {
            iter = q.remove();

            if((iter.getLeft()!=null)&&(iter.getRight()!=null))
            {
                sum = sum + iter.getData();
            }
            
            if(iter.getLeft()!=null){
                q.add(iter.getLeft());
            }

            if(iter.getRight()!=null )
            {
                 q.add(iter.getRight());
            }
        }// end of while
        return sum;
    }// end of function

    public int sumofnonleaf()
    {
        node iter;
        
        int sum = 0;

        if (root == null)
        {
            System.out.println("Tree is Empty");
            return -1;
        }


        Queue <node> q = new LinkedList<node>();
        q.add(root);

        while(!q.isEmpty())
        {
            iter = q.remove();

            if((iter.getLeft()==null)||(iter.getRight()==null))
            {
                sum = sum + iter.getData();
            }
            
            if(iter.getLeft()!=null){
                q.add(iter.getLeft());
            }

            if(iter.getRight()!=null )
            {
                 q.add(iter.getRight());
            }
        }// end of while
        return sum;
    }// end of function

    public int getMax()
    {
        node iter=root;
        
        int max = 0;

        if (root == null)
        {
            System.out.println("Tree is Empty");
            return -1;
        }


        Queue <node> q = new LinkedList<node>();
        q.add(root);
        max = root.getData();

        while(!q.isEmpty())
        {
            iter = q.remove();

            if(max >iter.getData())
            {
                max = iter.getData();
            }
            
            if(iter.getLeft()!=null){
                q.add(iter.getLeft());
            }

            if(iter.getRight()!=null )
            {
                 q.add(iter.getRight());
            }
        }// end of while
        return max;
    }// end of function

    public int getmin()
    {
        node iter= root;
        
        int min = 0;

        if (root == null)
        {
            System.out.println("Tree is Empty");
            return -1;
        }


        Queue <node> q = new LinkedList<node>();
        q.add(root);
        min = root.getData();

        while(!q.isEmpty())
        {
            iter = q.remove();

            if(min < iter.getData())
            {
                min = iter.getData();
            }
            
            if(iter.getLeft()!=null){
                q.add(iter.getLeft());
            }

            if(iter.getRight()!=null )
            {
                 q.add(iter.getRight());
            }
        }// end of while
        return min;
    }// end of function

    public int levelcount(node root)
    {   node iter=root;
        node dummy = new node(-1);
        int level = 0;

        if (root == null)
        {
            System.out.println("Tree is Empty");
            return -1;
        }


        Queue <node> q = new LinkedList<node>();
        q.add(root);
        q.add(dummy);
        
        while(!q.isEmpty())
        {
            iter = q.remove();

            if(iter.getData()==-1)
            {   level++;
                q.add(dummy);
                iter = q.remove();
            }
            
            if(iter.getLeft()!=null){
                q.add(iter.getLeft());
            }

            if(iter.getRight()!=null )
            {
                 q.add(iter.getRight());
            }
        }// end of while
            return level;
    }//end of fun 

}// end of class
 
public class BinaryTreeUser {
    public static boolean isIdentical (node n1,node n2)
    {
        node iter1 = n1;
        node iter2 = n2;

        Queue <node> q1 = new LinkedList<node>();
        Queue <node> q2 = new LinkedList<node>();

        q1.add(iter1);
        q2.add(iter2);

        while (!q1.isEmpty() && !q2.isEmpty())
        {
            iter1 = q1.remove();
            iter2 = q2.remove();

            if(iter1.getData()!=iter2.getData())
            return false;

            if(iter1.getLeft()!=null){
                q1.add(iter1.getLeft());
            }

            if(iter1.getRight()!=null )
            {
                 q1.add(iter1.getRight());
            }

            if(iter2.getLeft()!=null){
                q2.add(iter2.getLeft());
            }

            if(iter2.getRight()!=null )
            {
                 q2.add(iter2.getRight());
            }

        }   // while end
        if (q1.isEmpty() && q2.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }// fun end

    public static void swap(node r)
    {
        node t;
        t = r.getLeft();
        r.setLeft(r.getRight());
        r.setRight(t);        
    }

    public static node mirror_image(node root)
    {
        BinaryTree t = new BinaryTree();
        node iter = root;

        Queue <node> q = new LinkedList<node>();
        q.add(iter);

        while(!q.isEmpty())
        {
            iter=q.remove();
            swap(iter);
            t.insert_levelwise(iter.getData());

            if(iter.getLeft()!=null)
            {   
                q.add(iter.getLeft());
            }
            
            if(iter.getRight()!=null)
            {
                q.add(iter.getRight());
            }
        }

        return root;
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            BinaryTree bt = new BinaryTree();

            int i,num;

            System.out.println("Enter node values:");

            for(i=0;i<7;i++)
            {
                num = sc.nextInt();
                bt.insert_levelwise(num);

            }
            System.out.println("Tree traversal: ");
            bt.levelwise_traversal(bt.getroot());
            System.out.println("level count");
            System.out.println(bt.levelcount(bt.getroot()));

            BinaryTree t = new BinaryTree();
            t.setRoot( mirror_image(bt.getroot()));
            System.out.println("Mirror Image of the given binary tree is : ");
            t.levelwise_traversal(t.getroot());

            if(isIdentical(bt.getroot(), t.getroot()))
            System.out.println("trees are identical");
            else
            System.out.println("not identical");

            System.out.println("Max :"+bt.getMax());
            System.out.println("Min :"+bt.getmin());
            System.out.println("The Sum of Leaf nodes :"+bt.sumofleafnode());
            System.out.println("The Sum of Non Leaf nodes :"+bt.sumofnonleaf());

            sc.close();
        }
    }
}
