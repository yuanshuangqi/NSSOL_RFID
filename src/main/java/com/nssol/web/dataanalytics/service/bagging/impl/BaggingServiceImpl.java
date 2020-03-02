package com.nssol.web.dataanalytics.service.bagging.impl;

import com.nssol.dao.master.BaggingDao;
import com.nssol.web.dataanalytics.controller.bagging.BaggingRequest;
import com.nssol.web.dataanalytics.model.BaggingInfo;
import com.nssol.web.dataanalytics.service.bagging.BaggingOutput;
import com.nssol.web.dataanalytics.service.bagging.BaggingService;
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
public class BaggingServiceImpl implements BaggingService {
    @Resource
    BaggingDao baggingDao;
    @Override
    public BaggingOutput getBaggingList(BaggingRequest baggingRequest) {

        baggingRequest.setDateFrom(getDate(baggingRequest.getDateFrom()));
        baggingRequest.setDateTo(getDate(baggingRequest.getDateTo()));
        baggingRequest.setPageStart((baggingRequest.getCurrentPage()-1)*baggingRequest.getPageSize());
        baggingRequest.setPageEnd(baggingRequest.getCurrentPage()*baggingRequest.getPageSize()+1);
        Long totalCount = baggingDao.getBaggingTotalCount(baggingRequest);
        BaggingOutput output = new BaggingOutput();
        output.setCurrentPage(baggingRequest.getCurrentPage());
        output.setPageSize(baggingRequest.getPageSize());
        if(totalCount==0){
            output.setTotal(0);
            return output;
        }
        List<BaggingInfo> baggingInfoList = baggingDao.getBaggingList(baggingRequest);
        if(!ObjectUtils.isEmpty(baggingInfoList)){
            output.setTotal(totalCount);
            output.setBaggingData(baggingInfoList);
        }
        return output;
    }

    @Override
    public void downloadBagging(BaggingRequest baggingRequest,HttpServletResponse response) {
        try {
            baggingRequest.setCurrentPage(0);
            BaggingOutput output = this.getBaggingList(baggingRequest);
            List<BaggingInfo> baggingInfoList = output.getBaggingData();
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("包装信息列表");
            HSSFRow row = null;
            row = sheet.createRow(0);
            row.setHeight((short) (30 * 20));
            row.createCell(0).setCellValue("包装信息列表");
            CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 2);
            sheet.addMergedRegion(rowRegion);
            row = sheet.createRow(1);
            row.setHeight((short) (22.50 * 20));//设置行高
            row.createCell(0).setCellValue("PO单号");//为第一个单元格设值
            row.createCell(1).setCellValue("国家");//为第二个单元格设值
            row.createCell(2).setCellValue("SKU");//为第三个单元格设值
            row.createCell(3).setCellValue("款号");
            row.createCell(4).setCellValue("颜色");
            row.createCell(5).setCellValue("尺寸");
            row.createCell(6).setCellValue("花型");
            row.createCell(7).setCellValue("计划数");
            row.createCell(8).setCellValue("扫描数");

            for (int i = 0; i < baggingInfoList.size(); i++) {
                row = sheet.createRow(i + 2);
                BaggingInfo baggingInfo = baggingInfoList.get(i);
                row.createCell(0).setCellValue(baggingInfo.getOrderNo());
                row.createCell(1).setCellValue(baggingInfo.getBuCode());
                row.createCell(2).setCellValue(baggingInfo.getSkuCode());
                row.createCell(3).setCellValue(baggingInfo.getSampleCode());
                row.createCell(4).setCellValue(baggingInfo.getColor());
                row.createCell(5).setCellValue(baggingInfo.getSize());
                row.createCell(6).setCellValue(baggingInfo.getPatternDimensionCode());
                row.createCell(7).setCellValue(baggingInfo.getOrderQty());
                row.createCell(8).setCellValue(baggingInfo.getScanNum());
            }
            sheet.setDefaultRowHeight((short) (16.5 * 20));
            //列宽自适应
            for (int i = 0; i <= 13; i++) {
                sheet.autoSizeColumn(i);
            }
            String fileName= "bagging";
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
        if(StringUtils.isEmpty(date)){
            return null;
        }
        String[] strArr = date.split("T");
        return strArr[0];
    }
}
