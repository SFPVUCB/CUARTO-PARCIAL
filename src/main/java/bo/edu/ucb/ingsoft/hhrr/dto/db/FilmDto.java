package bo.edu.ucb.ingsoft.hhrr.dto.db;

public class FilmDto
{
  private Integer fil_id;
  private Integer language_id;
  private String title;
  private String description;
  private Integer realeseYear;
  private Integer realeseDuration;
  private Double rentalAmount;
  private Integer duration;
  private Integer rating;
  private String image;

    public FilmDto(Integer fil_id, Integer language_id, String title, String description, Integer realeseYear, Integer realeseDuration, Double rentalAmount, Integer duration, Integer rating, String image) {
        this.fil_id = fil_id;
        this.language_id = language_id;
        this.title = title;
        this.description = description;
        this.realeseYear = realeseYear;
        this.realeseDuration = realeseDuration;
        this.rentalAmount = rentalAmount;
        this.duration = duration;
        this.rating = rating;
        this.image = image;
    }

    public FilmDto()
    {
    }

    public Integer getFil_id() {
        return fil_id;
    }

    public void setFil_id(Integer fil_id) {
        this.fil_id = fil_id;
    }

    public Integer getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(Integer language_id) {
        this.language_id = language_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRealeseYear() {
        return realeseYear;
    }

    public void setRealeseYear(Integer realeseYear) {
        this.realeseYear = realeseYear;
    }

    public Integer getRealeseDuration() {
        return realeseDuration;
    }

    public void setRealeseDuration(Integer realeseDuration) {
        this.realeseDuration = realeseDuration;
    }

    public Double getRentalAmount() {
        return rentalAmount;
    }

    public void setRentalAmount(Double rentalAmount) {
        this.rentalAmount = rentalAmount;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "fil_id=" + fil_id +
                ", language_id=" + language_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", realeseYear=" + realeseYear +
                ", realeseDuration=" + realeseDuration +
                ", rentalAmount=" + rentalAmount +
                ", duration=" + duration +
                ", rating=" + rating +
                ", image=" + image +
                '}';
    }
}
