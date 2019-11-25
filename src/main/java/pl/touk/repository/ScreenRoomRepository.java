package pl.touk.repository;

import pl.touk.model.ScreenRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRoomRepository extends JpaRepository<ScreenRoom, Long> {
}
