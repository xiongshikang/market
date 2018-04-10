package cn.guludai.market.service.saler.service;

import cn.guludai.api.data.Request;
import cn.guludai.market.web.request.ApproveApplyResultReq;

import javax.servlet.ServletOutputStream;

public interface SalerExportService {

    void salerExport(Request<ApproveApplyResultReq> request, ServletOutputStream out);
}
