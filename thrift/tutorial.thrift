/**
* IDL: thrift interface definition language
*/

/**
* thrift支持的基本数据类型
    bool
    byte
    i16 16-bit integer
    i32 32-bit interger
    i64 64-bit interger
    double 
    string
    binary
    map<t1, t2>
    list<t1>
    set<t1>
*/

/**
*   支持引用其他thrift文件
*/
include "shared.thrift"

/**
*   可包含namespace, package, 或者prefix
*/

namespace cpp tutorial
namespace d tutorial
namespace java tutorial
namespace php tutorial
namespace perl tutorial
namespace haxe tutorial

/**
*   可自定义类型名称
*/
typedef i32 MyInterger

/**
*   可定义常量
*/
const i32 INT32CONSTANT = 9853
const map<string, string> MAPCONSTANT = { 'hello': 'world', 'goodnight': 'moon'}

/**
*   可定义枚举，只支持32bit integer
*/
enum Operation {
    ADD = 1,
    SUBTRACT = 2,
    MULTIPLY = 3,
    DIVIDE = 4
}

/**
*   数据结构，默认值
*/
struct Work {
    1: i32 num1 = 0,
    2: i32 num2,
    3: Operation op,
    4: optional string comment,
}

/**
*   数据结构，异常
*/
exception InvalidOperation {
    1: i32 whatOp,
    2: string why
}

/**
*   定义service, 只需要定义名称即可，也可以继承其他的service, 关键词extends
*/
service Calculator extends shared.SharedService {

    /**
    *   方法定义
    *   包含返回类型，参数，默认包含的exception
    */
    void ping(),

    i32 add(1: i32 num1, 2: i32 num2),

    i32 calculate(1: i32 logid, 2:Work w) throws (1: InvalidOperation ouch),

    /**
    *   oneway为关键词，说明，client端只发请求，但是不会监听返回信息
    */
    oneway void zip()
}



