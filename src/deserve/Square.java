package deserve;

public class Square implements ISquare {
	protected int position;
	protected GameSlate game;
	protected Player player;
	
	public Square(int position, GameSlate game, Player player) {
		super();
		this.position = position;
		this.game = game;
		this.player = player;
	}

	public void enter(Player player) {
		this.player = player;
	}
	
	public ISquare moveAndLand(int moves) {
		return game.findSquare(position, moves).landHereOrGoHome();
	}
	
	public ISquare landHereOrGoHome() {
		return this.isOccupied() ? game.firstSquare() : this ;
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
