@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToDoSimpleRestTemplateTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void toDoTest() {
        String body = this.restTemplate.getForObject("/todo", String.class);
        assertThat(body).contains("Read a Book");
    }

}