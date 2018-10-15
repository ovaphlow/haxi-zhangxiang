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
