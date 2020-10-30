package com.wdf.test.spring.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @ClassName: SpringFoxConfig
 * @Author WDF
 * @Description 基本的Spring配置。虽然您可以在技术上使用现有配置文件之一，
 * 但最好为其配置单独的文件。您需要提供的第一件事是@ EnableSwagger2注释。
 * 然后你需要提供一个Docket bean，它是用于配置SpringFox的主bean。
 * @Date 2020/10/30 10:33
 * @Copyright Dareway 2020/10/30
 * @Version 1.0
 **/
@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    /***
     * 测试地址Json(未添加ui依赖): http://localhost/v2/api-docs
     * ui查看地址：http://localhost/swagger-ui.html
     **/

    /**
     * 可以提供更多配置设置，我们稍后会看到，但这是一个简约配置，它执行以下操作：
     *
     * @ EnableSwagger2支持Swagger 2的SpringFox支持。
     *
     * DocumentationType.SWAGGER_2告诉Docket bean我们正在使用Swagger规范的版本2。
     *
     * select（）创建一个构建器，用于定义哪些控制器及其生成的文档中应包含哪些方法。
     *
     * apis（）定义要包含的类（控制器和模型类）。这里我们包括所有这些，但您可以通过基础包，类注释等来限制它们。
     *
     * paths（）允许您根据路径映射定义应包含哪个控制器的方法。我们现在包括所有这些，但您可以使用正则表达式等限制它。
     **/
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().
                        apis(RequestHandlerSelectors.any()).
                        paths(PathSelectors.any()).build();
    }

    /**
     * 您可以将其限制为某些正则表达式或Ant样式的路径模式，而不是匹配所有路径的任何路径。
     * 您可以随时为apis（）和paths（）提供自己的谓词。忽略某些类或方法的另一种方法是使用@ApiIgnore注释它们。
     **/

/*    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2).select().
                apis(RequestHandlerSelectors.basePackage("com.vojtechruzicka")).
                paths(PathSelectors.ant("/v2/**")).build().apiInfo(getApiInfo());
    }*/

    private ApiInfo getApiInfo() {
        return new ApiInfo("TITLE", "DESCIPRION", "VERSION", "TERMS OF SERVICE URL",
                new Contact("NAME", "URL", "EMAIL"), "LICENSE", "LICENSE URL",
                Collections.emptyList());
    }
}
