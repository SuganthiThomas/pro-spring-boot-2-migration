@RunWith(SpringRunner.class)
@DataMongoTest
// Use the following annotation if you require an external MongoDB server
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class TodoMongoTests {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void toDoMongoTest() {
        Todo toDo = new ToDo("Read a Book");
        this.mongoTemplate.save(toDo);

        ToDo result = this.mongoTemplate.findById(toDo.getId(), ToDo.class);

        assertThat(result.getId()).isEqualTo(toDo.getId());
    }


}