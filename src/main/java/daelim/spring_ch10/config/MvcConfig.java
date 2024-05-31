package daelim.spring_ch10.config;

import daelim.spring_ch10.CommonExceptionHandler;
import daelim.spring_ch10.service.MemberService;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ResourceBundle;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/view/", ".jsp");
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages.label");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    @Bean
    public MemberService memberService() {

        return new MemberService();
    }
    @Bean
    public CommonExceptionHandler commonExceptionHandler() {
        return new CommonExceptionHandler();
    }
}


