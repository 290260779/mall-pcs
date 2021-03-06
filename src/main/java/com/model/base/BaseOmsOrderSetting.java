package com.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseOmsOrderSetting<M extends BaseOmsOrderSetting<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}
	
	public java.lang.Long getId() {
		return getLong("id");
	}

	/**
	 * 秒杀订单超时关闭时间(分)
	 */
	public void setFlashOrderOvertime(java.lang.Integer flashOrderOvertime) {
		set("flash_order_overtime", flashOrderOvertime);
	}
	
	/**
	 * 秒杀订单超时关闭时间(分)
	 */
	public java.lang.Integer getFlashOrderOvertime() {
		return getInt("flash_order_overtime");
	}

	/**
	 * 正常订单超时时间(分)
	 */
	public void setNormalOrderOvertime(java.lang.Integer normalOrderOvertime) {
		set("normal_order_overtime", normalOrderOvertime);
	}
	
	/**
	 * 正常订单超时时间(分)
	 */
	public java.lang.Integer getNormalOrderOvertime() {
		return getInt("normal_order_overtime");
	}

	/**
	 * 发货后自动确认收货时间（天）
	 */
	public void setConfirmOvertime(java.lang.Integer confirmOvertime) {
		set("confirm_overtime", confirmOvertime);
	}
	
	/**
	 * 发货后自动确认收货时间（天）
	 */
	public java.lang.Integer getConfirmOvertime() {
		return getInt("confirm_overtime");
	}

	/**
	 * 自动完成交易时间，不能申请售后（天）
	 */
	public void setFinishOvertime(java.lang.Integer finishOvertime) {
		set("finish_overtime", finishOvertime);
	}
	
	/**
	 * 自动完成交易时间，不能申请售后（天）
	 */
	public java.lang.Integer getFinishOvertime() {
		return getInt("finish_overtime");
	}

	/**
	 * 订单完成后自动好评时间（天）
	 */
	public void setCommentOvertime(java.lang.Integer commentOvertime) {
		set("comment_overtime", commentOvertime);
	}
	
	/**
	 * 订单完成后自动好评时间（天）
	 */
	public java.lang.Integer getCommentOvertime() {
		return getInt("comment_overtime");
	}

}
