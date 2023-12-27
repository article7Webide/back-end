package article.WebIde.api.dto.directoryFile;

import article.WebIde.api.dto.com.comDto;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DirectoryFileReqDto extends comDto {
    private int dirId;

    private String dirNm;

    private int parentDirNo;

    private String dirFileGbcd;

    private String dirDpth;

    private String fileCntn;

    private int containerId;
}
