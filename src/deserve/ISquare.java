package deserve;

public interface ISquare {
	public int position();
	public ISquare moveAndLand(int moves);
	public void enter(Player player);
	public void leave(Player player);
	public boolean isOccupied();
	public ISquare landHereOrGoHome();
}
