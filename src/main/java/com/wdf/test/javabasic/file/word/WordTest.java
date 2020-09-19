package com.wdf.test.javabasic.file.word;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: WordTest
 * @Author WDF
 * @Description word测试类
 * @Date 2020/9/18 10:39
 * @Copyright Dareway 10:39
 **/
public class WordTest {
    private Configuration configuration = new Configuration();
    // 加载模板信息
    private Template readWord() {
        /**
         * 以下是两种指定ftl文件所在目录路径的方式，注意这两种方式都是
         * 指定ftl文件所在目录的路径，而不是ftl文件的路径
         */
        //指定路径的第一种方式（根据某个类的相对路径指定）
          //     configuration.setClassForTemplateLoading(this.getClass(), "/");
        configuration.setClassForTemplateLoading(WordTest.class,"");
        //指定路径的第二种方式，我的路径是C：/a.ftl
        //configuration.setDirectoryForTemplateLoading(new File("d:/"));


// 加载文档模板FTL文件所存在的位置
  //      configuration.setClassForTemplateLoading(this.getClass(),"/");
//web工程还可以使用加载方法configuration.setServletContextForTemplateLoading(Object servletContext, String path);
        configuration.setDefaultEncoding("UTF-8");
        Template tempWord = null;
        try {
           // configuration.setDirectoryForTemplateLoading(new File("d:/"));
//            final ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
//            configuration.setServletContextForTemplateLoading(servletContext, "/word/" );
// 获取模板信息
            tempWord = configuration.getTemplate("testword1.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempWord;

    }
    // 填充模板参数
    private void getFillData(Map dataMap) {
// 根据模板中的参数填充内容，可以不按顺序，参数名称要对上
        dataMap.put("wordname", "文档标题");
        dataMap.put("user", "userName");
        dataMap.put("password", "56fdh6ror8");
        dataMap.put("wordDescription", "本文档供开发人员和测试人员参考。调用服务请求时，需要先传递开发者编号和开发者密钥，系统会先对编号和密钥解析验证，如果不通过，不会继续处理信息。");
// list的内容对应表格，表格行数与list的size对应，正常应用中list数据从数据库获取，本示例设置一个size=5的list
/*        List wordList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map map = new HashMap();
            map.put("para", i);
            map.put("type", "参数" + i);
            if(4 == i){
                map.put("empty", "可空");
            }else{
                map.put("empty", "不可空");
            }
            wordList.add(map);
        }*/
        dataMap.put("para", "变量");
        dataMap.put("type", "类型");
        dataMap.put("empty", "不可空");
      //  dataMap.put("wordList", wordList);
    }
    // 创建新word文档
    public void createWord() {
        Map dataMap = new HashMap();
// 组装填充模板数据
        getFillData(dataMap);
// 文档输出目录
        File outFile = new File("D:/测试文档.doc");
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(outFile)));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
// 模板填充后，输出到指定目录
            readWord().process(dataMap, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 调用方法
    public static void main(String[] args) {
        WordTest test = new WordTest();
        test.createWord();
    }


}

