package bear_fish_game;

import java.util.Scanner;

public class Bear extends GameObject {
	
	Scanner scan = new Scanner(System.in);

	public Bear(int startX, int startY, int distance) {
		super(startX, startY, distance);
	}

	@Override
	public void move() {
		char in = scan.nextLine().charAt(0);
		
		switch (in) {
		case 'a': 
			y--;
			if (y < 0) y = 0;
			break;
		case 's': 
			x++;
			if (x > 9) x = 9;
			break;
		case 'w': 
			x--;
			if (x < 0) x = 0;
			break;
		case 'd': 
			y++;
			if (y > 19) y = 19;
			break;
		}
		
	}

	@Override
	public char getShape() {
		return 'B';
	}


}
