/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.user.response;
/**
 * 
 * @ClassName: ZtreeResponse 
 * @Description: 权限树类
 * @author: xiongshikang
 * @date: 2017年12月14日 下午2:35:37
 */
public class ZtreeResponse {
	
	/**
	 * 节点编号
	 */
	private String id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 父节点
	 */
	private String pId;
	/**
	 * 是否展开
	 */
	private boolean open;
	/**
	 * 是否选中
	 */
	private boolean checked;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public boolean getOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
}
