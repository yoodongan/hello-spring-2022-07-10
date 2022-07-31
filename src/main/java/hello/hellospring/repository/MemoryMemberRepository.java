package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> memberStore = new HashMap<>();
    private static long id = 0;
    @Override
    public Member save(Member member) {
        long lastId = ++id;
        member.setId(lastId);
        memberStore.put(lastId, member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(memberStore.get(id));

    }

    @Override
    public Optional<Member> findByName(String name) {
        return memberStore.values()
                .stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(memberStore.values());
    }

    @Override
    public void clearRepo() {
        memberStore.clear();
    }

}
