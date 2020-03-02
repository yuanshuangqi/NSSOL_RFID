package com.nssol.web.common.util;

import cn.hutool.json.JSONUtil;
import com.nssol.web.common.constants.ResultCodeEnum;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static void response(HttpServletResponse response,int status,int code,String message) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(status);
        Map<String, Serializable> resultMap = new HashMap<>();
        resultMap.put("code", code);
        resultMap.put("message", message);
        PrintWriter out = response.getWriter();
        out.write(JSONUtil.parse(resultMap).toString());
        out.flush();
        out.close();
    }
    public static void response(HttpServletResponse response, int status, ResultCodeEnum resultCodeEnum) {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(status);
        Map<String, Serializable> resultMap = new HashMap<>();
        resultMap.put("code", resultCodeEnum.getCode());
        resultMap.put("message", resultCodeEnum.getMsg());
        resultMap.put("success",resultCodeEnum.getSuccess());
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(JSONUtil.parse(resultMap).toString());
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void response(HttpServletResponse response, int status, ResultCodeEnum resultCodeEnum,Object data) {
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(status);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", resultCodeEnum.getCode());
        resultMap.put("message", resultCodeEnum.getMsg());
        resultMap.put("success",resultCodeEnum.getSuccess());
        resultMap.put("data",data);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(JSONUtil.parse(resultMap).toString());
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
