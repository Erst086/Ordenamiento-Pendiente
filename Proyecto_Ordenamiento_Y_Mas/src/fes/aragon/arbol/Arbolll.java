package fes.aragon.arbol;

public class Arbolll {
	// Funcion de utilidad para verificar si un nodo dado es un nodo hoja
    public static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
 
    // Funcion para aplicar un operador 'op' a los valores 'x' e 'y' y devolver el resultado
    public static double proceso(String op, double x, double y)
    {
        if (op.equals("+")) { return x + y; }
        if (op.equals("-")) { return x - y; }
        if (op.equals("*")) { return x * y; }
        if (op.equals("/")) { return x / y; }
 
        return 0;
    }
 
    // Funcion recursivo para evaluar un arbol de expresion binaria
    public static double evaluar(Node root)
    {
        // caso base: entrada invalida
        if (root == null) {
            return 0;
        }
 
        // las hojas de un orbol de expresion binaria son operandos
        if (isLeaf(root)) {
            return Double.valueOf(root.val);
        }
 
        // evalua recursivamentemente el sub rbol izquierdo y derecho
        double x = evaluar(root.left);
        double y = evaluar(root.right);
 
        // aplicamos el operador en la raiz a los valores obtenidos en el paso anterior
        return proceso(root.val, x, y);
    }
 
    public static void main(String[] args)
    {
        Node root = new Node("+");
        root.left = new Node("*");
        root.right = new Node("/");
        root.left.left = new Node("-");
        root.left.right = new Node("5");
        root.right.left = new Node("21");
        root.right.right = new Node("7");
        root.left.left.left = new Node("10");
        root.left.left.right = new Node("5");
        System.out.println("La exprecion es "+"\n"+"+ * / - 5 21 7 10 5");
        System.out.println("El resultado es " + evaluar(root));
    }
}
