package com.tutor.tutorbe.exception;


public class CodeException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	/** 异常代码 */
	private String code;
	/** 异常描述 */
	private String msg;
	/** 异常时间戳 */
	private long timestamp = System.currentTimeMillis();
	
	public CodeException() {
		super();
	}

	public CodeException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	public CodeException(String code, String msg, long timestamp) {
		super();
		this.code = code;
		this.msg = msg;
		this.timestamp = timestamp;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "CodeException [code=" + code + ", msg=" + msg + ", timestamp=" + timestamp + "]";
	}
}
