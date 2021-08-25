package com.mao.common.lang;

import com.baomidou.mybatisplus.extension.api.R;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
 private int code;
 private String msg;
 private Object data;

 public static Result succ(Object data) {
     return succ(200,"操作成功",data);
 }
 public static Result succ(int code,String msg, Object data) {
     Result m = new Result();
     m.setCode(200);
     m.setData(data);
     m.setMsg(msg);
     return m;
 }

 public static Result fail(String msg){
     return fail(400,msg,null);

 }
 public static Result fail(String msg,Object data) {
     return fail(400,msg,data);
 }
 public static Result fail(int code,String msg, Object data) {
     Result m = new Result();
     m.setCode(400);
     m.setData(data);
     m.setMsg(msg);
     return m;
 }

}
