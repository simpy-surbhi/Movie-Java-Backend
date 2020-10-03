package com.ezshare.MovieAPI.DTO;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ezshare.datamodel.MovieModel;
import com.ezshare.datamodel.UserModel;

public class CommentsDTO {

	private Long id;
	private BigInteger ratings;
	private String title;
	private String  comments;
	private Long userId;
	private Long movieId;
	private String  createdon;
	private String  updatedon;
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigInteger getRatings() {
		return ratings;
	}

	public void setRatings(BigInteger ratings) {
		this.ratings = ratings;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public CommentsDTO() {
		
	}

	public CommentsDTO(Long id, BigInteger ratings, String title, String comments, Long userId, Long movieId,
			String createdon, String updatedon) {
		this.id = id;
		this.ratings = ratings;
		this.title = title;
		this.comments = comments;
		this.userId = userId;
		this.movieId = movieId;
		this.createdon = createdon;
		this.updatedon = updatedon;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
}
