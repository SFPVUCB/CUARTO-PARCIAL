package bo.edu.ucb.ingsoft.hhrr.dao;

import bo.edu.ucb.ingsoft.hhrr.dto.db.FilmDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FilmTitleDao
{
    @Select("SELECT title,description,releaseyear,rentalduration,rentalamount,duration,rating,image FROM film WHERE title LIKE '%{title}%'")
    List<FilmDto> findfilmtitle(@Param("id") String botChatId,@Param("title") String title);


}
