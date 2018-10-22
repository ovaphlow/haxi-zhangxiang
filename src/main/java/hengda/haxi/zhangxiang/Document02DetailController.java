package hengda.haxi.zhangxiang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//一体化作业申请单 子单
@RequestMapping(value = "/api/document/02")
@RestController
@SuppressWarnings("unchecked")
public class Document02DetailController {

    private Logger logger = LoggerFactory.getLogger(Document02DetailController.class);

    private Document02DetailRepos repos;

    @Autowired
    public Document02DetailController(Document02DetailRepos repos) {
        this.repos = repos;
    }

    /**
     * 子单 计数
     * @param master_id
     * @return
     */
    @GetMapping(value = "/{master_id}/detail/qty")
    public Map<String, Object> qty(@PathVariable("master_id") int master_id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.qty(master_id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 04子单 计数
     * @param master_id
     * @return
     */
    @GetMapping(value = "/{master_id}/detail/04/qty")
    public Map<String, Object> qty04(@PathVariable("master_id") int master_id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.qty04(master_id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 03子单 计数
     * @param master_id
     * @return
     */
    @GetMapping(value = "/{master_id}/detail/03/qty")
    public Map<String, Object> qty03(@PathVariable("master_id") int master_id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.qty03(master_id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 02子单 计数
     * @param master_id
     * @return
     */
    @GetMapping(value = "/{master_id}/detail/02/qty")
    public Map<String, Object> qty02(@PathVariable("master_id") int master_id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.qty02(master_id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 01子单 计数
     * @param master_id
     * @return
     */
    @GetMapping(value = "/{master_id}/detail/01/qty")
    public Map<String, Object> qty01(@PathVariable("master_id") int master_id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.qty01(master_id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 03子单 值班干部销记
     * @param master_id
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/{master_id}/detail/03/{id}/p_jsy")
    public Map<String, Object> review03Pjsy(
            @PathVariable("master_id") int master_id,
            @PathVariable("id") int id,
            @RequestBody Map<String, Object> body
    ) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.review03Pjsy(master_id, id, body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 02子单 值班干部销记
     * @param master_id
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/{master_id}/detail/02/{id}/p_jsy")
    public Map<String, Object> review02Pjsy(
            @PathVariable("master_id") int master_id,
            @PathVariable("id") int id,
            @RequestBody Map<String, Object> body
    ) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.review02Pjsy(master_id, id, body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 04子单 质检销记
     * @param master_id
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/{master_id}/detail/04/{id}/qc")
    public Map<String, Object> review04Qc(
            @PathVariable("master_id") int master_id,
            @PathVariable("id") int id,
            @RequestBody Map<String, Object> body
    ) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.review04Qc(master_id, id, body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 03子单 质检销记
     * @param master_id
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/{master_id}/detail/03/{id}/qc")
    public Map<String, Object> review03Qc(
            @PathVariable("master_id") int master_id,
            @PathVariable("id") int id,
            @RequestBody Map<String, Object> body
    ) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.review03Qc(master_id, id, body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 02子单 质检销记
     * @param master_id
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/{master_id}/detail/02/{id}/qc")
    public Map<String, Object> review02Qc(
            @PathVariable("master_id") int master_id,
            @PathVariable("id") int id,
            @RequestBody Map<String, Object> body
    ) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.review02Qc(master_id, id, body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 01子单 质检销记
     * @param master_id
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/{master_id}/detail/01/{id}/qc")
    public Map<String, Object> review01Qc(
            @PathVariable("master_id") int master_id,
            @PathVariable("id") int id,
            @RequestBody Map<String, Object> body
    ) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.review01Qc(master_id, id, body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 04子单 班组销记
     * @param master_id
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/{master_id}/detail/04/{id}/p_bz")
    public Map<String, Object> review04Pbz(
            @PathVariable("master_id") int master_id,
            @PathVariable("id") int id,
            @RequestBody Map<String, Object> body
    ) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.review04Pbz(master_id, id, body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 01子单 班组销记
     * @param master_id
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/{master_id}/detail/01/{id}/p_bz")
    public Map<String, Object> review01Pbz(
            @PathVariable("master_id") int master_id,
            @PathVariable("id") int id,
            @RequestBody Map<String, Object> body
    ) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.review01Pbz(master_id, id, body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 04子单 删除
     * @param master_id
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{master_id}/detail/04/{id}")
    public Map<String, Object> remove04(@PathVariable("master_id") int master_id, @PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.remove04(master_id, id);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 03子单 删除
     * @param master_id
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{master_id}/detail/03/{id}")
    public Map<String, Object> remove03(@PathVariable("master_id") int master_id, @PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.remove03(master_id, id);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 02子单 删除
     * @param master_id
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{master_id}/detail/02/{id}")
    public Map<String, Object> remove02(@PathVariable("master_id") int master_id, @PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.remove02(master_id, id);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 删除子单
     * @param master_id
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{master_id}/detail/01/{id}")
    public Map<String, Object> remove01(@PathVariable("master_id") int master_id, @PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.remove01(master_id, id);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 04子单 修改
     * @param master_id
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/{master_id}/detail/04/{id}")
    public Map<String, Object> update04(
            @PathVariable("master_id") int master_id,
            @PathVariable("id") int id,
            @RequestBody Map<String, Object> body
    ) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.update04(master_id, id, body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 03子单 修改
     * @param master_id
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/{master_id}/detail/03/{id}")
    public Map<String, Object> update03(
            @PathVariable("master_id") int master_id,
            @PathVariable("id") int id,
            @RequestBody Map<String, Object> body
    ) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.update03(master_id, id, body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 02子单 修改
     * @param master_id
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/{master_id}/detail/02/{id}")
    public Map<String, Object> update02(
            @PathVariable("master_id") int master_id,
            @PathVariable("id") int id,
            @RequestBody Map<String, Object> body
    ) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.update02(master_id, id, body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 修改子单
     * @param master_id
     * @param id
     * @return
     */
    @PutMapping(value = "/{master_id}/detail/01/{id}")
    public Map<String, Object> update01(
            @PathVariable("master_id") int master_id,
            @PathVariable("id") int id,
            @RequestBody Map<String, Object> body
    ) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.update01(master_id, id, body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 04子单 信息
     * @param master_id
     * @param id
     * @return
     */
    @GetMapping(value = "/{master_id}/detail/04/{id}")
    public Map<String, Object> get04(@PathVariable("master_id") int master_id, @PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.get04(master_id, id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 03子单 信息
     * @param master_id
     * @param id
     * @return
     */
    @GetMapping(value = "/{master_id}/detail/03/{id}")
    public Map<String, Object> get03(@PathVariable("master_id") int master_id, @PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.get03(master_id, id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 02子单信息
     * @param master_id
     * @param id
     * @return
     */
    @GetMapping(value = "/{master_id}/detail/02/{id}")
    public Map<String, Object> get02(@PathVariable("master_id") int master_id, @PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.get02(master_id, id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 子单信息
     * @param master_id
     * @param id
     * @return
     */
    @GetMapping(value = "/{master_id}/detail/01/{id}")
    public Map<String, Object> get01(@PathVariable("master_id") int master_id, @PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.get01(master_id, id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 04子单 添加
     * @param master_id
     * @param body
     * @return
     */
    @PostMapping(value = "/{master_id}/detail/04")
    public Map<String, Object> save04(@PathVariable("master_id") int master_id, @RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            if (body.get("carriage_01").equals(true)) repos.save04(master_id, "01", body);
            if (body.get("carriage_02").equals(true)) repos.save04(master_id, "02", body);
            if (body.get("carriage_03").equals(true)) repos.save04(master_id, "03", body);
            if (body.get("carriage_04").equals(true)) repos.save04(master_id, "04", body);
            if (body.get("carriage_05").equals(true)) repos.save04(master_id, "05", body);
            if (body.get("carriage_06").equals(true)) repos.save04(master_id, "06", body);
            if (body.get("carriage_07").equals(true)) repos.save04(master_id, "07", body);
            if (body.get("carriage_08").equals(true)) repos.save04(master_id, "08", body);
            repos.updateMasterTime(master_id, body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 03子单 添加
     * @param master_id
     * @param body
     * @return
     */
    @PostMapping(value = "/{master_id}/detail/03")
    public Map<String, Object> save03(@PathVariable("master_id") int master_id, @RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            if (body.get("carriage_01").equals(true)) repos.save03(master_id, "01", body);
            if (body.get("carriage_02").equals(true)) repos.save03(master_id, "02", body);
            if (body.get("carriage_03").equals(true)) repos.save03(master_id, "03", body);
            if (body.get("carriage_04").equals(true)) repos.save03(master_id, "04", body);
            if (body.get("carriage_05").equals(true)) repos.save03(master_id, "05", body);
            if (body.get("carriage_06").equals(true)) repos.save03(master_id, "06", body);
            if (body.get("carriage_07").equals(true)) repos.save03(master_id, "07", body);
            if (body.get("carriage_08").equals(true)) repos.save03(master_id, "08", body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 02子单 添加
     * @param master_id
     * @param body
     * @return
     */
    @PostMapping(value = "/{master_id}/detail/02")
    public Map<String, Object> save02(@PathVariable("master_id") int master_id, @RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            if (body.get("carriage_01").equals(true)) repos.save02(master_id, "01", body);
            if (body.get("carriage_02").equals(true)) repos.save02(master_id, "02", body);
            if (body.get("carriage_03").equals(true)) repos.save02(master_id, "03", body);
            if (body.get("carriage_04").equals(true)) repos.save02(master_id, "04", body);
            if (body.get("carriage_05").equals(true)) repos.save02(master_id, "05", body);
            if (body.get("carriage_06").equals(true)) repos.save02(master_id, "06", body);
            if (body.get("carriage_07").equals(true)) repos.save02(master_id, "07", body);
            if (body.get("carriage_08").equals(true)) repos.save02(master_id, "08", body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 01子单 添加
     * @param master_id
     * @return
     */
    @PostMapping(value = "/{master_id}/detail/01")
    public Map<String, Object> save01(@PathVariable("master_id") int master_id, @RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            if (body.get("carriage_01").equals(true)) repos.save01(master_id, "01", body);
            if (body.get("carriage_02").equals(true)) repos.save01(master_id, "02", body);
            if (body.get("carriage_03").equals(true)) repos.save01(master_id, "03", body);
            if (body.get("carriage_04").equals(true)) repos.save01(master_id, "04", body);
            if (body.get("carriage_05").equals(true)) repos.save01(master_id, "05", body);
            if (body.get("carriage_06").equals(true)) repos.save01(master_id, "06", body);
            if (body.get("carriage_07").equals(true)) repos.save01(master_id, "07", body);
            if (body.get("carriage_08").equals(true)) repos.save01(master_id, "08", body);
            repos.updateMasterTime(master_id, body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 04子单 列表
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}/detail/04/")
    public Map<String, Object> list04(@PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.list04(id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 03子单 列表
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}/detail/03/")
    public Map<String, Object> list03(@PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.list03(id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 02子单 列表
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}/detail/02/")
    public Map<String, Object> list02(@PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.list02(id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 列表：01子单
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}/detail/01/")
    public Map<String, Object> list01(@PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.list01(id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }
}
