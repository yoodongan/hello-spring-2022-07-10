package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {
    MemberRepository memberRepository = new MemoryMemberRepository();
    @AfterEach
    public void clear() {
        memberRepository.clearRepo();
    }

    @Test
    public void saveTest() {
        Member member = new Member();
        member.setName("spring");
        memberRepository.save(member);
        Member result = memberRepository.findById(member.getId()).get();
        Assertions.assertThat(result).isEqualTo(member);
    }
    @Test
    public void findByName() {
        //given
        Member member = new Member();
        member.setName("spring!");
        memberRepository.save(member);
        //when
        Member result = memberRepository.findByName(("spring!")).get();
        //then
        Assertions.assertThat(result).isEqualTo(member);
    }
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spr");
        memberRepository.save(member1);
        Member member2 = new Member();
        member2.setName("ing");
        memberRepository.save(member2);
        //when
        List<Member> result = memberRepository.findAll();
        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

}
