package com.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseDmsDeviceStatus<M extends BaseDmsDeviceStatus<M>> extends Model<M> implements IBean {

	/**
	 * 设备Id
	 */
	public void setDeviceId(java.math.BigInteger deviceId) {
		set("device_id", deviceId);
	}
	
	/**
	 * 设备Id
	 */
	public java.math.BigInteger getDeviceId() {
		return get("device_id");
	}

	/**
	 * 设备激活状态（0-未激活、1-已激活）
	 */
	public void setDevActivate(java.lang.Boolean devActivate) {
		set("dev_activate", devActivate);
	}
	
	/**
	 * 设备激活状态（0-未激活、1-已激活）
	 */
	public java.lang.Boolean getDevActivate() {
		return get("dev_activate");
	}

	/**
	 * 设备运行状态 （1-正常 2-故障 3-离线 4-待维修 5-报废）
	 */
	public void setDevRun(java.lang.Integer devRun) {
		set("dev_run", devRun);
	}
	
	/**
	 * 设备运行状态 （1-正常 2-故障 3-离线 4-待维修 5-报废）
	 */
	public java.lang.Integer getDevRun() {
		return getInt("dev_run");
	}

	/**
	 * 设备绑定状态
	 */
	public void setDevBind(java.lang.Integer devBind) {
		set("dev_bind", devBind);
	}
	
	/**
	 * 设备绑定状态
	 */
	public java.lang.Integer getDevBind() {
		return getInt("dev_bind");
	}

	/**
	 * 设备缺货状态（0-缺货；1-不缺货）
	 */
	public void setDevStock(java.lang.Long devStock) {
		set("dev_stock", devStock);
	}
	
	/**
	 * 设备缺货状态（0-缺货；1-不缺货）
	 */
	public java.lang.Long getDevStock() {
		return getLong("dev_stock");
	}

	/**
	 * 设备售后状态
	 */
	public void setDevSaleAfter(java.lang.Integer devSaleAfter) {
		set("dev_sale_after", devSaleAfter);
	}
	
	/**
	 * 设备售后状态
	 */
	public java.lang.Integer getDevSaleAfter() {
		return getInt("dev_sale_after");
	}

	/**
	 * 设备投资状态（0:-不是投资设备；1-是投资设备）
	 */
	public void setDevInvest(java.lang.Boolean devInvest) {
		set("dev_invest", devInvest);
	}
	
	/**
	 * 设备投资状态（0:-不是投资设备；1-是投资设备）
	 */
	public java.lang.Boolean getDevInvest() {
		return get("dev_invest");
	}

}
