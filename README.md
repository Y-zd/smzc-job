smzc任务调度中心
==

[技术选型参考文章](https://www.expectfly.com/2017/08/15/%E5%88%86%E5%B8%83%E5%BC%8F%E5%AE%9A%E6%97%B6%E4%BB%BB%E5%8A%A1%E6%96%B9%E6%A1%88%E6%8A%80%E6%9C%AF%E9%80%89%E5%9E%8B/)<br>
[xxl-job官方文档](http://www.xuxueli.com/xxl-job/)
---

   ![image](https://github.com/Y-zd/smzc-job/blob/master/doc/images/smzc-job-design.png)


* [tables_xxl_job调度中心相关表sql](/doc/db/tables_xxl_job.sql)

* [xxl-job核心包](/xxl-job-core)

* [xxl-job调度管理后台](/xxl-job-admin)

* [plan-a-executor-demo(调度中心方案一执行器demo)](/plan-a-executor-demo)
    
    方案一的demo,与dubbo结合
     1. 注册到zk中
     2. 注册到分布式调度中心admin

* [plan-b-executor-demo(调度中心方案二执行器demo)](/plan-b-executor-demo)
    
    方案二的demo,需要在各模块单独写自己的执行器注册到任务调度中心
     1. 注册到分布式调度中心admin 

--- 
 使用方法:
   1. 创建调度中心相关表数据
   2. 启动调度中心xxl-job-admin
   3. 启动执行器executor
   4. 在admin系统中配置执行器
         
         ![image](https://github.com/Y-zd/smzc-job/blob/master/doc/images/executor-manager.png)
   
   5.  在任务管理中新增任务bean方式配置任务如下所示
   
          ![image](https://github.com/Y-zd/smzc-job/blob/master/doc/images/job-manager.png)

        以运行模式为BEAN的配置为例子：JobHandler中填写 executor 中 @JobHandler(value = "demoJobHandler") value值
```java
     @JobHandler(value = "demoJobHandler")
     @Component
     public class DemoJobHandler extends IJobHandler {
         
         @Resource
         private ConsumerCardInfoService consumerCardInfoService;
         @Override
         public ReturnT<String> execute(String param) throws Exception {
             XxlJobLogger.log("XXL-JOB, plan a demo result:" + consumerCardInfoService.selectCities().get(0).getCityName());
             return SUCCESS;
         }
     }
```

使用步骤中的第5步还支持多种模式详见官方文档——[三、任务详解](https://gitee.com/xuxueli0323/xxl-job/blob/master/doc/XXL-JOB%E5%AE%98%E6%96%B9%E6%96%87%E6%A1%A3.md)

---
TODO
   * 方案的选项（个人比较倾向第二种，可分模块自己维护执行器，对执行器的负荷也能分散）
   * 日志可以集成到我们目前的日志系统中来
   * 每个执行器可自由改为springBoot方式



   
   
   
   
      
        










