/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package storehausimport;

import entity.Gramata;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Kaspars
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("storeHausImportPU");
        EntityManager em = emf.createEntityManager();
        
           List listResult = em.createQuery("select g from Gramata g where g.num= :num_")
                    .setParameter("num_","2014-06/DU")
                    .getResultList();
          if(listResult.size()!=0){
              Iterator itr = listResult.iterator();
              while(itr.hasNext()){
                Gramata users = (Gramata)itr.next();
                System.out.print("Vards:"+users.getNum());
                System.out.println();
              }
            }
    }
    
}
