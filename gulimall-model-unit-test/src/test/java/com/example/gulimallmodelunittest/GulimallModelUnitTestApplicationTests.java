package com.example.gulimallmodelunittest;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanMap;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class GulimallModelUnitTestApplicationTests {

    /**
     * 功能描述: object转map测试
     * @Param: []
     * @Return: void
     * @Author: yjc
     * @Date: 2023/5/29 19:45
     */
    @Test
    void contextLoads() {


        // 创建一个Map对象
        Map<String, Object> dataMap = new HashMap<>();

        // 添加一些数据
        dataMap.put("Name", "张三");
        dataMap.put("Age", 20);
        dataMap.put("Gender", "男");
        dataMap.put("Profession", "学生");

        // 添加一个嵌套的Map对象
        Map<String, Object> addressMap = new HashMap<>();
        addressMap.put("Province", "广东省");
        addressMap.put("City", "广州市");
        addressMap.put("Address", "天河区XXX路XXX号XXX大厦XXX单元");
        dataMap.put("Address", addressMap);

        // 添加一个嵌套的List对象
        List<Object> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("1234567890");
        phoneNumbers.add("13800138000");
        dataMap.put("Phone Numbers", phoneNumbers);

        // 打印数据
        System.out.println("Name：" + dataMap.get("Name"));
        System.out.println("Age：" + dataMap.get("Age"));
        System.out.println("Gender：" + dataMap.get("Gender"));
        System.out.println("Profession：" + dataMap.get("Profession"));
        System.out.println("Address：" + dataMap.get("Address"));
        System.out.println("Phone Numbers：" + dataMap.get("Phone Numbers"));

//Object转Map
        Map<String,Object> map = JSONObject.parseObject(JSONObject.toJSONString(dataMap.get("Address")), Map.class);
        //Map<String,Object> map2 = JSONObject.parseObject(JSONObject.toJSONString(dataMap.get("电话号码")), Map.class);
        System.out.println(map);
        //System.out.println(map2);//报错：com.alibaba.fastjson.JSONException: syntax error, expect {, actual [, pos 1, line 1, column 2["1234567890","13800138000"]

        ObjectMapper mapper = new ObjectMapper();
        //对象转map
        try {
            Map m = mapper.readValue(mapper.writeValueAsString(dataMap.get("Address")), Map.class);
            System.out.println("mapper:"+m);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //#使用org.apache.commons.beanutils.BeanMap进行转换，实现Bean转Map
        BeanMap map3 = new BeanMap(dataMap.get("Address"));
//        map3.get("");

        System.out.println("map3："+map3); //BeanMap<{省份=广东省, 城市=广州市, 详细Address=天河区XXX路XXX号XXX大厦XXX单元}>
        System.out.println("Address："+map3.get("Address")); //BeanMap<{省份=广东省, 城市=广州市, 详细Address=天河区XXX路XXX号XXX大厦XXX单元}>
//#使用org.apache.commons.beanutils.BeanUtils将map转为对象
        //BeanUtils.populate(dataMap.get("Address"), map);


    }

}
