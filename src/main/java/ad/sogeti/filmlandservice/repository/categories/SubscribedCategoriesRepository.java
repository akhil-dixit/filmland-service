package ad.sogeti.filmlandservice.repository.categories;

import ad.sogeti.filmlandservice.model.categories.Subscribed_Categories;
import ad.sogeti.filmlandservice.utils.FilmLandConstants;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SubscribedCategoriesRepository extends CrudRepository<Subscribed_Categories,String> {

    List<Subscribed_Categories> findByEmail(String email);

    @Query(FilmLandConstants.FIND_SUBSCRIBED_CATEGORY)
    Subscribed_Categories findSubscribedCategoryByEmailAndName(@Param(FilmLandConstants.EMAIL) String email, @Param(FilmLandConstants.NAME) String name);
}
