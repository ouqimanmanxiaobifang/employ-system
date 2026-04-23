package com.enterprise.employeesystem.common;
// Lombok 是一个 Java 代码生成工具，能帮我们自动生成大量重复的样板代码，是后端开发必备神器。
import lombok.Data;
// 这个类的作用是让后端所有接口返回给前端的数据格式统一
// 文档注释：/** 注释内容 */（这种注释会被 JavaDoc 工具识别，生成 API 文档）
/**
 * 统一返回结果类
 */
//@Data这个注解的作用：自动生成以下所有代码
//1.所有私有字段的getter方法（获取字段值）
//2.所有私有字段的setter方法（获取字段值）
//3.toString()方法（打印对象时显示所有字段值）
//4.equals()和hashCode()方法（对象比较用）
//5.无参构造方法（new R<>()就是调用这个）

@Data
public class R<T> {
//    成员变量（类的属性）
    // 响应码  告诉前端请求成功还是失败
    private int code;
    // 响应消息   例"操作成功"、"用户名不存在"
    private String msg;
    // 响应数据   实际返回的数据
    private T data;

    // 成功：无数据
//    static表示这个方法属于类本身，而不是类的对象
//    调用方式，直接用类名.方法名（）   不用先new对象
    public static <T> R<T> success() {
//        新建一个空的返回结果对象，把它存到变量 r 里，后面要给它装内容。
//        R<T>代表的是声明一个R类型的变量
        R<T> r = new R<>();
//        给返回结果设置 “成功状态码”
//        这里的ResultCode.SUCCESS.getCode()来源于ResultCode这个文件
//        如果两个类在 “同一个包” 里（代码第一行的 package 声明一样），就不用导入；如果在 “不同包” 里，就必须导入。
        r.setCode(ResultCode.SUCCESS.getCode());
        r.setMsg(ResultCode.SUCCESS.getMsg());
        return r;
    }

    // 成功：带数据
    public static <T> R<T> success(T data) {
        R<T> r = new R<>();
        r.setCode(ResultCode.SUCCESS.getCode());
        r.setMsg(ResultCode.SUCCESS.getMsg());
        r.setData(data);
        return r;
    }

    // 失败
    public static <T> R<T> failed() {
        R<T> r = new R<>();
        r.setCode(ResultCode.FAILED.getCode());
        r.setMsg(ResultCode.FAILED.getMsg());
        return r;
    }
}


//public static <T> R<T> success() {
//    R<T> r = new R<>();
//    r.setCode(ResultCode.SUCCESS.getCode());
//    r.setMsg(ResultCode.SUCCESS.getMsg());
//    return r;
//}
/* 上面这一段代码的作用:快速创建一个表示[请求成功\无返回数据]的统一响应
* 对象     例子: 当你写一个接口，执行成功但不需要返回数据（比如新增用户、删除数据），你就可以直接调用这个方法，
* 得到一个 code=成功码、msg=成功提示 的标准响应对象，不用每次都自己 new R() 再手动设值。 */

// 为何用static主要是调用更简单,不用重复创建对象,这里的创建对象指的是在方法内部创建的,不用重复创建是外面调用这个方法不用重复
//
//


// 整个业务流程:
//场景描述
//前端传过来一个用户 ID：1001
//后端去数据库查，查到了这个用户的信息（名字：张三，年龄：25）
//后端要把 “成功状态”+“提示语”+“张三的信息” 一起返回给前端
//第一步   先有一个 User 类（用户信息类）
//// 简单的用户类，存名字和年龄
//public class User {
//    private String name;
//    private Integer age;
//
//    // 构造方法
//    public User(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    // Getter/Setter 省略...
//}
//第二步就是现在的代码
//第三步在接口里调用
//public class UserController {
//    // 根据ID查询用户信息的接口
//    public R<User> getUserById(Integer userId) {
//        // 1. 模拟去数据库查用户（假设查到了ID=1001的用户）
//        User user = new User("张三", 25);
//
//        // 2. 把“用户对象”装到返回结果里，一起返回给前端
//        return R.success(user); // 👈 这里会自动调用 setData(user)
//    }
//}
//前端最终收到的 JSON 数据（长这样）
//{
//  "code": 200,
//  "msg": "操作成功",
//  "data": {
//    "name": "张三",
//    "age": 25
//  }
//}
//


