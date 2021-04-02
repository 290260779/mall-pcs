package com.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseDmsDeviceMode<M extends BaseDmsDeviceMode<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}
	
	public java.lang.Long getId() {
		return getLong("id");
	}

	/**
	 * 型号名称
	 */
	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	/**
	 * 型号名称
	 */
	public java.lang.String getName() {
		return getStr("name");
	}

	/**
	 * 型号编号
	 */
	public void setModelSn(java.lang.String modelSn) {
		set("model_sn", modelSn);
	}
	
	/**
	 * 型号编号
	 */
	public java.lang.String getModelSn() {
		return getStr("model_sn");
	}

	/**
	 * 格子方案
	 */
	public void setCellPlan(java.lang.String cellPlan) {
		set("cell_plan", cellPlan);
	}
	
	/**
	 * 格子方案
	 */
	public java.lang.String getCellPlan() {
		return getStr("cell_plan");
	}

	/**
	 * 设备类型（1-普通售货机；2-充电线）
	 */
	public void setDeviceType(java.lang.Long deviceType) {
		set("device_type", deviceType);
	}
	
	/**
	 * 设备类型（1-普通售货机；2-充电线）
	 */
	public java.lang.Long getDeviceType() {
		return getLong("device_type");
	}

	/**
	 * 格子数（该型号设备的格子数）
	 */
	public void setCellNum(java.lang.Integer cellNum) {
		set("cell_num", cellNum);
	}
	
	/**
	 * 格子数（该型号设备的格子数）
	 */
	public java.lang.Integer getCellNum() {
		return getInt("cell_num");
	}

	/**
	 * 开柜次数
	 */
	public void setOpenTimes(java.lang.Integer openTimes) {
		set("open_times", openTimes);
	}
	
	/**
	 * 开柜次数
	 */
	public java.lang.Integer getOpenTimes() {
		return getInt("open_times");
	}

	/**
	 * 购买成功之后的重新开柜时间（min）
	 */
	public void setOpenAgainTime(java.lang.Integer openAgainTime) {
		set("open_again_time", openAgainTime);
	}
	
	/**
	 * 购买成功之后的重新开柜时间（min）
	 */
	public java.lang.Integer getOpenAgainTime() {
		return getInt("open_again_time");
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