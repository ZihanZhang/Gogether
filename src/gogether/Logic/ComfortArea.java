package gogether.Logic;

public class ComfortArea {
	public int leftupx, leftupy;
	public int rightdownx, rightdowny;
	
	public boolean isInComArea(int x, int y) {
		if (leftupx <= x && x <= rightdownx && leftupy <= y && y <= rightdowny) {
			return true;
		}
		else {
			return false;
		}
	}
}
