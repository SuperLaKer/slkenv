package aa.slkenv.dataBase.timeDate.web.mapper;

import aa.slkenv.dataBase.timeDate.web.domain.TimeDate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-05-27
 */
public interface TimeDateMapper extends BaseMapper<TimeDate> {

    @Select("select * from time_date")
    public List<TimeDate> findAll();


    @Select("select * from time_date where the_datetime > #{date}")
    public List<TimeDate> findByDateTime(@Param("date") Date date);
}
