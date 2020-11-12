package com.wdf.test.page.select2;

import com.wdf.test.page.select2.model.Select2Entity;
import com.wdf.test.sql.mybatis.domain.User;
import com.wdf.test.sql.mybatis.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.*;

@Controller
public class Select2TestController {
    Logger log = LoggerFactory.getLogger(Select2TestController.class);

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/select2")
    public String select(Model model){
        log.info("进入select2页面");
        model.addAttribute("msg", "测试默认值");
        return "select2/select2";
    }

    @RequestMapping("/select2data")
    @ResponseBody
    public List<Select2Entity> selectData(){
        Select2Entity s ;
        List<Select2Entity> list =new ArrayList<>();
        for (int i = 1;i < 5;i++){
            log.info("i: "+i);
            s = new Select2Entity();
            s.setId(i+"");
            s.setText("后端第"+i+"条数据");
            list.add(s);
        }
        list.forEach(i->{
            System.out.println(i.getId()+"-"+i.getText()+"\n");
        });
        log.info("select2 数据返回完成");
        return list;
    }

    @ResponseBody
    @RequestMapping("/select2data2")
    public List<Select2Entity> select2data2(@RequestParam String search,@RequestParam String site){
        log.info("前端返的值：{}{}",search,site);
        List<Select2Entity> list = new LinkedList<>();
        List<User> list1 = userMapper.select();
        Select2Entity s ;
        for (int i = 0;i <list1.size();i++){
            log.info("i: "+i);
            s = new Select2Entity();
            s.setId(i+"");
            //s.setText("后端第"+i+"条数据"+search);
            s.setText(list1.get(i).toString());
            list.add(s);
        }
        return list;
    }
}
