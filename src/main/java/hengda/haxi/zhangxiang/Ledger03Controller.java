package hengda.haxi.zhangxiang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/api/ledger/03")
@RestController
@SuppressWarnings("unchecked")
public class Ledger03Controller {

    private Logger logger = LoggerFactory.getLogger(Ledger03Controller.class);

    private Ledger03Repos repos;

    @Autowired
    public Ledger03Controller(Ledger03Repos repos) {
        this.repos = repos;
    }

    @PutMapping(value = "/review/{id}")
    public Map<String, Object> reviewHandler(@PathVariable int id, @RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap<>();
        try {
            body.put("id", id);
            repos.reviewHandler(body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }


    @GetMapping(value = "/review/")
    public Map<String, Object> listReview() {
        Map<String, Object> resp = new HashMap<>();
        try {
            resp.put("content", repos.listReview());
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> get(@PathVariable("id") int id) {
        Map<String, Object> resp = new HashMap<>();
        try {
            resp.put("content", repos.get(id));
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
    }

    @PostMapping(value = "/")
    public Map<String, Object> save(@RequestBody Map<String, Object> body) {
        Map<String, Object> resp = new HashMap<>();
        try {
            repos.save(body);
            resp.put("message", "");
        } catch (Exception e) {
            logger.error("{}", e);
            resp.put("message", "服务器错误");
        }
        return resp;
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
