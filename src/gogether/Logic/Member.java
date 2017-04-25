package gogether.Logic;

import java.util.ArrayList;

public class Member {
	public int oldx, oldy, curx, cury, nextx, nexty, pbestx, pbesty, gbestx, gbesty, newx, newy;
	public int destx, desty, depax, depay;
	public int preference;
	public double w, c1, c2;
	public ArrayList<FastArea> fas = new ArrayList<FastArea>();
	public ArrayList<ComfortArea> cas = new ArrayList<ComfortArea>();
	public ArrayList<NoPassArea> npas = new ArrayList<NoPassArea>();
	
	public Member(int destx, int desty, int depax, int depay) {
		this.depax = depax;
		this.depay = depay;
		this.destx = destx;
		this.desty = desty;
	}
	
	public void setNewLocation() {
		double r1 = Math.random();
		double r2 = Math.random();
		newx = (int) (w * nextx + r1 * c1 * (pbestx - curx) + r2 * c2 * (gbestx - curx));
		newy = (int) (w * nexty + r1 * c1 * (pbesty - cury) + r2 * c2 * (gbesty - cury));	
	}
	
	public void moveToNewLocation() {
		oldx = curx;
		oldy = cury;
		curx = newx;
		cury = newy;
	}
	
	//Fast Particle Best
	public void setPbestxFast() {
		
		if (curx < destx + 100 && curx > destx - 100 && cury < desty + 100 && cury > desty - 100) {
			pbestx = destx;
		}
		
		int total = 0;
		int num = 0;
		for (int i = -50; i <= 50; i++) {
			for (int j = -50; j <= 50; j++) {
				for (FastArea fa: fas) {
					if (fa.isInFastArea(curx + i, cury + j)) {
						total += i;
						num++;
					}
				}
			}
		}

		if (num != 0 && total > 0) {
			pbestx = curx + total / num;
		}
		else {
			pbestx = curx;
		}
	}
	
	public void setPbestyFast() {
		
		if (curx < destx + 100 && curx > destx - 100 && cury < desty + 100 && cury > desty - 100) {
			pbesty = desty;
		}

		int total = 0;
		int num = 0;
		for (int i = -50; i <= 50; i++) {
			for (int j = -50; j <= 50; j++) {
				for (FastArea fa: fas) {
					if (fa.isInFastArea(curx + i, cury + j)) {
						total += j;
						num++;
					}
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
	
	//Comfort Particle Best
	public void setPbestxCom() {
		
		if (curx < destx + 100 && curx > destx - 100 && cury < desty + 100 && cury > desty - 100) {
			pbestx = destx;
		}
		
		int total = 0;
		int num = 0;
		for (int i = -50; i <= 50; i++) {
			for (int j = -50; j <= 50; j++) {
				for (ComfortArea ca: cas) {
					if (ca.isInComArea(curx + i, cury + j)) {
						total += i;
						num++;
					}
				}
			}
		}
		if (num != 0 && total > 0) {
			pbestx = curx + total / num;
		}
		else {
			pbestx = curx;
		}
	}
	
	public void setPbestyCom() {
		
		if (curx < destx + 100 && curx > destx - 100 && cury < desty + 100 && cury > desty - 100) {
			pbesty = desty;
		}
		
		int total = 0;
		int num = 0;
		for (int i = -50; i <= 50; i++) {
			for (int j = -50; j <= 50; j++) {
				for (ComfortArea ca: cas) {
					if (ca.isInComArea(curx + i, cury + j)) {
						total += j;
						num++;
					}
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
		gbestx = curx + (destx - curx) / 10;
	}
	
	public void setGbesty() {
		gbesty = cury + (desty - cury) / 10;
	}
	
	public void setNextLocation() {
		nextx = curx + (curx - oldx);
		nexty = cury + (cury - oldy);
	}
	
	public void avoidNoPassArea() {
		for(NoPassArea npa:npas) {
			int nearSide;
			if (npa.isInNoPassArea(newx, newy)) {
//				System.out.println(newx + " " + newy);
				nearSide = npa.nearSide(newx, newy);
//				System.out.println(nearSide);
				if (nearSide == 1) {
					newy = npa.leftupy;
				}
				if (nearSide == 2) {
					newx = npa.rightdownx;
				}
				if (nearSide == 3) {
					newy = npa.rightdowny;
				}
				if (nearSide == 4) {
					newx = npa.leftupx;
				}
			}
		}
	}
	
}
