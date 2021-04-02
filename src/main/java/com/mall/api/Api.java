package com.mall.api;

import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.quark.api.bean.ApiDescription;
import com.quark.api.controller.ApiTook;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Clear
public class Api extends Controller {

	/**
	 * 配置接口的访问地址
     * {result=ok, taskId=OSS-0803_4b8de1291d2c68c62c6f236a7e98f274, status=successed_online}
	 */
//	private static final String url_path = "/jizhi-lingzhi/api/list";//废弃
	private static final String url_path = "/mall/api/list";
	/**
	 * 配置接口的渲染文件位置
	 */
	private static final String page_path = "/api/api.ftl";
	/**
	 * 配置接口的扫描包
	 */
	private static final String scan_package = "com.mall.api";
	/**
	 * 扫描api接口
	 */
	private static final List<ApiDescription> list = ApiTook.buildApis(scan_package);

	/**
	 * 接口访问controll
	 *
	 * @return
	 */
	public void list() {
		ApiDescription api = null;
		String api_name = null;
		String name = getPara();
		if (name != null && !"".equalsIgnoreCase(name)) {
			try {
				name = URLDecoder.decode(name, "utf8");
				api = ApiTook.getApisOfMap(name);
				api_name = name;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("解析路劲参数失败");
			}
		} else {
			api = ApiTook.getApisOfMap(list.get(0).getApi());
			api_name = api.getApi();
		}
		set("api_name", api_name).set("path", url_path).set("list", list).set("api", api);
		renderFreeMarker(page_path);
	}

}
