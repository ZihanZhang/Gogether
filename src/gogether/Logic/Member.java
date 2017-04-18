package gogether.Logic;

public class Member {
	public int oldx, oldy, curx, cury, nextx, nexty, pbestx, pbesty, gbestx, gbesty, newx, newy;
	public double w, c1, c2;
	public FastArea fa = new FastArea();
	
	public void setNewLocation() {
		double r1 = Math.random();
		double r2 = Math.random();
		newx = (int) (w * nextx + r1 * c1 * (pbestx - curx) + r2 * c2 * (gbestx - curx));
		newy = (int) (w * nextx + r1 * c1 * (pbesty - cury) + r2 * c2 * (gbesty - cury));	
	}
	
	public void moveToNewLocation() {
		oldx = curx;
		oldy = cury;
		curx = newx;
		cury = newy;
	}
	
	public void setPbestx() {
		int total = 0;
		int num = 0;
		for (int i = -50; i <= 50; i++) {
			for (int j = -50; j <= 50; j++) {
				if (fa.isInFastArea(curx + i, cury + j)) {
					total += i;
					num++;
				}
			}
		}
		if (num != 0) {
			pbestx = curx + total / num;
		}
		else {
			pbestx = curx;
		}
	}
	
	public void setPbesty() {
		int total = 0;
		int num = 0;
		for (int i = -50; i <= 50; i++) {
			for (int j = -50; j <= 50; j++) {
				if (fa.isInFastArea(curx + i, cury + j)) {
					total += j;
					num++;
				}
			}
		}
		if (num != 0) {
			pbesty = cury + total / num;
		}
		else {
			pbesty = cury;
		}
	}
	
	public void setGbestx() {
		gbestx = curx + (700 - curx) / 10;
	}
	
	public void setGbesty() {
		gbesty = cury + (370 - cury) / 10;
	}
	
	public void setNextLocation() {
		nextx = curx + (curx - oldx);
		nexty = cury + (cury - oldy);
	}
	
	
}
