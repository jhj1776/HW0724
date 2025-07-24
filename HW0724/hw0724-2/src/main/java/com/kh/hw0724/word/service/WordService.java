package com.kh.hw0724.word.service;

import com.kh.hw0724.word.mapper.WordMapper;
import com.kh.hw0724.word.vo.WordVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class WordService {
    private final WordMapper mapper;

    public int insertWord(WordVo vo) {
        return mapper.insertWord(vo);
    }

    public List<WordVo> selectWordList() {
        return mapper.selectWordList();
    }

    public WordVo selectOneByNo(String no) {
        return mapper.selectOneByNo(no);
    }

    public int del(String no) {
        return mapper.del(no);
    }

    public int update(WordVo vo) {
        return mapper.update(vo);
    }

    public List<WordVo> selectCategoryName( ) {
        return mapper.selectCategoryName();
    }

    public int insertCategory(WordVo vo) {
        return mapper.insertCategory(vo);
    }
}
