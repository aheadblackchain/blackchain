#区块链
江西软件职业技术大学-区块链官网

## 技术与版本
1. 后台框架：springboot 2.3.3
2. 连接数据库：jpa 
3. 模板：thymeleaf
4. 前台框架：bootstrap
5. 数据库：mysql 8
6. 编辑器：idea 2019.3.5
7. 版本控制器：git
8. Java 1.8


## 命名规范：
1. 类命名：首字母大写
2. 普通变量：驼峰命名法。第一个单词小写，以后每个单词首字母大写
3. 静态变量：全部大写
4. 包名：全部小写

## springboot 注解
### 实体类注解
1. @GeneratedValue自动生成策略
    @GeneratedValue(strategy=GenerationType.AUTO) 也是默认策略， 即写成@GeneratedValue也可；
    (strategy = GenerationType.IDENTITY)指定“自动增长”
2. @Entity 注解这是个实体类
3. @Table 注解表相关，如别名等
4. @Id 注解主键
6. @Column 标识一些字段特性
    - name：表示数据库表中该字段的名称，默认情形属性名称一致。
    - nullable：表示该字段是否允许为null，默认为true。
    - unique：表示该字段是否是唯一标识，默认为false。
    - length：表示该字段的大小，仅对String类型的字段有效。
7. @Transient 标识该字段并非数据库字段映射
## dao
1. @Repository注解可以标记在任何的类上，用来表明该类是用来执行与数据库相关的操作
## servlet
1.业务层采用@Service
## controller
1. @Controller作用于表现层（spring-mvc的注解)
2. @GetMapping用于将HTTP get请求映射到特定处理程序的方法注解
   具体来说，@GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写
3. @RequestMapping
4. @RequestParam
    - required 这个参数定义了参数值是否是必须要传的
    - defaultValue 取值就是用来给取值为空的请求参数提供一个默认值的
    ```java
       @RequestMapping(value = "/name")
        String getName(@RequestParam(value = "person", defaultValue = "John") String personName) {
            return "Required element of request param";
        }
    ```
## 其他
1. @Component是一个通用的Spring容器管理的单例bean组件

# thymeleaf模板
1. xmlns：th指的是将thymeleaf的命名空间的名字命名为th，这个符号和之后所用的th一致。
```html
<html xmlns:th="http://www.thymeleaf.org">
```
2. th:text：在th后面加上一个冒号，并附加特定的字符组合，这个thymeleaf定义的占位符是生成thymeleaf页面的基础。之后我们可以看到很多这样的占位符。
   ${welcome}：${}这个占位符是thymeleaf非常关键的符号之一，用于变量的解析。
```html
<p th:text="${welcome}">Welcome to thymeleaf world!</p>
```
3. 
```html
 <li th:each="product:${products}">
         <span th:text="${product.id}">编号</span>
         <span th:text="${product.title}">标题</span>
         <span th:text="${product.formatedPrice()}">价格</span>
         <span th:text="${product.discountPercent*100+'%'}">折扣</span>
     </li>
```
4. 
```html
<span th:if="${product.discountPercent<=0.9}">热销</span>
```


