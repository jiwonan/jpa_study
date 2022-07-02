package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
// @Table(name = "USER") // db 명과 클래스 명이 다를 경우 설정 가능.
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Member() {

    }
}
