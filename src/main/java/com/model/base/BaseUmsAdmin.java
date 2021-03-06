package com.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseUmsAdmin<M extends BaseUmsAdmin<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}
	
	public java.lang.Long getId() {
		return getLong("id");
	}

	/**
	 * 用户名
	 */
	public void setUsername(java.lang.String username) {
		set("username", username);
	}
	
	/**
	 * 用户名
	 */
	public java.lang.String getUsername() {
		return getStr("username");
	}

	/**
	 * 密码
	 */
	public void setPassword(java.lang.String password) {
		set("password", password);
	}
	
	/**
	 * 密码
	 */
	public java.lang.String getPassword() {
		return getStr("password");
	}

	/**
	 * 联系人名称
	 */
	public void setContact(java.lang.String contact) {
		set("contact", contact);
	}
	
	/**
	 * 联系人名称
	 */
	public java.lang.String getContact() {
		return getStr("contact");
	}

	/**
	 * 手机号码（联系方式）
	 */
	public void setMobile(java.lang.String mobile) {
		set("mobile", mobile);
	}
	
	/**
	 * 手机号码（联系方式）
	 */
	public java.lang.String getMobile() {
		return getStr("mobile");
	}

	/**
	 * 用户地区
	 */
	public void setRegion(java.lang.String region) {
		set("region", region);
	}
	
	/**
	 * 用户地区
	 */
	public java.lang.String getRegion() {
		return getStr("region");
	}

	/**
	 * 上级用户Id
	 */
	public void setParentId(java.math.BigInteger parentId) {
		set("parent_id", parentId);
	}
	
	/**
	 * 上级用户Id
	 */
	public java.math.BigInteger getParentId() {
		return get("parent_id");
	}

	/**
	 * 结算方式（1-手动结算、2-自动结算、3-月结）
	 */
	public void setSettleType(java.lang.Long settleType) {
		set("settle_type", settleType);
	}
	
	/**
	 * 结算方式（1-手动结算、2-自动结算、3-月结）
	 */
	public java.lang.Long getSettleType() {
		return getLong("settle_type");
	}

	/**
	 * 分成比例（x%）
	 */
	public void setShareRatio(java.math.BigDecimal shareRatio) {
		set("share_ratio", shareRatio);
	}
	
	/**
	 * 分成比例（x%）
	 */
	public java.math.BigDecimal getShareRatio() {
		return get("share_ratio");
	}

	/**
	 * 是否发送短信
	 */
	public void setSendMsg(java.lang.Boolean sendMsg) {
		set("send_msg", sendMsg);
	}
	
	/**
	 * 是否发送短信
	 */
	public java.lang.Boolean getSendMsg() {
		return get("send_msg");
	}

	/**
	 * 用户头像
	 */
	public void setIcon(java.lang.String icon) {
		set("icon", icon);
	}
	
	/**
	 * 用户头像
	 */
	public java.lang.String getIcon() {
		return getStr("icon");
	}

	/**
	 * 小程序用户的openId
	 */
	public void setOpenId(java.lang.String openId) {
		set("open_id", openId);
	}
	
	/**
	 * 小程序用户的openId
	 */
	public java.lang.String getOpenId() {
		return getStr("open_id");
	}

	/**
	 * 邮箱
	 */
	public void setEmail(java.lang.String email) {
		set("email", email);
	}
	
	/**
	 * 邮箱
	 */
	public java.lang.String getEmail() {
		return getStr("email");
	}

	/**
	 * 昵称小程序名称
	 */
	public void setNickName(java.lang.String nickName) {
		set("nick_name", nickName);
	}
	
	/**
	 * 昵称小程序名称
	 */
	public java.lang.String getNickName() {
		return getStr("nick_name");
	}

	/**
	 * 备注信息
	 */
	public void setNote(java.lang.String note) {
		set("note", note);
	}
	
	/**
	 * 备注信息
	 */
	public java.lang.String getNote() {
		return getStr("note");
	}

	/**
	 * 创建时间
	 */
	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}
	
	/**
	 * 创建时间
	 */
	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	/**
	 * 最后登录时间
	 */
	public void setLoginTime(java.util.Date loginTime) {
		set("login_time", loginTime);
	}
	
	/**
	 * 最后登录时间
	 */
	public java.util.Date getLoginTime() {
		return get("login_time");
	}

	/**
	 * 帐号启用状态：0->禁用；1->启用
	 */
	public void setStatus(java.lang.Integer status) {
		set("status", status);
	}
	
	/**
	 * 帐号启用状态：0->禁用；1->启用
	 */
	public java.lang.Integer getStatus() {
		return getInt("status");
	}

	/**
	 * 用户的token
	 */
	public void setToken(java.lang.String token) {
		set("token", token);
	}
	
	/**
	 * 用户的token
	 */
	public java.lang.String getToken() {
		return getStr("token");
	}

	/**
	 * 每次给这个用户分成的时候，需要扣除的手续费
	 */
	public void setServiceRate(java.math.BigDecimal serviceRate) {
		set("service_rate", serviceRate);
	}
	
	/**
	 * 每次给这个用户分成的时候，需要扣除的手续费
	 */
	public java.math.BigDecimal getServiceRate() {
		return get("service_rate");
	}

	/**
	 * 售后服务电话
	 */
	public void setSalesOphone(java.lang.String salesOphone) {
		set("sales_ophone", salesOphone);
	}
	
	/**
	 * 售后服务电话
	 */
	public java.lang.String getSalesOphone() {
		return getStr("sales_ophone");
	}

}
