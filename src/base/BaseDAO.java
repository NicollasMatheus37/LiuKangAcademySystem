package base;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public abstract class BaseDAO {
	
	public BaseDAO() {}
	
	private String sql = "";
	
//	protected abstract List<Object> index() throws SQLException;
//	
//	protected abstract Object view(int id) throws SQLException;
//	
//	protected abstract void store() throws SQLException;
//	
//	protected abstract void update() throws SQLException;
//	
//	protected abstract void destroy() throws SQLException;
	
	protected void _set(PreparedStatement preparedStatement, int position, Object params) throws SQLException {
		if(params == null) {
			preparedStatement.setNull(position, Types.NULL);
		} else if(params instanceof String) {
			preparedStatement.setString(position, (String)params);
		}
	}
	
	protected BaseDAO select(String statement) {
		this.setSql(this.getSql() + "SELECT " + statement); 
		return this;
	}
	
	protected BaseDAO from(String statement) {
		this.setSql(this.getSql() + "FROM " + statement);
		return this;
	}
	
	protected BaseDAO where(String statement, String value) {
		this.setSql(this.getSql() + "WHERE " + statement);
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
