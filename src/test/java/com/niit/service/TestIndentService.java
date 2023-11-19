package com.niit.service;

import com.niit.pojo.Indent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TestIndentService {
    private IndentService indentService;
    @Autowired
    public void setIndentService(IndentService indentService) {
        this.indentService = indentService;
    }
    @Test
    public void test01(){
        Indent indent  = new Indent();
        indent.setId(1);
        indent.setPlaneId(3352);
        indent.setUsername("张松溪");
        indent.setPhone("14577554125");
        indent.setCoach(0);
        indent.setPrice(350);
        indent.setState(0);
        indent.setSeatId(150);
        int num = indentService.insertIndent(indent);
        log.info("插入了【" + num + "】数据！！！");
    }
}
