package com.zyyoona7.lambda;

public class LambdaDemo {


    /*Lambda 表达式的结构。
    一个 Lambda 表达式可以有零个或多个参数
    参数的类型既可以明确声明，也可以根据上下文来推断。例如：(int a)与(a)效果相同
    所有参数需包含在圆括号内，参数之间用逗号相隔。例如：(a, b) 或 (int a, int b) 或 (String a, int b, float c)
    空圆括号代表参数集为空。例如：() -> 42
    当只有一个参数，且其类型可推导时，圆括号（）可省略。例如：a -> return a*a
    Lambda 表达式的主体可包含零条或多条语句
    如果 Lambda 表达式的主体只有一条语句，花括号{}可省略。匿名函数的返回类型与该主体表达式一致
    如果 Lambda 表达式的主体包含一条以上语句，则表达式必须包含在花括号{}中（形成代码块）。匿名函数的返回类型与代码块的返回类型一致，若没有返回则为空*/

    /*
    函数式接口是只包含一个抽象方法声明的接口。
    @FunctionalInterface 是 Java 8 新加入的一种接口，用于指明该接口类型声明是根据 Java 语言规范定义的函数式接口。
    Java 8 还声明了一些 Lambda 表达式可以使用的函数式接口，当你注释的接口不是有效的函数式接口时，
    可以使用 @FunctionalInterface 解决编译层面的错误。
     */

    public static void execute1(CustomInterface customInterface) {
        customInterface.doSomething("custom interface 1");
    }

    public static String execute2(CustomInterface2 customInterface2) {
        return customInterface2.doSomething();
    }

    public static void main(String[] args) {

        execute1((str) -> System.out.println(str));
        /*
        方法引用是用来直接访问类或者实例的已经存在的方法或者构造方法。
        方法引用提供了一种引用而不执行方法的方式，它需要由兼容的函数式接口构成的目标类型上下文。
        计算时，方法引用会创建函数式接口的一个实例。
        当Lambda表达式中只是执行一个方法调用时，不用Lambda表达式，直接通过方法引用的形式可读性更高一些。
        方法引用是一种更简洁易懂的Lambda表达式。
         */
        execute1(System.out::println);
        String string = execute2(() -> {
            System.out.println("interface 2 doSomething execute");
            return "custom interface 2";
        });
        System.out.println(string);
    }
}
