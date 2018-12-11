package hengda.haxi.zhangxiang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/api/ledger/05")
@RestController
@SuppressWarnings("unchecked")
public class Ledger05Controller {

    private Logger logger = LoggerFactory.getLogger(Ledger05Controller.class);

    private Ledger05Repos repos;

    @Autowired
    public Ledger05Controller(Ledger05Repos repos) {
        this.repos = repos;
    }

    @GetMapping(value = "/")
    public Map<String, Object> list() {
        Map<String, Object> resp = new HashMap<>();
        try {
            resp.put("content", repos.list());
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }
}
