package article.WebIde.api.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
// import org.hibernate.annotations.ColumnDefault;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
// import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "DIR_FILE_BSE")
public class DirectoryFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dirId;

    @Column(length = 50, nullable = false)
    private String dirNm;

    private int parentDirNo;

    @Column(length = 1)
    private String dirFileGbcd;

    private int dirDpth;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String fileCntn;

    private int containerId;

    @Column(length = 20)
    private String regId;

    @CreatedDate
    private LocalDateTime regDt;

    @Column(length = 20)
    private String modId;

    @LastModifiedDate
    private LocalDateTime  modDt;

    @Builder
    public void updateDirectoryFile(String dirNm, String fileCntn, String modId, LocalDateTime  modDt){
        this.dirNm = dirNm;
        this.fileCntn = fileCntn;
        this.modId = modId;
        this.modDt = modDt;

    }
}
