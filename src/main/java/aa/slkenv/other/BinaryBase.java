package aa.slkenv.other;

/**
 * 二进制基础：
 *
 * 补码==================================
 * 正数补码：不变
 * 负数补码：除了符号位其他位取反，然后加1
 *
 * 负数==================================
 * +5原码：0000 0101 (1*2^2 + 1*2^0)
 * +5补码：0000 0101
 *
 * -5原码：1000 0101
 * -5取反：1111 1010 (除了符号位取反)
 * -5补码：1111 1011
 *
 * 1111 1011
 * 0000 0101
 * 0000 0000: 进位去掉
 *
 * 补码计算===============================
 * 数字用补码存储：屏蔽符号，直接相加，溢出丢弃
 *
 * -5 + 5 = 0
 * 1111 1011
 * 0000 0101
 * 0000 0000: 溢出的进位去掉
 * 负数用补码表示，整数的补码一样
 *
 * ============================相减===============
 * +5：0000 0101
 * -5：1111 1011
 * 溢出舍弃，不够就借
 * 1111 2021
 * 1111 1011
 * 0000 1010
 * ============================相减===============
 * -5：1111 1011
 * +5：0000 0101
 *
 * 结果补码: 1111 0110
 * 结果原码: 1000 1010
 */
public class BinaryBase {
}