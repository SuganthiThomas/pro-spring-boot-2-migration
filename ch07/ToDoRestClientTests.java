@RunWith(SpringRunner.class)
@RestClientTest(ToDoService.class)

public class ToDoRestClientTests {
  @Autowired
  private ToDoService service;

  @Autowired
  private MockRestServiceServer server;

  @RestClientTest
  public void toDoRestClientTest() throws Exception {
    String content = "{\"description\":\"Read a Book\",\"completed\":true}";

    this.server.expect(requestTo("/todos/my-id"))   
        .andRespond(withSuccess(content, MediaType.APPLICATION_JSON_UTF8));
        ToDo result = this.service.findById("my-id");
        assertThat(result).isNotNull();
        assertThat(result.getDescription()).contains("Read a Book");
  }
}