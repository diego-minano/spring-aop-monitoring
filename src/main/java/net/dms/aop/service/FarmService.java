package net.dms.aop.service;

import lombok.extern.slf4j.Slf4j;
import net.dms.aop.model.Tree;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;

@Slf4j
@Service
public class FarmService {

    public Tree getTree(Long id) {
        waitRandom();
        return Tree.builder().withId(id).build();
    }

    public void save(Tree tree) {
        waitRandom();
        log.info("Tree {} has been stored", tree);
    }

    private void waitRandom() {
        try {
            TimeUnit.MILLISECONDS.sleep(RandomGenerator.getDefault().nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
