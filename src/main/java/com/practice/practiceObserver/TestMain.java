package com.practice.practiceObserver;

public class TestMain {

	public static void main(String[] args) {
		
		// 建立一個基金會
		FoundationSubject foundation = new MyFoundation();
		// 成員 A , B加入基金會
		Member memberA =new MemberA(foundation);
		foundation.registMember(memberA);
		
		Member memberB =new MemberB(foundation);		
		foundation.registMember(memberB);
		
		// 基金會開始募款
		foundation.notifyMemberRaiseMoney();
		
	}
}
