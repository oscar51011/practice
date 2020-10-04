package com.practice.practiceObserver;

/**
 * 基金會主題
 * @author 林聖凱
 *
 */
public interface FoundationSubject {
	/**
	 * 加入基金會
	 * @param member
	 */
	void registMember(Member member);
	/**
	 * 離開基金會
	 * @param member
	 */
	void removeMember(Member member);
	/**
	 * 通知 成員募款
	 */
	void notifyMemberRaiseMoney();
	/**
	 * 成員回報募款完成
	 */
	void addRaiseMoneySuccessCount();
	/**
	 * 成員回報 成本計算完成
	 */
	void addCalculateCostCuccessCount();
}
