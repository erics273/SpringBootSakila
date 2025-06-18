package com.pluralsight.controllers;

import com.pluralsight.dao.FilmDao;
import com.pluralsight.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {

    @Autowired
    @Qualifier("jdbcFilmDao")
    private FilmDao filmDao;

    @GetMapping("/api/films")
    public List<Film> getAllFilms(){

        return filmDao.getAll();

    }

    @PostMapping("/api/films")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Film addFilm(@RequestBody Film film){

        return filmDao.add(film);

    }

}
