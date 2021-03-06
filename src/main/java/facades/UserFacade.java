package facades;

import dtos.UsersDTO;
//import entities.Joke;
import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import securityerrorhandling.AuthenticationException;

public class UserFacade {
   
    private static EntityManagerFactory emf;
    private static UserFacade instance; 
    
    private UserFacade() {
        
    }
    
        public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }
        
        
    public long getUserCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long userCount = (long)em.createQuery("SELECT COUNT(u) FROM User u").getSingleResult();
            return userCount;
        }finally{  
            em.close();
        }
        
    }
     public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }
     
     
        public UsersDTO getAllUsers() {
        EntityManager em = emf.createEntityManager();
        try {
            return new UsersDTO(em.createNamedQuery("Users.getAll").getResultList());
        } finally {
            em.close();
        }
    }
         
//         
//    public String addJoke(Joke joke, String username) throws MissingInputException{
//       
//         EntityManager em = emf.createEntityManager();
//            User user = em.find(User.class, username);
//            
//            if (joke != null) {
//                em.getTransaction().begin();
//                user.addJoke(joke);
//                em.getTransaction().commit();
//            }
//        return joke.getJoke();
//    }
    
}
