import java.util.Scanner;
public class Connect4Game {
	
	public static final String RED = "R";
	public static final String YELLOW = "Y";
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		boolean stopGame = false;
		Connect42DArray grid = new Connect42DArray();
		grid.emptyGrid();
		System.out.println("Are you playing against the computer or another person? Enter 'C' for computer or 'H' for human:");
		System.out.print("> ");
		String gameType = input.nextLine();
		if(gameType.equalsIgnoreCase("C"))//one player game...
		{
			ConnectPlayer AI = new RandomAIPlayer();
			ConnectPlayer player = new HumanPlayer();
			System.out.println("Player 1(User), choose your piece...Enter R for Red or Y for Yellow");
			System.out.print("> ");
			String piece = input.nextLine();
			if(piece.equalsIgnoreCase(RED))
			{
				player.setPiece(RED);
				AI.setPiece(YELLOW);
				System.out.println("Your Piece: " + player.piece);
				System.out.println("Computer's Piece: " + AI.piece);
				System.out.println(" ");
				System.out.print(grid.toString());
			}
			else if(piece.equalsIgnoreCase(YELLOW))
			{
				player.setPiece(YELLOW);
				AI.setPiece(RED);
				System.out.println("Your Piece: " + player.piece);
				System.out.println("Computer's Piece: " + AI.piece);
				System.out.println(" ");
				System.out.print(grid.toString());
			}
			else
				System.out.println("Invalid Entry. Run again.");
			
			while(!stopGame)
			{
				if(player.piece.equals(null))
					break;
				System.out.println(" ");
				System.out.println("Player 1(user), enter a column between 0 and 6 to drop a piece...");
				System.out.print("> ");
				if(input.hasNextInt())
				{
					int column = input.nextInt();
					if(grid.isGridFull() == false) 
					{
						if(grid.isValidColumn(column) == true)
						{
							grid.dropPiece(player, column);
							System.out.print(grid.toString());
							System.out.println(" ");
							if(grid.didLastPieceConnect4() == true)
							{
								System.out.println("User has won!");
								System.out.println("Play again?...y/n");
								System.out.print("> ");
								input.nextLine();
								String answer = input.nextLine();
								if(answer.equalsIgnoreCase("y"))
								{
									grid.emptyGrid();
									System.out.print(grid.toString());
									System.out.println(" ");
									continue;
								}
								else
								{
									System.out.println("Thanks for playing!");
									stopGame = true;
								}
									
							}
							else
							{
								System.out.println(" ");
								grid.dropPiece(AI, 0);
								System.out.println("Computer's turn: " + grid.columnOfLastTurn);
								System.out.print(grid.toString());
								System.out.println(" ");
								if(grid.didLastPieceConnect4() == true)
								{
									System.out.println("Computer has won!");
									System.out.println("Play again?...y/n");
									System.out.print("> ");
									input.nextLine();
									String answer = input.nextLine();
									if(answer.equalsIgnoreCase("y"))
									{
										grid.emptyGrid();
										System.out.print(grid.toString());
										System.out.println(" ");
										continue;
									}
										
									else
									{
										System.out.println("Thanks for playing!");
										stopGame = true;
									}
								}
								else
									continue;
							}
						}
						else
						{
							System.out.println("Invalid Column...");
							continue;
						}
					}
					else
					{
						System.out.println("Nobody wins..");
						stopGame = true;
					}
				}
				else
				{
					System.out.println("Invalid entry");
					input.next();
					continue;
				}
			}
		}
		else if(gameType.equalsIgnoreCase("H"))//two player game
		{
			ConnectPlayer player1 = new HumanPlayer();
			ConnectPlayer player2 = new HumanPlayer();
			System.out.println("Player 1, choose your piece...Enter R for Red or Y for Yellow");
			System.out.print("> ");
			String pieceType = input.nextLine();
			if(pieceType.equalsIgnoreCase(RED))
			{
				player1.setPiece(RED);
				player2.setPiece(YELLOW);
				System.out.println("Player 1: " + player1.piece);
				System.out.println("Player 2: " + player2.piece);
				System.out.print(grid.toString());
				System.out.println(" ");
			}
			else if(pieceType.equalsIgnoreCase(YELLOW))
			{
				player1.setPiece(YELLOW);
				player2.setPiece(RED);
				System.out.println("Player 1: " + player1.piece);
				System.out.println("Player 2: " + player2.piece);
				System.out.print(grid.toString());
				System.out.println(" ");
			}
			else
				System.out.println("Invalid Entry, run again.");
			
			while(!stopGame)
			{
				if(player1.piece.equals(null) || player2.piece.equals(null))
					break;
				System.out.println("Player 1, enter a column between 0 and 6 to drop a piece...");
				System.out.print("> ");
				if(input.hasNextInt())
				{
					int column = input.nextInt();
					if(grid.isGridFull() == false) 
					{
						if(grid.isValidColumn(column) == true)
						{
							grid.dropPiece(player1, column);
							System.out.print(grid.toString());
							System.out.println(" ");
							if(grid.didLastPieceConnect4() == true)
							{
								System.out.println("Player 1 has won!");
								System.out.println("Play again?...y/n");
								System.out.print("> ");
								input.nextLine();
								String answer = input.nextLine();
								if(answer.equalsIgnoreCase("y"))
								{
									grid.emptyGrid();
									System.out.print(grid.toString());
									System.out.println(" ");
									continue;
								}
									
								else
								{
									System.out.println("Thanks for playing!");
									stopGame = true;
								}
							}
							else
							{
								System.out.println("Player 2, enter a column between 0 and 6 to drop a piece...");
								System.out.print("> ");
								int column2 = input.nextInt();
								if(grid.isValidColumn(column2) == true)
								{
									grid.dropPiece(player2, column2);
									System.out.println(grid.toString());
									System.out.println(" ");
									if(grid.didLastPieceConnect4() == true)
									{
										System.out.println("Player 2 has won!");
										System.out.println("Play again?...y/n");
										System.out.print("> ");
										input.nextLine();
										String answer = input.nextLine();
										if(answer.equalsIgnoreCase("y"))
										{
											grid.emptyGrid();
											System.out.print(grid.toString());
											System.out.println(" ");
											continue;
										}
											
										else
										{
											System.out.println("Thanks for playing!");
											stopGame = true;
										}
									}
									else
										continue;
								}
							}
						}
						else
						{
							System.out.println("Invalid Column...");
							continue;
						}
					}
					else
					{
						System.out.println("Nobody wins..");
						stopGame = true;
					}
				}
				else
				{
					System.out.println("Invalid Entry");
					System.out.println(" ");
					input.next();
					continue; 
				}
				
			}
		}
		else
			System.out.println("Invalid Entry. Run again.");
		
		input.close();
	}
}