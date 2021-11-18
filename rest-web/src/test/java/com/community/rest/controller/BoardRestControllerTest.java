package com.community.rest.controller;

import com.community.rest.domain.Board;
import com.community.rest.domain.User;
import com.community.rest.domain.enums.BoardType;
import com.community.rest.repository.BoardRepository;
import com.community.rest.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class BoardRestControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void 값넣기() {
        User user = userRepository.save(User.builder()
                .name("havi")
                .password("test")
                .email("havi@gmail.com")
                .build());
        IntStream.rangeClosed(1, 200).forEach(index -> 	boardRepository.save(Board.builder()
                .title("게시글"+index)
                .subTitle("순서"+index)
                .content("콘텐츠")
                .boardType(BoardType.free)
                .user(user)
                .build()));

        assertThat(boardRepository.findAll().size()).isEqualTo(200);
    }
}