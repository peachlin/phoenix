package com.zmsj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wang.kun
 */
@EnableSwagger2
@MapperScan("com.zmsj.phoenix.dao")
@SpringBootApplication
public class Application {

  public static void main(String[] args) {

    SpringApplication.run(Application.class, args);
  }

  @Bean
  @Lazy
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2).select().apis(
        RequestHandlerSelectors.basePackage("com.zmsj"))
        .paths(PathSelectors.any()).build()
        .apiInfo(new ApiInfoBuilder().title("工业大屏").description("工业大屏")
            .version("1.0").build());
  }
}
