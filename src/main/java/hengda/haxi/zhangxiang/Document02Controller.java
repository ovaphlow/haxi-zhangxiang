package hengda.haxi.zhangxiang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// 一体化作业申请单
@RequestMapping("/api/document/02")
@RestController
@SuppressWarnings("unchecked")
public class Document02Controller {

    private Logger logger = LoggerFactory.getLogger(Document02Controller.class);

    private Document02Repos repos;

    @Autowired
    public Document02Controller(Document02Repos repos) {
        this.repos = repos;
    }

    /**
     * 待处理任务数量：值班所长
     * @return
     */
    @GetMapping(value = "/todo/p_zbsz")
    public Map<String, Object> todoPzbsz() {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.todoPzbszApprove());
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 待处理任务数量：调度
     * @return
     */
    @GetMapping(value = "/todo/p_dd")
    public Map<String, Object> todoPdd() {
        Map<String, Object> resp = new HashMap();
        try {
            Map<String, Object> result = repos.todoPddApprove();
            Map<String, Object> result1 = repos.todoPddReview();
            Map<String, Object> qty = new HashMap();
            qty.put("qty", Integer.parseInt(result.get("qty").toString()));
            qty.put("qty1", Integer.parseInt(result1.get("qty").toString()));
            resp.put("content", qty);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 待处理任务数量：质检
     * @param qc
     * @return
     */
    @GetMapping(value = "/todo/qc/{qc}")
    public Map<String, Object> todoQc(@PathVariable("qc") String qc) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.todoQcReview(qc));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 待处理任务数量：班组
     * @param p_bz
     * @return
     */
    @GetMapping(value = "/todo/p_bz/{p_bz}")
    public Map<String, Object> todoPbz(@PathVariable("p_bz") String p_bz) {
        Map<String, Object> resp = new HashMap();
        try {
            Map<String, Object> result = repos.todoPbzApprove(p_bz);
            Map<String, Object> result1 = repos.todoPbzReview(p_bz);
            Map<String, Object> qty = new HashMap();
            qty.put("qty", Integer.parseInt(result.get("qty").toString()));
            qty.put("qty1", Integer.parseInt(result1.get("qty").toString()));
            resp.put("content", qty);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 待处理任务数量：技术员
     * @return
     */
    @GetMapping(value = "/todo/p_jsy")
    public Map<String, Object> todoPjsy() {
        Map<String, Object> resp = new HashMap();
        try {
            Map<String, Object> result = repos.todoPjsyApprove();
            Map<String, Object> result1 = repos.todoPjsyReview();
            Map<String, Object> qty = new HashMap();
            qty.put("qty", Integer.parseInt(result.get("qty").toString()));
            qty.put("qty1", Integer.parseInt(result.get("qty").toString()));
            resp.put("content", qty);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }


    /**
     * 按车组统计作业数量
     * @return
     */
    @GetMapping(value = "/stats/")
    public Map<String, Object> stats() {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.stats());
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 一般配件和关键配件的更换记录单销记时触发
     * 检修工长销记列表
     * @return
     */
    @GetMapping(value = "/verify/p_gz/")
    public Map<String, Object> verifyPgz() {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.verifyPgz());
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 检查供电状态是否冲突，列出所有冲突的申请。
     * @param id
     * @return Map
     */
    @GetMapping(value = "/check/power/{id}")
    public Map<String, Object> checkPowerStatus(@PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.checkPower(id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 调度销记列表
     * @return
     */
    @GetMapping(value = "/review/p_dd/")
    public Map<String, Object> listReviewPdd() {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.listReviewPdd());
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 技术员销记列表
     * @return
     */
    @GetMapping(value = "/review/p_jsy/")
    public Map<String, Object> listReviewPjsy() {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.listReviewPjsy());
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 质检销记列表
     * @param qc
     * @return
     */
    @GetMapping(value = "/review/qc/{qc}/")
    public Map<String, Object> listReviewQc(@PathVariable("qc") String qc) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.listReviewQc(qc));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 班组销记列表
     * @param p_bz
     * @return
     */
    @GetMapping(value = "/review/p_bz/{p_bz}/")
    public Map<String, Object> listReviewPbz(@PathVariable("p_bz") String p_bz) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.listReviewPbz(p_bz));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 作业负责人销记
     * @param id
     * @return
     */
    @GetMapping(value = "/review/applicant/{id}/")
    public Map<String, Object> listReviewApplicant(@PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.listReviewApplicant(id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 值班所长确认列表
     * @return
     */
    @GetMapping(value = "/approve/p_zbsz/")
    public Map<String, Object> listApprovePzbsz() {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.listApprovePzbsz());
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 调度确认列表
     * @return
     */
    @GetMapping(value = "/approve/p_dd/")
    public Map<String, Object> listApprovePdd() {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.listApprovePdd());
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 班组确认列表
     * @param p_bz
     * @return
     */
    @GetMapping(value = "/approve/p_bz/{p_bz}")
    public Map<String, Object> listApprovePbz(@PathVariable("p_bz") String p_bz) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.listApprovePbz(p_bz));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 技术员确认
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/{id}/approve/p_jsy")
    public Map<String, Object> submitApprovePjsy(@PathVariable("id") int id, @RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            body.put("id", id);
            repos.submitApprovePjsy(body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 技术员审核列表
     * @return
     */
    @GetMapping(value = "/approve/p_jsy/")
    public Map<String, Object> listApprovePjsy() {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.listApprovePjsy());
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 查询
     * @param body
     * @return
     */
    @PostMapping(value = "/filter/")
    public Map<String, Object> filter(@RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.filter(body));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 指定用户审核或销记的申请单
     * @param id
     * @return
     */
    @GetMapping(value = "/filter/user/{id}/flow")
    public Map<String, Object> filterByUserFlow(@PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.filterByUserFlow(id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 指定用户申请单
     * @param id
     * @return
     */
    @GetMapping(value = "/filter/user/{id}")
    public Map<String, Object> filterByUser(@PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.filterByUser(id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 查询已完成申请单
     * @param body
     * @return
     */
    @PostMapping(value = "/filter/fin/")
    public Map<String, Object> filterFin(@RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.filterFin(body));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "");
        }
        return resp;
    }

    /**
     * 首页置顶显示 报警列表
     * @return
     */
    @GetMapping(value = "/warning/")
    public Map<String, Object> listWarning() {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.listWarning());
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 首页显示列表
     * 默认只显示非报警状态的未完成项目
     * 包括检查值班干部带处理申请单计数和超期时间
     * @return
     */
    @GetMapping(value = "/")
    public Map<String, Object> list() {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.list());
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 删除申请单
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Map<String, Object> remove(@PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.remove(id);
            resp.put("message", "");
            resp.put("content", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 申请单信息
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Map<String, Object> get(@PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.get(id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 修改申请单
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable("id") int id, @RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            body.put("id", id);
            repos.update(body);
            resp.put("message", "");
            resp.put("content", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 提交申请
     * @param body
     * @return
     */
    @PostMapping(value = "/")
    public Map<String, Object> save(@RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.save(body);
            resp.put("message", "");
            resp.put("content", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }
}