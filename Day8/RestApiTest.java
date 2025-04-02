package Day8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootApplication
public class RestApiTest {
    public static void main(String[] args) {
        SpringApplication.run(RestApiTest.class, args);
    }
}

// --- Model ---
class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}

// --- Service ---
@Service
class UserService {
    public List<User> getUsers() {
        return Arrays.asList(new User(1, "Alice"), new User(2, "Bob"));
    }
}

// --- Controller ---
@RestController
@RequestMapping("/users")
class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }
}

// --- Tests ---
@ExtendWith(MockitoExtension.class)
class RestApiTestCases {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testUserService() {
        UserService userService = new UserService();
        List<User> users = userService.getUsers();
        assertNotNull(users);
        assertEquals(2, users.size());
        assertEquals("Alice", users.get(0).getName());
    }

    @Test
    void testUserController() {
        when(userService.getUsers()).thenReturn(Arrays.asList(new User(1, "Alice"), new User(2, "Bob")));
        List<User> users = userController.getUsers();
        assertNotNull(users);
        assertEquals(2, users.size());
        assertEquals("Alice", users.get(0).getName());
        verify(userService, times(1)).getUsers();
    }
}
