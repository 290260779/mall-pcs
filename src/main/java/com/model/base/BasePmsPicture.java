package com.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BasePmsPicture<M extends BasePmsPicture<M>> extends Model<M> implements IBean {

	/**
	 * 图片表 Id
	 */
	public void setId(java.math.BigInteger id) {
		set("id", id);
	}
	
	/**
	 * 图片表 Id
	 */
	public java.math.BigInteger getId() {
		return get("id");
	}

	/**
	 * 图片OSS的URL
	 */
	public void setPic(java.lang.String pic) {
		set("pic", pic);
	}
	
	/**
	 * 图片OSS的URL
	 */
	public java.lang.String getPic() {
		return getStr("pic");
	}

	/**
	 * 排序
	 */
	public void setSort(java.lang.Long sort) {
		set("sort", sort);
	}
	
	/**
	 * 排序
	 */
	public java.lang.Long getSort() {
		return getLong("sort");
	}

}