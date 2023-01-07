
package br.ufsc.curso.SpringBoot_Postagem.Util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *
 * @author RC_Ventura
 */
@Component
public class ApplicationContextLoad implements ApplicationContextAware {            //classe que carrega a instância do Bean

    @Autowired
    private static  ApplicationContext applicationContext;
    
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        
        this.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    
    
    
}
