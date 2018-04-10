/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.common.page;

import java.io.Serializable;
import java.util.List;

/**
 * Author: lei.zhang
 * Description:
 * Date: Created in 14:58 2017/11/6/006
 */
public class Page<T> implements Serializable {

    private static final long serialVersionUID = -7303822844150859888L;

    /**
     * <pre>
     * 页码数
     * </pre>
     */
    private Integer page;

    /**
     * <pre>
     * 每页显示多少条
     * </pre>
     */
    private Integer pageSize;

    /**
     * <pre>
     * 总条数
     * </pre>
     */
    private Integer totalCount;

    private List<T> list;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
