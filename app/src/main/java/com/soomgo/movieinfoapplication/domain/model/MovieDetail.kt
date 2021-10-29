package com.soomgo.movieinfoapplication.domain.model

import com.soomgo.movieinfoapplication.data.dto.Genre
import com.soomgo.movieinfoapplication.data.dto.ProductionCompany
import com.soomgo.movieinfoapplication.data.dto.ProductionCountry
import com.soomgo.movieinfoapplication.data.dto.SpokenLanguage

data class MovieDetail(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: Any?,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompany> = emptyList(),
    val production_countries: List<ProductionCountry> = emptyList(),
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage> = emptyList(),
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)