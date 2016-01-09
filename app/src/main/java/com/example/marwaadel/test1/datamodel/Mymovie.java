package com.example.marwaadel.test1.datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marwa Adel on 12/25/2015.
 */
public class Mymovie
{



private String posterPath;



private String overview;

private String releaseDate;

private List<Integer> genreIds = new ArrayList<Integer>();

private Integer id;

private String originalTitle;

private String originalLanguage;

private String title;


private Double voteAverage;

private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The posterPath
     */

    public String getPosterPath() {
        return posterPath;
    }

    /**
     * @param posterPath The poster_path
     */

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }



    /**
     * @return The overview
     */

    public String getOverview() {
        return overview;
    }

    /**
     * @param overview The overview
     */

    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     * @return The releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate The release_date
     */

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return The genreIds
     */

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    /**
     * @param genreIds The genre_ids
     */

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    /**
     * @return The id
     */

    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The originalTitle
     */

    public String getOriginalTitle() {
        return originalTitle;
    }

    /**
     * @param originalTitle The original_title
     */

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    /**
     * @return The originalLanguage
     */

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    /**
     * @param originalLanguage The original_language
     */

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    /**
     * @return The title
     */

    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */

    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * @return The voteAverage
     */

    public Double getVoteAverage() {
        return voteAverage;
    }

    /**
     * @param voteAverage The vote_average
     */

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }


    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}



