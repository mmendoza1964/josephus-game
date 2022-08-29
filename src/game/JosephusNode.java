package game;

/**
 * Creates nodes for JosephusGame
 * @author Mark Mendoza
 * @version 1.3
 */
//A doubly-linked list node. This node class is not an inner class,
//so you will need to use getters/setters to access the fields in 
//the class. They should not be public.
public class JosephusNode {
	//fields
    private JosephusNode left;
	private JosephusNode right;
	private String name;

	/**
	 * constructor
	 * @param name player name
	 */
	public JosephusNode(String name) {
		this.name = name;
		left = this;
		right = this;
	}

	/**
	 * constructor setting supplied name and nodes
	 * @param name player name
	 * @param left Node to the left
	 * @param right Node to right right
	 */
	public JosephusNode(String name, JosephusNode left,
				 JosephusNode right) {
	    this.left = left;
	    this.right = right;
	    this.name = name;
    }

	/**
	 * @param left Node to left
	 */
    public void setLeft(JosephusNode left) {
		this.left = left;
	}

	/**
	 * @param right Node to right
	 */
	public void setRight(JosephusNode right) {
		this.right = right;
	}

	/**
	 * @param name player name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Node to left
	 */
	public JosephusNode getLeft() {
	    return left;
    }

	/**
	 * @return Node to right
	 */
	public JosephusNode getRight() {
        return right;
    }

	/**
	 * @return player name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}
