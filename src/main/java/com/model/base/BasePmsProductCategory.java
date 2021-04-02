package com.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BasePmsProductCategory<M extends BasePmsProductCategory<M>> extends Model<M> implements IBean {

	/**
	 * 产品分类Id
	 */
	public void setId(java.lang.Long id) {
		set("id", id);
	}
	
	/**
	 * 产品分类Id
	 */
	public java.lang.Long getId() {
		return getLong("id");
	}

	/**
	 * 上机分类的编号：0表示一级分类
	 */
	public void setParentId(java.lang.Long parentId) {
		set("parent_id", parentId);
	}
	
	/**
	 * 上机分类的编号：0表示一级分类
	 */
	public java.lang.Long getParentId() {
		return getLong("parent_id");
	}

	/**
	 * 分类名称
	 */
	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	/**
	 * 分类名称
	 */
	public java.lang.String getName() {
		return getStr("name");
	}

	/**
	 * 分类级别：0->1级；1->2级
	 */
	public void setLevel(java.lang.Integer level) {
		set("level", level);
	}
	
	/**
	 * 分类级别：0->1级；1->2级
	 */
	public java.lang.Integer getLevel() {
		return getInt("level");
	}

	/**
	 * 显示状态：0->不显示；1->显示
	 */
	public void setShowStatus(java.lang.Integer showStatus) {
		set("show_status", showStatus);
	}
	
	/**
	 * 显示状态：0->不显示；1->显示
	 */
	public java.lang.Integer getShowStatus() {
		return getInt("show_status");
	}

	/**
	 * 排序
	 */
	public void setSort(java.lang.Integer sort) {
		set("sort", sort);
	}
	
	/**
	 * 排序
	 */
	public java.lang.Integer getSort() {
		return getInt("sort");
	}

	/**
	 * 商品数量
	 */
	public void setProductCount(java.lang.Integer productCount) {
		set("product_count", productCount);
	}
	
	/**
	 * 商品数量
	 */
	public java.lang.Integer getProductCount() {
		return getInt("product_count");
	}

	/**
	 * 商品单位
	 */
	public void setProductUnit(java.lang.String productUnit) {
		set("product_unit", productUnit);
	}
	
	/**
	 * 商品单位
	 */
	public java.lang.String getProductUnit() {
		return getStr("product_unit");
	}

	/**
	 * 是否显示在导航栏：0->不显示；1->显示
	 */
	public void setNavStatus(java.lang.Integer navStatus) {
		set("nav_status", navStatus);
	}
	
	/**
	 * 是否显示在导航栏：0->不显示；1->显示
	 */
	public java.lang.Integer getNavStatus() {
		return getInt("nav_status");
	}

	/**
	 * 图标
	 */
	public void setIcon(java.lang.String icon) {
		set("icon", icon);
	}
	
	/**
	 * 图标
	 */
	public java.lang.String getIcon() {
		return getStr("icon");
	}

	/**
	 * 关键词
	 */
	public void setKeywords(java.lang.String keywords) {
		set("keywords", keywords);
	}
	
	/**
	 * 关键词
	 */
	public java.lang.String getKeywords() {
		return getStr("keywords");
	}

	/**
	 * 描述
	 */
	public void setDescription(java.lang.String description) {
		set("description", description);
	}
	
	/**
	 * 描述
	 */
	public java.lang.String getDescription() {
		return getStr("description");
	}

}
