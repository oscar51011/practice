package com.practice.practiceObserver;

import java.util.ArrayList;
import java.util.List;

public class MyFoundation implements FoundationSubject {
	
	List<Member> members = new ArrayList<Member>(); // 基金會成員
	private int raiseMoneySuccessCount;				// 募款成功人數
	private int calculateCostCuccessCount;			// 計算成本人數
	
	@Override
	public void registMember(Member member) {
		members.add(member);
	}

	@Override
	public void removeMember(Member member) {
		members.remove(member);
	}

	@Override
	public void notifyMemberRaiseMoney() {
		if(members.isEmpty() || members == null) {
			System.out.println("沒有會員參與，募資結束");
		} else {		
			for(Member member: members) {
				member.raiseMoney();
			}
		}
	}
	
	/*
	 * 告訴基金會募款成功
	 */
	public void addRaiseMoneySuccessCount() {
		this.raiseMoneySuccessCount += 1;
		if(checkEveryBodyRaiseMoneySuccess()) {
			notifyMemberCalaulateCost();
		}
	}
	
	private boolean checkEveryBodyRaiseMoneySuccess() {
		if(raiseMoneySuccessCount == members.size()) {
			System.out.println("所有成員募款完成，請各自成員回去計算該次募款所需支出");
			return true;
		}
		return false;
	}

	private void notifyMemberCalaulateCost() {
		for(Member member: members) {
			member.calculateCost();
		}
	}
	
	/**
	 * 告訴基金會計算成本成功
	 */
	public void addCalculateCostCuccessCount() {
		this.calculateCostCuccessCount += 1;
		if(checkEverybodyCalculateCostSuccess()) {			
			calculateTotalMoney();
		}
			
	}
	
	private boolean checkEverybodyCalculateCostSuccess() {
		if(calculateCostCuccessCount == members.size()) {
			System.out.println("所有成員成本計算完成，開始計算總獲利");
			return true;
		}
		return false;
	}

	private void calculateTotalMoney() {
		System.out.println("計算完金額，通知成員計算各自獲利");
		notifyMemberReportProfit();			
	}

	private void notifyMemberReportProfit() {
		for(Member member: members) {
			member.reportProfit();
		}	
	}
}
