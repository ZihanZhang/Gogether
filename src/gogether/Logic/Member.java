package gogether.Logic;

public class Member {
	public int curx, cury, nextx, nexty, pbestx, pbesty, gbestx, gbesty, newx, newy;
	public double w, c1, c2;
	
	public void setNewLocation() {
		double r1 = Math.random();
		double r2 = Math.random();
		newx = (int) (w * nextx + r1 * c1 * (pbestx - curx) + r2 * c2 * (gbestx - curx));
		newy = (int) (w * nextx + r1 * c1 * (pbesty - cury) + r2 * c2 * (gbesty - cury));	
	}
	
	public void moveToNewLocation() {
		curx = newx;
		cury = newy;
	}
}
