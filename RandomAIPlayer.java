import java.util.Random;
public class RandomAIPlayer extends ConnectPlayer {
	
	public void makeMove(int negativeNumber, Connect42DArray game)
	{
		Random generator = new Random();
		int column = generator.nextInt(6);
		int row = 5;
		boolean moveMade = false;
		while(!moveMade && row > 0)
		{
			if(game.isColumnFull(column) == false)
			{
				if(game.grid[row][column].equals(" "))
				{
					game.grid[row][column] = this.piece;
					game.columnOfLastTurn = column;
					game.rowOfLastTurn = row;
					moveMade = true;
				}
				else
					row--;
			}
			else
			{
				column = generator.nextInt(6);
			}
			
		}
		
	}
}