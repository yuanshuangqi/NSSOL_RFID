package com.nssol.web.dataanalytics.service.metalcheck.impl;

import com.nssol.dao.master.MetalCheckDao;
import com.nssol.web.dataanalytics.controller.metalcheck.MetalCheckRequest;
import com.nssol.web.dataanalytics.model.BaggingInfo;
import com.nssol.web.dataanalytics.model.MetalCheckInfo;
import com.nssol.web.dataanalytics.service.bagging.BaggingOutput;
import com.nssol.web.dataanalytics.service.metalcheck.MetalCheckOutput;
import com.nssol.web.dataanalytics.service.metalcheck.MetalCheckService;
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
public class MetalCheckServiceImpl implements MetalCheckService {
    @Resource
    MetalCheckDao metalCheckDao;
    @Override
    public MetalCheckOutput getMetalCheckList(MetalCheckRequest metalCheckRequest) {

        metalCheckRequest.setDateFrom(getDate(metalCheckRequest.getDateFrom()));
        metalCheckRequest.setDateTo(getDate(metalCheckRequest.getDateTo()));
        metalCheckRequest.setPageStart((metalCheckRequest.getCurrentPage()-1)*metalCheckRequest.getPageSize());
        metalCheckRequest.setPageEnd(metalCheckRequest.getCurrentPage()*metalCheckRequest.getPageSize()+1);
        Long totalCount = metalCheckDao.getMetalCheckTotalCount(metalCheckRequest);
        MetalCheckOutput output = new MetalCheckOutput();
        output.setCurrentPage(metalCheckRequest.getCurrentPage());
        output.setPageSize(metalCheckRequest.getPageSize());
        if(totalCount==0){
            output.setTotal(0);
            return output;
        }
        List<MetalCheckInfo> metalCheckInfoList = metalCheckDao.getMetalCheckList(metalCheckRequest);
        if(!ObjectUtils.isEmpty(metalCheckInfoList)){
            output.setTotal(totalCount);
            output.setMetalCheckData(metalCheckInfoList);
        }
        return output;
    }

    @Override
    public void downloadMetalCheck(MetalCheckRequest metalCheckRequest, HttpServletResponse response) {
        try {
            metalCheckRequest.setCurrentPage(0);
            MetalCheckOutput output = this.getMetalCheckList(metalCheckRequest);
            List<MetalCheckInfo> metalCheckInfoList = output.getMetalCheckData();
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("检针信息列表");
            HSSFRow row = null;
            row = sheet.createRow(0);
            row.setHeight((short) (30 * 20));
            row.createCell(0).setCellValue("检针信息列表");
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

            for (int i = 0; i < metalCheckInfoList.size(); i++) {
                row = sheet.createRow(i + 2);
                MetalCheckInfo metalCheckInfo = metalCheckInfoList.get(i);
                row.createCell(0).setCellValue(metalCheckInfo.getOrderNo());
                row.createCell(1).setCellValue(metalCheckInfo.getBuCode());
                row.createCell(2).setCellValue(metalCheckInfo.getSkuCode());
                row.createCell(3).setCellValue(metalCheckInfo.getSampleCode());
                row.createCell(4).setCellValue(metalCheckInfo.getColor());
                row.createCell(5).setCellValue(metalCheckInfo.getSize());
                row.createCell(6).setCellValue(metalCheckInfo.getPatternDimensionCode());
                row.createCell(7).setCellValue(metalCheckInfo.getOrderQty());
                row.createCell(8).setCellValue(metalCheckInfo.getScanNum());
            }
            sheet.setDefaultRowHeight((short) (16.5 * 20));
            //列宽自适应
            for (int i = 0; i <= 13; i++) {
                sheet.autoSizeColumn(i);
            }
            String fileName= "metalCheck";
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
