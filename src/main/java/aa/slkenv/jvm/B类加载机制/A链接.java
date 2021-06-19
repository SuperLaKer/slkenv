package aa.slkenv.jvm.B类加载机制;

// javap -c A.class; 编译为更可读的字节码

/**
 * 加载、验证
 * 准备：静态变量分配内存，并赋予默认值
 * 解析：动态连接，对字节码符号赋值（指针）
 * 初始化：静态变量赋值，执行静态代码块
 * 静态连接：给变量直接赋值、根据上下文能够推导出来保存哪个指针。这些在初始化阶段已经完成
 * <p>
 * 动态连接：只有在程序执行的时候才能确定该变量保存的是哪个指针
 * 动态连接：Python
 */
public class A链接 {
    public static void main(String[] args) {
        String path = A链接.class.getResource("/").getPath();
        System.out.println(path);
    }
}
