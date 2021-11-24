
public class SudokuSolver {
	public static boolean isInRow(int number , int row , SudokuBoard s){
		for(int i=0 ; i<s.getSize() ; i++){
			if (s.getValue(row, i)==number)
				return true ;
		}
		return false ;
	}
	public static boolean isInColumn(int number , int Column , SudokuBoard s){
		for(int i=0 ; i<s.getSize() ; i++){
			if (s.getValue(i,Column)==number)
				return true ;
		}
		return false ;
	}
	public static boolean isInSquare(int number , int row , int Column , SudokuBoard s){
		int squareUpLeftRow = row - row%3 ;
		int squareUpLeftColumn = Column - Column%3 ;
		for(int i=squareUpLeftRow ; i<squareUpLeftRow+3 ; i++){
			for(int j=squareUpLeftColumn ; j< squareUpLeftColumn +3 ; j++){
				if (s.getValue(i,j)==number)
					return true ;
			}
		}
		return false ;
	}
	public static boolean isValid (int number , int row , int Column , SudokuBoard s){
		return (!isInRow(number , row , s)&&
				!isInColumn(number , Column , s) &&
				!isInSquare(number , row , Column , s)) ;
	} 
	public static boolean solve ( SudokuBoard s){
		
		for( int row=0 ; row<s.getSize() ; row++){
			for(int Column=0 ; Column<s.getSize() ; Column++){
				if(s.getValue(row, Column)==0){
					for(int numTest=1 ; numTest<=s.getSize() ; numTest++){
						if(isValid(numTest , row , Column , s)){
							s.setValue(row,Column,numTest );
							if(solve(s)){
								return true ;
							}
							else{
								s.setValue(row, Column, 0);
							}
						}
					}
					return false ;
				}
			}
		}
		return true ;
	}
	
	public static void main (String[] args){
		SudokuBoard s1 = new SudokuBoard();
		// Here, a user should enter values already existing in a sudoku board 
		// If a cell is empty, zero should be entered 
		s1.insertBoard();
		if(solve(s1)){
			s1.printBoard();
		}
		else{
			System.out.println("The sudoku board you entered is unsolvable");
		}
		
		
	}
	
}
