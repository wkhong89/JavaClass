package bear_fish_game;

import java.util.Random;

public class Fish extends GameObject {
	int mvCount;
	int firstMove, secondMove;
	

	public Fish(int startX, int startY, int distance) {
		super(startX, startY, distance);
	}
	
	private boolean doMove() {
		if (mvCount % 5 == 0) {
			mvCount = 0;

			Random rand = new Random();
			firstMove = rand.nextInt(5);
			while ((secondMove = rand.nextInt(5)) == firstMove);
			
		}

		if (mvCount == firstMove || mvCount == secondMove) {
			mvCount++;
			return true;
		}
		else { 
			mvCount++;
			return false;
		}
		
	}

	@Override
	public void move() {
		if (doMove()) {
			Random rand = new Random();
			int direction = rand.nextInt(4);
			
			switch (direction) {
			case 0: // 왼쪽 
				x--;
				if (x < 0) x = 0;
				break;
			case 1:  // 위  
				y--;
				if (y < 0) y = 0;
				break;
			case 2: //  아래 
				y++;
				if (y > 19) y = 19;
				break;
			case 3:  // 오른쪽 
				x++;
				if (x > 9) x = 9;
				break;
			}
			
		}
		
	}

	@Override
	public char getShape() {
		return '@';
	}

}
