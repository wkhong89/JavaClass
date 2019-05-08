package bear_fish_game;

import java.util.Random;

public class Game {
	static char[][] grid = new char[10][20];
	
	public static void drawGrid(Bear bear, Fish fish) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++)
				grid[i][j] = '-';
		}
		
		grid[fish.getX()][fish.getY()] = fish.getShape();
		grid[bear.getX()][bear.getY()] = bear.getShape();
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		Random rand = new Random();
		int pos = rand.nextInt(200);
		int posX, posY;

		Bear bear = new Bear(0, 0, 1);
		posX = pos/20; // 199/20 = 9
		posY = pos%20; // 199%20 = 19
		Fish fish = new Fish(posX, posY, 1);
		System.out.println("** Bear의 Fish 먹기 게임을 시작합니다.**");
		while (!bear.collide(fish)) {
			drawGrid(bear, fish);
			System.out.print("왼쪽(a), 아래(s), 위(w), 오른쪽(d) >> ");
			bear.move();
			fish.move();
		}
		drawGrid(bear, fish);
		System.out.println("Bear Wins!!");


	}

}
