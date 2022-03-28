## Mybatis

**MyBatis组件以及执行基本流程**

- SqlSessionFactoryBuilder（构造器）:它会根据配置信息或者代码生成SqlSessionFactory（工厂接口）
- SqlSessionFactory：依靠工厂来生成SqlSession。
- SqlSession：是一个既可以发送SQL去执行并返回结果的，也可以获取Mapper接口，通过Mapper接口查询并封装数据。
- SQL Mapper:它是MyBatis新设计的组件，它是由一个Java接口和XML文件（或者注解)构成的，需要给出对应的SQL和映射规则。它负责发送SQL去执行，并返回结果。

![image-20220328144728063](resources/image-20220328144728063.png)

