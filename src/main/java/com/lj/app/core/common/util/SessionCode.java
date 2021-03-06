package com.lj.app.core.common.util;

/**
 * 
 * Sesseion编码配置
 *
 */
public class SessionCode {

  /**
   * Session 中存放登录名称的Session Code
   */
  public static final  String LOGIN_NAME = "loginName";
  /**
   * Session 中存放登录名称的Session Code
   */
  public static final  String USER_NAME = "userName";

  /**
   * Session 中存放登主帐号的Session Code
   */
  public static final  String MAIN_ACCT = "mainAcct";

  /**
   * Session 中存放，主帐号ID
   */
  public static final String MAIN_ACCT_ID = "mainAcctId";

  /**
   * app菜单权限列表
   */
  public static final String APP_MENU_PERMISSION_LIST = "appMenuPermissionList";
  /**
   * app菜单权限列表
   */
  public static final String APP_MENU_PERMISSION_LIST_SIZE = "appMenuPermissionListSize";
  /**
   * 角色列表
   */
  public static final String APP_ROLE_LIST = "appRoleList";
  /**
   * 组织机构
   */
  public static final String APP_USER_GROUP_LIST = "appUserGroupList";

  // ----------------- Client Info -----------------------//

  /**
   * Session中存放，菜单列表 CODE=perminssionList
   */
  public static final String PERMINSSION_LIST = "perminssionList";

  /**
   * Request 中存放，错误信息
   */
  public static final String ERROR_MESSAGE = "errorMessage";

  /**
   * Request 中存放，警告信息
   */
  public static final String WARN_MESSAGE = "warnMessage";

  /**
   * Request 中存放，普通提示信息
   */
  public static final String INFO_MESSAGE = "infoMessage";

  /**
   * Request 中存放，普通提示信息
   */
  public static final String SUCCESS_MESSAGE = "successMessage";

  /**
   * Session 中存放，真实请求服务ip地址
   */
  public static final String CLIENT_INFO_REQUEST_ADDRESS = "requestAddress";

  /**
   * Session中存放，服务器ip地址
   */
  public static final String SERVER_INFO_IP_ADDRESS = "serverIp";

  /**
   * Session中存放，计算机名称
   */
  public static final String CLIENT_INFO_HOST_NAME = "hostName";

  public static final String SSO_LOGIN_URL = "SSO_LOGIN_URL";

  /**
   * spring profiles配置
   */
  public static final String SPRING_PROFILES_ACTIVE = "spring.profiles.active";

}
