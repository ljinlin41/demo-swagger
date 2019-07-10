package cn.ljlin233.demoswagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lvjinlin@yunrong.cn
 * @version V2.1
 * @date 2019/7/10 11:33
 * @since 2.1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(this.apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("cn.ljlin233.demoswagger.controller"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("springboot利用swagger构建api文档")
            .description("项目描述，代码地址 https://github.com/ljinlin41")
            .termsOfServiceUrl("https://github.com/ljinlin41")
            .version("1.0")
            .build();
    }

}























