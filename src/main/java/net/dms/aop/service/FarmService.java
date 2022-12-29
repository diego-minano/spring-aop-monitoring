package net.dms.aop.service;

import lombok.extern.slf4j.Slf4j;
import net.dms.aop.model.Tree;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FarmService {

    public void save(Tree tree) {
        log.info("Tree {} has been stored", tree);
    }
}
