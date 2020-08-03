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
}
