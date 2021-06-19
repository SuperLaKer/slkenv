package aa.slkenv.jvm;


/**
 * Java的高级抽象：
 * metaspace：类元信息，在加载的时候就会把类元信息放到metaspace，解析阶段会使用这些符号
 * metaspace的const pool: 此类相关的所有符号。如方法名、参数名、括号这些东西编译后都是一个一个符号。肯定不是英文单词
 *
 * 解析阶段：对象|单词 指向metaspace
 * people.say()  == 调用metaspace中的符号
 * java= -v xx.class看看就明白了
 *
 */
public class 入口类 {
}
