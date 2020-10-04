package com.practice.practiceObserver;
/**
 * 基金會成員
 * @author 林聖凱
 *
 */
public interface Member {
	/**
	 * 募款
	 */
	public void raiseMoney();
	/**
	 * 計算成本
	 */
	public void calculateCost();
	/**
	 * 回報獲利
	 */
	public void reportProfit();
}
