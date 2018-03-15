/*
	NQueen problem, prints all solutions and prints out how many solutions there are.
	I use a board of 1 and 0, 0 indicating empty spot and 1 indicating a queen.
	Using backtracking and non-recursive.
	Resources:
	https://www.geeksforgeeks.org/printing-solutions-n-queen-problem/
	https://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
	https://see.stanford.edu/materials/icspacs106b/H19-RecBacktrackExamples.pdf
*/

import java.util.ArrayList;
import java.util.Scanner;

public class NQueen_2{
	public static void main(String[] args){
		int N;
		boolean notSave = false;
		int currentColumn, currentRow;
		ArrayList<int[][]> arr = new ArrayList<>();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the N value to solve the NQueen problem: ");
		N = scan.nextInt();
		
		int[][] board = new int[N][N];
		int[] row = new int[N];
		
		mywhile:
		while(true){
			for(currentColumn = 0; currentColumn < N; currentColumn++){
				if(row[currentColumn] >= N && currentColumn > -1){
					row[currentColumn] = 0;
					currentColumn--;
					if(currentColumn >= 0){
						board[row[currentColumn]++][currentColumn] = 0;
					}				
				}		
				if(currentColumn < 0) {
					break mywhile;
				}
				for(currentRow = row[currentColumn]; currentRow < N; currentRow++){	
					//Loop to check left side
					for(int j = currentColumn; j >= 0; j--){
						if(board[currentRow][j] == 1){
							notSave = true;
							break;
						}
					}
		
					//Loop to check left diagonal up
					for(int i = currentRow, j = currentColumn; i >= 0 && j >= 0; i--, j--){
						if(board[i][j] == 1){
							notSave = true;
							break;
						}
					}
		
					//Loop to check left diagonal down
					for(int i = currentRow, j = currentColumn; i <N && j >= 0; i++, j--){
						if(board[i][j] == 1){
							notSave = true;
							break;
						}
					}
					
					//It is a save position, mark 1 for Queen.
					if(!notSave){
						board[currentRow][currentColumn] = 1;
						row[currentColumn] = currentRow;
						break;
					}
				
					notSave = false;
					row[currentColumn] = 0;
				
					if(currentRow == N-1){
						board[row[currentColumn-1]++][currentColumn-1] = 0;
						currentColumn -= 2;
					}
				}
			}
		
			row[0]++;
			
			//add to arraylist if it is a solution
			arr.add(board);
			
			//if there are more solutions, make new board
			if(row[0] < N){
				board = new int[N][N];
			
				for(int i = 1; i < N; i++){
					row[i] = 0;
				}
			}else break;
		}
		
		System.out.printf("\n\nThere are %d solutions\n\n", arr.size());
		
		for(int[][] b:arr)
			print(b);
	}
		
	public static void print(int[][] board){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++)
				System.out.printf("%d ", board[i][j]);
			
			System.out.println();
		}
	System.out.println();
	}
}	
