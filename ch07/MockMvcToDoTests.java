@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcToDoTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testHomePage() throws Exception {
        MockMvc mvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void testAboutPage() throws Exception {
        MockMvc mvc.perform(get("/about"))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("About Us")));
    }
}