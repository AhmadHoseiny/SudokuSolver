import java.util.Scanner; 

public class SudokuBoard {
	private static final int BoardSize = 9; 
	private int [][] Board ;
	public SudokuBoard(){
		Board = new int [BoardSize][BoardSize];
	}
	public int getValue(int row , int column){
		return Board[row][column];
	}
	public void setValue(int row , int column , int number){
		 Board[row][column] = number;
	}
	public void insertBoard(){
		for(int i=0 ; i<BoardSize ; i++){
			for(int j=0 ; j<BoardSize ; j++){
				Scanner sc = new Scanner(System.in);
				int x = sc.nextInt();
				this.setValue(i, j, x);
			}
		}
	}
	public int getSize(){
		return BoardSize ;
	}
	public void printBoard(){
		for(int i=0 ; i<BoardSize ; i++){
			if(i%3==0 && i!=0){
				System.out.println("___________");
				System.out.println();
			}
			for(int j=0 ; j<BoardSize ; j++){
				if(j%3==0 && j!=0){
					System.out.print("|");
				}
				System.out.print(this.getValue(i, j));
			}
			System.out.println();
		}
	}
	
}
