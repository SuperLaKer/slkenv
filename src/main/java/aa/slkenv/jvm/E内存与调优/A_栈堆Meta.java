package aa.slkenv.jvm.E内存与调优;

/**
 * 栈：变量，可能是引用类型  执行堆
 * 堆：变量头有个执行metaspace的指针
 * static User = new User(): metaspace指向了栈
 *
 * 如果对象在方法内部用完就不用了，则此对象只会存在于方法私有栈所以：
 * 栈可能执行堆
 */
public class A_栈堆Meta {
}
