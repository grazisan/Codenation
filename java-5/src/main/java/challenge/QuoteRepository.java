package challenge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {

    @Query(value = "SELECT id, actor, detail FROM scripts WHERE random() < 0.01 LIMIT 1;",
            nativeQuery = true)
    Quote getQuote();

    @Query(value = "SELECT id, actor, detail FROM scripts WHERE actor LIKE :actor AND random() < 0.01 LIMIT 1;",
            nativeQuery = true)
    Quote getQuoteByActor(@Param("actor")String actor);

}
