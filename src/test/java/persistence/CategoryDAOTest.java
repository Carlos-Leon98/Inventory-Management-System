package persistence;

import entity.Category;
import testUtils.Database;
import java.sql.Timestamp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for CategoryDAO
 */
class CategoryDAOTest {

    CategoryDAO dao;

    /**
     * Run set up tasks before each test:
     * 1. execute SQL which deletes everything from the table and inserts records
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("dump.sql");

        dao = new CategoryDAO();
    }

    /**
     * Verify successful retrieval of a Category
     */
    @Test
    void getByIdSuccess() {
        Category retrievedCategory = dao.getById(1);
        assertEquals("Electronics", retrievedCategory.getName());
        // Add more assertions as needed
    }

    /**
     * Verify successful insert of a Category
     */
    @Test
    void insertSuccess() {
        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        currentDate.setNanos(0);

        Category newCategory = new Category();
        newCategory.setName("Games");
        newCategory.setCreatedAt(currentDate);
        int id = dao.insert(newCategory);
        assertNotEquals(0, id);
        Category insertedCategory = dao.getById(id);
        assertEquals(newCategory, insertedCategory);
    }

    /**
     * Verify successful update of a Category
     */
    @Test
    void updateSuccess() {
        Category categoryToUpdate = dao.getById(2);
        categoryToUpdate.setName("Updated Category");
        dao.update(categoryToUpdate);

        Category updatedCategory = dao.getById(2);
        assertEquals("Updated Category", updatedCategory.getName());
    }

    /**
     * Verify successful delete of Category
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Verify successful retrieval of all Categories
     */
    @Test
    void getAllSuccess() {
        List<Category> categories = dao.getAll();
        assertEquals(3, categories.size());
    }
}