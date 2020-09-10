#区块链
江西软件职业技术大学-区块链官网

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
## 其他
1. @Component是一个通用的Spring容器管理的单例bean组件


