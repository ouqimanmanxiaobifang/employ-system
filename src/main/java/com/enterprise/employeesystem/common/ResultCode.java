package com.enterprise.employeesystem.common;

/**
 * 响应码枚举（企业标准）
 */
//什么是枚举？
// 枚举是 Java 专门用来表示 **“一组固定不变的选项”** 的特殊类型。
//比如：星期（周一到周日）、季节（春夏秋冬）、接口状态码（成功、失败、未登录），这些选项是固定的，不会变的。
public enum ResultCode {
//    下面这四行代表预先在枚举内部创建好的 4 个ResultCode对象，
//    外面永远不能再 new 新的ResultCode对象，只能用这 4 个。
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数校验失败"),
    UNAUTHORIZED(401, "未登录");

    private int code;
    private String msg;

//    构造方法当你写SUCCESS(200, "操作成功")的时候，Java 就会自动调用这个构造方法，把200传给code参数，把"操作成功"传给msg参数。
    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}




//这一个包的完整工作流程
//第一步  项目启动时
//   ResultCode 枚举里的 4 个对象自动创建！
//SUCCESS(200, "操作成功")
//FAILED(500, "操作失败")
//VALIDATE_FAILED(404, "参数校验失败")
//UNAUTHORIZED(401, "未登录")
//可以理解为:项目一运行，就提前造好 4 个固定对象放在内存里，随时等着被调用。
//
//第二步  你在接口里写一句
//return R.success();
//这一句会触发 R 类里的静态方法：
//public static <T> R<T> success() {

//第三步  方法内部开始造盒子
//新建一个空盒子叫r
//R<T> r = new R<>();

//第四步   去字典里拿 “成功码”
//r.setCode(ResultCode.SUCCESS.getCode());
//这一步内部执行 3 小步：
//ResultCode.SUCCESS→ 拿到提前创建好的成功对象
//.getCode()→ 从成功对象里取出 200
//r.setCode(200)→ 把 200 放进盒子 r

//第 5 步：去字典里拿 “成功消息”
//r.setMsg(ResultCode.SUCCESS.getMsg());
//同样 3 小步拿
//1.SUCCESS 对象
//2.取消息："操作成功"
//3.放进盒子 r

//第 6 步：把造好的盒子返回
