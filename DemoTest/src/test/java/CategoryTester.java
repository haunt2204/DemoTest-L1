
import com.nth.pojo.Category;
import com.nth.services.CategoryService;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author admin
 */
public class CategoryTester {

    @BeforeAll
    public static void BeforeAll() {
        //Mo ket noi
    }

    @AfterAll
    public static void AfterAll() {
        //Dong ket noi
    }

    @Test
    public void testNotNull() {
        try {
            CategoryService cate = new CategoryService();
            List<Category> result = cate.getCategories();
            long actual = result.stream().filter(c->c.getName()==null).count();
            long expected = 0;
            Assertions.assertEquals(expected, actual);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testUniqueName(){
        CategoryService s = new CategoryService();
        try {
            List<Category> cats = s.getCategories();
            List<String> listName = cats.stream().flatMap(c->Stream.of(c.getName())).collect(Collectors.toList());
            Set<String> setName = new HashSet<>(listName);
            Assertions.assertEquals(listName.size(), setName.size());
        } catch (SQLException ex) {
            Logger.getLogger(CategoryTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
