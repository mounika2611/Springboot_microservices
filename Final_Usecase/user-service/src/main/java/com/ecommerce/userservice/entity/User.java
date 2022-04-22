package com.ecommerce.userservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "user")

public class User {
	
	
	    @Id
	    @GeneratedValue (strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column (name = "user_name")
	    private String userName;
	    @Column (name = "user_password") 
	    private String userPassword;
	   

	    @OneToOne (cascade = CascadeType.ALL)
	    @JoinColumn (name = "user_details_id")
	    private UserDetails userDetails;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserPassword() {
			return userPassword;
		}

		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}

		

		public UserDetails getUserDetails() {
			return userDetails;
		}

		public void setUserDetails(UserDetails userDetails) {
			this.userDetails = userDetails;
		}

}
