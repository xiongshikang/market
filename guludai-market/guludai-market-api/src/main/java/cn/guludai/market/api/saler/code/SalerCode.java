/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.api.saler.code;

import cn.guludai.api.Code;

/**
 * @author gaopeng
 */
public enum SalerCode implements Code {

        NOTFIND("70001", "找不到材料"),
        DATA_EMPTY("7002","没有一条申请审批进度记录"),
        APPLY_CODE_EMPTY("7003","流水号参数错误"),
        USER_IS_MEPTY("7004","用户不存在"),
        USER_PASSWORD_IS_ERROR("7005","密码不正确"),
        CUSTOMER_ID_CARD_EMPTY("7006","身份证号为空"),;
	 
        public final String code, message;

        private SalerCode(String code, String message) {
                this.message = message;
                this.code = code;
        }

        @Override
        public String getMessage() {
                return message;
        }

        @Override
        public String getCode() {
                return code;
        }

}
