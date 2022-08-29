package game;

import exceptions.GameException;

/**
 * Creates nodes for JosephusGame
 * @author Mark Mendoza
 * @version 1.4
 */
public class JosephusCircle
{
	//fields go here...
	private JosephusNode head;
	private JosephusNode cursor;
	private final int maxPlayers;
	private int playerCount;

	/**
	 * starts game with max number of players
	 * @param playerMax max number of players for game session
	 */
	public JosephusCircle(int playerMax) {
		//Creates a new JosephusCircle object with the maximum players given.
		maxPlayers = playerMax;
	}

	/**
	 * adds node before head
	 * @param player Name of player
	 */
	public void addPlayer(String player)
	{
		//Adds a new player to the game from left-to-right in the 
		//internal linked list.
		if (getPlayerCount() == getMaxPlayers()) {//if playerCount reached
			throw new GameException("Max number of players already reached");
		} else if (getHead() == null) {//if circle is empty
			setHead(new JosephusNode(player));
		} else {//circle is not empty
			JosephusNode current = getHead();//start current at head
			while (current.getRight() != null &&
					current.getRight() != getHead()) { //move to last element
				current = current.getRight();//move cursor to right
			}
			//add player after last players
			current.setRight(new JosephusNode(player, current, getHead()));
			getHead().setLeft(current.getRight());
		}
		setPlayerCount(getPlayerCount() + 1);
		setCursor(getHead());//cursor starts at head, assurance
	}

	/**
	 * moves cursor along nodes
	 * @param direction Direction cursor is moving
	 * @param steps Number of steps skipped to next victim
	 * @return name of player removed
	 */
	public String moveCursor(Direction direction, int steps)
	{
		//Moves the current player (the cursor) from the current 
		//position the given number of steps to the left or right
		for (int i = 0; i < steps; i++) {
			if (direction == Direction.LEFT) {
				setCursor(getCursor().getLeft());
			} else {//direction is RIGHT
				setCursor(getCursor().getRight());
			}
		}
		return getCursor().getName();
	}

	/**
	 * remove node at cursor, reassigns pointers as needed
	 * @param direction Direction game is played in
	 */
	public void removeAtCursor(Direction direction)
	{
		//Removes the player at the cursor position from the circle.
		if (getCursor() == getHead()) {//if cursor is at head
			getCursor().getRight().setLeft(getCursor().getLeft()); //set right node's left pointer
			getCursor().getLeft().setRight(getCursor().getRight());//set left node's right pointer
			if (direction == Direction.LEFT) {//if direction is left, move head left
				setHead(getCursor().getRight());
				moveCursor(Direction.LEFT, 1);
			} else {//if direction is right, move head right
				setHead(getCursor().getRight());
				moveCursor(Direction.RIGHT, 1);
			}
		} else if (getCursor().getRight() == getHead()) {//if tail
			getCursor().getLeft().setRight(getHead());//set left node's right node
			getHead().setLeft(getCursor().getLeft()); //set new head's left node
			moveCursor(direction, 1);
		} else {//if middle node
			getCursor().getRight().setLeft(getCursor().getLeft());//set right node's left
			getCursor().getLeft().setRight(getCursor().getRight());//set left node's right
			moveCursor(direction, 1);
		}
		setPlayerCount(getPlayerCount() - 1);
	}

	/**
	 * returns visual of contained nodes
	 * @return visual of contained nodes
	 */
	public String getCircle()
	{
		//Returns a string representing the internal state of the circle, 
		//with the following format:
		//<-- Player A <--> Player B <--> Player C <--> Player D -->
		if (getHead() == null) {
			return "Circle is empty";
		} else {//not empty
			JosephusNode current = getHead();

			String result = "<-- ";
			//if cursor at head
			if (cursor == getHead()) {
				result += getHead().getName().toUpperCase();
			} else {//cursor not at head
				result += getHead().getName();
			}
			//if head is last node
			if (getHead().getRight() == getHead()) {
				result += " -->";
				return result;
			}
			//rest of nodes
			while (current.getRight() != null &&
					current.getRight() != getHead()) {
				current = current.getRight();
				result += " <--> ";
				//check if at cursor (uppercase or not)
				if (current == getCursor()) {
					result += current.getName().toUpperCase();
				} else {
					result += current.getName();
				}
			}
			result += " -->";
			return result;
		}
	}

	/**
	 * @return boolean. Returns true if 1 player left, else returns false
	 */
	public boolean isGameOver()
	{
		//Returns true if the game is over. That is, this method will 
		//return true if only one player remains in the circle.
		//System.out.println("Player count is: " + playerCount);
		return getPlayerCount() == 1;
	}

	@Override
	public String toString() {
		return this.getCircle();
	}

	/**
	 * @return number of players still alive
	 */
	public int getPlayerCount() {
		return playerCount;
	}

	/**
	 * @param playerCount number of players alive
	 */
	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}

	/**
	 * @return Returns head field (first node)
	 */
	public JosephusNode getHead() {
		return head;
	}

	/**
	 * @param head first node in circle
	 */
	public void setHead(JosephusNode head) {
		this.head = head;
	}

	/**
	 * @return current node at cursor
	 */
	public JosephusNode getCursor() {
		return cursor;
	}

	/**
	 * @param cursor current node at cursor
	 */
	public void setCursor(JosephusNode cursor) {
		this.cursor = cursor;
	}

	/**
	 * @return max number of players for game session
	 */
	public int getMaxPlayers() {
		return maxPlayers;
	}
}
