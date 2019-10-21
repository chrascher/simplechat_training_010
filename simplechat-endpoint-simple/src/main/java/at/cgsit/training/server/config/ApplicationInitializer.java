package at.cgsit.training.server.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApplicationInitializer {
//        implements WebApplicationInitializer {

    //    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("at.cgsit.training");
        servletContext.addListener(new ContextLoaderListener(context));

        context.setConfigLocation("classpath:applicationContext.xml");

        // servletContext.setInitParameter("contextConfigLocation", "at.cgsit.training");

    /*    AutowiredAnnotationBeanPostProcessor bpp = new AutowiredAnnotationBeanPostProcessor();
        bpp.setBeanFactory(cc.getAutowireCapableBeanFactory());
        bpp.processInjection(target);
        */
    }

}
