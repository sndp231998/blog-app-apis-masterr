package com.sandip.blog.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="posts")
@NoArgsConstructor
@Getter
@Setter
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer postId;
	
	@Column(name="post_title" ,length=100,nullable=false)
	private String title;
	@Column (length=1000)
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	//yo small letter category utta Category.java ma use garne/vako xa mappedBy ma
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="post",cascade= CascadeType.ALL)
	private Set<Comment> comments=new HashSet<>();
	
	
}
