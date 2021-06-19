package aa.slkenv.dataBase.timeDate.web.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>
 *
 * </p>
 *
 * @author jobob
 * @since 2021-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TimeDate implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String theDate;
    private LocalDateTime theDatetime;
    private LocalTime theTime;
    private LocalDateTime theTimestamp;
    private String tempAString;

    /**
     * 保留字段2
     */
    private String tempBString;

    /**
     * 是否启用
     */
    private String status;


}
