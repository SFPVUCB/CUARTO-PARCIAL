package bo.edu.ucb.ingsoft.hhrr.dao;

import bo.edu.ucb.ingsoft.hhrr.dto.db.FilmDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FilmDao
{
    @Select("SELECT title,description,releaseyear,rentalduration,rentalamount,duration,rating,image FROM film")
    List<FilmDto> findfilm();

    @Select("SELECT title,description,releaseyear,rentalduration,rentalamount,duration,rating,image FROM film WHERE title = #{title}") //FIXME: NO PUDE USAR LIKE
    List<FilmDto> findfilmtitle(@Param("title") String title);

    @Select("SELECT title,description,releaseyear,rentalduration,rentalamount,duration,rating,image FROM film WHERE rating = #{rating}") //FIXME: NO PUDE USAR LIKE
    List<FilmDto> findfilmrating(@Param("rating") Integer rating);


}
