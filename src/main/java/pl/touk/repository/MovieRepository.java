package pl.touk.repository;

import pl.touk.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    //TODO Jak ograniczyć wyniki wyszukiwania tylko do tytułów i screenTimes
    // SELECT .. m.title ... zwraca błąd
    @Query("SELECT DISTINCT m FROM Movie m JOIN m.screenTime st WHERE st.screenTime between :startFrom and :startTo")
    Stream<Movie> findByScreenTimeBetween(@Param("startFrom") LocalDateTime startFrom, @Param("startTo") LocalDateTime startTo);

    Movie findByTitle(String title);

    //TODO Rekordy się powtarzają
    //    @Query("SELECT DISTINCT * FROM Movie m JOIN SCREEN_TIMES st ON st.MOVIE_ID=m.ID ORDER BY m.TITLE ASC, st.SCREEN_TIME;")   //SQL
//    @Query("SELECT DISTINCT m FROM Movie m JOIN m.screenTime st WHERE st.MOVIE_ID=m.id ORDER BY m.title ASC, st.screenTime")
    Stream<Movie> findAllByOrderByTitleAscScreenTimeAsc();
}
