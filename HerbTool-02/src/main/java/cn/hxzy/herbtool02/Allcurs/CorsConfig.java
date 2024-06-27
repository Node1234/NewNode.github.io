package cn.hxzy.herbtool02.Allcurs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CorsConfig类，用于配置Spring应用程序的跨域资源共享（CORS）。
 * 该配置允许来自指定源的请求访问应用程序的所有资源，并允许特定的HTTP方法。
 */
@Configuration // 声明这是一个配置类
public class CorsConfig implements WebMvcConfigurer {

    /**
     * 重写addCorsMappings方法，配置CORS映射。
     * @param registry CorsRegistry实例，用于配置CORS
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 添加全局CORS配置，允许所有路径的请求
        registry.addMapping("/**")
                // 允许来自http://localhost:63342的请求
                .allowedOrigins("http://localhost:63342")
                // 允许的HTTP方法包括GET, POST, PUT, DELETE
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                // 允许发送Cookie等凭证信息
                .allowCredentials(true);
    }
}

