package com.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BasePmsAlbumPic<M extends BasePmsAlbumPic<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}
	
	public java.lang.Long getId() {
		return getLong("id");
	}

	/**
	 * 图片所属的相册（相册的ID）
	 */
	public void setAlbumId(java.lang.Long albumId) {
		set("album_id", albumId);
	}
	
	/**
	 * 图片所属的相册（相册的ID）
	 */
	public java.lang.Long getAlbumId() {
		return getLong("album_id");
	}

	/**
	 * 图片 Url
	 */
	public void setPic(java.lang.String pic) {
		set("pic", pic);
	}
	
	/**
	 * 图片 Url
	 */
	public java.lang.String getPic() {
		return getStr("pic");
	}

}