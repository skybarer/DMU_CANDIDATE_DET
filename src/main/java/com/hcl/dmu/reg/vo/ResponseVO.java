/**
 * 
 */
package com.hcl.dmu.reg.vo;

/**
 * @author sekhar.k
 *
 */
public class ResponseVO {
	
	private String code;
	private Object message;
	private long recordCount;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
	public long getRecordCount() {
		return recordCount;
	}
	
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}
	
	@Override
	public String toString() {
		return "ResponseVO [code=" + code + ", message=" + message + ", recordCount=" + recordCount + "]";
	}

	
	
	
}
