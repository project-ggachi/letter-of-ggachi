package com.letter.ggachi.repository.post;

import com.letter.ggachi.domain.entity.Member;
import com.letter.ggachi.domain.entity.Post;
import com.letter.ggachi.repository.member.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * please explain class!
 *
 * @author :Uheejoon
 * @fileName :PostRepositoryTest
 * @since :2024-02-16 오후 4:08
 */
@SpringBootTest
@Transactional
@Commit
class PostRepositoryTest {

  @Autowired
  private PostRepository postRepository;
  @Autowired
  private MemberRepository memberRepository;
  List<Post> posts = new ArrayList<>();
  Member member;

  @BeforeEach
  void setUp() {
    postRepository.deleteAll();
    member = Member.builder()
      .nickname("yhj3855")
      .name("유희준")
      .email("yhj3855@naver.com")
      .password("1234")
      .phoneNumber("01082003855")
      .introduction("")
      .build();
    memberRepository.save(member);

    for (int i = 1; i <= 30; i++) {
      Post post = Post.builder()
        .title("제목" + i)
        .member(member)
        .letters(new ArrayList<>())
        .startDate(LocalDateTime.now())
        .endDate(LocalDateTime.of(2024, 2, 18, 0, 0))
        .postEnc("")
        .postStatus("")
        .build();
      posts.add(post);
    }
    postRepository.saveAll(posts);
  }

  @Test
  @DisplayName("memberID와 Pageable을 활용한 데이터 조회")
  void findAllByMemberId() {
    Page<Post> postList = postRepository.findAllByMemberId(1L, PageRequest.of(0, 20));
    assertThat(postList.getContent().size()).isEqualTo(20);

  }
}