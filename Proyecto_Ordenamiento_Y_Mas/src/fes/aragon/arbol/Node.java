package fes.aragon.arbol;

public class Node {
	public String val;
    public Node left;
	public Node right;
 
    public Node(String val)
    {
        this.val = val;
        this.left = this.right = null;
    }

}
