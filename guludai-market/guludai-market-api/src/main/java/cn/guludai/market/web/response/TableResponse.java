/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.response;

import java.util.List;

/**
 * 
 * @ClassName: TableResultResponse 
 * @Description: 分页帮助类
 * @author: xiongshikang
 * @date: 2017年11月20日 下午1:48:28 
 * @param <T>
 */
public class TableResponse<T> {
    long total;
    List<T> rows;

    public TableResponse(long l, List<T> rows) {
        this.total = l;
        this.rows = rows;
    }

    public TableResponse() {
    }

    TableResponse<T> total(long total){
        this.total = total;
        return this;
    }
    TableResponse<T> total(List<T> rows){
        this.rows = rows;
        return this;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
