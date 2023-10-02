package ad.sogeti.filmlandservice.repository.categories;

import ad.sogeti.filmlandservice.model.categories.Available_Categories;
import ad.sogeti.filmlandservice.utils.FilmLandConstants;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AvailableCategoriesRepository extends CrudRepository<Available_Categories,String>{

    List<Available_Categories> findByEmail(String email);

    @Modifying
    @Transactional
    @Query(FilmLandConstants.DELETE_SUBSCRIBED_CATEGORY)
    void deleteSubscribedCategory(@Param(FilmLandConstants.EMAIL) String email, @Param(FilmLandConstants.NAME) String name);
}