package aa.slkenv.dataBase.timeDate.web.repositories;

import aa.slkenv.dataBase.timeDate.web.entity.TimeDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TimeDateRepository extends JpaRepository<TimeDate,Long> {

    List<TimeDate> findByTheDateBefore(LocalDate localDate);

    List<TimeDate> findByTheDateAfter(LocalDate localDate);

    // private Timestamp theTimestamp;
    List<TimeDate> findByTheTimestampIsBefore(Timestamp timestamp);
}
