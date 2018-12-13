package hengda.haxi.zhangxiang;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExcelService {

    private Logger logger = LoggerFactory.getLogger(ExcelService.class);
    private Document02DetailRepos repos;
    private final String staticPath = "../webapp/";
    private final String targetDir = "download/";
    private final String templateJournal02Detail02Path = "./excel/template-journal02.02.xlsx";
    private final String templateJournal02Detail03Path = "./excel/template-journal02.03.xlsx";

    @Autowired
    public ExcelService(Document02DetailRepos repos) {
        this.repos = repos;
    }
    
    private void Document02Detail02ExportToExcelWriteRow(Sheet sheet, int row, Map<String, Object> data) {
        sheet.getRow(row + 3).getCell(0).setCellValue(data.get("name").toString());
        sheet.getRow(row + 3).getCell(1).setCellValue(data.get("train").toString());
        sheet.getRow(row + 3).getCell(2).setCellValue(data.get("carriage").toString());
        sheet.getRow(row + 3).getCell(3).setCellValue(data.get("position").toString());
        sheet.getRow(row + 3).getCell(4).setCellValue(data.get("date").toString());
        sheet.getRow(row + 3).getCell(5).setCellValue(data.get("time").toString());
        sheet.getRow(row + 3).getCell(6).setCellValue(data.get("reason").toString());
        sheet.getRow(row + 3).getCell(7).setCellValue(data.get("p_gywj").toString());
        sheet.getRow(row + 3).getCell(8).setCellValue(data.get("p_ljbs").toString());
        sheet.getRow(row + 3).getCell(9).setCellValue(data.get("component_sn_old").toString());
        sheet.getRow(row + 3).getCell(10).setCellValue(data.get("component_sn_new").toString());
        sheet.getRow(row + 3).getCell(11).setCellValue(data.get("p_bjaz").toString());
        sheet.getRow(row + 3).getCell(12).setCellValue(data.get("operator").toString());
        sheet.getRow(row + 3).getCell(13).setCellValue(data.get("leader").toString());
        sheet.getRow(row + 3).getCell(14).setCellValue(data.get("p_bjgnsy").toString());
        sheet.getRow(row + 3).getCell(15).setCellValue(data.get("qc").toString());
        sheet.getRow(row + 3).getCell(16).setCellValue(data.get("duty_officer").toString());
    }

    private void Document02Detail03ExportToExcelWriteRow(Sheet sheet, int row, Map<String, Object> data) {
        sheet.getRow(row + 3).getCell(0).setCellValue(data.get("name").toString());
        sheet.getRow(row + 3).getCell(1).setCellValue(data.get("train").toString());
        sheet.getRow(row + 3).getCell(2).setCellValue(data.get("carriage").toString());
        sheet.getRow(row + 3).getCell(3).setCellValue(data.get("position").toString());
        sheet.getRow(row + 3).getCell(4).setCellValue(data.get("date").toString());
        sheet.getRow(row + 3).getCell(5).setCellValue(data.get("time").toString());
        sheet.getRow(row + 3).getCell(6).setCellValue(data.get("production_date").toString());
        sheet.getRow(row + 3).getCell(7).setCellValue(data.get("reason").toString());
        sheet.getRow(row + 3).getCell(8).setCellValue(data.get("p_gywj").toString());
        sheet.getRow(row + 3).getCell(9).setCellValue(data.get("p_ljbs").toString());
        sheet.getRow(row + 3).getCell(10).setCellValue(data.get("component_sn_old").toString());
        sheet.getRow(row + 3).getCell(11).setCellValue(data.get("component_sn_new").toString());
        sheet.getRow(row + 3).getCell(12).setCellValue(data.get("p_bjaz").toString());
        sheet.getRow(row + 3).getCell(13).setCellValue(data.get("operator").toString());
        sheet.getRow(row + 3).getCell(14).setCellValue(data.get("leader").toString());
        sheet.getRow(row + 3).getCell(15).setCellValue(data.get("p_bjgnsy").toString());
        sheet.getRow(row + 3).getCell(16).setCellValue(data.get("qc").toString());
        sheet.getRow(row + 3).getCell(17).setCellValue(data.get("duty_officer").toString());
    }

    public Map<String, Object> Document02Detail02ExportToExcel(int id) {
        Map<String, Object> resp = new HashMap<>();
        List<Map<String, Object>> result = repos.list02(id);
        if (result.size() == 0) {
            resp.put("message", "没有对应的数据");
            return resp;
        }
        if (result.size() > 30) {
            resp.put("message", "数据过多");
            return resp;
        }

        double total = result.size();
        double page = 10;
        int sheet_qty = (int) Math.ceil(total / page);

        OutputStream out = null;
        File buffer = new File(templateJournal02Detail02Path);
        try {
            InputStream fis = new FileInputStream(buffer);
            Workbook wb = new XSSFWorkbook(fis);
            for (int i = 0; i < sheet_qty; i++) {
                Sheet sheet = wb.getSheetAt(i);
                int remain = result.size() - (int) page * i;
                remain = remain > 10 ? 10 : remain;
                for (int j = 0; j < remain; j++) {
                    Document02Detail02ExportToExcelWriteRow(sheet, j, result.get((int) page * i + j));
                }
            }
            out = new FileOutputStream(staticPath + targetDir + result.get(0).get("uuid").toString() + ".xlsx");
            wb.write(out);

            resp.put("content", targetDir + result.get(0).get("uuid").toString() + ".xlsx");
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    public Map<String, Object> Document02Detail03ExportToExcel(int id) {
        Map<String, Object> resp = new HashMap<>();
        List<Map<String, Object>> result = repos.list03(id);
        if (result.size() == 0) {
            resp.put("content", "");
            resp.put("message", "没有对应的数据");
            return resp;
        }
        if (result.size() > 30) {
            resp.put("message", "数据过多");
            return resp;
        }

        double total = result.size();
        double page = 10;
        int sheet_qty = (int) Math.ceil(total / page);

        OutputStream out = null;
        File buffer = new File(templateJournal02Detail03Path);
        try {
            InputStream fis = new FileInputStream(buffer);
            Workbook wb = new XSSFWorkbook(fis);
            for (int i = 0; i < sheet_qty; i++) {
                Sheet sheet = wb.getSheetAt(i);
                int remain = result.size() - (int) page * i;
                remain = remain > 10 ? 10 : remain;
                for (int j = 0; j < remain; j++) {
                    Document02Detail03ExportToExcelWriteRow(sheet, j, result.get((int) page * i + j));
                }
            }
            out = new FileOutputStream(staticPath + targetDir + result.get(0).get("uuid").toString() + ".xlsx");
            wb.write(out);

            resp.put("content", targetDir + result.get(0).get("uuid").toString() + ".xlsx");
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }
}
