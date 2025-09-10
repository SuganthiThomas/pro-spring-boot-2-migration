@RunWith(SpringRunner.class)
@WebMvcTest(ToDoController.class)
public class ToDoWebMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ToDoRepository toDoRepository;

    @Test
    public void toDoControllerTest() throws Exception {
        given(this.toDoRepository.findById("my-id")).Return(new ToDo("Do Homework", true));


        this.mvc.perform(get("/todo/my-id").accept(MediaType.APPLICATION_JSON_UTF8))
               .andExpect(status().isOk())
               .andExpect(content().string("{\"id":\"my-id\",\"description\":\"Do Homework\",\"completed\":true}"));
    }
}