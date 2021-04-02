package com.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseUmsAdminPay<M extends BaseUmsAdminPay<M>> extends Model<M> implements IBean {

	/**
	 * 支付表ID
	 */
	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	/**
	 * 支付表ID
	 */
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * 支付订单号
	 */
	public void setOrderNumber(java.lang.String orderNumber) {
		set("order_number", orderNumber);
	}
	
	/**
	 * 支付订单号
	 */
	public java.lang.String getOrderNumber() {
		return getStr("order_number");
	}

	/**
	 * 1-支付成功2-失败
	 */
	public void setIsPay(java.lang.Integer isPay) {
		set("is_pay", isPay);
	}
	
	/**
	 * 1-支付成功2-失败
	 */
	public java.lang.Integer getIsPay() {
		return getInt("is_pay");
	}

	/**
	 * 支付时间
	 */
	public void setPayTime(java.util.Date payTime) {
		set("pay_time", payTime);
	}
	
	/**
	 * 支付时间
	 */
	public java.util.Date getPayTime() {
		return get("pay_time");
	}

	/**
	 * 支付用户ID
	 */
	public void setAdminId(java.lang.Integer adminId) {
		set("admin_id", adminId);
	}
	
	/**
	 * 支付用户ID
	 */
	public java.lang.Integer getAdminId() {
		return getInt("admin_id");
	}

	/**
	 * 支付的金额
	 */
	public void setPayMoney(java.lang.String payMoney) {
		set("pay_money", payMoney);
	}
	
	/**
	 * 支付的金额
	 */
	public java.lang.String getPayMoney() {
		return getStr("pay_money");
	}

	/**
	 * 实际支付的金额
	 */
	public void setTotalFee(java.lang.String totalFee) {
		set("total_fee", totalFee);
	}
	
	/**
	 * 实际支付的金额
	 */
	public java.lang.String getTotalFee() {
		return getStr("total_fee");
	}

}
