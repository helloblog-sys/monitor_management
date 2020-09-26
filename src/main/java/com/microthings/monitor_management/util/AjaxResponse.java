package com.microthings.monitor_management.util;

import java.io.Serializable;

/**
 * @ClassName AjaxResponse
 * Description TODO
 * @Author hms
 * @Date 2019/8/28 22:00
 * @Version 1.0
 **/
public class AjaxResponse implements Serializable {

    private static final long serialVersionUID = -603454364015061374L;

    public static final AjaxResponse OK = new AjaxResponse(1, "ok");
    public static final AjaxResponse FAILED = new AjaxResponse(-1, "failed");
    public static final AjaxResponse SYSTEM_BUSY = new AjaxResponse(-100000, "系统繁忙，请您稍后再试");
    public static final AjaxResponse ACCOUNT_NOT_EXIST = new AjaxResponse(
            -100101, "您输入的账号不存在");
    public static final AjaxResponse PASSWORD_NOT_PASSED = new AjaxResponse(
            -100102, "您输入的账号密码不正确");
    public static final AjaxResponse CHECKCODE_NOT_CHECKED = new AjaxResponse(
            -100103, "您输入的验证码不正确");
    public static final AjaxResponse ADD_ACCOUNT_EXIST = new AjaxResponse(
            -100104, "该用户已存在");
    public static final AjaxResponse ADD_ACCOUNT_NOTEXIST = new AjaxResponse(
            -100107, "该用户不存在");
    public static final AjaxResponse ADD_PERMISSION_EXIST = new AjaxResponse(
            -100105, "该权限已存在");
    public static final AjaxResponse ADD_ROLE_EXIST = new AjaxResponse(
            -100106, "该角色已存在");
    public static final AjaxResponse UPDATE_PASSWORD_SUCCESS = new AjaxResponse(
            2, "修改成功，请重新登录");
    public static final AjaxResponse ADD_DEVICE_EXIST = new AjaxResponse(
            -100201, "该设备sn号已被注册");
    public static final AjaxResponse ADD_ALARM_EXIST = new AjaxResponse(
            -100202, "该告警信息已经存在");
    public static final AjaxResponse Emial_NOT_NULL= new AjaxResponse(
            -100203, "用户邮箱不能为空");


    /**
     * 状态码
     */
    private int s;
    /**
     * 描述原因
     */
    private String d;
    /**
     * 响应数据
     */
    private Object data;


    /**
     * 构造一个有状态码和描述的Ajax响应
     *
     * @param s 状态码
     * @param d 描述
     */
    public AjaxResponse(int s, String d) {
        this.s = s;
        this.d = d;
    }

    /**
     * 构造一个有状态码、描述、数据的Ajax响应
     *
     * @param s 状态码
     * @param d 描述
     * @param data 响应数据
     */
    public AjaxResponse(int s, String d, Object data) {
        this.s = s;
        this.d = d;
        this.data = data;
    }

    /**
     * 产生一个成功的响应，并携带数据
     *
     * @return
     */
    public static AjaxResponse OK(Object data) {
        return new AjaxResponse(1, "ok", data);
    }
    /**
     * 产生一个失败的响应，并携带数据
     *
     * @return
     */
    public static AjaxResponse FAILED(Object data) {
        return new AjaxResponse(-1, "failed", data);
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}

