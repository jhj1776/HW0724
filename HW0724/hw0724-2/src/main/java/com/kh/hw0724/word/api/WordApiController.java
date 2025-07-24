package com.kh.hw0724.word.api;

import com.kh.hw0724.word.service.WordService;
import com.kh.hw0724.word.vo.WordVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/word")
@RequiredArgsConstructor
@CrossOrigin(value = "http://192.168.20.159:5500/")
public class WordApiController {
    private final WordService service;

    @PostMapping
    public ResponseEntity<Integer> insertWord(@RequestBody WordVo vo) {
        System.out.println("vo = " + vo);
        int result = service.insertWord(vo);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping
    public ResponseEntity<List<WordVo>> selectWordList() {
        List<WordVo> voList = service.selectWordList();
        return ResponseEntity
                .ok()
                .body(voList);
    }

    @GetMapping("{no}")
    public ResponseEntity<WordVo> selectOneByNo(@PathVariable String no) {
        WordVo vo = service.selectOneByNo(no);
        return ResponseEntity
                .ok()
                .body(vo);
    }

    @DeleteMapping("{no}")
    public ResponseEntity<Integer> del(@PathVariable String no) {
        int result = service.del(no);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @PutMapping()
    public ResponseEntity<Integer> update(@RequestBody WordVo vo) {
        int result = service.update(vo);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("getCategory")
    public ResponseEntity<List<WordVo>> selectCategoryName(){
        
        List<WordVo> voList = service.selectCategoryName();
        return ResponseEntity
                .ok()
                .body(voList);
    }

    @PostMapping("insertCategory")
    public ResponseEntity<Integer> insertCategory(@RequestBody WordVo vo){
        int result = service.insertCategory(vo);
        return ResponseEntity
                .ok()
                .body(result);
    }


}
