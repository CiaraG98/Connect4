public class HumanPlayer extends ConnectPlayer{
	
	public void makeMove(int column, Connect42DArray game)
	{
		game.columnOfLastTurn = column;
		int row = 5 ;
		if(game.isColumnFull(column) == false)
		{
			while(row > 0)
			{
				if(game.grid[row][column].equals(" "))
				{
					game.grid[row][column] = this.piece;
					game.rowOfLastTurn = row;
					break;
				}
				else
					row--;
			}
		}
	}	
}