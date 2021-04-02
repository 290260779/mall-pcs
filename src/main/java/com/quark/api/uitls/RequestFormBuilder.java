/**
 * 
 */
package com.quark.api.uitls;



import com.quark.api.annotation.ApiOfDataType;
import com.quark.api.bean.ApiDescription;
import com.quark.api.bean.FormBean;
import com.quark.api.bean.Input;
import com.quark.api.bean.Params;
import com.quark.api.controller.ApiTook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kingsley
 *
 * @datetime 2014年12月5日 上午12:27:34
 * 
 */
public class RequestFormBuilder {

	public static FormBean buildForm(ApiDescription bean) {

		FormBean form = new FormBean();
		form.setAction(bean.getUrl());
		List<Input> inputs = new ArrayList<Input>();
		StringBuffer sb = new StringBuffer();
		for (Params p : bean.getParams()) {
			String type = p.getType();
			if (ApiOfDataType.File.equalsIgnoreCase(type)) {
				form.setMultipart(1);
				form.setMethod("post");
			}
			String defaultValue = p.getDefaultValue();
			String explain = p.getExplain();
			String name = p.getName();
			Input input = new Input();
			input.setExplain(explain);
			input.setType(type);
			input.setName(name);
			inputs.add(input);
		}
		form.setInputs(inputs);
		return form;
	}

	public static void main(String[] args) {
		List<ApiDescription> list = ApiTook.buildApis("com.app.admin");
		for (ApiDescription apiBean : list) {
			List<Params> params = apiBean.getParams();
		}

	}
}
