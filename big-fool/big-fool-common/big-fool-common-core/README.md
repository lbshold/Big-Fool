**记录big-fool-common-core 做了哪些事情**

#### 1. 引入Hutool: Java工具类库

#### 2. 请求返回统一格式、请求返回工具类

        RestResult、RestResultUtils 

#### 3. 全局异常统一处理

        WholeExceptionHandler
        
#### 4. 全局时间序列化配置：Date、Java8时间序列化
         
        JavaTimeModule、JacksonConfiguration
        
#### 5. RestTemplate：Http请求工具

        RestTemplateConfiguration
        
#### 6. 自定义线程池 ThreadPoolTaskExecutor

        AsyncThreadPoolConfig
        