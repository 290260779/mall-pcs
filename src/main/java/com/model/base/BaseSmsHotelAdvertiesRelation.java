package com.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSmsHotelAdvertiesRelation<M extends BaseSmsHotelAdvertiesRelation<M>> extends Model<M> implements IBean {

	/**
	 * 酒店与广告的关联关系
	 */
	public void setId(java.math.BigInteger id) {
		set("id", id);
	}
	
	/**
	 * 酒店与广告的关联关系
	 */
	public java.math.BigInteger getId() {
		return get("id");
	}

	/**
	 * 酒店 Id
	 */
	public void setHotelId(java.lang.Long hotelId) {
		set("hotel_id", hotelId);
	}
	
	/**
	 * 酒店 Id
	 */
	public java.lang.Long getHotelId() {
		return getLong("hotel_id");
	}

	/**
	 * 首页轮播广告 Id
	 */
	public void setAdvertise(java.lang.Long advertise) {
		set("advertise", advertise);
	}
	
	/**
	 * 首页轮播广告 Id
	 */
	public java.lang.Long getAdvertise() {
		return getLong("advertise");
	}

	/**
	 * 是否删除该关联关系（0-已删除；1-未删除）
	 */
	public void setStatusDel(java.lang.Boolean statusDel) {
		set("status_del", statusDel);
	}
	
	/**
	 * 是否删除该关联关系（0-已删除；1-未删除）
	 */
	public java.lang.Boolean getStatusDel() {
		return get("status_del");
	}

	/**
	 * 绑定/解绑时间
	 */
	public void setOpTime(java.util.Date opTime) {
		set("op_time", opTime);
	}
	
	/**
	 * 绑定/解绑时间
	 */
	public java.util.Date getOpTime() {
		return get("op_time");
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
