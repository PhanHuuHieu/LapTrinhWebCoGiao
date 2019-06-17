package LTW.model;

public class GuessBookEntry {
	private int idSeek;
	private String name;
	private String massage;
	

	public GuessBookEntry() {}
	public GuessBookEntry(int idSeek,String name, String massage) {
		super();
		this.idSeek=idSeek;
		this.name = name;
		this.massage = massage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}

	public int getIdSeek() {
		return idSeek;
	}
	public void setIdSeek(int idSeek) {
		this.idSeek = idSeek;
	}
	
	
}
