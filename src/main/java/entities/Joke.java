/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Gustav
 */
//@Entity
//public class Joke implements Serializable {
////
////    private static final long serialVersionUID = 1L;
////    @Id
////    @GeneratedValue(strategy = GenerationType.AUTO)
////    private Long id;
////    private String joke;
////    
////     @ManyToOne(cascade = { CascadeType.PERSIST })
////    private User user;
////
////    public Joke(String joke) {
////        this.joke = joke;
////    }
////    
////    public void setUser(User user) {
////        if (user != null){
////            this.user = user;
////            user.addJoke(this);
////        }
////    }
////
////    public Long getId() {
////        return id;
////    }
////
////    public void setId(Long id) {
////        this.id = id;
////    }
////
////    public String getJoke() {
////        return joke;
////    }
////
////    public User getUser() {
////        return user;
////    }
//
//}
