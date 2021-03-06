package com.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseDdmsHotelDistRelation<M extends BaseDdmsHotelDistRelation<M>> extends Model<M> implements IBean {

	/**
	 * 场所与分成方案的关联关系
	 */
	public void setId(java.lang.Long id) {
		set("id", id);
	}
	
	/**
	 * 场所与分成方案的关联关系
	 */
	public java.lang.Long getId() {
		return getLong("id");
	}

	/**
	 * 场所Id
	 */
	public void setHotelId(java.math.BigInteger hotelId) {
		set("hotel_id", hotelId);
	}
	
	/**
	 * 场所Id
	 */
	public java.math.BigInteger getHotelId() {
		return get("hotel_id");
	}

	/**
	 * 分成方案表的Id
	 */
	public void setDistId(java.lang.Long distId) {
		set("dist_id", distId);
	}
	
	/**
	 * 分成方案表的Id
	 */
	public java.lang.Long getDistId() {
		return getLong("dist_id");
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
