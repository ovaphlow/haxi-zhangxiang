package hengda.haxi.zhangxiang;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/excel")
@SuppressWarnings("unchecked")
public class ExcelController {

    private Logger logger = LoggerFactory.getLogger(ExcelController.class);

    private final Journal02Mapper mapper02;

    @Autowired
    public ExcelController(Journal02Mapper mapper02) {
        this.mapper02 = mapper02;
    }

    @RequestMapping(value = "/journal02/{id}", method = RequestMethod.GET)
    public Map<String, Object> test(@PathVariable("id") int id) {
        Map<String, Object> r = new HashMap();
        OutputStream out = null;
        try {
            Map<String, Object> map = mapper02.get(id);
            File buffer = new File("c:/Users/ovaphlow/Desktop/template.xlsx");
            InputStream fis = new FileInputStream(buffer);
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);

            sheet.getRow(10).getCell(0).setCellValue("   申请单位：" + map.get("dept").toString());

            sheet.getRow(14).getCell(15).setCellValue(map.get("applicant").toString());
            sheet.getRow(14).getCell(58).setCellValue(map.get("applicant_phone").toString());
            sheet.getRow(18).getCell(15).setCellValue(map.get("leader").toString());
            sheet.getRow(18).getCell(58).setCellValue(map.get("leader_phone").toString());
            sheet.getRow(22).getCell(15).setCellValue(map.get("group_sn").toString());
            sheet.getRow(26).getCell(15).setCellValue(map.get("date_begin_alt").toString() +
                    " " +
                    map.get("time_begin_alt").toString() +
                    " ---- " +
                    map.get("time_end_alt").toString());
            sheet.getRow(32).getCell(15).setCellValue(map.get("content").toString() + "\n" + map.get("content_detail").toString());

//            "□✓"
            if ("供".equals(map.get("p_yq_xdc").toString())) {
                sheet.getRow(52).getCell(26).setCellValue("             ✓供         □断         □无要求");
            } else if ("断".equals(map.get("p_yq_xdc").toString())) {
                sheet.getRow(52).getCell(26).setCellValue("             □供         ✓断         □无要求");
            } else if ("无要求".equals(map.get("p_yq_xdc").toString())) {
                sheet.getRow(52).getCell(26).setCellValue("             □供         □断         ✓无要求");
            }

            if ("供".equals(map.get("p_yq_jcw").toString())) {
                sheet.getRow(57).getCell(26).setCellValue("             ✓供         □断         □无要求");
            } else if ("断".equals(map.get("p_yq_jcw").toString())) {
                sheet.getRow(57).getCell(26).setCellValue("             □供         ✓断         □无要求");
            } else if ("无要求".equals(map.get("p_yq_jcw").toString())) {
                sheet.getRow(57).getCell(26).setCellValue("             □供         □断         ✓无要求");
            }

            if ("供".equals(map.get("p_yq_zydd").toString())) {
                sheet.getRow(62).getCell(26).setCellValue("             ✓供         □断         □无要求");
            } else if ("断".equals(map.get("p_yq_zydd").toString())) {
                sheet.getRow(62).getCell(26).setCellValue("             □供         ✓断         □无要求");
            } else if ("无要求".equals(map.get("p_yq_zydd").toString())) {
                sheet.getRow(62).getCell(26).setCellValue("             □供         □断         ✓无要求");
            }

            sheet.getRow(67).getCell(26).setCellValue(map.get("p_yq_qt").toString());

            out = new FileOutputStream("c:/Users/ovaphlow/Desktop/out.xlsx");
            wb.write(out);

            r.put("content", "");
            r.put("message", "");
        } catch (Exception e) {
            e.printStackTrace();
            r.put("content", "");
            r.put("message", "服务器错误。");
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return r;
    }
}
