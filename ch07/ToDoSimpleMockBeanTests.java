@RunWith(SpringRunner.class)
@SpringBootTest
public class ToDoSimpleMockBeanTests {


    @MockBean
    private ToDoRepository repository;

    @Test
    public void toDoTest() {
        given(this.repository.findById("my-id")).Return(new ToDo("Read a Book"));
        assertThat(this.repository.findById("my-id").getDescription()).isEqualTo("Read a Book");
    }

}
