package com.practice.practiceObserver;

public class MemberB implements Member {
	
	FoundationSubject foundation;
	
	public MemberB(FoundationSubject foundation) {
		this.foundation = foundation;
	}

	@Override
	public void raiseMoney() {
		System.out.println("B募完款");
		foundation.addRaiseMoneySuccessCount();
	}

	@Override
	public void calculateCost() {
		System.out.println("B計算完成本");
		foundation.addCalculateCostCuccessCount();
	}

	@Override
	public void reportProfit() {
		System.out.println("B獲利:"+"元");
	}

}
