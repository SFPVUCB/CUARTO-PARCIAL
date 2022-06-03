package bo.edu.ucb.ingsoft.hhrr.api;

import bo.edu.ucb.ingsoft.hhrr.bl.CityBl2;
import bo.edu.ucb.ingsoft.hhrr.bl.FilmCategoryBl;
import bo.edu.ucb.ingsoft.hhrr.dto.db.CityDto;
import bo.edu.ucb.ingsoft.hhrr.dto.db.FilmCategoryDto;
import bo.edu.ucb.ingsoft.hhrr.dto.db.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class FilmCategoryController
{
    @Autowired
    public DataSource dataSource;

    @Autowired
    private FilmCategoryBl filmcategoryBl;

    @GetMapping(path = "/filmcategory1/{filmcategory_id}")
    public ResponseDto findfilmcateogryById(@PathVariable Integer filmcategory_id) {
        FilmCategoryDto filmcategoryDto = filmcategoryBl.findFilmCategoryById(filmcategory_id);
        if (filmcategoryDto != null) {
            return new ResponseDto( true, filmcategoryDto, null);
        } else {
            return new ResponseDto( false, null, "No existe ");
        }
    }

    @GetMapping(path = "/filmcategory2")
    public List<FilmCategoryDto> findAllFilmCategory() {
        return filmcategoryBl.findAllFilmsCategory();
    }
}
