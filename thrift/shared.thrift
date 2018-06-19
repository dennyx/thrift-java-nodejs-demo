/**
*   可被其他文件引用
*/

namespace cpp shared
namespace d share  // shared在这里为关键词
namespace java shared
namespace perl shared
namespace php shared
namespace haxe shared

struct SharedStruct {
    1: i32 key
    2: string value
}

service SharedService {
    SharedStruct getStruct(1: i32 key)
}