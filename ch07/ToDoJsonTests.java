@RunWith(SpringRunner.class)
@JsonTest
public class ToDoJsonTests {
  @Autowired
  private JacksonTester<ToDo> json;

  @Test
  public void toDoSerializeTest() throws Exception {
    ToDo toDo = new ToDo("Read a Book");
    assertThat(this.json.write(toDo)).isEqualToJson("todo.json");
    assertThat(this.json.write(toDo)).hasJsonPathStringValue("@.description");
    assertThat(this.json.write(toDo)).extractingJsonPathStringValue("@.description")
        .isEqualTo("Read a Book");
  }

  @Test
  public void toDoDeserializeTest() throws Exception {
    String content = "{\"description\":\"Read a Book\",\"completed\":true}";
    assertThat(this.json.parse(content)).isEqualTo(new ToDo("Read a Book", true));
    assertThat(this.json.parseObject(content).getDescription()).isEqualTo("Read a Book");
  }
}