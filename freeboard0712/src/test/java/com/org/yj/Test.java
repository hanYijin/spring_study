package com.org.yj;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner .class)
@Configuration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class Test {

}
