package com.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseDmsDeviceAdmin<M extends BaseDmsDeviceAdmin<M>> extends Model<M> implements IBean {

	/**
	 * 设备人员关系Id
	 */
	public void setId(java.math.BigInteger id) {
		set("id", id);
	}
	
	/**
	 * 设备人员关系Id
	 */
	public java.math.BigInteger getId() {
		return get("id");
	}

	/**
	 * 设备 Id
	 */
	public void setDeviceId(java.math.BigInteger deviceId) {
		set("device_id", deviceId);
	}
	
	/**
	 * 设备 Id
	 */
	public java.math.BigInteger getDeviceId() {
		return get("device_id");
	}

	/**
	 * 人员 Id
	 */
	public void setAdminId(java.lang.Long adminId) {
		set("admin_id", adminId);
	}
	
	/**
	 * 人员 Id
	 */
	public java.lang.Long getAdminId() {
		return getLong("admin_id");
	}

	/**
	 * 绑定关系（推广关系-2；场所-3）
	 */
	public void setBindType(java.lang.Integer bindType) {
		set("bind_type", bindType);
	}
	
	/**
	 * 绑定关系（推广关系-2；场所-3）
	 */
	public java.lang.Integer getBindType() {
		return getInt("bind_type");
	}

	/**
	 * 绑定时间
	 */
	public void setBindTime(java.util.Date bindTime) {
		set("bind_time", bindTime);
	}
	
	/**
	 * 绑定时间
	 */
	public java.util.Date getBindTime() {
		return get("bind_time");
	}

	/**
	 * 是否删除（1-未删除，0-已删除）
	 */
	public void setStatusDel(java.lang.Integer statusDel) {
		set("status_del", statusDel);
	}
	
	/**
	 * 是否删除（1-未删除，0-已删除）
	 */
	public java.lang.Integer getStatusDel() {
		return getInt("status_del");
	}

	/**
	 * 设备的编号
	 */
	public void setDeviceSn(java.lang.String deviceSn) {
		set("device_sn", deviceSn);
	}
	
	/**
	 * 设备的编号
	 */
	public java.lang.String getDeviceSn() {
		return getStr("device_sn");
	}

	/**
	 * 时间戳值
	 */
	public void setTime(java.lang.String time) {
		set("time", time);
	}
	
	/**
	 * 时间戳值
	 */
	public java.lang.String getTime() {
		return getStr("time");
	}

}
