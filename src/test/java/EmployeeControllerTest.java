import com.thoughtworks.school.Employee;
import com.thoughtworks.school.EmployeeController;
import com.thoughtworks.school.IEmployeeService;
import com.thoughtworks.school.application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(EmployeeController.class)
@ContextConfiguration(classes = application.class)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private IEmployeeService employeeService;

    @Test
    public void getEmployees() throws Exception {
        Employee employee = new Employee(0, "小明", 20, "男");
        given(employeeService.getEmployeeList()).willReturn(Arrays.asList(employee));
        mvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':0,'name':'小明','age':20, 'gender':'男'}]"));
    }
}
