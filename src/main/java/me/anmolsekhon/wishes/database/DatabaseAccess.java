package me.anmolsekhon.wishes.database;

import me.anmolsekhon.wishes.beans.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DatabaseAccess {
    @Autowired
    protected NamedParameterJdbcTemplate jdbc;

    public List<Wish> getWishes() {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        String query = "SELECT * FROM WISHES";

        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Wish>(Wish.class));
    }

    public void insertWish(Wish wish) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        String query = "INSERT INTO WISHES VALUES(NULL, :wish)";
        namedParameters.addValue("wish", wish.getWish());
        jdbc.update(query, namedParameters);
    }

    public List<Wish> getWishById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        String query = "SELECT * FROM WISHES WHERE id=:id";
        namedParameters.addValue("id", id);

        return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Wish>(Wish.class));
    }


}
