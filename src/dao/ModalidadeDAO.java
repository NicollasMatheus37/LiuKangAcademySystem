package dao;

public class ModalidadeDAO extends BaseDAO {

	public void getAllModalidades() {
		this.select("*")
			.from("modalidades")
			.apply();
	}
	
	public void getOneModalidade(Integer id) {
		this.select("*")
			.from("modalidades")
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void createModalidade(String fields, String values) {
		this.insertInto("modalidades", fields)
			.values(values)
			.apply();
	}
	
	public void updateModalidade(String fields, String value, Integer id) {
		this.update("modalidades")
			.setValue(fields, value)
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void deleteModalidade(Integer id) {
		this.delete()
			.from("modalidades")
			.where("id", "=", id.toString());
	}
	
}
