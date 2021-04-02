package com.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseUmsMenu<M extends BaseUmsMenu<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}
	
	public java.lang.Long getId() {
		return getLong("id");
	}

	/**
	 * 父级ID
	 */
	public void setParentId(java.lang.Long parentId) {
		set("parent_id", parentId);
	}
	
	/**
	 * 父级ID
	 */
	public java.lang.Long getParentId() {
		return getLong("parent_id");
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
	 * 菜单名称
	 */
	public void setTitle(java.lang.String title) {
		set("title", title);
	}
	
	/**
	 * 菜单名称
	 */
	public java.lang.String getTitle() {
		return getStr("title");
	}

	/**
	 * 菜单级数
	 */
	public void setLevel(java.lang.Integer level) {
		set("level", level);
	}
	
	/**
	 * 菜单级数
	 */
	public java.lang.Integer getLevel() {
		return getInt("level");
	}

	/**
	 * 菜单排序
	 */
	public void setSort(java.lang.Integer sort) {
		set("sort", sort);
	}
	
	/**
	 * 菜单排序
	 */
	public java.lang.Integer getSort() {
		return getInt("sort");
	}

	/**
	 * 菜单URL
	 */
	public void setUrl(java.lang.String url) {
		set("url", url);
	}
	
	/**
	 * 菜单URL
	 */
	public java.lang.String getUrl() {
		return getStr("url");
	}

	/**
	 * 前端名称
	 */
	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	/**
	 * 前端名称
	 */
	public java.lang.String getName() {
		return getStr("name");
	}

	/**
	 * 前端图标
	 */
	public void setIcon(java.lang.String icon) {
		set("icon", icon);
	}
	
	/**
	 * 前端图标
	 */
	public java.lang.String getIcon() {
		return getStr("icon");
	}

	/**
	 * 前端隐藏
	 */
	public void setHidden(java.lang.Integer hidden) {
		set("hidden", hidden);
	}
	
	/**
	 * 前端隐藏
	 */
	public java.lang.Integer getHidden() {
		return getInt("hidden");
	}

}