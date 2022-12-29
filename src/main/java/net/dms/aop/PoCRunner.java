package net.dms.aop;

import net.dms.aop.model.Tree;
import net.dms.aop.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PoCRunner implements CommandLineRunner {

    @Autowired
    private FarmService farmService;

    @Override
    public void run(String... args) throws Exception {
        Tree tree = Tree.builder().withId(100L).build();
        farmService.save(tree);
    }
}
