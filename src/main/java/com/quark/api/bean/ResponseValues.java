/**
 *
 */
package com.quark.api.bean;

import java.io.Serializable;
import java.util.HashMap;


/**
 * @author kingsley
 *
 * @datetime 2014年12月20日 上午11:56:27
 */
public class ResponseValues extends HashMap<String, Object> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ResponseValues() {

    }

    @Override
    public Object put(String key, Object value) {
        return super.put(key, value);
    }
}
