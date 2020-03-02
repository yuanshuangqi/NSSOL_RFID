package com.nssol.web.dataanalytics.service.order.impl;

import com.nssol.dao.master.OrderDao;
import com.nssol.web.dataanalytics.controller.order.OrderRequest;
import com.nssol.web.dataanalytics.model.OrderInfo;
import com.nssol.web.dataanalytics.service.order.OrderOutput;
import com.nssol.web.dataanalytics.service.order.OrderService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Resource
    OrderDao orderDao;
    @Override
    public OrderOutput getOrderList(OrderRequest orderRequest) {
        orderRequest.setDateFrom(getDate(orderRequest.getDateFrom()));
        orderRequest.setDateTo(getDate(orderRequest.getDateTo()));
        orderRequest.setPageStart((orderRequest.getCurrentPage()-1)*orderRequest.getPageSize());
        orderRequest.setPageEnd(orderRequest.getCurrentPage()*orderRequest.getPageSize()+1);
        Long totalCount = orderDao.getOrderTotalCount(orderRequest);
        OrderOutput output = new OrderOutput();
        output.setCurrentPage(orderRequest.getCurrentPage());
        output.setPageSize(orderRequest.getPageSize());
        if(totalCount==0){
            output.setTotal(0);
            return output;
        }
        List<OrderInfo> orderInfoList = orderDao.getOrderList(orderRequest);
        if(!ObjectUtils.isEmpty(orderInfoList)){
            output.setTotal(totalCount);
            output.setOrderData(orderInfoList);
        }
        return output;
    }

    @Override
    public void downloadOrder(OrderRequest orderRequest, HttpServletResponse response) {
        try {
            orderRequest.setCurrentPage(0);
            OrderOutput output = this.getOrderList(orderRequest);
            List<OrderInfo> orderInfoList = output.getOrderData();
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("订单信息列表");
            HSSFRow row = null;
            row = sheet.createRow(0);
            row.setHeight((short) (30 * 20));
            row.createCell(0).setCellValue("订单信息列表");
            CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 2);
            sheet.addMergedRegion(rowRegion);
            row = sheet.createRow(1);
            row.setHeight((short) (22.50 * 20));//设置行高
            row.createCell(0).setCellValue("PO单号");//为第一个单元格设值
            row.createCell(1).setCellValue("ETD");//为第二个单元格设值
            row.createCell(2).setCellValue("国家");
            row.createCell(3).setCellValue("SKU");
            row.createCell(4).setCellValue("款号");
            row.createCell(5).setCellValue("颜色");
            row.createCell(6).setCellValue("尺寸");
            row.createCell(7).setCellValue("花型");
            row.createCell(8).setCellValue("计划数");
            row.createCell(9).setCellValue("包装数");
            row.createCell(10).setCellValue("检针数");

            for (int i = 0; i < orderInfoList.size(); i++) {
                row = sheet.createRow(i + 2);
                OrderInfo orderInfo = orderInfoList.get(i);
                row.createCell(0).setCellValue(orderInfo.getOrderNo());
                row.createCell(1).setCellValue(orderInfo.getETD());
                row.createCell(2).setCellValue(orderInfo.getBuCode());
                row.createCell(3).setCellValue(orderInfo.getSkuCode());
                row.createCell(4).setCellValue(orderInfo.getSampleCode());
                row.createCell(5).setCellValue(orderInfo.getColor());
                row.createCell(6).setCellValue(orderInfo.getSize());
                row.createCell(7).setCellValue(orderInfo.getPatternDimensionCode());
                row.createCell(8).setCellValue(orderInfo.getOrderQty());
                row.createCell(9).setCellValue(orderInfo.getBaggingQty());
                row.createCell(10).setCellValue(orderInfo.getMetalCheckQty());
            }
            sheet.setDefaultRowHeight((short) (16.5 * 20));
            //列宽自适应
            for (int i = 0; i <= 13; i++) {
                sheet.autoSizeColumn(i);
            }
            String fileName= "order";
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            OutputStream os = response.getOutputStream();
            response.setHeader("Content-disposition", "attachment;filename="+fileName+".xls");//默认Excel名称
            wb.write(os);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String getDate(String date){
        if(!StringUtils.isEmpty(date)) {
            String[] strArr = date.split("T");
            return strArr[0];
        }
        return null;
    }
}
