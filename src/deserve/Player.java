package deserve;

public class Player {
	protected String name;
	protected ISquare square;
	
	public Player(String name) {
		super();
		this.name = name;
	}
	
	public void setInitialPosition(ISquare square) {
		this.square = square;
		this.square.enter(this);
	}
	
	public int position() {
		return this.square.position();
	}

	public void moveForward(int moves) {
		square.leave(this);
		square = square.moveAndLand(moves);
		square.enter(this);
	}
	
	public boolean wins(int winPosition) {
		return square.position() == winPosition;
	}
}
