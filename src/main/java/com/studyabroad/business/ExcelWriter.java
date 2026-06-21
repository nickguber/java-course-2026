package com.studyabroad.business;

import com.studyabroad.model.AbroadCourse;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ExcelWriter {

    private static final String FILE_PATH = "src/main/java/com/studyabroad/db/abroad_course_accounting_applications.xlsx";

    public synchronized void writeAbroadCourse(AbroadCourse course) {

        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            fis.close();

            int rowNum = sheet.getLastRowNum() + 1;
            Row row = sheet.createRow(rowNum);

            row.createCell(0).setCellValue(course.getUniversity());
            row.createCell(1).setCellValue(course.getCity());
            row.createCell(2).setCellValue(course.getCountry());
            row.createCell(3).setCellValue(course.getCourseId());
            row.createCell(4).setCellValue(course.getCourseName());
            row.createCell(5).setCellValue(course.getErasmusID() != null ? String.valueOf(course.getErasmusID()) : "X");
            row.createCell(6).setCellValue(course.getEcts());
            row.createCell(7).setCellValue(course.getCourseURL());
            row.createCell(8).setCellValue(course.getDiplom());

            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            workbook.write(fos);
            fos.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}