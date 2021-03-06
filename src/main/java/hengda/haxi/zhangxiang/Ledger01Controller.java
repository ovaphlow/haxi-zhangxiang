package hengda.haxi.zhangxiang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// 禁动牌台帐
@RequestMapping(value = "/api/ledger/01")
@RestController
@SuppressWarnings("unchecked")
public class Ledger01Controller {

    private Logger logger = LoggerFactory.getLogger(Ledger01Controller.class);

    private Ledger01Repos repos;

    @Autowired
    public Ledger01Controller(Ledger01Repos repos) {
        this.repos = repos;
    }

    /**
     * 统计
     * @return
     */
    @GetMapping(value = "/stats")
    public Map<String, Object> stats() {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.stats());
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
    @PostMapping(value = "/filter")
    public Map<String, Object> filter(@RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.filter(body));
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 列表
     * @return
     */
    @GetMapping(value = "/")
    public Map<String, Object> list() {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.list());
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 返还
     * @param id
     * @param body
     * @return
     */
    @PutMapping(value = "/return/{id}")
    public Map<String, Object> returnSubmit(@PathVariable("id") int id, @RequestBody Map<String, Object> body) {
        logger.info("{}", body);
        Map<String, Object> resp = new HashMap();
        try {
            body.put("id", id);
            repos.returnHandler(body);
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 待返还列表
     * @return
     */
    @GetMapping(value = "/return/")
    public Map<String, Object> listReturn() {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.returnList());
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 申请信息
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Map<String, Object> get(@PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap();
        try {
            resp.put("content", repos.get(id));
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    /**
     * 新增申请
     * @param body
     * @return
     */
    @PostMapping(value = "/")
    public Map<String, Object> save(@RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap();
        try {
            repos.save(body);
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }
}
