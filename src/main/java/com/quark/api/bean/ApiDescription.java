/**
 * 
 */
package com.quark.api.bean;

import java.io.Serializable;
import java.util.List;


/**
 * @author kingsley
 *
 * @datetime 2014年12月3日 下午5:46:30
 */
public class ApiDescription implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String api;
	private String url;
	private String author;
	private String explain;
	private List<Params> params;
	private List<Returns> returns;
	private List<Log> logs;
	private FormBean form;



	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public List<Params> getParams() {
		return params;
	}

	public void setParams(List<Params> params) {
		this.params = params;
	}

	public List<Returns> getReturns() {
		return returns;
	}

	public void setReturns(List<Returns> returns) {
		this.returns = returns;
	}

	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public FormBean getForm() {
		return form;
	}

	public void setForm(FormBean form) {
		this.form = form;
	}
}
