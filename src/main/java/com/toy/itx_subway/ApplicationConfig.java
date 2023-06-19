package com.toy.itx_subway;

import com.toy.itx_subway.domain.ItxTimeData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ItxTimeData itxTimeData(){
        return new ItxTimeData();
    }
}
