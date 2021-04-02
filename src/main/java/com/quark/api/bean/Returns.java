/**
 * 
 */
package com.quark.api.bean;

import java.io.Serializable;

/**
 * @author kingsley
 *
 * @datetime 2014年12月3日 下午7:36:50
 */
public class Returns implements Serializable {

	//返回值名
	private String name;
	//返回值解释
	private String explain;
	//返回值类型

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}
}
