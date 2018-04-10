/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.user.response;

import java.util.List;
/**
 * 
 * @ClassName: MenuTree 
 * @Description: 菜单
 * @author: xiongshikang
 * @date: 2017年12月15日 下午12:22:11
 */
public class MenuTree{
	/**
	 * 显示图标
	 */
	private String icon;
	/**
	 * 名称
	 */
	private  String title;
	/**
	 * 跳转地址
	 */
	private String href;
	/**
	 * 编号
	 */
	private String id;
	/**
	 * 上级编号
	 */
	private String parentId;
	/**
	 * 是否展开
	 */
    boolean spread = false;
    
    List<MenuTree> children ;
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public boolean isSpread() {
		return spread;
	}

	public void setSpread(boolean spread) {
		this.spread = spread;
	}

	public List<MenuTree> getChildren() {
		return children;
	}

	public void setChildren(List<MenuTree> children) {
		this.children = children;
	}
 
}
