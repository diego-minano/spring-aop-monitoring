package net.dms.aop.resource;

import lombok.extern.slf4j.Slf4j;
import net.dms.aop.model.Tree;
import net.dms.aop.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class FarmController {
    @Autowired
    private FarmService farmService;

    @GetMapping("{id}")
    public Tree getTree(@PathVariable Long id) {
        return farmService.getTree(id);
    }

    @PostMapping
    public void save(@RequestBody Tree tree){
        log.info("rest, saving");
        farmService.save(tree);
    }
}
