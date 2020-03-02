package com.nssol.web.system.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageFactory {

    public static Map<String,Object> createPageMap(List list){
        Map<String,Object> map = new HashMap<>();
        map.put("total",list.size());
        map.put("rows",list);
        return map;
    }
}
