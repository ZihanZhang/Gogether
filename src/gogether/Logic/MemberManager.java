package gogether.Logic;

import java.util.ArrayList;

import javax.swing.JList;

public class MemberManager {
	public JList memberList = null;	
	public ArrayList<Member> mma = new ArrayList<Member>();
	public MemberManager() {
	}
	
	public JList setJList() {
		Member[] mm = new Member[50];
		int i = 0;
		for (Member m: mma) {
			mm[i] = m;
			i++;
		}
		memberList = new JList(mm);
		return memberList;
	}
}
