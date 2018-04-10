/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.controller.saler;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import cn.guludai.api.data.Response;
import cn.guludai.market.service.saler.service.ApproveApplyResultService;
import cn.guludai.market.web.saler.request.ApplyExcelModelRequest;

/**
 * 
 * @ClassName: SalerExportController 
 * @Description: 导出每个销售负责的渠道销售成果
 * @author: xiongshikang
 * @date: 2018年1月3日 下午3:44:00
 */
@Controller
public class SalerExportController  {

    @Autowired
    private ApproveApplyResultService approveApplyResultService;

    /**
     * 
     * @author: xiongshikang
     * @date: 2018年1月5日 上午9:25:03
     * @Title: applyExcel 
     * @Description: 导出售销统计excel表
     * @param model
     * @param response
     * @return
     *
     */
    @GetMapping("/web/salerExport")
    public Response<String> applyExcel(ApplyExcelModelRequest model , HttpServletResponse response ) {
        Response<String> result = new Response<>();
        String name = "渠道销售成果报表";
        try {
            ServletOutputStream out=initResponse(response ,name);
            approveApplyResultService.ApplyExcelLoad(model , out);
            result.setMessage("导出成功!");
        } catch (Exception e) {
            result.setMessage("导出失败:{}" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 初始化HttpServletResponse
     * @param response
     * @param name
     * @return
     * @throws IOException
     */
    public ServletOutputStream initResponse(HttpServletResponse response , String name) throws IOException{
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        String fileName= name + Calendar.getInstance().getTimeInMillis();
        ServletOutputStream out=response.getOutputStream();
        response.setHeader("content-disposition","attachment;filename="+new String(fileName.getBytes("gb2312"), "ISO8859-1") + ".xlsx");
        return out;
    }
 
}
