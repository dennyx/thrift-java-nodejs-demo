# Thrift示例项目

## 简介
* 此项目，只为更好的理解存在的一种项目结构，如台州微信银行；
* thrift是一个软件框架，用来进行可扩展且跨语言的服务的开发，以构建在不同编程语言间无缝结合的，高效的服务；允许定义一个简单的定义文件中的数据类型和服务接口，以作为输入文件，编译器生成代码用来方便地生成RPC客户端和服务器通信的无缝跨编程语言；
* thrift 示例项目，server端基于Java实现，client端基于Nodejs实现，与台州微信银行保持一样的通讯方式
* RPC: 远程过程调用，需要解决的问题： 通讯，序列化等

## 项目结构
* thrift
    * shared.thrift, tutorial.thrift 为thrift定义文件
    * gen-java为thrift根据thrift定义文件，自动生成的java代码
        ```bash
        thrift -r --gen Java tutorial.thrift
        ```
    * gen-nodejs为thrift根据thrift定义文件，自动生成的nodejs代码
        ```bash
        thrift -r --gen js:node tutorial.thrift      
        ```
* node_client
    * nodejs客户端
    * 启动方式: node NodeClient.js

* java_server
    * java server端
    * 启动方式: JavaServer.main

## ref
* http://blog.csdn.net/jinking_xu/article/details/46785637
* http://www.micmiu.com/soa/rpc/thrift-sample/
* https://www.zhihu.com/question/20189791
* https://diwakergupta.github.io/thrift-missing-guide/
* thrift与http通信性能比较：http://snoopyxdy.blog.163.com/blog/static/6011744020153245334890/