package com.kh.hw0724.word.mapper;

import com.kh.hw0724.word.vo.WordVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface WordMapper {

    @Insert("""
            INSERT INTO WORD
            (
                NO
                , LENGTH
                , WORD
                , CATEGORY_ID
            )
            VALUES
            (
                SEQ_W.NEXTVAL
                , #{length}
                , #{word}
                , #{categoryId}
            )
            """)
    int insertWord(WordVo vo);

    @Select("""
            SELECT W.NO, W.LENGTH, W.WORD, W.CATEGORY_ID, W.ACTIVE_WORD ,C.CATEGORY_NAME
            FROM WORD W
            JOIN CATEGORY C ON W.CATEGORY_ID = C.CATEGORY_ID
            WHERE ACTIVE_WORD = 'Y'
            """)
    List<WordVo> selectWordList();

    @Select("""
            SELECT W.NO, W.LENGTH, W.WORD, W.CATEGORY_ID, W.ACTIVE_WORD ,C.CATEGORY_NAME
            FROM WORD W
            JOIN CATEGORY C ON W.CATEGORY_ID = C.CATEGORY_ID
            WHERE ACTIVE_WORD = 'Y'
            AND NO = #{no}
            """)
    WordVo selectOneByNo(String no);

    @Update("""
            UPDATE WORD
            SET ACTIVE_WORD = 'N'
            WHERE NO = #{no}
            """)
    int del(String no);

    @Update("""
            UPDATE WORD
            SET WORD = #{word}
                , LENGTH = #{length}
            WHERE NO = #{no}
            """)
    int update(WordVo no);

    @Select("""
            SELECT CATEGORY_ID ,CATEGORY_NAME
            FROM CATEGORY
            """)
    List<WordVo> selectCategoryName( );

    @Insert("""
            INSERT INTO CATEGORY
            (
                CATEGORY_ID
                , CATEGORY_NAME
            )
            VALUES
            (
                SEQ_C.NEXTVAL
                , #{categoryName}
            )
            """)
    int insertCategory(WordVo vo);
}
