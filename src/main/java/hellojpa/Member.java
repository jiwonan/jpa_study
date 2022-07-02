package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
// @Table(name = "USER") // db 명과 클래스 명이 다를 경우 설정 가능.
public class Member {
    @Id
    private Long id;
    private String name;

    private int age;
    public Member() {}

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // @Column(name = "username") // 컬럼 이름이 객체와 데이터베이스가 다를 경우 해당 어노테이션으로 매핑 가능.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
