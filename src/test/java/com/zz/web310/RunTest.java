package com.zz.web310;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class) // 里面不变
@SpringBootTest(classes = Run.class) // main() 函数所在类
@WebAppConfiguration
public class RunTest {

}
