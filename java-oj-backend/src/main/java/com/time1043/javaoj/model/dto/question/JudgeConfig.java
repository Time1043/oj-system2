package com.time1043.javaoj.model.dto.question;

import lombok.Data;

/**
 * 题目配置
 */
@Data
public class JudgeConfig {
    /**
     * 时间限制（单位：ms）
     */
    private Long timeLimit;

    /**
     * 内存限制（单位：KB）
     */
    private Long memoryLimit;

    /**
     * 堆栈限制（单位：KB）
     */
    private Long stackLimit;
}
