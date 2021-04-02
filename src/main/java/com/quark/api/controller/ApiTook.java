package com.quark.api.controller;


import com.quark.api.annotation.*;
import com.quark.api.bean.*;
import com.quark.api.uitls.PackageUtils;
import com.quark.api.uitls.RequestFormBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApiTook {

	private static HashMap<String, ApiDescription> apis_map = null;
	private static List<ApiDescription> apis = null;
	private static List<Log> logs = null;
	private static String _package = "";

	public static List<ApiDescription> buildApis(String _package) {
		if (apis == null) {
			_package = _package;
			buildBeans();
		}
		return apis;
	}

	public static ApiDescription getApisOfMap(String name) {
		if (apis_map == null) {
			apis_map = new HashMap<String, ApiDescription>();
			for (final ApiDescription apiBean : apis) {
				String api = apiBean.getApi();
				if (api!=null) {
					apis_map.put(api,apiBean);
				}
			}
		}
		return apis_map.get(name);
	}

	public static List<Log> getLogs() {
		if (logs == null) {
			buildBeans();
		}
		return logs;
	}

	private static void buildBeans() {
		/**
		 * app功能
		 */
		apis = new ArrayList<ApiDescription>();
		logs = new ArrayList<Log>();
		@SuppressWarnings("rawtypes")
		List<Class> app_controller = PackageUtils.getClasses(_package);
		for (@SuppressWarnings("rawtypes")
		Class class1 : app_controller) {
			Method[] methods = class1.getDeclaredMethods();
			for (Method method : methods) {
				String into_method = class1.getSimpleName() + "/" + method.getName();
				Annotation[] annotations = method.getDeclaredAnnotations();
				ApiDescription description = new ApiDescription();
				boolean find = false;
				for (Annotation annotation : annotations) {
					if (annotation instanceof Api) {
						find = true;
						// 映射接口到路径
						Api api = (Api) annotation;
						description.setApi(api.name());
						description.setUrl(api.url());
						description.setAuthor(api.author());
						description.setExplain(api.explain());
						System.out.println("api:" + api.name()+" # "+api.url());
					}  else if (annotation instanceof ApiOfUpdateLog) {
						ApiOfUpdateLog updateLog = (ApiOfUpdateLog) annotation;
						List<Log> logs_list = new ArrayList<Log>();
						Log log = new Log();
						log.setDate(updateLog.date());
						log.setLog(updateLog.log());
						logs_list.add(log);
						description.setLogs(logs_list);
					} else if (annotation instanceof ApiOfUpdateLogs) {
						ApiOfUpdateLogs logs_annotaioni = (ApiOfUpdateLogs) annotation;
						ApiOfUpdateLog[] logs = logs_annotaioni.value();
						List<Log> logs_list = new ArrayList<Log>();
						for (ApiOfUpdateLog updateLog : logs) {
							Log log = new Log();
							log.setDate(updateLog.date());
							log.setLog(updateLog.log());
							logs_list.add(log);
						}
						description.setLogs(logs_list);
					} else if (annotation instanceof ApiOfURLParam) {
						ApiOfURLParam urlParam = (ApiOfURLParam) annotation;
						List<Params> params_list = new ArrayList<Params>();
						Params param = new Params();
						String name = urlParam.name();
						String explain = urlParam.explain();
						param.setExplain(explain);
						param.setName(name);
						param.setType(urlParam.type());
						params_list.add(param);
						description.setParams(params_list);
						FormBean form = RequestFormBuilder
								.buildForm(description);
						description.setForm(form);
					} else if (annotation instanceof ApiOfURLParams) {
						ApiOfURLParams urlParams = (ApiOfURLParams) annotation;
						ApiOfURLParam[] params = urlParams.value();
						List<Params> params_list = new ArrayList<Params>();
						for (ApiOfURLParam p : params) {
							Params param = new Params();
							String name = p.name();
							String explain = p.explain();
							param.setExplain(explain);
							param.setName(name);
							param.setType(p.type());
							params_list.add(param);
						}
						description.setParams(params_list);
						FormBean form = RequestFormBuilder
								.buildForm(description);
						description.setForm(form);
					} else if (annotation instanceof ApiOfReturnValue) {
						ApiOfReturnValue returnParam = (ApiOfReturnValue) annotation;
						List<Returns> returns_list = description.getReturns();
						if (returns_list == null) {
							returns_list = new ArrayList<Returns>();
							description.setReturns(returns_list);
						}
						Returns returns = new Returns();
						returns.setName(returnParam.name());
						returns.setExplain(returnParam.explain());
						returns_list.add(returns);
					} else if (annotation instanceof ApiOfReturnValues) {
						ApiOfReturnValues returnParams = (ApiOfReturnValues) annotation;
						ApiOfReturnValue[] params = returnParams.value();
						List<Returns> returns_list = description.getReturns();
						if (returns_list == null) {
							returns_list = new ArrayList<Returns>();
							description.setReturns(returns_list);
						}
						for (ApiOfReturnValue returnParam : params) {
							Returns returns = new Returns();
							returns.setName(returnParam.name());
							returns.setExplain(returnParam.explain());
							returns_list.add(returns);
						}
					}
				}
				if(find)
				  apis.add(description);
			}
		}
		for (ApiDescription api : apis) {
			List<Log> logs_list = api.getLogs();
			if (logs_list != null)
				for (Log log : logs_list) {
					logs.add(log);
				}
		}
		System.out.println("end annotation...");
	}
}
