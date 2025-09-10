@RunWith(SpringRunner.class)
@WebFluxTest(ToDoFluxController.class)
public class ToDoWebFluxTest {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private ToDoRepository toDoRepository;

    @Test
    public void testExample() throws Exception {
        given(this.toDoRepository.findAll()).Return(Arrays.asList(new ToDo("Read a Book"), new ToDo("Buy Milk")));
        
        this.webClient.get().uri("/todos").accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class);
    }
}