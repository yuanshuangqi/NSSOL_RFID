package com.nssol.web.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 全局统一状态码
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {
    SUCCESS(true, 20000, "成功"),
    AUTHENTICATE_SUCCESS(true,20000,"认证通过"),
    ADD_SUCCESS(true, 20002, "新增成功"),
    DEL_SUCCESS(true, 20002, "删除成功"),
    EDIT_SUCCESS(true, 20002, "修改成功"),
    ROLE_ASSIGN_SUCCESS(true, 20003, "角色分配成功"),
    MENU_ASSIGN_SUCCESS(true, 20004, "权限分配成功"),
    PAUSED_SUCCESS(true,20005,"暂停成功"),
    START_SUCCESS(true,20006,"任务开始执行"),
    UNKNOWN_REASON(false,21000,"未知错误,请联系管理员"),
    BAD_SQL_GRAMMAR(false,21001,"sql语法错误"),
    JSON_PARSE_ERROR(false,21002,"json解析异常"),
    PARAM_ERROR(false,21003,"参数不正确"),
    FILE_UPLOAD_ERROR(false,21004,"文件上传错误"),
    EXCEL_DATA_IMPORT_ERROR(false,21005,"Excel数据导入错误"),
    ACCOUNT_UNKNOWN(false,21006,"用户不存在，请联系管理员"),
    ACCOUNT_PASSWORD_ERROR(false,21007,"账号或者密码错误"),
    USER_NO_PERMISSION(false,21008,"无权限用户,请联系管理员"),
    ROLE_NO_SELF(false,21009,"父级角色不能是自身"),
    ROLE_NO_CHILDREN(false,21010,"父级角色不能为自身的子角色"),
    MENU_NO_SELF(false,21011,"父级菜单不能是自身"),
    MENU_NO_CHILDREN(false,21012,"父级菜单不能为自身的子菜单"),
    DEPT_NO_SELF(false,21013,"父级部门不能是自身"),
    DEPT_NO_CHILDREN(false,21014,"父级部门不能为自身的子部门"),
    PASSWORD_ERROR(false,21015,"密码错误"),
    NO_CORRESPONDING_PERMISSION(false,21016,"没有相应权限，请联系管理员"),
    LOGIN_TIMEOUT(false,21017,"登录超时，请重新登录"),
    EDIT_FAIL(false, 21018, "修改失败");
    private Boolean success;
    private Integer code;
    private String msg;
    public Boolean getSuccess(){
        return this.success;
    }
}