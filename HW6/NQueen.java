import java.util.*;
public class NQueen{
	public static void main(String[] args){
		
		Queue<int[][]> q = new PriorityQueue<>();
		
		int[][] board = new int[4][4];
		Position[] pos = new Position[4];
		
		for(int i = 0; i<4; i++)
			pos[i] = new Position();
		/*
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++)
				System.out.printf("%d ", board[i][j]);
			
			System.out.println();
		}
		*/
		boolean notSave = false, solve = false, notAllSolve = true;
		int currentColumn, currentRow, N = 4;
		
		//while(notAllSolve){
		for(currentColumn = 0; currentColumn < N; currentColumn++){
			if(pos[currentColumn].row >= N && currentColumn > -1){
				System.out.println(pos[currentColumn].row);
				pos[currentColumn].row = 0;
				System.out.println(pos[currentColumn].row);
				currentColumn--;
				System.out.println(currentColumn);
				if(currentColumn >= 0){
					board[pos[currentColumn].row++][currentColumn] = 0;
					System.out.println(board[pos[currentColumn].row][currentColumn]);
				}				
			}		
			if(currentColumn < 0) 
			{
				
				break;
			}
			for(currentRow = pos[currentColumn].row; currentRow < N; currentRow++){	
				//Loop to check left side
				for(int j = currentColumn; j >= 0; j--){
					if(board[currentRow][j] == 1){
						notSave = true;
						break;
					}
				}
		
				//Loop to check left diagonal
				for(int i = currentRow, j = currentColumn; i >= 0 && j >= 0; i--, j--){
					if(board[i][j] == 1){
						notSave = true;
						break;
					}
				}
		
				//Loop to check 
				for(int i = currentRow, j = currentColumn; i <N && j >= 0; i++, j--){
					if(board[i][j] == 1){
						notSave = true;
						break;
					}
				}
				
				if(!notSave){
					board[currentRow][currentColumn] = 1;
					pos[currentColumn].row = currentRow;
					
					//pos[currentColumn].col = currentColumn;
					break;
				}
				notSave = false;
				pos[currentColumn].row = 0;
				if(currentRow == N-1){
				if(currentColumn-1 < 0)
					break;
				board[pos[currentColumn-1].row++][currentColumn-1] = 0;
				currentColumn -= 2;
				}
			}
			/*
			if(currentColumn == N-1)
				solve = true;
			*/
			print(board);
			System.out.println(pos[currentColumn].row);
		}
		
		
	}
		
	public static void print(int[][] board){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++)
				System.out.printf("%d ", board[i][j]);
			
			System.out.println();
		}
	System.out.println();
	}
}	


class Position{
	public int row = 0;
	//public int col = 0;
}