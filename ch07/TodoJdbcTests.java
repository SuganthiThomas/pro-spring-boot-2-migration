@RunWith(SpringRunner.class)
@JdbcTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class TodoJdbcTests {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  private CommonRepository<ToDo> repository;

  @Test
  public void toDoJdbcTest() {
    ToDo toDo = new ToDo("Read a Book");

    this.repository = new ToDoRepository(jdbcTemplate);
    this.repository.save(toDo);

    ToDo result = this.repository.findById(toDo.getId());
    asserTThat(result.getId()).isEqualTo(toDo.getId());
  }

}
