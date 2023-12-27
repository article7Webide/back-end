package article.WebIde.api.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String password;
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(String email, String password, Authority authority, String nickname) {
        this.email = email;
        this.password = password;
        this.authority = authority;
        this.nickname = nickname;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
