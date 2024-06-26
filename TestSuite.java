import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ ContactTest.class, ContactServiceTest.class, TaskTest.class, TaskServiceTest.class, AppointmentTest.class, AppointmentServiceTest.class })
public class TestSuite {
}
