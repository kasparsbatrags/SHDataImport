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
import static jdk.nashorn.internal.objects.NativeString.substring;

/**
 *
 * @author Kaspars
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String firma="Lursolkjljljljkljft ,SIA";
        
        System.out.println(substring(firma,0,firma.indexOf(",")));
       
        
    }
    
}
