package com.example.formdemo.repository;

import com.example.formdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcUserRepo implements UserRepo {
    private JdbcTemplate jdbc;

    //end::jdbcTemplate[]

    @Autowired
    public JdbcUserRepo(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public Iterable<User> findAll() {
        return jdbc.query("select id, username, password from User",
                this::mapRowToUser);
    }

    // tag::findOne[]
    @Override
    public User findByUsername(String username) {
        return jdbc.queryForObject(
                "select username, password from User where username=?",
                this::mapRowToUser, username);
    }

    @Override
    public User save(User user) {
        jdbc.update(
                "insert into USER ( username, password) values (?, ?)",
                user.getUsername(),
                user.getPassword());
        return user;
    }

    private User mapRowToUser(ResultSet rs, int rowNum)
            throws SQLException {
        return new User(rs.getLong("id"),
                 rs.getString("username"),
                rs.getString("password"));
    }

}
