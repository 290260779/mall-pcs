package com.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseDmsDeviceMaintain<M extends BaseDmsDeviceMaintain<M>> extends Model<M> implements IBean {

	/**
	 * 维修设备列表
	 */
	public void setId(java.math.BigInteger id) {
		set("id", id);
	}
	
	/**
	 * 维修设备列表
	 */
	public java.math.BigInteger getId() {
		return get("id");
	}

	/**
	 * 设备编号
	 */
	public void setDeviceSn(java.lang.String deviceSn) {
		set("device_sn", deviceSn);
	}
	
	/**
	 * 设备编号
	 */
	public java.lang.String getDeviceSn() {
		return getStr("device_sn");
	}

	/**
	 * 设备id
	 */
	public void setDevId(java.math.BigInteger devId) {
		set("dev_id", devId);
	}
	
	/**
	 * 设备id
	 */
	public java.math.BigInteger getDevId() {
		return get("dev_id");
	}

	/**
	 * 维修类型（多个维修选项之间使用;进行分割）
	 */
	public void setMaintainType(java.lang.String maintainType) {
		set("maintain_type", maintainType);
	}
	
	/**
	 * 维修类型（多个维修选项之间使用;进行分割）
	 */
	public java.lang.String getMaintainType() {
		return getStr("maintain_type");
	}

	/**
	 * 快递公司
	 */
	public void setFmsCompany(java.lang.Long fmsCompany) {
		set("fms_company", fmsCompany);
	}
	
	/**
	 * 快递公司
	 */
	public java.lang.Long getFmsCompany() {
		return getLong("fms_company");
	}

	/**
	 * 快递单号
	 */
	public void setFmsNumber(java.lang.String fmsNumber) {
		set("fms_number", fmsNumber);
	}
	
	/**
	 * 快递单号
	 */
	public java.lang.String getFmsNumber() {
		return getStr("fms_number");
	}

	/**
	 * 快递支付类型：1 - 到付；2 - 寄付
	 */
	public void setPayType(java.lang.Long payType) {
		set("pay_type", payType);
	}
	
	/**
	 * 快递支付类型：1 - 到付；2 - 寄付
	 */
	public java.lang.Long getPayType() {
		return getLong("pay_type");
	}

	/**
	 * 寄回地址
	 */
	public void setReturnAddr(java.lang.String returnAddr) {
		set("return_addr", returnAddr);
	}
	
	/**
	 * 寄回地址
	 */
	public java.lang.String getReturnAddr() {
		return getStr("return_addr");
	}

	/**
	 * 损坏图片（多张图片以;分割）
	 */
	public void setDamageImg(java.lang.String damageImg) {
		set("damage_img", damageImg);
	}
	
	/**
	 * 损坏图片（多张图片以;分割）
	 */
	public java.lang.String getDamageImg() {
		return getStr("damage_img");
	}

	/**
	 * 损坏图片描述
	 */
	public void setDamageNote(java.lang.String damageNote) {
		set("damage_note", damageNote);
	}
	
	/**
	 * 损坏图片描述
	 */
	public java.lang.String getDamageNote() {
		return getStr("damage_note");
	}

	/**
	 * 设备维修状态（1-待维修、2-维修中、3-已维修、4-发货完成）
	 */
	public void setDevMaintainStatus(java.lang.Integer devMaintainStatus) {
		set("dev_maintain_status", devMaintainStatus);
	}
	
	/**
	 * 设备维修状态（1-待维修、2-维修中、3-已维修、4-发货完成）
	 */
	public java.lang.Integer getDevMaintainStatus() {
		return getInt("dev_maintain_status");
	}

	/**
	 * 添加设备时间
	 */
	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}
	
	/**
	 * 添加设备时间
	 */
	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	/**
	 * 修改设备状态时间
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		set("update_time", updateTime);
	}
	
	/**
	 * 修改设备状态时间
	 */
	public java.util.Date getUpdateTime() {
		return get("update_time");
	}

}
