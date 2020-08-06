package com.qssy.exam.webexam.commom;

public class JsonToken {

    public int code ;
    public  String msg;
    public Object data;
    public Object state;

    public JsonToken(int code, String msg, Object data, Object state) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.state = state;
    }

    public JsonToken(Object state) {
        this.state = state;
    }

    public JsonToken(int code) {
        this.code = code;
    }
    public JsonToken() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }
}
