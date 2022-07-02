package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
// @Table(name = "USER") // db 명과 클래스 명이 다를 경우 설정 가능.
public class Member {
    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    // Enum은 ORDINAL을 쓰면 안됨.
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    // 최근에는 LoalDate, LocalDateTime을 지원하기때문에 Temporal이 필요 없음.

    @Lob // 큰 데이터.
    private String description;

    @Transient // DB에 컬럼 할당 x.
    private int temp;

    public Member() {

    }
}
