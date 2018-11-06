public abstract class ConnectPlayer {

	String piece;
	public abstract void makeMove(int column, Connect42DArray game);
	
	public void setPiece(String piece)
	{
		if(piece != null)
		{
			this.piece = piece;
		}
	}
}