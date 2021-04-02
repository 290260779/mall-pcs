/**
 * 
 */
package com.quark.api.annotation;

import java.lang.annotation.*;

/**
 * @author kingsley
 *
 * @datetime 2014年11月29日 下午3:49:06
 */
@Repeatable(ApiOfReturnValues.class)
@Retention(RetentionPolicy.RUNTIME)
// 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Target({ ElementType.FIELD, ElementType.METHOD })
// 定义注解的作用目标**作用范围字段、枚举的常量/方法
@Documented
// 说明该注解将被包含在javadoc中
public @interface ApiOfReturnValue {

	/**
	 * 返回字段值名
	 * 
	 * @return
	 */
	public String name();

	/**
	 * 返回字段说明
	 * 
	 * @return
	 */
	public String explain();

}
