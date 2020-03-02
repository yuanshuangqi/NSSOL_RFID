package com.nssol.web.system.controller.menu;

import com.nssol.model.PageParameter;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "菜单分页搜索类")
public class MenuRequest extends PageParameter {

    private String menuName;

}
