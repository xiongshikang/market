/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.code;

import cn.guludai.api.Code;

/**
 * @author gaopeng
 */
public enum MarketBaseCode implements Code {

        SUCCESS("200", "成功"),
        NO_DATA("201", "没有查到数据"),
        ERROR_SYS("6003", "系统异常"),
        ERROR_SQL("6001", "DB异常"),
        ERROR_INVALID("6000", "DB无效"),
        ERROR_REQ_A002("A002", "请求参数缺少"),
        BASE_SHOP_ERP_NOT_EMPTY("6004","安全信息已存在"),
        RSA_CREATE_ERROR("6006","rsa生成错误"),
        COPY_PROPERTIES_ERROR("6006","copy属性错误"),
        APP_USER_APPLY_SHOP_ERROR("6007","获取申请信息(app_user_apply_shop)错误"),
        ACTIVITY_ID_NOT_EMPTY("6008","申请审批的工作流已启动,无法在次启用"),
        PROCESSINSTANCE_IS_NOT_EMPTY("6009","任务已被领取。"),
        USER_CODE_EMPTY("6010","用户编号为空"),
        COMPANY_LIST_ERROR("6011","远程调用获取公司列表错误"),
        COMPANY_INSERT_ERROR("6012","远程调用添加公司信息失败");
	
        private final String code;
        private final String message;

        MarketBaseCode(String code, String message)
        {
                this.code = code;
                this.message = message;
        }

        @Override
        public String getMessage() {
                return message;
        }

        @Override
        public String getCode() {
                return code;
        }


        public static boolean isSignType(String code)
        {
                for (MarketBaseCode s : MarketBaseCode.values())
                {
                        if (s.getCode().equals(code))
                        {
                                return true;
                        }
                }
                return false;
        }
}
