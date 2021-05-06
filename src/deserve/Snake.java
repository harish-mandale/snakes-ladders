package deserve;

public class Snake extends Square {
	private int transport;
	
	public Snake(int position, Game game, Player player, int transport) {
		super(position, game, player);
		this.transport = transport;
	}
	public ISquare landHereOrGoHome() {
		return this.destination().landHereOrGoHome();
	}
	protected ISquare destination() {
		return game.getSquare(position+transport);
	}
}
