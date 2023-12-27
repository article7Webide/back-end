package article.WebIde.api.dto.directoryFile;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
public class DirectoryFileRespDto {
    private int dirId;

    private String dirNm;

    private int parentDirNo;

    private String dirFileGbcd;

    private int dirDpth;

    private String fileCntn;

    private int containerId;
}
