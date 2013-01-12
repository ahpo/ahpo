/**   
 * @Title: Constants.java 
 * @Package com.pub.constant 
 * @author xhh  
 * @date 2012-5-25 上午8:42:45 
 * @version V1.0   
 */
package com.pub.util.constant;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;

import com.pub.util.config.Config;

/**
 * @ClassName: Constants
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author xhh
 * @date 2012-5-25 上午8:42:45
 * @version 1.0
 */
public abstract class Constants {

	public static ServletContext sc;
	public static WebApplicationContext applicationContext;

	/**
	 * config.privilege.xml中的常量
	 */
	public static final String QUERY_SYSUSER_QUERY = Config.params.getString(
			"query.sysUserQuery", "system_user");
	public static final String QUERY_SYSRES_QUERY = Config.params.getString(
			"query.sysResQuery", "system_res");
	
	public static final String QUERY_SYSROLE_QUERY = Config.params.getString(
			"query.sysRoleQuery", "system_role");
	public static final String QUERY_SYSDEPT_QUERY = Config.params.getString(
			"query.sysDeptQuery", "system_department");

	public static final String QUERY_ROADINFO_QUERY = Config.params.getString(
			"query.roadInfoQuery", "roadinfo");
	public static final String QUERY_ROADLIST_QUERY = Config.params.getString(
			"query.roadListQuery", "road_video");
	public static final String QUERY_ROADINFOLIST_QUERY = Config.params
			.getString("query.roadInfoListQuery", "road_image");
	public static final String QUERY_ROADREPORT_QUERY = Config.params
			.getString("query.roadReportQuery", "road_report");
	public static final String QUERY_CARILLEGALINFO_QUERY = Config.params
			.getString("query.carIllegalInfoQuery", "carIllegalInfo");
	public static final String QUERY_CITY_QUERY = Config.params.getString(
			"query.cityQuery", "city");
	public static final String QUERY_ROADPOSITION_QUERY = Config.params
			.getString("query.roadPositionQuery", "road_position");
	public static final String QUERY_SOFTVERSION_QUERY = Config.params
			.getString("query.softVersionQuery", "soft_version");
	public static final String QUERY_CITYAREA_QUERY = Config.params.getString(
			"query.cityAreaQuery", "cityArea");
	public static final String QUERY_USERROADSTATUS_QUERY = Config.params
			.getString("query.userRoadStatusQuery", "userRoadStatus");
	public static final String QUERY_HTTPROADLIST_QUERY = Config.params
			.getString("query.httpRoadListQuery", "http_road_video");
	public static final String QUERY_TBLLOOKUP_QUERY = Config.params.getString(
			"query.tblLookupQuery", "tblLookup");
	public static final String QUERY_TBLDICTIONARY_QUERY = Config.params
			.getString("query.tblDictionaryQuery", "tblDictionary");
	public static final String QUERY_TBLEXC_QUERY = Config.params
			.getString("query.tblExcQuery", "tblExc");
	public static final String QUERY_GUIDEROADINFO_QUERY = Config.params
			.getString("query.guideRoadInfoQuery", "guideRoadInfo");
	public static final String QUERY_GUIDELOGIN_QUERY = Config.params
			.getString("query.guideLoginQuery", "guideLogin");
	public static final String QUERY_RBINFO_QUERY = Config.params.getString(
			"query.rbInfoQuery", "rbInfo");
	public static final String QUERY_RBRECORDINFO_QUERY = Config.params
			.getString("query.rbRecordInfoQuery", "rbRecordInfo");
	public static final String QUERY_RBRECORDLHINFO_QUERY = Config.params
			.getString("query.rbRecordLHInfoQuery", "rbRecordLHInfo");
	public static final String QUERY_RBRECORDLINFO_QUERY = Config.params
			.getString("query.rbRecordLInfoQuery", "rbRecordLInfo");
	public static final String QUERY_RGENINFO_QUERY = Config.params.getString(
			"query.rGenInfoQuery", "rGenInfo");
	public static final String QUERY_RGENLINFO_QUERY = Config.params.getString(
			"query.rGenLInfoQuery", "rGenLInfo");

	public static final String QUERY_HUGUIDELOGIN_QUERY = Config.params
			.getString("query.huGuideLoginQuery", "huGuideLogin");
	public static final String QUERY_HUGUIDEROADINFO_QUERY = Config.params
			.getString("query.huGuideRoadInfoQuery", "huGuideRoadInfo");
	public static final String QUERY_HURBINFO_QUERY = Config.params.getString(
			"query.huRBInfoQuery", "huRBInfo");
	public static final String QUERY_HURBRECORDINFO_QUERY = Config.params
			.getString("query.huRBRecordInfoQuery", "huRBRecordInfo");
	public static final String QUERY_HURBRECORDLHINFO_QUERY = Config.params
			.getString("query.huRBRecordLHInfoQuery", "huRBRecordLHInfo");
	public static final String QUERY_HURBRECORDLINFO_QUERY = Config.params
			.getString("query.huRBRecordLInfoQuery", "huRBRecordLInfo");
	public static final String QUERY_HURGENINFO_QUERY = Config.params
			.getString("query.huRGenInfoQuery", "huRGenInfo");
	public static final String QUERY_HURGENLINFO_QUERY = Config.params
			.getString("query.huRGenLInfoQuery", "huRGenLInfo");

	public static final String QUERY_WEBGUIDEROADINFO_QUERY = Config.params
			.getString("query.webGuideRoadInfoQuery", "webGuideRoadInfo");
	public static final String QUERY_WEBGUIDELOGIN_QUERY = Config.params
			.getString("query.webGuideLoginQuery", "webGuideLogin");
	public static final String QUERY_WEBRBINFO_QUERY = Config.params.getString(
			"query.webRBInfoQuery", "webRBInfo");
	public static final String QUERY_WEBRBRECORDLINFO_QUERY = Config.params
			.getString("query.webRBRecordLInfoQuery", "webRBRecordLInfo");
	public static final String QUERY_WEBRBRECORDLHINFO_QUERY = Config.params
			.getString("query.webRBRecordLDInfoQuery", "webRBRecordLDInfo");
	public static final String QUERY_WEBRGENLINFO_QUERY = Config.params
			.getString("query.webRGenLInfoQuery", "webRGenLInfo");

	/**
	 * QUERY_ROADREPORT_QUERY 日志常量
	 */
	public static final String LOGIN_IN_LOG = "登录系统";
	public static final String LOGIN_OUT_LOG = "退出系统";
	/**
	 * 登陆用户保持在session中的key
	 */
	public static final String USER_NAME = "userName";
	public static final String RAND_CODE = "rand";
	public static final String UID = "uid";
	public static final String RID = "rid";
	public static final String LOGIN_IP = "loginIp";
	public static final String BEGIN_TIME = "beginTime";
	public static final String END_TIME = "endTime";
	/**
	 * 登陆业务
	 */
	public static final String LOGIN_ERROR_1 = "用户名或者密码为空,验证失败!";
	public static final String LOGIN_ERROR_2 = "验证码已失效";
	public static final String LOGIN_ERROR_3 = "验证码错误";
	public static final String LOGIN_ERROR_4 = "用户或者密码错误!";
	public static final String LOGIN_ERROR_5 = "系统维护中";

	/**
	 * 业务操作返回结果信息
	 */
	public static final String OPERATE_QUERY = "查询系统用户信息";
	public static final String OPERATE_QUERY_FAIL = "查询失败";
	public static final String OPERATE_QUERY_FAIL_REASON = "数据库数据错误";

	/**
	 * 权限菜单
	 */
	public static final String RES_TYPE = "resType";
	public static final String RES_TYPE_USER = "user";
	public static final String RES_TYPE_ROLE = "role";
	public static final String PRIVILEGE = "privilege";

	/**
	 * 左侧菜单
	 */
	public static final String LET_MENU_RESOURCES = "resources";
	
	public static final String USER_MENU = "USER_MENU";

	/**
	 * 访问权限中涉及到的配置常量
	 */
	public static final String POWER_REQUEST = "request.";
	public static final String POWER_SPLIT = "\\.";

	/**
	 * struts2拦截器中涉及到的常量
	 */
	public static final String STRUTS_ACTION = ".action";

	/**
	 * 获取登陆用户的IP
	 */
	public static String getUserIp() {
		return ServletActionContext.getRequest().getRemoteAddr();
	}

	/**
	 * 相似性记录验证标示：创建
	 */
	public static final int CHECKSIMILARITY_MODE_CREATE = 1;
	/**
	 * 相似性记录验证标识：修改
	 */
	public static final int CHECKSIMILARITY_MODE_UPDATE = 0;

	/**
	 * 异常类型
	 */
	public static final String EG_EXC_TYPE = "EG_EXC_TYPE";
	/**
	 * 异常状态
	 */
	public static final String EG_EXC_STATUS = "EG_EXC_STATUS";
}
