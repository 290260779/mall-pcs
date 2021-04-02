/**
 * 
 */
package com.quark.api.bean;

import java.io.Serializable;

/**
 * @author kingsley
 *
 * @datetime 2014年12月3日 下午7:46:00
 */
public class Log implements Serializable{

	private String date;
	private String log;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}
}
