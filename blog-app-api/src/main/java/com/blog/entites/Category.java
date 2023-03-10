package com.blog.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity

public class Category {

	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private int id;
	    
	    @Column(name="title",length=100,nullable=false)
	   private String categoryTitle;
	    
	    @Column(name="description")
	   private String categoryDescription;

	      @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	      private List<Post> post=new ArrayList<>();
	    
//	    public Category(int id, String categoryTitle, String categoryDescription) {
//			super();
//			this.id = id;
//			this.categoryTitle = categoryTitle;
//			this.categoryDescription = categoryDescription;
//		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCategoryTitle() {
			return categoryTitle;
		}

		public void setCategoryTitle(String categoryTitle) {
			this.categoryTitle = categoryTitle;
		}

		public String getCategoryDescription() {
			return categoryDescription;
		}

		public void setCategoryDescription(String categoryDescription) {
			this.categoryDescription = categoryDescription;
		}

		public List<Post> getPost() {
			return post;
		}

		public void setPost(List<Post> post) {
			this.post = post;
		}
	    
		
	    
}
