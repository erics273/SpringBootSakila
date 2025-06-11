package com.pluralsight.dao;

import com.pluralsight.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFilmDao implements FilmDao {

    private DataSource dataSource;

    @Autowired
    public JdbcFilmDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Film film) {
        String sql = "INSERT INTO film (title, rental_rate, language_id) VALUES (?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, film.getTitle());
            stmt.setDouble(2, film.getRentalRate());

            //hard coding the language id to 1 since its not allowed to be null
            //I was too lazy to update the UI
            stmt.setInt(3, 1);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Film> getAll() {
        List<Film> films = new ArrayList<>();
        String sql = "SELECT film_id, title, rental_rate FROM film";

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Film film = new Film();
                film.setFilmId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setRentalRate(rs.getDouble("rental_rate"));

                films.add(film);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }
}
