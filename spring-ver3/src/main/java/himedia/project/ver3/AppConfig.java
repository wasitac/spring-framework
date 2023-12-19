package himedia.project.ver3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("himedia.project.ver3.repository")
@MapperScan("himedia.project.ver3.mapper")
public class AppConfig {

}
