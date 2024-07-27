package cn.myth.springframework.aop;

/**
 * Superinterface for all Advisors that are driven by a pointcut.
 * This covers nearly all advisors except introduction advisors,
 * for which method-level matching doesn't apply.
 */
public interface PointcutAdvisor extends Advisor {

    // PointcutAdvisor 承担了 Pointcut 和 Advice 的组合，Pointcut 用于获取 JoinPoint，而 Advice 决定于 JoinPoint 执行什么操作。

    /**
     * Get the Pointcut that drives this advisor.
     */
    Pointcut getPointcut();
}
