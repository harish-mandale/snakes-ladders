package deserve;

public class Ladder extends Square {
	private int transport;
	public Ladder(int position, Game game, Player player, int transport) {
		super(position, game, player);
		this.transport = transport;
	}
	public ISquare landHere() {
		return this.destination().landHere();
	}
	protected ISquare destination() {
		return game.getSquare(position+transport);
	}
}
