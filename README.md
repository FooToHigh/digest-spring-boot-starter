# 工程简介

# 延伸阅读

怎么自定义一个start

	点击file -- new -- project  输入名称等等等。。。创建工程
        
	实现的功能是输入字符串，进行加密后返回
	
	1 引入第三方加密组件 common codec
	
	2.定义接口，接口说明了我们要做的功能是什么，比如接口里定义一个方法，传入一个字符串，返回一个String
	
	3.定义实现类，实现接口，调用commons包下的工具类进行md5加密返回字符串
	
	最重要的来了 
	
	4.新建一个配置包，包下新建一个类，此类的作用是加载配置信息，类上贴注解@componentScan @ConfigurationProperties（prefix = "digest"）加载指定配置的文件的前缀的具体的某个配置项，类里有个属性，这个属性在审判日那个项目启动的时候会从配置文件种读取并注入
	  配置文件新增 digest.type=md5
	
	5.在第四步的包下再建一个类，类上贴注解，@Configuration，把它声明为一个配置类Config，程序在启动的过程种会执行这个类中的方法，
	  再贴注解@EnableConfigurationProperties(第四步建的类.class)，作用是激活相应的属性,开发的时候才能拿到对应的属性
	  写个方法，返回第二步定义的接口对象，方法上贴注解@bean，@ConditionalOnProperty(prefix = "配置文件的前缀",name = "第四步的类里的哪个属性名",havingValue = "md5")
	  
	  @ConditionalOnProperty  这个注解的作用是让spring按需加载，
	
	6.在resource目录下新增目录META-INF,新增文件spring.factories   这个文件是为了保存元数据
		里面写上 org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.footohigh.digest.conf.Config 值是config类
	
	7.把pom文件里<pluging>注释掉，因为这个插件会对打包的项目进行一下加工，经过二次加工的文件，引入到别的项目里，spring不认识，
		然后直接install，到target里把包放到本地仓库