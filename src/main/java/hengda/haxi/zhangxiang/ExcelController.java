package hengda.haxi.zhangxiang;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/excel")
@SuppressWarnings("unchecked")
public class ExcelController {

    private Logger logger = LoggerFactory.getLogger(ExcelController.class);

    private final Journal02Mapper mapper02;

    private final String staticPath = "../webapp/public/";
    private final String targetDir = "download/";
    private final String templateJournal02Path = "./excel/template-journal02.xlsx";

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

            File buffer = new File(templateJournal02Path);
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

            BASE64Decoder dec = new BASE64Decoder();
            byte[] imgData;

//            调度签字
            if (map.get("sign_p_dd") != null) {
//            sheet.getRow(77).getCell(15).setCellValue(map.get("p_dd").toString());
                imgData = dec.decodeBuffer(map.get("sign_p_dd").toString().substring(22));
                for (int i = 0; i < imgData.length; ++i) {
                    if (imgData[i] < 0) {
                        imgData[i] += 256;
                    }
                }
                int picIdxDD = wb.addPicture(imgData, Workbook.PICTURE_TYPE_PNG);
                CreationHelper helperDD = wb.getCreationHelper();
                Drawing drawingDD = sheet.createDrawingPatriarch();
                ClientAnchor anchorDD = helperDD.createClientAnchor();
                anchorDD.setCol1(15);
                anchorDD.setRow1(77);
                Picture pictDD = drawingDD.createPicture(anchorDD, picIdxDD);
                pictDD.resize();
            }

//            技术员签字
            if (map.get("sign_p_jsy") != null) {
//            sheet.getRow(77).getCell(48).setCellValue(map.get("p_jsy").toString());
                imgData = dec.decodeBuffer(map.get("sign_p_jsy").toString().substring(22));
                for (int i = 0; i < imgData.length; ++i) {
                    if (imgData[i] < 0) {
                        imgData[i] += 256;
                    }
                }
                int picIdxJSY = wb.addPicture(imgData, Workbook.PICTURE_TYPE_PNG);
                CreationHelper helperJSY = wb.getCreationHelper();
                Drawing drawingJSY = sheet.createDrawingPatriarch();
                ClientAnchor anchorJSY = helperJSY.createClientAnchor();
                anchorJSY.setCol1(48);
                anchorJSY.setRow1(77);
                Picture pictJSY = drawingJSY.createPicture(anchorJSY, picIdxJSY);
                pictJSY.resize();
            }

//            值班所长签字
            if (map.get("sign_p_zbsz") != null) {
//            sheet.getRow(77).getCell(75).setCellValue(map.get("p_zbsz").toString());
                imgData = dec.decodeBuffer(map.get("sign_p_zbsz").toString().substring(22));
                for (int i = 0; i < imgData.length; ++i) {
                    if (imgData[i] < 0) {
                        imgData[i] += 256;
                    }
                }
                int picIdxZBSZ = wb.addPicture(imgData, Workbook.PICTURE_TYPE_PNG);
                CreationHelper helperZBSZ = wb.getCreationHelper();
                Drawing drawingZBSZ = sheet.createDrawingPatriarch();
                ClientAnchor anchorZBSZ = helperZBSZ.createClientAnchor();
                anchorZBSZ.setCol1(75);
                anchorZBSZ.setRow1(77);
                Picture pictZBSZ = drawingZBSZ.createPicture(anchorZBSZ, picIdxZBSZ);
                pictZBSZ.resize();
            }

            sheet.getRow(92).getCell(15).setCellValue(map.get("verify_report").toString());
            if (map.get("verify_leader_date") != null) {
                sheet.getRow(104).getCell(15).setCellValue(map.get("verify_leader_date").toString() + " " + map.get("verify_leader_time").toString());
            }

//            作业负责人签字
            if (map.get("sign_verify_leader") != null) {
//                sheet.getRow(104).getCell(75).setCellValue(map.get("verify_leader").toString());
                imgData = dec.decodeBuffer(map.get("sign_verify_leader").toString().substring(22));
                for (int i = 0; i < imgData.length; ++i) {
                    if (imgData[i] < 0) {
                        imgData[i] += 256;
                    }
                }
                int picIdxVerifyLeader = wb.addPicture(imgData, Workbook.PICTURE_TYPE_PNG);
                CreationHelper helperVerifyLeader = wb.getCreationHelper();
                Drawing drawingVerifyLeader = sheet.createDrawingPatriarch();
                ClientAnchor anchorVerifyLeader = helperVerifyLeader.createClientAnchor();
                anchorVerifyLeader.setCol1(75);
                anchorVerifyLeader.setRow1(104);
                Picture pictVerifyLeader = drawingVerifyLeader.createPicture(anchorVerifyLeader, picIdxVerifyLeader);
                pictVerifyLeader.resize();
            }

            if (map.get("verify_date") != null) {
                sheet.getRow(110).getCell(15).setCellValue(map.get("verify_date").toString() + " " + map.get("verify_time").toString());
            }

//            调度员签字
            if (map.get("sign_verify") != null) {
                sheet.getRow(110).getCell(75).setCellValue(map.get("verify").toString());
                imgData = dec.decodeBuffer(map.get("sign_verify").toString().substring(22));
                for (int i = 0; i < imgData.length; ++i) {
                    if (imgData[i] < 0) {
                        imgData[i] += 256;
                    }
                }
                int picIdxVerify = wb.addPicture(imgData, Workbook.PICTURE_TYPE_PNG);
                CreationHelper helperVerify = wb.getCreationHelper();
                Drawing drawingVerify = sheet.createDrawingPatriarch();
                ClientAnchor anchorVerify = helperVerify.createClientAnchor();
                anchorVerify.setCol1(75);
                anchorVerify.setRow1(104);
                Picture pictVerify = drawingVerify.createPicture(anchorVerify, picIdxVerify);
                pictVerify.resize();
            }

            String v = "技术员：" + map.get("p_jsy_content").toString() +
                    "   班组：" +
                    map.get("p_jsy_bz").toString() +
                    "   质检：" +
                    map.get("p_jsy_qc").toString();
            if (map.get("remark") != null) {
                v += map.get("remark").toString();
            }
            sheet.getRow(116).getCell(15).setCellValue(v);

            out = new FileOutputStream(staticPath + targetDir + map.get("uuid").toString() + ".xlsx");
            wb.write(out);

            r.put("content", targetDir + map.get("uuid").toString() + ".xlsx");
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
