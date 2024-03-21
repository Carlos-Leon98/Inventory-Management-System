package persistence;

import entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for EntitiesDAO class
 * @author cleonrivas
 */
class EntitiesDAOTest {

    EntitiesDAO<Category> dao;

    /**
     * Run set up tasks before each test:
     * 1. execute SQL which deletes everything from the table and inserts records
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("dump.sql");

        dao = new EntitiesDAO<>(Category.class);
    }

    /**
     * Verify successful retrieval of the Entity
     */
    @Test
    void getByIdSuccess() {
        Category category = dao.getById(1);
        assertNotNull(category);
        assertEquals("Electronics", category.getName());
    }

    /**
     * Verify successful update of an Entity
     */
    @Test
    void updateSuccess() {
        Category categoryToUpdate = dao.getById(2);
        categoryToUpdate.setName("Updated Category");
        dao.update(categoryToUpdate);

        Category updatedCategory = dao.getById(2);
        assertEquals("Updated Category", updatedCategory.getName());
    }

//    /**
//     * Verify successful insert of an Entity
//     */
//    @Test
//    void insertSuccess() {
//        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
//        currentDate.setNanos(0);
//
//        Category newCategory = new Category();
//        newCategory.setName("Games");
//        newCategory.setCreatedAt(currentDate);
//        int id = dao.insert(newCategory);
//        assertNotEquals(0, id);
//        Category insertedCategory = dao.getById(id);
//        assertEquals(newCategory, insertedCategory);
//    }

    /**
     * Verify successful delete of Entity
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Verify successful retrieval of all same Entity
     */
    @Test
    void getAllSuccess() {
        List<Category> categories = dao.getAll();
        assertEquals(3, categories.size());
    }
}