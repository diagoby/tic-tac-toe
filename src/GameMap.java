import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 */

/**
 * @author username
 *
 */
public class GameMap {
	public String[][] field = null;

	public int size = 0;

	public String placeholder = " ";
	public String rowDelimiter = "-";
	public String columnDelimiter = " | ";
	
	public String player = "x";
	public String opponent = "0";
	
	public int step = 10;
	
	/**
	 * 
	 */
	public GameMap(int size) {
		this.size = size;

		this.field = new String[size][size];
		this.fill();
	}
	
	private void fill() {
		for (String[] row : this.field) {
			Arrays.fill(row, this.placeholder);
		}
	}

	public int evaluate() {
		/*
		 * Check for rows
		 * */
		for (String[] row : this.field) {
			if(!isLineComplete(row)) continue;
			
			return calculateScore(row);
		}
		
		/*
		 * Check for columns
		 * */
		for (int i = 0; i < this.size; i++) {
			final String[] col = new String[size]; 

			for (int j = 0; j < this.size; j++) {
				col[j] = field[j][i];
			}
			
			if(!isLineComplete(col)) continue;
			
			return calculateScore(col);
		}
		
		/*
		 * Check for diagonals
		 * */
		final String[] mainDiagonal = new String[size];
		final String[] secDiagonal = new String[size];
		
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if(i == j) {
					secDiagonal[i] = this.field[i][j];
				}
				
				if(i + j == this.size - 1) {
					mainDiagonal[i] = this.field[i][j];
				}
			}
		}

		if(isLineComplete(mainDiagonal)) {
			return calculateScore(mainDiagonal);
		}
		
		if(isLineComplete(secDiagonal)) {
			return calculateScore(secDiagonal);
		}

		return 0;
	}
	
	public int minimax(boolean isMax) {
		int score = this.evaluate();
		
		if (score == this.step) return score;
		if (score == -this.step) return score;
		if (!isMovesLeft()) return 0; /* It's a tie */
		
		int best = isMax ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		String actor = isMax ? this.player : this.opponent;
		
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (!this.field[i][j].equals(this.placeholder)) continue;
				
				this.field[i][j] = actor;
				
				best = isMax 
					? Math.max(best, minimax(!isMax))
					: Math.min(best, minimax(!isMax));
				
				this.field[i][j] = this.placeholder;
			}
		}

		return best;
	}
	 
	public Move findBestMove() { 
		int best = Integer.MIN_VALUE;
		Move bestMove = new Move();
	
		for (int i = 0; i < this.size; i++) { 
			for (int j = 0; j < this.size; j++) { 
				if (this.field[i][j].equals(this.placeholder)) { 
					this.field[i][j] = this.player; 
					int moveVal = minimax(false); 
					this.field[i][j] = this.placeholder; 

					if (moveVal > best) { 
						bestMove.row = i; 
						bestMove.col = j; 
						best = moveVal; 
					} 
				} 
			} 
		}
	
		return bestMove;
	}
	
	public boolean isMovesLeft() {
		return Stream.of(this.field)
			.flatMap(Stream::of)
			.anyMatch(value -> value.equals(this.placeholder));
	}
	
	private int calculateScore(String[] line) {
		int score = 0;

		if(line[0].equals(this.player)) {
			score = this.step;
		} else if(line[0].equals(this.opponent)) {
			score = -this.step;
		}

		return score;
	}
	
	private boolean isLineComplete(String[] line) {
		return Arrays.stream(line).distinct().count() == 1;
	}

	public void makeMove(Move move, String symbol) {
		this.field[move.row][move.col] = symbol;
	}

	public String draw() {
		String delimiter = String
			.format("%n%s%n", this.rowDelimiter.repeat(3 * this.size + this.size - 1));
		// String delimiter = String
		// 	.format("%n%s%n", this.rowDelimiter.repeat(3 * this.size + this.size - 1));

		String out = Stream.of(this.field)
			.map((row) -> " " + String.join(this.columnDelimiter, row) + " ")
			.collect(Collectors.joining(delimiter));

		// System.out.printf("%s%n", out);
		return out;
	}

	public String getWinner() {
		int score = this.evaluate();

		if(score == 0) return "";
 
		return score == this.step ? this.player : this.opponent;
	}
	
	public class Move {
		int row;
		int col;
		
		public Move() {}
		
		public Move(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		@Override
		public String toString() {
			return this.row + ", " + this.col;
		}
	}
}




