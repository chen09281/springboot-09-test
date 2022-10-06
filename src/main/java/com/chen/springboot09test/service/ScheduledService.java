package com.chen.springboot09test.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    // 在一个特定的时间执行这个方法 Timer

    // cron表达式
    // 秒 分 时 日 月 周几
    /*
    *  30 15 10 * * ? 每天10点15分30执行一次
    * */
    @Scheduled(cron = "0 19 16 * * ?")
    public void hell(){
        System.out.println("hello,你被执行了~");
    }
}
