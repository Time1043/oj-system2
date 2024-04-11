package com.time1043.javaoj.controller;

import com.time1043.javaoj.common.BaseResponse;
import com.time1043.javaoj.common.ErrorCode;
import com.time1043.javaoj.common.ResultUtils;
import com.time1043.javaoj.exception.BusinessException;
import com.time1043.javaoj.model.dto.postthumb.QuestionSubmitAddRequest;
import com.time1043.javaoj.model.entity.User;
import com.time1043.javaoj.service.QuestionSubmitService;
import com.time1043.javaoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 帖子点赞接口
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 点赞 / 取消点赞
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return resultNum 本次点赞变化数
     */
    @PostMapping("/")
    public BaseResponse<Integer> doThumb(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
            HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getPostId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        long postId = questionSubmitAddRequest.getPostId();
        int result = questionSubmitService.doQuestionSubmit(postId, loginUser);
        return ResultUtils.success(result);
    }

}
