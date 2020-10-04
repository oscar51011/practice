package com.practice.practiceObserver;

public class MemberA implements Member {
	
	FoundationSubject foundation;
	
	public MemberA(FoundationSubject foundation) {
		this.foundation = foundation;
	}

	@Override
	public void raiseMoney() {
		System.out.println("A募完款");
		foundation.addRaiseMoneySuccessCount();
	}

	@Override
	public void calculateCost() {
		System.out.println("A計算完成本");
		foundation.addCalculateCostCuccessCount();
	}

	@Override
	public void reportProfit() {
		System.out.println("A獲利:"+"元");
	}
}
