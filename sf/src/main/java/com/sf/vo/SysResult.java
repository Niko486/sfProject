package com.sf.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysResult {
    private int status;
    private String msg;
    private Object data;

    public static SysResult fail(){
        return new SysResult(201,"业务动用失败",null);
    }
    public static SysResult fail(String msg){
        return new SysResult(201,"业务调用失败",msg);
    }
    public static SysResult success(){
        return new SysResult(200,"业务调用成功",null);
    }
    public static SysResult success(Object data){
        return new SysResult(200,"业务调用成功",data);
    }
    public static SysResult success(String msg,Object data){
        return new SysResult(200,msg,data);
    }
}
