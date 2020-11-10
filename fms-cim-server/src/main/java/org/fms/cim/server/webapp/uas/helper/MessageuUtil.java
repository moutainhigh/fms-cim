package org.fms.cim.server.webapp.uas.helper;

//消息类用来通讯
public class MessageuUtil {

    public MessageuUtil() {
        this.setCode(-1);
        this.setMsg("未设置返回信息");
        this.setData(null);
    }

    private Integer code;//操作码此值用来判断是否请求成功 1-成功 0-失败 -1未设置对象
    private String msg;// 返回提示信息，在code为0时返回相关错误提示信息
    private Object data;//返回对象

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
