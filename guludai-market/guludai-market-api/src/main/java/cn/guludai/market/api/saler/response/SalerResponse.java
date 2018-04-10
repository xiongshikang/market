/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.api.saler.response;

import java.io.Serializable;

/**
 * @author gaopeng
 */
public class SalerResponse implements Serializable {

        private static final long serialVersionUID = -7303822844150859888L;
        private String flowCode;
        private String applyCode;
        private String applyTime;
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
		public String getApplyTime() {
			return applyTime;
		}
		public void setApplyTime(String applyTime) {
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
