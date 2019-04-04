package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public abstract class BaseDAO {
	
	public BaseDAO() {}
	
	private String sql = "";
	
	protected void _set(PreparedStatement preparedStatement, int position, Object params) throws SQLException {
		if(params == null) {
			preparedStatement.setNull(position, Types.NULL);
		} else if(params instanceof String) {
			preparedStatement.setString(position, (String)params);
		}
	}
	
	protected BaseDAO delete() {
		this.setSql(getSql() + "Delete ");
		return this;
	}
	
	protected BaseDAO setValue(String field, String value) {
		this.setSql(this.getSql() + "SET " + field + "=" + value);
		return this;
	}
	
	protected BaseDAO update(String table) {
		this.setSql(this.getSql() + "UPDATE " + table);
		return this;
	}
	
	protected BaseDAO insertInto(String table, String statement) {
		this.setSql(this.getSql() + "INSERT INTO " + table + " (" + statement + ") ");
		return this;
	}
	
	protected BaseDAO values(String statement) {
		this.setSql(getSql() + "VALUES " + statement);
		return this;
	}
	
	protected BaseDAO select(String statement) {
		this.setSql(this.getSql() + "SELECT " + statement); 
		return this;
	}
	
	protected BaseDAO from(String statement) {
		this.setSql(this.getSql() + "FROM " + statement);
		return this;
	}
	
	protected BaseDAO where(String statement, String operator, String value) {
		this.setSql(this.getSql() + "WHERE " + statement + operator + value);
		return this;
	}
	
	protected BaseDAO orderBy(String statement) {
		this.setSql(this.getSql() + "ORDER BY " + statement);
		return this;
	}
	
	protected BaseDAO join(String statement) {
		this.setSql(this.getSql() + "JOIN " + statement);
		return this;
	}
	
	protected BaseDAO innerJoin(String statement) {
		this.setSql(this.getSql() + "INNER JOIN " + statement);
		return this;
	}
	
	protected BaseDAO leftJoin(String statement) {
		this.setSql(this.getSql() + "LEFT JOIN " + statement);
		return this;
	}
	
	protected BaseDAO rightJoin(String statement) {
		this.setSql(this.getSql() + "RIGHT JOIN " + statement);
		return this;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
	
	protected void apply() {
		this.getSql();
	}
	// select("name").from("alunos").where("id", "1").orderBy("id").apply();
}
