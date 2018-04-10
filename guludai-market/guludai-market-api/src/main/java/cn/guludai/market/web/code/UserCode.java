/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.code;

import cn.guludai.api.Code;

/**
 * @author qiao.he
 */
public enum UserCode implements Code {

	EMAIL_FORMAT_ERROR("10001", "邮箱格式有误"),
	PWD_NOT_EMPTY("10003", "账号或密码不能为空"),
	PWD_LENGTH_ERROR("10004", "密码长度过长"),
	OLD_PWD_ERROR("10005", "旧密码有误"),
	USER_EXIST_ERROR("10006", "用户不存在"),
	USER_EXISTENCE_ERROR("10007", "用户已存在"),
	USER_NAME_EXISTENCE_ERROR("10008", "用户名称已存在"),
	USER_CORE_NOT_ERROR("10009", "用户编号不能为空"),;

	public final String code, message;

	private UserCode(String code, String message) {
		this.message = message;
		this.code = code;
	}

	public static UserCode get(String code) {
		for (UserCode constants : UserCode.values()) {
			if (constants.getCode().equals(code))
				return constants;
		}
		throw new IllegalArgumentException("UserCode is not exist : "+ code);
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
