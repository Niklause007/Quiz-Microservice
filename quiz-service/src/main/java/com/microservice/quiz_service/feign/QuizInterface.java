package com.microservice.quiz_service.feign;

import com.microservice.quiz_service.entity.QuestionWrapper;
import com.microservice.quiz_service.entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForOuiz(@RequestParam String category, @RequestParam Integer numQ);
    @PostMapping("question/getQuestions")
    public  ResponseEntity<List<QuestionWrapper>>getQuestionsFromId(@RequestBody List<Integer> questionIds);
    @GetMapping("question/getScore")
    public  ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

}
