package bo.edu.ucb.ingsoft.hhrr.dto.db;

public class FilmCategoryDto
{
    private Integer filmcategory_id;
    private Integer film_film_id;
    private Integer category_id;

    public FilmCategoryDto(Integer filmcategory_id, Integer film_film_id, Integer category_id)
    {
        this.filmcategory_id = filmcategory_id;
        this.film_film_id = film_film_id;
        this.category_id = category_id;
    }
    public FilmCategoryDto() {}

    public Integer getFilmcategory_id() {
        return filmcategory_id;
    }

    public void setFilmcategory_id(Integer filmcategory_id) {
        this.filmcategory_id = filmcategory_id;
    }

    public Integer getFilm_film_id() {
        return film_film_id;
    }

    public void setFilm_film_id(Integer film_film_id) {
        this.film_film_id = film_film_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
    @Override
    public String toString() {
        return "FilmCategoryDto{" +
                "filmcategory_id=" + filmcategory_id +
                ", film_film_id=" + film_film_id +
                ", category_id=" + category_id +
                '}';
    }
}
