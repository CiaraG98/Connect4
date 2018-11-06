public class Connect42DArray implements Connect4Grid {

	public String[][] grid;
	public int row;
	public int column;
	public int columnOfLastTurn;
	public int rowOfLastTurn;

	public Connect42DArray() 
	{
		this.row = 6;
		this.column = 7;
		this.grid = new String[row][column];
	}

	public void emptyGrid() 
	{
		for(int i = 0; i < this.grid.length; i++)
		{
			for(int j = 0; j < this.grid[i].length; j++)
			{
				this.grid[i][j] = " ";
			}
		}
	}
	
	public String toString()
	{
		String gridString = " ";
		for(int i = 0; i < grid.length; i++)
		{
			System.out.println("---------------------------");
			for(int j = 0; j < grid[i].length; j++)
			{
				if(j < 6)
					System.out.print(" " + this.grid[i][j] + " |");
				else
					System.out.print(this.grid[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println("---------------------------");
		return gridString;
	}
	
	
	public boolean isValidColumn(int column) 
	{
		if(column >= 0 && column <= 6)
			return true;
		else
			return false;
	}

	public boolean isColumnFull(int column) 
	{
		boolean full = false;
		if(isValidColumn(column) == true)
		{
			if(this.grid[0][column].equals(null))
				full = true;
		}
		return full;
	}

	public void dropPiece(ConnectPlayer player, int column)
	{
		player.makeMove(column, this);
	}

	public boolean didLastPieceConnect4() 
	{
		int connect = 1;
		int column = this.columnOfLastTurn;
		int row = this.rowOfLastTurn;
		while(column != 6)//across right
		{
			if(this.grid[row][column].equals(this.grid[row][column + 1]))
			{
				connect++;
				if(connect == 4)
				{
					return true;
				}
				else 
				{
					column++;
				}
			}
			else
				break;
		}
		connect = 1;
		while(column != 0)//across left
		{
			if(this.grid[row][column].equals(this.grid[row][column - 1]))
			{
				connect++;
				if(connect == 4)
				{
					return true;
				}
				else 
				{
					column--;
				}
			}
			else
				break;
		}
		connect = 1;
		while(row != 5)//down
		{
			if(this.grid[row][column].equals(this.grid[row + 1][column]))
			{
				connect++;
				if(connect == 4)
				{
					return true;
				}
				else 
				{
					row++;
				}
			}
			else
				break;
		}
		connect = 1;
		while(row != 5)//up
		{
			if(this.grid[row][column].equals(this.grid[row - 1][column]))
			{
				connect++;
				if(connect == 4)
				{
					return true;
				}
				else 
				{
					row--;
					if(row < 0)
						break;
				}
			}
			else
				break;
		}
		connect = 1;
		while(column != 6 && row != 5)//diagonal down right
		{
			if(this.grid[row][column].equals(this.grid[row + 1][column + 1]))
			{
				connect++;
				if(connect == 4)
				{
					return true;
				}
				else 
				{
					row++;
					column++;
				}
			}
			else
				break;
		}
		connect = 1;
		while(column != 0 && row != 5)//diagonal down left
		{
			if(this.grid[row][column].equals(this.grid[row + 1][column - 1]))
			{
				connect++;
				if(connect == 4)
				{
					return true;
				}
				else 
				{
					row++;
					column--;
				}
			}
			else
				break;
		}
		connect = 1;
		while(row != 0 && column != 0)//diagonal up left
		{
			if(this.grid[row][column].equals(this.grid[row - 1][column - 1]))
			{
				connect++;
				if(connect == 4)
				{
					return true;
				}
				else 
				{
					row--;
					column--;
				}
			}
			else
				break;
		}
		connect = 1;
		while(row != 0 && column != 6)//diagonal up right
		{
			if(this.grid[row][column].equals(this.grid[row - 1][column + 1]))
			{
				connect++;
				if(connect == 4)
				{
					return true;
				}
				else 
				{
					row--;
					column++;
				}
			}
			else
				break;
		}
		return false;
	}

	public boolean isGridFull() 
	{
		boolean full = true;
		for(int i = 0; i < this.grid.length; i++)
		{
			for(int j = 0; j < this.grid[i].length; j++)
			{
				if(this.grid[i][j] == " ")
				{
					full = false;
				}
			}
		}
		return full;
	}

	
}
