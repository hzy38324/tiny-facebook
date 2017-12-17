package com.b4u.tinyfacebook.aspectj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: hzy
 * @since:
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AspectjConfig {
    @Bean
    public AudienceV3 AudienceV3() {
        return new AudienceV3();
    }

    @Bean
    public Performance goodPerformance() {
        return new GoodPerformance();
    }

    @Bean
    public Performance badPerformance() {
        return new BadPerformance();
    }

    @Bean
    public PerformCountAspect performCountAspect() {
        return new PerformCountAspect();
    }
}
