9091- gongyu-admin访问路径：<br>
	http://localhost:9090/gongyu-admin
- swagger文档路径：<br>
	http://localhost:8080/gongyu-admin/swagger/index.html
- swagger注解路径：<br>
	http://localhost:8080/gongyu-admin/swagger-ui.html
- 账号密码：admin/admin
<br>
- Eclipse、IDEA运行ApiApplication.java，则可启动项目【gongyu-api】
- gongyu-api访问路径：<br>
	http://localhost:9091/gongyu-api/swagger-ui.html
<br>
- Eclipse、IDEA运行GeneratorApplication.java，则可启动项目【gongyu-generator】
- gongyu-generator访问路径：<br>
	http://localhost:8082/gongyu-generator
<br>
 **集群部署**
- 集群部署，需要安装redis，并配置redis信息
- 需要配置【gongyu.redis.open=true】，表示开启redis缓存
- 需要配置【gongyu.cluster=true】，表示开启集群环境
