package com.wdf.test.javabasic.file.word;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: WordBoot
 * @Author WDF
 * @Description 测试SpringBoot生成word文档，总结在文末
 * @Date 2020/9/19 14:04
 * @Copyright WDF 2020/9/19
 * @Version 1.0
 **/
@Controller
@RequestMapping("/word")
public class WordBoot {

    /**
     * @Author WDF
     * @Description 调用接口生成word文档
     * @Date 2020/9/19 14:57
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("/test")
    @ResponseBody
    public ResponseEntity<byte[]> outWord(){
        try {
            File file = WordBoot.createWord();
            HttpHeaders headers = new HttpHeaders();
            //String finalName = StringUtils.processFileName(request, fileName);//为了解决中文名称乱码问题
            String finalName ="Test.doc";
            headers.setContentDispositionFormData("attachment", finalName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件下载失败");
        }

        return new ResponseEntity<byte[]>(new byte[0],HttpStatus.OK);
    }

    /**
     * 生成word文件
     */
    public static File createWord(){

        String templateName="testword.ftl";//word模板名称
        String filePath="D:\\freemarker";//文件生成的目标路径,保存word文档的路径
        String fileName="Test.doc";//生成的word文件名称

        //输出文件
        File outFile = new File(filePath+File.separator+fileName);
        try {
            //创建配置实例
            Configuration configuration = new Configuration();

            //设置编码
            configuration.setDefaultEncoding("utf-8");

            //ftl模板文件
            configuration.setClassForTemplateLoading(WordBoot.class,"/static/word/");

            //获取模板
            Template template = configuration.getTemplate(templateName);

            //如果输出目标文件夹不存在，则创建
            if (!outFile.getParentFile().exists()){
                outFile.getParentFile().mkdirs();
            }

            //将模板和数据模型合并生成文件
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"utf-8"));
            Map<String,Object> dataMap1=new HashMap<String,Object>();
            getFillData(dataMap1);
            //生成文件
            template.process(dataMap1, out);

            //关闭流
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outFile;
    }

    private static void getFillData(Map dataMap) {
        // 根据模板中的参数填充内容，可以不按顺序，参数名称要对上
        dataMap.put("wordname", "文档标题123");
        dataMap.put("user", "userName");
        dataMap.put("password", "12345");
        dataMap.put("wordDescription", "描述内容");
        dataMap.put("para", "变量");
        dataMap.put("type", "类型");
        dataMap.put("empty", "不可空");
    }
}
/**
 在Spring Boot中加载word的文档的时候，加载ftl文档的位置应该是从 target目录下面去加载的（不太确定），不是像大多数情况这样根据类的路径去加载。SpringBoot加载的位置应该是从 “resources”文件下面开始，如果放到“resources”的根目录下面需要加一道“/”斜线。
 类似于：
 configuration.setClassForTemplateLoading(类名.class,"/ ");
 这个时候的类名就与本类没有太大关系了，而是任意的类名即可，都会从这个目录下面去加载文件。
 如果是放在该目录下面的static文件下面，就要把目录改成“/static/”即可。后面有“/”没有影响，因为在获取的时候会进行判断。
 一端完整的获取配置的代码：和文件位置。

 **/