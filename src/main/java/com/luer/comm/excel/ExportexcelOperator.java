package com.luer.comm.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import com.luer.operator.bean.Operator;
import com.luer.operator.service.OperatorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

/**
 * 导出数据到excel表格
 * Created by shenjianhua on 2018-12-28
 */

/**
 * 常用组件：
 * <p>
 * HSSFWorkbook    excel的文档对象
 * <p>
 * HSSFSheet       excel的表单
 * <p>
 * HSSFRow        excel的行
 * <p>
 * HSSFCell       excel的格子单元
 * <p>
 * HSSFFont        excel字体
 * <p>
 * 样式：
 * <p>
 * HSSFCellStyle    cell样式
 */

@RestController
@RequestMapping("/exportExcel1")
@Api(description = "导出数据到excel表格")
public class ExportexcelOperator {

    @Autowired
    OperatorService operatorService;

    @CrossOrigin
    @ApiOperation(value = "导出操作员信息到ecxel表格", notes = "导出操作员信息到ecxel表格", httpMethod = "POST")
    @ApiImplicitParam(name = "", value = "", required = true, dataType = "")
    @ResponseBody
    @PostMapping("/exportOperator")
    public void ExportNoResponse(/*String titleName, String sheetName,
                                                  int columnNumber, String[] columnName, String[][] dataList, String fileName, */) {
/*----------------------------------------造传参数据-------------------------------------------------------------*/
        //excel的表单名
        String sheetName = "操作员信息数据表";
        //excel的标题名
        String titleName = "操作员信息数据表";
        //提示 没啥用
        String fileName = "操作员信息数据表";
        //字段数量
        int columnNumber = 11;
        List<Operator> operators = operatorService.select();
        String[] columnName = {"操作员id", "创造时间", "更新时间", "登录账号", "登录密码", "昵称","用户角色","角色状态", "手机号码", "邮箱", "注释"};
        String[][] dataList = new String[operators.size()][20];
        for (int i = 0; i < operators.size(); i++) {
            if (null != operators.get(i).getId()) {
                dataList[i][0] = operators.get(i).getId();
            }else {
                dataList[i][0] = null;
            }
            if (null != operators.get(i).getCreateTime()) {
                dataList[i][1] = operators.get(i).getCreateTime().toLocaleString();
            }else {
                dataList[i][1] = null;
            }

            if (null != operators.get(i).getUpdateTime()) {
                dataList[i][2] = operators.get(i).getUpdateTime().toLocaleString();
            }else {
                dataList[i][2] = null;
            }

            if (null != operators.get(i).getUsername()) {
                dataList[i][3] = operators.get(i).getUsername();
            }else {
                dataList[i][3] = null;
            }
            if(null != operators.get(i).getPassword()) {
                dataList[i][4] = operators.get(i).getPassword();
            }else {
                dataList[i][4] = null;
            }
            if(null != operators.get(i).getNickname()) {
                dataList[i][5] = operators.get(i).getNickname();
            }else {
                dataList[i][5] = null;
            }

            if(null != operators.get(i).getRole()) {
                dataList[i][6] = operators.get(i).getRole();
            }else {
                dataList[i][6] = null;
            }

            if(null != operators.get(i).getState()) {
                dataList[i][7] = operators.get(i).getState();
            }else {
                dataList[i][7] = null;
            }

            if(null != operators.get(i).getPhoneNumber()) {
                dataList[i][8] = operators.get(i).getPhoneNumber();
            }else {
                dataList[i][8] = null;
            }

            if(null != operators.get(i).getEmail()) {
                dataList[i][9] = operators.get(i).getEmail();
            }else {
                dataList[i][9] = null;
            }

            if(null != operators.get(i).getRemark()) {
                dataList[i][10] = operators.get(i).getRemark();
            }else {
                dataList[i][10] = null;
            }
        }

        /*-----------------------------------------------造传参数据-----------------------------------------------------------------------------*/

        int flag = 0;
        int[] columnWidth = new int[columnNumber];
        for (flag = 0; flag < columnNumber; flag++) {
            if (flag == 0) {
                columnWidth[flag] = 40;
            } else {
                columnWidth[flag] = 30;
            }
        }

        if (columnNumber == columnWidth.length && columnWidth.length == columnName.length) {
            // 第一步，创建一个webbook，对应一个Excel文件
            HSSFWorkbook wb = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet sheet = wb.createSheet(sheetName);
            // sheet.setDefaultColumnWidth(15); //统一设置列宽
            for (int i = 0; i < columnNumber; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i == j) {
                        sheet.setColumnWidth(i, columnWidth[j] * 256); // 单独设置每列的宽
                    }
                }
            }
            // 创建第0行 也就是标题
            HSSFRow row1 = sheet.createRow((int) 0);
            row1.setHeightInPoints(30);// 设备标题的高度
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
            row.setHeightInPoints(30);// 设置表头高度

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
            for (int i = 0; i < columnNumber; i++) {
                HSSFCell cell = row.createCell(i);
                cell.setCellValue(columnName[i]);
                cell.setCellStyle(style);
            }

            // 第五步，创建单元格，并设置值
            for (int i = 0; i < dataList.length; i++) {
                row = sheet.createRow((int) i + 2);
                // 为数据内容设置特点新单元格样式1 自动换行 上下居中
                HSSFCellStyle zidonghuanhang = wb.createCellStyle();
                zidonghuanhang.setWrapText(true);// 设置自动换行
                zidonghuanhang.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式

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
                zidonghuanhang2.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 左右居中-----------------------------

                // 设置边框
                zidonghuanhang2.setBottomBorderColor(HSSFColor.BLACK.index);
                zidonghuanhang2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
                zidonghuanhang2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
                zidonghuanhang2.setBorderRight(HSSFCellStyle.BORDER_THIN);
                zidonghuanhang2.setBorderTop(HSSFCellStyle.BORDER_THIN);
                HSSFCell datacell = null;
                for (int j = 0; j < columnNumber; j++) {
                    datacell = row.createCell(j);
                    datacell.setCellValue(dataList[i][j]);
                    datacell.setCellStyle(zidonghuanhang2);
                }
            }

            // 第六步，将文件存到指定位置
            try {
                FileOutputStream fout = new FileOutputStream(new File("D:operator.xls"));
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
    }

}
