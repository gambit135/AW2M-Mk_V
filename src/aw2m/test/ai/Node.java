package aw2m.test.ai;

/**
 * A node is understood as an element of a minimax search tree.
 *
 *
 * @author Alejandro Téllez G. <java.util.fck@hotmail.com>
 *
 */
public class Node {

    /**
     * Alpha-beta data.
     */
    int alpha, beta, ply;
    /**
     * True if this node is a Max node; false otherwise.
     */
    boolean isMax;
    /**
     * The number of child this node is, in regard to its parent node.
     */
    int childSecuenceNumber;
    /**
     * The max number of children this node can have. Consider storing the value
     * by reference, encapsulated on another object, or as a static variable.
     */
    int maxNumberOfChildren;
    /**
     * The type of movement or action this node represents. Note that some
     * movement types are movement-sensitive: 1. 2. 3.
     */
    byte movementType;
}
