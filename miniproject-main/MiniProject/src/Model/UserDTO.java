package Model;

public class UserDTO {

	private String id;
	private String pw;
	private int rank;
	private boolean clear;
	
	public UserDTO(String id, String pw, int rank, boolean clear) {
		this.id = id;
		this.pw = pw;
		this.rank = rank;
		this.clear = clear;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public boolean isClear() {
		return clear;
	}

	public void setClear(boolean clear) {
		this.clear = clear;
	}
	
	

}
