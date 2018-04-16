# java-week6-spring-boot-basic
本题要求使用Spring boot来完成对Employee CURD(增删改查) API接口的实现。
1. 要求每一个Employee包含 id、name、age、gender四个字段。
2. 至少需要完成查询所有 Employee 的API接口，并返回一个包含所有Employee的JSON，要求接口路径：http://localhost:8080/employees
3. 要求使用Postman来向目标接口路径发送请求，获取Response，Response JSON格式如下:
```
[
    {
      "id": 0,
      "name": "小明",
      "age": 20,
      "gender": "男"
    },
    {
      "id": 1,
      "name": "小红",
      "age": 19,
      "gender": "女"  
    },
    {
      "id": 2,
      "name": "小智",
      "age": 15,
      "gender": "男"
    },
    {
      "id": 3,
      "name": "小刚",
      "age": 16,
      "gender": "男"
    },
    {
      "id": 4,
      "name": "小霞",
      "age": 15,
      "gender": "女"
    }
  ]
```
4. 将结果截图，并将图片存放在项目根目录下，截图命名为result.png。例如： 
![result](https://raw.githubusercontent.com/tws-online-quiz/spring-boot-quiz/master/example.png "result example")
