package aa.slkenv.dataBase.timeDate.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;


/**
 * MySQL和Java数据类型对应关系
 */
@Data
@Entity
@Table(name = "timedate")
@EqualsAndHashCode(callSuper = false)
public class TimeDate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "the_date")
    private Date theDate;
    @Column(name = "the_datetime")
    private Timestamp theDatetime;
    @Column(name = "the_time")
    private Time theTime;
    @Column(name = "the_timestamp")
    private Timestamp theTimestamp;
    private String status;
}
