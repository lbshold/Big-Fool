package top.lconcise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.lconcise.mapper.UserMapper;

@SpringBootApplication
@MapperScan("top.lconcise.mapper")
public class TemplateApplication {

    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }
}
