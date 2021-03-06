package com.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BasePlanProductHotel<M extends BasePlanProductHotel<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}
	
	public java.lang.Long getId() {
		return getLong("id");
	}

	/**
	 * 商品方案Id
	 */
	public void setPlanId(java.lang.Integer planId) {
		set("plan_id", planId);
	}
	
	/**
	 * 商品方案Id
	 */
	public java.lang.Integer getPlanId() {
		return getInt("plan_id");
	}

	/**
	 * 酒店Id
	 */
	public void setHotelId(java.lang.Integer hotelId) {
		set("hotel_id", hotelId);
	}
	
	/**
	 * 酒店Id
	 */
	public java.lang.Integer getHotelId() {
		return getInt("hotel_id");
	}

	/**
	 * 删除状态（0-false-已删除、1-true-未删除）
	 */
	public void setStatusDel(java.lang.Boolean statusDel) {
		set("status_del", statusDel);
	}
	
	/**
	 * 删除状态（0-false-已删除、1-true-未删除）
	 */
	public java.lang.Boolean getStatusDel() {
		return get("status_del");
	}

	/**
	 * 备注
	 */
	public void setNote(java.lang.String note) {
		set("note", note);
	}
	
	/**
	 * 备注
	 */
	public java.lang.String getNote() {
		return getStr("note");
	}

}
