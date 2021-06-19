package aa.slkenv.jvm.A类加载顺序;

import lombok.Getter;
import lombok.Setter;

/**
 * class头部有一个执行metaspace的指针，准备阶段、解析阶段会用到这些信息
 * new xxClass();
 * 默认执行一些逻辑：
 *
 *
 * 加载 ---》 验证 ---》准备 ---》解析 ---》 初始化
 * <p>
 * 准备阶段：静态变量赋予默认值。对象赋值为null，基本赋值为 0， false等
 * 解析阶段：.class文件加载到内存中后数据是分片存放的。解析阶段就是拿到MetaSpace中的地址
 * 解析阶段：metaSpace存放类更顶层的抽象，类的描述信息都在这里面
 * 初始化：静态变量初始化，执行静态代码块
 */
@Getter
@Setter
class A {

    static String A_STATIC = "A静态变量";

    static {
        System.out.println(A_STATIC+"已经初始化了...");
        System.out.println("A静态代码块");
    }

    public A() {
        // 第一行：父类无参
        // 第二行：加载 ---》 验证 ---》准备 ---》解析 ---》 初始化
        System.out.println("A无参构造");
    }

}

@Getter
@Setter
class B extends A {

    static String B_STATIC = "B静态变量";
    static private C_CLASS c = new C_CLASS();

    static {
        System.out.println(B_STATIC);
        System.out.println("B静态代码块");
    }

    public B() {
        // 第一行默认调用父类无参
        System.out.println("B无参构造");
    }

}

class C_CLASS {
    public C_CLASS() {
        System.out.println("c 无参。。。");
    }
}

public class ClassLoadOrder {

    public static void main(String[] args) {

        /*
         * B继承A, B静态属性指向C
         * 无参构造：第一行默认调用父类无参构造
         *
         * A静态属性，A静态代码块，A无参，C无参，B
         */
        B b = new B();

        System.out.println("\r\n");
        System.out.println("\r\n");

    }
}

