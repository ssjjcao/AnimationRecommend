# 这个用来记录我们的详细更新吧，commit写一堆总是难受的

> time: 2019/11/19  11:21
>
> 总体描述：数据安全方面做了一些尝试，更新了数据库的内容，docker初始文件写了一个放上去了，添加了几个未来可能会用到的好用的库

1. ### 添加了Jasypt库

   1. 将数据库用户名，密码加密存储，加密所用盐值已换掉
   2. 具体盐值发在群里
   3. 之后应当在部署的时候通过命令加入盐值

2. ### 更新了数据库内容，LXM的新版本重新更新到数据库

3. ### 加入了dockerfile等

   1. 为了未来的docker方便搞一点，先写了个基础文件，修改了pom.xml的配置使易得
   2. ~~

4. ### 添加了几个库~

   1. spring-boot-devtools热部署
   2. fastjson一个很快很好用的json库
   3. lombok邪恶的代码简洁神器
   4. springfox-swagger快乐的文档自动生成器

> author: killMyTime
>
> site: killMyTime.top
>
> commit end~~~