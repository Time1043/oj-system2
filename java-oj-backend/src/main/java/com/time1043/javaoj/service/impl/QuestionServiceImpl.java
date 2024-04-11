package com.time1043.javaoj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.time1043.javaoj.model.entity.Question;
import com.time1043.javaoj.service.QuestionService;
import com.time1043.javaoj.mapper.QuestionMapper;
import org.springframework.stereotype.Service;

/**
* @author 16654
* @description 针对表【question(题目)】的数据库操作Service实现
* @createDate 2024-04-11 20:49:30
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService{

}




