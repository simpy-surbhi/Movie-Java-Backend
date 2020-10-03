package com.ezshare.MovieAPI.DTO;

public class SeenMovieDTO {
	private long id;
	private long userid;
	private long movieid;
	private String createdon;
	private String updatedon;
	
	
	public SeenMovieDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public SeenMovieDTO(long id, long userid, long movieid, String createdon, String updatedon) {
		this.id = id;
		this.userid = userid;
		this.movieid = movieid;
		this.createdon = createdon;
		this.updatedon = updatedon;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getMovieid() {
		return movieid;
	}

	public void setMovieid(long movieid) {
		this.movieid = movieid;
	}

	public String getCreatedon() {
		return createdon;
	}

	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}
}
