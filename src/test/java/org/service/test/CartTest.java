package org.service.test;

import org.bean.SpuInfo;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.service.CartService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;


@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration({"/applicationContext.xml"}) //加载配置文件
public class CartTest {


    @Resource
    private CartService cartService;

    @Test
    public void test() throws JsonGenerationException, JsonMappingException, IOException, IOException {

        SpuInfo spu = new SpuInfo();
        spu.setSpuId(123);
        spu.setCreateTime(105456464);

        //将对象转换成json字符串
        ObjectMapper om = new ObjectMapper();
        Writer wr = new StringWriter();
        om.writeValue(wr, spu);

        String str = wr.toString();
        //添加数据
        cartService.add(str);

    }
}