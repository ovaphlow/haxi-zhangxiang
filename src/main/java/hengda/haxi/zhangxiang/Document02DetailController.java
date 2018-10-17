package hengda.haxi.zhangxiang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//一体化作业申请单 子单
@RequestMapping(value = "/api/document/02")
@RestController
@SuppressWarnings("unchecked")
public class Document02DetailController {

    private Logger logger = LoggerFactory.getLogger(Document02DetailController.class);

    private Document02Repos repos;

    @Autowired
    public Document02DetailController(Document02Repos repos) {
        this.repos = repos;
    }
}
