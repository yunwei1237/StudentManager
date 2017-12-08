package com.tcf.basebean;

public class Info {
	private String msg;
	private String err;
	private Object objs;
	public Info() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Info(String msg, String err, Object objs) {
		super();
		this.msg = msg;
		this.err = err;
		this.objs = objs;
	}
	public Info(String msg, String err) {
		super();
		this.msg = msg;
		this.err = err;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getErr() {
		return err;
	}
	public void setErr(String err) {
		this.err = err;
	}
	public Object getObjs() {
		return objs;
	}
	public void setObjs(Object objs) {
		this.objs = objs;
	}
	@Override
	public String toString() {
		return "Info [msg=" + msg + ", err=" + err + ", objs=" + objs + "]";
	}
}
