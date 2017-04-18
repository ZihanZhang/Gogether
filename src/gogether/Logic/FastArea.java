package gogether.Logic;

public class FastArea {
	public int leftupx, leftupy;
	public int rightdownx, rightdowny;
	
	public boolean isInFastArea(int x, int y) {
		if (leftupx <= x && x <= rightdownx && rightdowny <= y && y <= leftupy) {
			return true;
		}
		else {
			return false;
		}
	}
}
