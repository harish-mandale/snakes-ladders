package deserve;

public class Player {
	protected String name;
	protected ISquare square;
	public void moveForward(int moves) {
		square.leave(this);
		square = square.moveAndLand(moves);
		square.enter(this);
	}
	
	public boolean wins(int winPosition) {
		return square.position() == winPosition;
	}
}
