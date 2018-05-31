package classes;

public class Score {
	private int position;
	private String uname;
	private int score;	
	
	public Score(int position, String uname, int score) {
		super();
		this.position = position;
		this.uname = uname;
		this.score = score;
	}
	
	public Score() {
		// TODO Auto-generated constructor stub
	}

	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Score [position=" + position + ", uname=" + uname + ", score=" + score + "]";
	}
	
	
	
}
