package hengda.haxi.zhangxiang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// �?体化作业申请�?
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
     * 驳回列表
     * @return
     */
    @GetMapping(value = "/reject/")
    public Map<String, Object> listReject() {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.listReject());
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 驳回 （�?�用�?
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/{id}/reject")
    public Map<String, Object> submitReject(@PathVariable("id") int id, @RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.submitReject(id, body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 待处理任务数量：值班销记
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
     * 待处理任务数量：工长
     * @param p_bz
     * @return
     */
    @GetMapping(value = "/todo/p_gz/{p_bz}")
    public Map<String, Object> todoPgz(@PathVariable("p_bz") String p_bz) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.todoPgzReview(p_bz));
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
     * 待处理任务数量：�?术员
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
     * 按车组统计作业数�?
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
     * �?查供电状态是否冲突，列出�?有冲突的申请�?
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
     * 调度销记
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/review/p_dd/{id}")
    public Map<String, Object> submitReviewPdd(@PathVariable("id") int id, @RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            body.put("id", id);
            repos.submitReviewPdd(body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 调度�?记列�?
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
     * �?术员�?记列�?
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
     * 质检销记
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/review/qc/{id}")
    public Map<String, Object> submitReviewQc(@PathVariable("id") int id, @RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            body.put("id", id);
            repos.submitReviewQc(body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 质检�?记列�?
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
     * 子帐�?03：工长销�?
     * @param master_id
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/{master_id}/03/{id}/p_gz")
    public Map<String, Object> reviewPgz03(
            @PathVariable("master_id") int master_id,
            @PathVariable("id") int id,
            @RequestBody Map<String, Object> body
    ) {
        Map<String, Object> resp = new HashMap();
        try {
            body.put("master_id", master_id);
            body.put("id", id);
            repos.submitReviewPgz03(body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 子账�?02：工长销�?
     * @param master_id
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/{master_id}/02/{id}/p_gz")
    public Map<String, Object> reviewPgz02(
            @PathVariable("master_id") int master_id,
            @PathVariable("id") int id,
            @RequestBody Map<String, Object> body
    ) {
        Map<String, Object> resp = new HashMap();
        try {
            body.put("master_id", master_id);
            body.put("id", id);
            repos.submitReviewPgz02(body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * �?般配件和关键配件的更换记录单�?记时触发
     * �?修工长销记列�?
     * @return
     */
    @GetMapping(value = "/verify/p_gz/{p_bz}")
    public Map<String, Object> verifyPgz(@PathVariable("p_bz") String p_bz) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.listReviewPgz(p_bz));
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 班组�?记签�?
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/{id}/review/p_bz")
    public Map<String, Object> submitReviewPbz(@PathVariable("id") int id, @RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            body.put("id", id);
            repos.submitReviewPbz(body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 班组�?记列�?
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
     * 作业负责人销�?
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/review/applicant/{id}")
    public Map<String, Object> submitReviewApplicant(
            @PathVariable("id") int id,
            @RequestBody Map<String, Object> body
    ) {
        Map<String, Object> resp = new HashMap();
        try {
            body.put("id", id);
            repos.submitReviewApplicant(body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 作业负责人销�?
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
     * 值班�?长确�?
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/approve/p_zbsz/{id}")
    public Map<String, Object> submitApprovePzbsz(@PathVariable("id") int id, @RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            body.put("id", id);
            repos.submitApprovePzbsz(body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 值班�?长确认列�?
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
     * 调度确认
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/approve/p_dd/{id}")
    public Map<String, Object> submitApprovePdd(@PathVariable("id") int id, @RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            body.put("id", id);
            repos.submitApprovePdd(body);
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
     * 班组确认
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/approve/p_bz/{id}")
    public Map<String, Object> submitApprovePbz(@PathVariable("id") int id, @RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            body.put("id", id);
            repos.submitApprovePbz(body);
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
    @GetMapping(value = "/approve/p_bz/{p_bz}/")
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
     * �?术员确认
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
     * �?术员审核列表
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
     * 指定用户审核或销记的申请�?
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
     * 指定用户申请�?
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
     * 2018-10 分为报警和警告，报警红色，警告黄�?
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
     * 默认只显示非报警状�?�的未完成项�?
     * 包括�?查�?�班干部带处理申请单计数和超期时�?
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
     * 删除申请�?
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
     * 申请单信�?
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
     * 修改申请�?
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
