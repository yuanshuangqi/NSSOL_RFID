package com.nssol.web.util.role;

import cn.hutool.core.collection.CollUtil;
import com.nssol.web.system.model.RoleInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleUtil {
    /**
     * 递归封装子角色
     * @param parentRole
     * @param roles
     * @return
     */
    public static List<RoleInfo> getChildren(RoleInfo parentRole, List<RoleInfo> roles) {
        List<RoleInfo> children = new ArrayList<>();
        for (RoleInfo role : roles) {
            if(role.getParentId().equals(parentRole.getId())){
                children.add(role);
            }
        }
        if(CollUtil.isNotEmpty(children)){
            for (RoleInfo child : children) {
                child.setChildren(getChildren(child,roles));
            }
        }
        return children;

    }
}
