import java.util.List;
import java.util.ArrayList;

/**
    A tree in which each node has an arbitrary number of children.
*/
public class Tree
{
    private Node root;
    
    static class Node
    {
        public Object data;
        public List<Node> children;
        

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {
            int sum = 1;
            for(Node child:this.children){
                sum += child.size();
            }
            return sum;
        }
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree(Object rootData)
    {
        this.root = new Node();
        this.root.data = rootData;
        this.root.children = new ArrayList<>();
        
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree subtree)
    {
        this.root.children.add(subtree.root);
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size() 
    {
        return this.root.size();
    }

    // Additional methods will be added in later sections.

    /*
     * A vistor whos visit method is called for each  visted node during a tree traversal
     */

     public interface Vistor {
        /*
         * The visit method is called for each visited node
         * @param data: The data of the node being visited
         */
        void visit(Object data);
     }
     

     /*
      * Traverses this tree in pre order
      * @param v: The visited to be invoked in each node
      */
      public void preorder(Visitor v){

      }

      /* 
       * Traverses the tree witha  gievn root in preorder
       * @param n: teh root of the tree to traverse
       * @param v: the visitor to be invoked in each node
       */

       private static void preorder(Node n, Visitor v){
        if(n == null){
            return;
        }
        v.visit(n.data);

        for(Node child: n.children){
            Tree.preorder((Child v);
        }
       }
     

}
