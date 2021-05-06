package deserve;

public class Square implements ISquare {
	protected int position;
	protected Player player;
	protected Game game;
	public Square(int position, Game game, Player player) {
		super();
		this.position = position;
		this.player = player;
		this.game = game;
	}

	public void enter(Player player) {
		this.player = player;
	}
	
	public ISquare moveAndLand(int moves) {
		return game.findSquare(position, moves).landHereOrGoHome();
	}
	
	public ISquare landHereOrGoHome() {
		return this.isOccupied() ? game.getSquare(1) : this ;
	}
	
	@Override
	public int position() {
		return this.position;
	}
	
	@Override
	public void leave(Player player) {
		this.player = null;
	}
	
	@Override
	public boolean isOccupied() {
		return this.player != null;
	}
}
