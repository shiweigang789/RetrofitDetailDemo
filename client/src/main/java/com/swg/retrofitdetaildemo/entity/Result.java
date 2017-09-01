package com.swg.retrofitdetaildemo.entity;

/**
 * Created by swg on 2017/8/31.
 */

public class Result<T> {

    /**
     * code : 200
     * msg : OK
     * data : [{"id":1,"date":"2017-08-31 05:14:52","author":"怪盗kidou","title":"Retrofit2 测试1","content":"这里是 Retrofit2 Demo 测试服务器1"},{"id":2,"date":"2017-08-31 05:14:52","author":"怪盗kidou","title":"Retrofit2 测试2","content":"这里是 Retrofit2 Demo 测试服务器2"},{"id":3,"date":"2017-08-31 05:14:52","author":"怪盗kidou","title":"Retrofit2 测试3","content":"这里是 Retrofit2 Demo 测试服务器3"},{"id":4,"date":"2017-08-31 05:14:52","author":"怪盗kidou","title":"Retrofit2 测试4","content":"这里是 Retrofit2 Demo 测试服务器4"},{"id":5,"date":"2017-08-31 05:14:52","author":"怪盗kidou","title":"Retrofit2 测试5","content":"这里是 Retrofit2 Demo 测试服务器5"},{"id":6,"date":"2017-08-31 05:14:52","author":"怪盗kidou","title":"Retrofit2 测试6","content":"这里是 Retrofit2 Demo 测试服务器6"},{"id":7,"date":"2017-08-31 05:14:52","author":"怪盗kidou","title":"Retrofit2 测试7","content":"这里是 Retrofit2 Demo 测试服务器7"},{"id":8,"date":"2017-08-31 05:14:52","author":"怪盗kidou","title":"Retrofit2 测试8","content":"这里是 Retrofit2 Demo 测试服务器8"},{"id":9,"date":"2017-08-31 05:14:52","author":"怪盗kidou","title":"Retrofit2 测试9","content":"这里是 Retrofit2 Demo 测试服务器9"},{"id":10,"date":"2017-08-31 05:14:52","author":"怪盗kidou","title":"Retrofit2 测试10","content":"这里是 Retrofit2 Demo 测试服务器10"}]
     * count : 15
     * page : 1
     */

    private int code;
    private String msg;
    private int count;
    private int page;
    private T data;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
