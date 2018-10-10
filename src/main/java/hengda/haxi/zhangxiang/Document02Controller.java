package hengda.haxi.zhangxiang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
