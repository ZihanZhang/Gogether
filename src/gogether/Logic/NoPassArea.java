package gogether.Logic;

public class NoPassArea {
	public int leftupx, leftupy;
	public int rightdownx, rightdowny;
	
	public boolean isInNoPassArea(int x, int y) {
		if (leftupx <= x && x <= rightdownx && leftupy <= y && y <= rightdowny) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int nearSide(int x, int y) {
		
		int disToLeft = x - leftupx;
		int disToRight = rightdownx - x;
		int disToUp = y - leftupy;
		int disToDown = rightdowny - y;
		
//		System.out.println(x + " " + y);
//		System.out.println(disToLeft);
//		System.out.println(disToRight);
//		System.out.println(disToUp);
//		System.out.println(disToDown);
		
		int min = disToLeft;
		int num = 4;
		
		if (disToRight < min) {
			min = disToRight;
			num = 2;
		}
		
		if (disToUp < min) {
			min = disToUp;
			num = 1;
		}
		
		if (disToDown < min) {
			min = disToDown;
			num = 3;
		}		
		return num;
	}
}
