package dao;

public class AssiduidadeDAO extends BaseDAO {
	
	public void getAllAssiduidades() {
		this.select("*")
			.from("assiduidade")
			.apply();
	}
	
	public void getOneAssiduidade(Integer id) {
		this.select("*")
			.from("assiduidade")
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void createAssiduidade(String fields, String values) {
		this.insertInto("assiduidade", fields)
			.values(values)
			.apply();
	}
	
	public void updateAssiduidade(String fields, String value, Integer id) {
		this.update("assiduidade")
			.setValue(fields, value)
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void deleteAssiduidade(Integer id) {
		this.delete()
			.from("assiduidade")
			.where("id", "=", id.toString());
	}

	
}
