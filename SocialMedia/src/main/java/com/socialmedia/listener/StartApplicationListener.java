package com.socialmedia.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.socialmedia.playfab.PlayFabUtil;

@Component  
public class StartApplicationListener implements ApplicationListener<ContextRefreshedEvent>{  
  
    @Override  
    public void onApplicationEvent(ContextRefreshedEvent event) {  
          PlayFabUtil.StartUpPlayFab();
    }  
}
