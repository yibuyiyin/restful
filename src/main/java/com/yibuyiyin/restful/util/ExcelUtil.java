package com.yibuyiyin.restful.util;

import lombok.var;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Excel工具类
 */
public class ExcelUtil {

	/**
     * Excel表格导出
     * @param response HttpServletResponse对象
     * @param excelData Excel表格的数据，封装为List<List<String>>
     * @param sheetName sheet的名字
     * @param fileName 导出Excel的文件名
     * @param columnWidth Excel表格的宽度，建议为15
     * @throws IOException 抛IO异常
     */
    public static void exportExcel(HttpServletRequest request,
                                   HttpServletResponse response,
                                   List<List<String>> excelData,
                                   String sheetName,
                                   String fileName,
                                   int columnWidth) throws IOException {
        var workbook = createExcel(excelData, sheetName, columnWidth);
		String userAgent = request.getHeader("User-Agent").toLowerCase();
		//针对IE或者以IE为内核的浏览器：
		if (userAgent.contains("msie") || userAgent.contains("like gecko") ) {
			fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
		} else {
			//非IE浏览器的处理：
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}
        //准备将Excel的输出流通过response输出到页面下载
		response.reset();
		//设置导出Excel的名称
		response.addHeader("Access-Control-Expose-Headers", "Content-Disposition, fileName");//
		response.addHeader("fileName", URLEncoder.encode(fileName,"UTF-8"));
		response.setContentType("application/octet-stream;charset=UTF-8");
		//设置导出Excel的名称
		response.setHeader("Content-Disposition", "attachment;fileName="+ new String(fileName.getBytes("gbk"), "iso8859-1"));
        //刷新缓冲
        response.flushBuffer();
        //刷新缓冲
        //workbook将Excel写入到response的输出流中，供页面下载该Excel文件
        workbook.write(response.getOutputStream());

        //关闭workbook
        workbook.close();
    }

    /**
     * 生成excel
     * @param excelData
     * @param sheetName
     * @param columnWidth
     * @return
     */
    public static HSSFWorkbook createExcel(
            List<List<String>> excelData,
            String sheetName,
            int columnWidth
    ) {
        //声明一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        //生成一个表格，设置表格名称
        HSSFSheet sheet = workbook.createSheet(sheetName);

        //设置表格列宽度
        sheet.setDefaultColumnWidth(columnWidth);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setAlignment(HorizontalAlignment.CENTER);//水平居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中

        // 背景色
//        style.setFillForegroundColor(HSSFColor.YELLOW.index);
//        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//        style.setFillBackgroundColor(HSSFColor.YELLOW.index);

        // 设置边框
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        // 自动换行
        style.setWrapText(true);

        // 生成一个字体
        //HSSFFont font = workbook.createFont();
        //font.setFontHeightInPoints((short) 10);
        //font.setColor(HSSFColor.RED.index);
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //font.setFontName("宋体");
        // 把字体 应用到当前样式
        //style.setFont(font);

        //写入List<List<String>>中的数据
        int rowIndex = 0;
        for(List<String> data : excelData){
            //创建一个row行，然后自增1
            HSSFRow row = sheet.createRow(rowIndex++);
            //遍历添加本行数据
            for (int i = 0; i < data.size(); i++) {
                //创建一个单元格
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(style);//style设置好后，为cell设置样式
                //创建一个内容对象
                HSSFRichTextString text = new HSSFRichTextString(data.get(i));

                //将内容对象的文字内容写入到单元格中
                cell.setCellValue(text);
            }
        }
        return workbook;
    }

}