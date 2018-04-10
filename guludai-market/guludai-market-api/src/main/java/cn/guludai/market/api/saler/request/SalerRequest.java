/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.api.saler.request;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gaopeng
 */
public class SalerRequest implements Serializable {

        private static final long serialVersionUID = 574356225504459524L;
        private String flowCode;
        private String applyCode;
        private Date applyTime;
        private String approveStatus;
        private String approveResult;
        private String approveStartTime;
        private String approveEndTime;
		public String getApplyCode() {
			return applyCode;
		}
		public void setApplyCode(String applyCode) {
			this.applyCode = applyCode;
		}
		public Date getApplyTime() {
			return applyTime;
		}
		public void setApplyTime(Date applyTime) {
			this.applyTime = applyTime;
		}
		public String getApproveStatus() {
			return approveStatus;
		}
		public void setApproveStatus(String approveStatus) {
			this.approveStatus = approveStatus;
		}
		public String getApproveResult() {
			return approveResult;
		}
		public void setApproveResult(String approveResult) {
			this.approveResult = approveResult;
		}
		public String getApproveStartTime() {
			return approveStartTime;
		}
		public void setApproveStartTime(String approveStartTime) {
			this.approveStartTime = approveStartTime;
		}
		public String getApproveEndTime() {
			return approveEndTime;
		}
		public void setApproveEndTime(String approveEndTime) {
			this.approveEndTime = approveEndTime;
		}
		public String getFlowCode() {
			return flowCode;
		}
		public void setFlowCode(String flowCode) {
			this.flowCode = flowCode;
		}
}
