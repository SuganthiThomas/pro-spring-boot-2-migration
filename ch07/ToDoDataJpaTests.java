@RunWith(SpringRunner.class)
@DataJpATest
// If you wish to test with a real database, you can add the following annotation
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ToDoDataJpaTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ToDoRepository repository;

    @Test
    public void toDoDataTest() throws Exception {
      this.entityManager.persist(new ToDo("Read a Book"));
        Iterable<ToDo> toDos = this.repository.findByDescriptionContains("Read a Book");
       
        assertEquals(toDos.iterator().next()).toString().contains("Read a Book");
    }
}