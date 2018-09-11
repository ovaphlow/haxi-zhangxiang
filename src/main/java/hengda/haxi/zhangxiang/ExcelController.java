package hengda.haxi.zhangxiang;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
// import sun.misc.BASE64Decoder;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/excel")
@SuppressWarnings("unchecked")
public class ExcelController {

    private Logger logger = LoggerFactory.getLogger(ExcelController.class);


    private final String staticPath = "../webapp/";
    private final String targetDir = "download/";
    private final String templateJournal02Path = "./excel/template-journal02.xlsx";
    private final String templateJournal02Detail01Path = "./excel/template-journal02.01.xlsx";
    private final String templateJournal02Detail02Path = "./excel/template-journal02.02.xlsx";
    private final String templateJournal02Detail03Path = "./excel/template-journal02.03.xlsx";
    private final String templateJournal02Detail04Path = "./excel/template-journal02.04.xlsx";

    @Autowired
    private JdbcTemplate jdbc;

    @GetMapping(value = "/journal02/{id}/04")
    public Map<String, Object> exportDetail04Excel(@PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            OutputStream out = null;
            String sql = "select * from journal02_04 where master_id = ?";
            List<Map<String, Object>> result = jdbc.queryForList(sql, id);

            File buffer = new File(templateJournal02Detail04Path);
            InputStream fis = new FileInputStream(buffer);
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);

            if (result.size() == 0) {
                resp.put("content", "");
                resp.put("message", "没有对应的数据");
                return resp;
            }

            sheet.getRow(1).getCell(1).setCellValue(result.get(0).get("subject").toString());
            sheet.getRow(2).getCell(3).setCellValue(result.get(0).get("software_version_new").toString());
            sheet.getRow(2).getCell(7).setCellValue(result.get(0).get("software_version_old").toString());
            sheet.getRow(2).getCell(10).setCellValue(result.get(0).get("approval_sn").toString());
            sheet.getRow(3).getCell(1).setCellValue(result.get(0).get("train").toString());
            sheet.getRow(3).getCell(10).setCellValue(result.get(0).get("date").toString());

            for (Map<String, Object> item : result) {
                int carriage = Integer.parseInt(item.get("carriage").toString());
                sheet.getRow(carriage + 4).getCell(1).setCellValue(item.get("time_begin").toString());
                sheet.getRow(carriage + 4).getCell(2).setCellValue(item.get("time_end").toString());
                sheet.getRow(carriage + 4).getCell(4).setCellValue(item.get("dept").toString());
                sheet.getRow(carriage + 4).getCell(6).setCellValue(item.get("operator").toString());
                sheet.getRow(carriage + 4).getCell(8).setCellValue(item.get("watcher").toString());
                sheet.getRow(carriage + 4).getCell(9).setCellValue(item.get("watcher_group").toString());
                sheet.getRow(carriage + 4).getCell(10).setCellValue(item.get("qc").toString());
                sheet.getRow(carriage + 4).getCell(11).setCellValue(item.get("remark").toString());
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

    @GetMapping(value = "/journal02/{id}/03")
    public Map<String, Object> exportDetail03Excel(@PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            OutputStream out = null;
            String sql = "select * from journal02_03 where master_id = ?";
            List<Map<String, Object>> result = jdbc.queryForList(sql, id);

            File buffer = new File(templateJournal02Detail03Path);
            InputStream fis = new FileInputStream(buffer);
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);

            if (result.size() == 0) {
                resp.put("content", "");
                resp.put("message", "没有对应的数据");
                return resp;
            }

            for (int i = 0; i < result.size(); i++) {
                sheet.getRow(i + 3).getCell(0).setCellValue(result.get(i).get("name").toString());
                sheet.getRow(i + 3).getCell(1).setCellValue(result.get(i).get("train").toString());
                sheet.getRow(i + 3).getCell(2).setCellValue(result.get(i).get("carriage").toString());
                sheet.getRow(i + 3).getCell(3).setCellValue(result.get(i).get("position").toString());
                sheet.getRow(i + 3).getCell(4).setCellValue(result.get(i).get("date").toString());
                sheet.getRow(i + 3).getCell(5).setCellValue(result.get(i).get("time").toString());
                sheet.getRow(i + 3).getCell(6).setCellValue(result.get(i).get("production_date").toString());
                sheet.getRow(i + 3).getCell(7).setCellValue(result.get(i).get("reason").toString());
                sheet.getRow(i + 3).getCell(8).setCellValue(result.get(i).get("p_gywj").toString());
                sheet.getRow(i + 3).getCell(9).setCellValue(result.get(i).get("p_ljbs").toString());
                sheet.getRow(i + 3).getCell(10).setCellValue(result.get(i).get("component_sn_old").toString());
                sheet.getRow(i + 3).getCell(11).setCellValue(result.get(i).get("component_sn_new").toString());
                sheet.getRow(i + 3).getCell(12).setCellValue(result.get(i).get("p_bjaz").toString());
                sheet.getRow(i + 3).getCell(13).setCellValue(result.get(i).get("operator").toString());
                sheet.getRow(i + 3).getCell(14).setCellValue(result.get(i).get("leader").toString());
                sheet.getRow(i + 3).getCell(15).setCellValue(result.get(i).get("p_bjgnsy").toString());
                sheet.getRow(i + 3).getCell(16).setCellValue(result.get(i).get("qc").toString());
                sheet.getRow(i + 3).getCell(17).setCellValue(result.get(i).get("duty_officer").toString());
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

    @GetMapping(value = "/journal02/{id}/02")
    public Map<String, Object> exportDetail02Excel(@PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            OutputStream out = null;
            String sql = "select * from journal02_02 where master_id = ?";
            List<Map<String, Object>> result = jdbc.queryForList(sql, id);

            File buffer = new File(templateJournal02Detail02Path);
            InputStream fis = new FileInputStream(buffer);
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);

            if (result.size() == 0) {
                resp.put("content", "");
                resp.put("message", "没有对应的数据");
                return resp;
            }

            for (int i = 0; i < result.size(); i++) {
                sheet.getRow(i + 3).getCell(0).setCellValue(result.get(i).get("name").toString());
                sheet.getRow(i + 3).getCell(1).setCellValue(result.get(i).get("train").toString());
                sheet.getRow(i + 3).getCell(2).setCellValue(result.get(i).get("carriage").toString());
                sheet.getRow(i + 3).getCell(3).setCellValue(result.get(i).get("position").toString());
                sheet.getRow(i + 3).getCell(4).setCellValue(result.get(i).get("date").toString());
                sheet.getRow(i + 3).getCell(5).setCellValue(result.get(i).get("time").toString());
                sheet.getRow(i + 3).getCell(6).setCellValue(result.get(i).get("reason").toString());
                sheet.getRow(i + 3).getCell(7).setCellValue(result.get(i).get("p_gywj").toString());
                sheet.getRow(i + 3).getCell(8).setCellValue(result.get(i).get("p_ljbs").toString());
                sheet.getRow(i + 3).getCell(9).setCellValue(result.get(i).get("component_sn_old").toString());
                sheet.getRow(i + 3).getCell(10).setCellValue(result.get(i).get("component_sn_new").toString());
                sheet.getRow(i + 3).getCell(11).setCellValue(result.get(i).get("p_bjaz").toString());
                sheet.getRow(i + 3).getCell(12).setCellValue(result.get(i).get("operator").toString());
                sheet.getRow(i + 3).getCell(13).setCellValue(result.get(i).get("leader").toString());
                sheet.getRow(i + 3).getCell(14).setCellValue(result.get(i).get("p_bjgnsy").toString());
                sheet.getRow(i + 3).getCell(15).setCellValue(result.get(i).get("qc").toString());
                sheet.getRow(i + 3).getCell(16).setCellValue(result.get(i).get("duty_officer").toString());
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

    @GetMapping(value = "/journal02/{id}/01")
    public Map<String, Object> exportDetail01Excel(@PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            OutputStream out = null;
            String sql = "select * from journal02_01 where master_id = ?";
            List<Map<String, Object>> result = jdbc.queryForList(sql, id);

            File buffer = new File(templateJournal02Detail01Path);
            InputStream fis = new FileInputStream(buffer);
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);

            if (result.size() == 0) {
                resp.put("content", "");
                resp.put("message", "没有对应的数据");
                return resp;
            }

            sheet.getRow(1).getCell(1).setCellValue(result.get(0).get("subject").toString());
            sheet.getRow(1).getCell(8).setCellValue(result.get(0).get("approval_sn").toString());
            sheet.getRow(2).getCell(1).setCellValue(result.get(0).get("train_sn").toString());
            sheet.getRow(2).getCell(8).setCellValue(result.get(0).get("date").toString());

            for (Map<String, Object> item : result) {
                int carriage = Integer.parseInt(item.get("carriage").toString());
                sheet.getRow(carriage + 3).getCell(1).setCellValue(result.get(0).get("carriage_subject").toString());
                sheet.getRow(carriage + 3).getCell(2).setCellValue(result.get(0).get("time_begin").toString());
                sheet.getRow(carriage + 3).getCell(3).setCellValue(result.get(0).get("time_end").toString());
                sheet.getRow(carriage + 3).getCell(4).setCellValue(result.get(0).get("result").toString());
                sheet.getRow(carriage + 3).getCell(5).setCellValue(result.get(0).get("report").toString());
                sheet.getRow(carriage + 3).getCell(6).setCellValue(result.get(0).get("dept").toString());
                sheet.getRow(carriage + 3).getCell(7).setCellValue(result.get(0).get("executor").toString());
                sheet.getRow(carriage + 3).getCell(8).setCellValue(result.get(0).get("watcher").toString());
                sheet.getRow(carriage + 3).getCell(9).setCellValue(result.get(0).get("watcher_group").toString());
                sheet.getRow(carriage + 3).getCell(10).setCellValue(result.get(0).get("qc").toString());
                sheet.getRow(carriage + 3).getCell(11).setCellValue(result.get(0).get("remark").toString());
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

    @RequestMapping(value = "/journal02/{id}", method = RequestMethod.GET)
    public Map<String, Object> exportMasterExcel(@PathVariable("id") int id) {
        Map<String, Object> r = new HashMap();
        OutputStream out = null;
        try {
            String sql = "select *, " +
                "date_format(date_begin, '%Y年%m月%d日') as date_begin_alt, " +
                "date_format(time_begin, '%k时%i分') as time_begin_alt, " +
                "date_format(date_end, '%Y年%m月%d日') as date_end_alt, " +
                "date_format(time_end, '%k时%i分') as time_end_alt " +
                "from journal02 where id = ?";
            Map<String, Object> map = jdbc.queryForMap(sql, id);

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

            if ("检查库".equals(map.get("p_yq_zydd").toString())) {
                sheet.getRow(62).getCell(26).setCellValue("             ✓检查库     □临修库     □无要求");
            } else if ("临修库".equals(map.get("p_yq_zydd").toString())) {
                sheet.getRow(62).getCell(26).setCellValue("             □检查库     ✓临修库     □无要求");
            } else if ("无要求".equals(map.get("p_yq_zydd").toString())) {
                sheet.getRow(62).getCell(26).setCellValue("             □检查库     □临修库     ✓无要求");
            }

            sheet.getRow(67).getCell(26).setCellValue(map.get("p_yq_qt").toString());

            // BASE64Decoder dec = new BASE64Decoder();
            Base64 base64 = new Base64();
            byte[] imgData;

//            调度签字
            if (map.get("sign_p_dd") != null) {
//            sheet.getRow(77).getCell(15).setCellValue(map.get("p_dd").toString());
                // imgData = dec.decodeBuffer(map.get("sign_p_dd").toString().substring(22));
                imgData = base64.decode(map.get("sign_p_dd").toString().substring(22));
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
            if (map.get("sign_p_jsy") != null && !"".equals(map.get("sign_p_jsy").toString())) {
//            sheet.getRow(77).getCell(48).setCellValue(map.get("p_jsy").toString());
                // imgData = dec.decodeBuffer(map.get("sign_p_jsy").toString().substring(22));
                imgData = base64.decode(map.get("sign_p_jsy").toString().substring(22));
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
                // imgData = dec.decodeBuffer(map.get("sign_p_zbsz").toString().substring(22));
                imgData = base64.decode(map.get("sign_p_zbsz").toString().substring(22));
                for (int i = 0; i < imgData.length; ++i) {
                    if (imgData[i] < 0) {
                        imgData[i] += 256;
                    }
                }
                int picIdxZBSZ = wb.addPicture(imgData, Workbook.PICTURE_TYPE_PNG);
                CreationHelper helperZBSZ = wb.getCreationHelper();
                Drawing drawingZBSZ = sheet.createDrawingPatriarch();
                ClientAnchor anchorZBSZ = helperZBSZ.createClientAnchor();
                anchorZBSZ.setCol1(80);
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
                // imgData = dec.decodeBuffer(map.get("sign_verify_leader").toString().substring(22));
                imgData = base64.decode(map.get("sign_verify_leader").toString().substring(22));
                for (int i = 0; i < imgData.length; ++i) {
                    if (imgData[i] < 0) {
                        imgData[i] += 256;
                    }
                }
                int picIdxVerifyLeader = wb.addPicture(imgData, Workbook.PICTURE_TYPE_PNG);
                CreationHelper helperVerifyLeader = wb.getCreationHelper();
                Drawing drawingVerifyLeader = sheet.createDrawingPatriarch();
                ClientAnchor anchorVerifyLeader = helperVerifyLeader.createClientAnchor();
                anchorVerifyLeader.setCol1(65);
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
                // imgData = dec.decodeBuffer(map.get("sign_verify").toString().substring(22));
                imgData = base64.decode(map.get("sign_verify").toString().substring(22));
                for (int i = 0; i < imgData.length; ++i) {
                    if (imgData[i] < 0) {
                        imgData[i] += 256;
                    }
                }
                int picIdxVerify = wb.addPicture(imgData, Workbook.PICTURE_TYPE_PNG);
                CreationHelper helperVerify = wb.getCreationHelper();
                Drawing drawingVerify = sheet.createDrawingPatriarch();
                ClientAnchor anchorVerify = helperVerify.createClientAnchor();
                anchorVerify.setCol1(65);
                anchorVerify.setRow1(110);
                Picture pictVerify = drawingVerify.createPicture(anchorVerify, picIdxVerify);
                pictVerify.resize();
            }

            // 班组签字
            if (map.get("sign_verify_leader_bz") != null) {
                // imgData = dec.decodeBuffer(map.get("sign_verify_leader_bz").toString().substring(22));
                imgData = base64.decode(map.get("sign_verify_leader_bz").toString().substring(22));
                for (int i = 0; i < imgData.length; ++i) {
                    if (imgData[i] < 0) {
                        imgData[i] += 256;
                    }
                }
                int picIdxVerify = wb.addPicture(imgData, Workbook.PICTURE_TYPE_PNG);
                CreationHelper helperVerify = wb.getCreationHelper();
                Drawing drawingVerify = sheet.createDrawingPatriarch();
                ClientAnchor anchorVerify = helperVerify.createClientAnchor();
                anchorVerify.setCol1(15);
                anchorVerify.setRow1(116);
                Picture pictVerify = drawingVerify.createPicture(anchorVerify, picIdxVerify);
                pictVerify.resize();
            } else if (map.get("sign_p_jsy_bz") != null) {
                // imgData = dec.decodeBuffer(map.get("sign_p_jsy_bz").toString().substring(22));
                imgData = base64.decode(map.get("sign_p_jsy_bz").toString().substring(22));
                for (int i = 0; i < imgData.length; ++i) {
                    if (imgData[i] < 0) {
                        imgData[i] += 256;
                    }
                }
                int picIdxVerify = wb.addPicture(imgData, Workbook.PICTURE_TYPE_PNG);
                CreationHelper helperVerify = wb.getCreationHelper();
                Drawing drawingVerify = sheet.createDrawingPatriarch();
                ClientAnchor anchorVerify = helperVerify.createClientAnchor();
                anchorVerify.setCol1(15);
                anchorVerify.setRow1(116);
                Picture pictVerify = drawingVerify.createPicture(anchorVerify, picIdxVerify);
                pictVerify.resize();
            }

            // 质检签字
            if (map.get("sign_verify_leader_qc") != null) {
                // imgData = dec.decodeBuffer(map.get("sign_verify_leader_qc").toString().substring(22));
                imgData = base64.decode(map.get("sign_verify_leader_qc").toString().substring(22));
                for (int i = 0; i < imgData.length; ++i) {
                    if (imgData[i] < 0) {
                        imgData[i] += 256;
                    }
                }
                int picIdxVerify = wb.addPicture(imgData, Workbook.PICTURE_TYPE_PNG);
                CreationHelper helperVerify = wb.getCreationHelper();
                Drawing drawingVerify = sheet.createDrawingPatriarch();
                ClientAnchor anchorVerify = helperVerify.createClientAnchor();
                anchorVerify.setCol1(80);
                anchorVerify.setRow1(116);
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
            logger.error("{}", e);
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
