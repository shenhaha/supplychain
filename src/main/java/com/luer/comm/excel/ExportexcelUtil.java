package com.luer.comm.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import com.luer.basicsetup.bean.Materialmessage;
import com.luer.basicsetup.service.MaterialmessageService;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


/**
 * 导出数据到excel表格
 * Created by shenjianhua on 2018-12-28
 */

/**
 *常用组件：
 *
 *     HSSFWorkbook    excel的文档对象
 *
 *     HSSFSheet       excel的表单
 *
 *     HSSFRow        excel的行
 *
 *     HSSFCell       excel的格子单元
 *
 *     HSSFFont        excel字体
 *
 *     样式：
 *
 *     HSSFCellStyle    cell样式
 *
 * */

@RestController
@RequestMapping("/exportExcel")
@Api(description = "导出数据到excel表格")
public class ExportexcelUtil {


  /*  public static void main(String [] args) throws Exception {

        //excel的表单名
        String sheetName = "原材料信息数据表";
        //excel的标题名
        String titleName = "原材料信息数据表";
        //提示 没啥用
        String fileName = "原材料信息数据表";
        //int columnNumber = 3;
        int columnNumber = 20;
        //int[] columnWidth = { 10, 20, 30 };
        //int[] columnWidth = {40,20,20,20,20,20,20,20,20};
        String[][] dataList = {
            {"4e7a2bbe5cc243b214b3824596cd543", "2018-12-27 10:34:19", "2018-12-27 10:34:19", "usernamedsfsdsf", "passwrodsdlkjflsd", "nicknamesdgfds", "18896876323", "1324325432.qq.com", "remarkdsgfdg", "4e7a2bbe5cc24a63b214b3824596cd543", "2018-12-27 10:34:19", "2018-12-27 10:34:19", "usernamedsfsdsf", "passwrodsdlkjflsd", "nicknamesdgfds", "18896876323", "1324325432.qq.com", "remarkdsgfdg", "1324325432.qq.com", "remarkdsgfdg"},
            {"4e7a2bbe5cc24a6314b3824596cd543", "2018-12-27 10:34:19", "2018-12-27 10:34:19", "usernamedsfsdsf", "passwrodsdlkjflsd", "nicknamesdgfds", "18896876323", "1324325432.qq.com", "remarkdsgfdg", "4e7a2bbe5cc24a63b214b3824596cd543", "2018-12-27 10:34:19", "2018-12-27 10:34:19", "usernamedsfsdsf", "passwrodsdlkjflsd", "nicknamesdgfds", "18896876323", "1324325432.qq.com", "remarkdsgfdg", "1324325432.qq.com", "remarkdsgfdg"},
        };
        String[] columnName = { "原材料信息id", "创造时间", "更新时间","物料名称","物料编码","物料分类","默认损耗","厂商","成本价","基本计量单位","成份","启用状态","数据状态","备用字段1","备用字段2","备用字段3","备用字段4","备用字段5","备用字段6","备注"};
        new ExportexcelUtil().ExportNoResponse(sheetName, titleName,
                columnNumber, columnName, dataList, fileName);
    }*/



  /*  @GetMapping("/export")
    @ResponseBody
    public ResultSet test() throws Exception{
        //excel的表单名
        String sheetName = "原材料信息数据表";
        //excel的标题名
        String titleName = "原材料信息数据表";
        //提示 没啥用
        String fileName = "原材料信息数据表";
        //int columnNumber = 3;
        int columnNumber = 20;
        List<Materialmessage> materialmessages = materialmessageService.select();
        String[] columnName = { "原材料信息id", "创造时间", "更新时间","物料名称","物料编码","物料分类","默认损耗","厂商","成本价","基本计量单位","成份","启用状态","数据状态","备用字段1","备用字段2","备用字段3","备用字段4","备用字段5","备用字段6","备注"};
        String[][] dataList = new String[materialmessages.size()][20];
        for(int i=0;i<materialmessages.size();i++) {
            if(StringUtils.isNotBlank(materialmessages.get(i).getId())){
                dataList[i][0] = materialmessages.get(i).getId();
            }else {
                dataList[i][0] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getCreateTime().toString())){
                    dataList[i][1] = materialmessages.get(i).getCreateTime().toString();
                }else {
                    dataList[i][1] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getUpdateTime().toString())){
                dataList[i][2] = materialmessages.get(i).getUpdateTime().toString();
            }else {
                dataList[i][2] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getName())){
                dataList[i][3] = materialmessages.get(i).getName();
            }else {
                dataList[i][3] = null;
            }

            if(StringUtils.isNotBlank(materialmessages.get(i).getMaterialCode())){
                dataList[i][4] = materialmessages.get(i).getMaterialCode();
            }else {
                dataList[i][4] = null;
            }

            if(StringUtils.isNotBlank(materialmessages.get(i).getType())){
                dataList[i][5] = materialmessages.get(i).getType();
            }else {
                dataList[i][5] = null;
            }

            if(StringUtils.isNotBlank(materialmessages.get(i).getDefaultLoss())){
                dataList[i][6] = materialmessages.get(i).getDefaultLoss();
            }else {
                dataList[i][6] = null;
            }

            if(StringUtils.isNotBlank(materialmessages.get(i).getManufacturer())){
                dataList[i][7] = materialmessages.get(i).getManufacturer();
            }else {
                dataList[i][7] = null;
            }

            if(StringUtils.isNotBlank(materialmessages.get(i).getCostPrice())){
                dataList[i][8] = materialmessages.get(i).getCostPrice();
            }else {
                dataList[i][8] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getUnit())){
                dataList[i][9] = materialmessages.get(i).getUnit();
            }else {
                dataList[i][9] = null;
            }

            if(StringUtils.isNotBlank(materialmessages.get(i).getIngredients())){
                dataList[i][10] = materialmessages.get(i).getIngredients();
            }else {
                dataList[i][10] = null;
            }

            if(StringUtils.isNotBlank(materialmessages.get(i).getSpare())){
                dataList[i][11] = materialmessages.get(i).getSpare();
            }else {
                dataList[i][11] = null;
            }

            if(StringUtils.isNotBlank(materialmessages.get(i).getDataState())){
                dataList[i][12] = materialmessages.get(i).getDataState();
            }else {
                dataList[i][12] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getSpare01())){
                dataList[i][13] = materialmessages.get(i).getSpare01();
            }else {
                dataList[i][13] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getSpare02())){
                dataList[i][14] = materialmessages.get(i).getSpare02();
            }else {
                dataList[i][14] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getSpare03())){
                dataList[i][15] = materialmessages.get(i).getSpare03();
            }else {
                dataList[i][15] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getSpare04())){
                dataList[i][16] = materialmessages.get(i).getSpare04();
            }else {
                dataList[i][16] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getSpare05())){
                dataList[i][17] = materialmessages.get(i).getSpare05();
            }else {
                dataList[i][17] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getSpare06())){
                dataList[i][18] = materialmessages.get(i).getSpare06();
            }else {
                dataList[i][18] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getRemark())){
                dataList[i][19] = materialmessages.get(i).getRemark();
            }else {
                dataList[i][19] = null;
            }
        }
        MultipartFile file  = ExportexcelUtil.ExportNoResponse(titleName,sheetName,columnNumber,columnName,dataList,fileName);

        return ResultSet.getSuccess();
    }*/

    @Autowired
    private MaterialmessageService materialmessageService;

    @GetMapping("/export")
    public void ExportNoResponse(/*String titleName, String sheetName,
                                                  int columnNumber, String[] columnName, String[][] dataList, String fileName, */HttpServletResponse response){

        //excel的表单名
        String sheetName = "原材料信息数据表";
        //excel的标题名
        String titleName = "原材料信息数据表";
        //提示 没啥用
        String fileName = "原材料信息数据表";
        //字段数量
        int columnNumber = 20;
        String[] columnName = { "原材料信息id", "创造时间", "更新时间","物料名称","物料编码","物料分类","默认损耗","厂商","成本价","基本计量单位","成份","启用状态","数据状态","备用字段1","备用字段2","备用字段3","备用字段4","备用字段5","备用字段6","备注"};
        List<Materialmessage> materialmessages = materialmessageService.select();
        String[][] dataList = new String[materialmessages.size()][20];
        for(int i=0;i<materialmessages.size();i++) {
            if(StringUtils.isNotBlank(materialmessages.get(i).getId())){
                dataList[i][0] = materialmessages.get(i).getId();
            }else {
                dataList[i][0] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getCreateTime().toString())){
                dataList[i][1] = materialmessages.get(i).getCreateTime().toString();
            }else {
                dataList[i][1] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getUpdateTime().toString())){
                dataList[i][2] = materialmessages.get(i).getUpdateTime().toString();
            }else {
                dataList[i][2] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getName())){
                dataList[i][3] = materialmessages.get(i).getName();
            }else {
                dataList[i][3] = null;
            }

            if(StringUtils.isNotBlank(materialmessages.get(i).getMaterialCode())){
                dataList[i][4] = materialmessages.get(i).getMaterialCode();
            }else {
                dataList[i][4] = null;
            }

            if(StringUtils.isNotBlank(materialmessages.get(i).getType())){
                dataList[i][5] = materialmessages.get(i).getType();
            }else {
                dataList[i][5] = null;
            }

            if(StringUtils.isNotBlank(materialmessages.get(i).getDefaultLoss())){
                dataList[i][6] = materialmessages.get(i).getDefaultLoss();
            }else {
                dataList[i][6] = null;
            }

            if(StringUtils.isNotBlank(materialmessages.get(i).getManufacturer())){
                dataList[i][7] = materialmessages.get(i).getManufacturer();
            }else {
                dataList[i][7] = null;
            }

            /*if(StringUtils.isNotBlank(materialmessages.get(i).getCostPrice())){
                dataList[i][8] = materialmessages.get(i).getCostPrice();
            }else {
                dataList[i][8] = null;
            }*/
            if(StringUtils.isNotBlank(materialmessages.get(i).getUnit())){
                dataList[i][9] = materialmessages.get(i).getUnit();
            }else {
                dataList[i][9] = null;
            }

            if(StringUtils.isNotBlank(materialmessages.get(i).getIngredients())){
                dataList[i][10] = materialmessages.get(i).getIngredients();
            }else {
                dataList[i][10] = null;
            }

            if(StringUtils.isNotBlank(materialmessages.get(i).getSpare())){
                dataList[i][11] = materialmessages.get(i).getSpare();
            }else {
                dataList[i][11] = null;
            }

            if(StringUtils.isNotBlank(materialmessages.get(i).getDataState())){
                dataList[i][12] = materialmessages.get(i).getDataState();
            }else {
                dataList[i][12] = null;
            }

            if(StringUtils.isNotBlank(materialmessages.get(i).getSpare02())){
                dataList[i][14] = materialmessages.get(i).getSpare02();
            }else {
                dataList[i][14] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getSpare03())){
                dataList[i][15] = materialmessages.get(i).getSpare03();
            }else {
                dataList[i][15] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getSpare04())){
                dataList[i][16] = materialmessages.get(i).getSpare04();
            }else {
                dataList[i][16] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getSpare05())){
                dataList[i][17] = materialmessages.get(i).getSpare05();
            }else {
                dataList[i][17] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getSpare06())){
                dataList[i][18] = materialmessages.get(i).getSpare06();
            }else {
                dataList[i][18] = null;
            }
            if(StringUtils.isNotBlank(materialmessages.get(i).getRemark())){
                dataList[i][19] = materialmessages.get(i).getRemark();
            }else {
                dataList[i][19] = null;
            }
        }

/*----------------------------------------------------------------------------------------------------------------------------*/

        int flag = 0;
        int[] columnWidth=new int[columnNumber];
        for(flag=0;flag<columnNumber;flag++){
            if(flag==0){
                columnWidth[flag] = 40;
                //System.out.println("columnWidth[i]: "+columnWidth[flag]);
            }else{
                columnWidth[flag] = 30;
                //System.out.println("columnWidth[i]: "+columnWidth[flag]);
            }
        }

        if (columnNumber == columnWidth.length&& columnWidth.length == columnName.length) {
            // 第一步，创建一个webbook，对应一个Excel文件
            HSSFWorkbook wb = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet sheet = wb.createSheet(sheetName);
            // sheet.setDefaultColumnWidth(15); //统一设置列宽
            for (int i = 0; i < columnNumber; i++)
            {
                for (int j = 0; j <= i; j++)
                {
                    if (i == j)
                    {
                        sheet.setColumnWidth(i, columnWidth[j] * 256); // 单独设置每列的宽
                    }
                }
            }
            // 创建第0行 也就是标题
            HSSFRow row1 = sheet.createRow((int) 0);
            row1.setHeightInPoints(50);// 设备标题的高度
            // 第三步创建标题的单元格样式style2以及字体样式headerFont1
            HSSFCellStyle style2 = wb.createCellStyle();
            style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            style2.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
            style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            HSSFFont headerFont1 = (HSSFFont) wb.createFont(); // 创建字体样式
            headerFont1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗
            headerFont1.setFontName("黑体"); // 设置字体类型
            headerFont1.setFontHeightInPoints((short) 15); // 设置字体大小
            style2.setFont(headerFont1); // 为标题样式设置字体样式

            HSSFCell cell1 = row1.createCell(0);// 创建标题第一列
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,
                    columnNumber - 1)); // 合并第0到第17列
            cell1.setCellValue(titleName); // 设置值标题
            cell1.setCellStyle(style2); // 设置标题样式

            // 创建第1行 也就是表头
            HSSFRow row = sheet.createRow((int) 1);
            row.setHeightInPoints(37);// 设置表头高度

            // 第四步，创建表头单元格样式 以及表头的字体样式
            HSSFCellStyle style = wb.createCellStyle();
            style.setWrapText(true);// 设置自动换行
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式

            style.setBottomBorderColor(HSSFColor.BLACK.index);
            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);
            style.setBorderTop(HSSFCellStyle.BORDER_THIN);

            HSSFFont headerFont = (HSSFFont) wb.createFont(); // 创建字体样式
            headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗
            headerFont.setFontName("黑体"); // 设置字体类型
            headerFont.setFontHeightInPoints((short) 10); // 设置字体大小
            style.setFont(headerFont); // 为标题样式设置字体样式

            // 第四.一步，创建表头的列
            for (int i = 0; i < columnNumber; i++)
            {
                HSSFCell cell = row.createCell(i);
                cell.setCellValue(columnName[i]);
                cell.setCellStyle(style);
            }

            // 第五步，创建单元格，并设置值
            for (int i = 0; i < dataList.length; i++)
            {
                row = sheet.createRow((int) i + 2);
                // 为数据内容设置特点新单元格样式1 自动换行 上下居中
                HSSFCellStyle zidonghuanhang = wb.createCellStyle();
                zidonghuanhang.setWrapText(true);// 设置自动换行
                zidonghuanhang
                        .setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式

                // 设置边框
                zidonghuanhang.setBottomBorderColor(HSSFColor.BLACK.index);
                zidonghuanhang.setBorderBottom(HSSFCellStyle.BORDER_THIN);
                zidonghuanhang.setBorderLeft(HSSFCellStyle.BORDER_THIN);
                zidonghuanhang.setBorderRight(HSSFCellStyle.BORDER_THIN);
                zidonghuanhang.setBorderTop(HSSFCellStyle.BORDER_THIN);

                // 为数据内容设置特点新单元格样式2 自动换行 上下居中左右也居中
                HSSFCellStyle zidonghuanhang2 = wb.createCellStyle();
                zidonghuanhang2.setWrapText(true);// 设置自动换行
                zidonghuanhang2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个上下居中格式
                zidonghuanhang2.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中

                // 设置边框
                zidonghuanhang2.setBottomBorderColor(HSSFColor.BLACK.index);
                zidonghuanhang2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
                zidonghuanhang2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
                zidonghuanhang2.setBorderRight(HSSFCellStyle.BORDER_THIN);
                zidonghuanhang2.setBorderTop(HSSFCellStyle.BORDER_THIN);
                HSSFCell datacell = null;
                for (int j = 0; j < columnNumber; j++)
                {
                    datacell = row.createCell(j);
                    datacell.setCellValue(dataList[i][j]);
                    datacell.setCellStyle(zidonghuanhang2);
                }
            }

            // 第六步，将文件存到指定位置
            try {
                FileOutputStream fout = new FileOutputStream(new File("D:material.xls"));
                wb.write(fout);
                String str = "导出" + fileName + "成功！";
                System.out.println(str);
                fout.close();
            } catch (Exception e) {
                e.printStackTrace();
                String str1 = "导出" + fileName + "失败！";
                System.out.println(str1);
            }
        } else {
            System.out.println("列数目长度名称三个数组长度要一致");
        }
       // return new File("D:/material.xls");
    }

}
