package niky.postgresapi.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import niky.postgresapi.dao.BookDao;

public class BookDaoImpl implements BookDao {
  
  private final JdbcTemplate jdbcTemplate;

  public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
  
}
