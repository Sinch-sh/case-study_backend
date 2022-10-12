package com.code.userservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
}

//	@Autowired
//	private UserService service;
//
//	@MockBean
//	private UserRepository userRepository;
//
//	@Test
//	public void getUsersTest() {
//		when(userRepository.findAll()).thenReturn(Stream.of(new User("10","Will", "Will@test","will123", "987654342","12345")).collect(Collectors.toList()));
//		assertEquals(1, service.getAllUsers().size());
//	}
//
//	@Test
//	public void saveUserTest() {
//		User user = new User("12","Max", "max@test", "max123", "87654556","123456");
//		when(userRepository.insert(user)).thenReturn(user);
//		assertEquals(user, service.addUser(user));
//	}
//
//
//
//
////	@Test
////	public void deleteUserTest() {
////		User user = new User("1","pooh", "pooh@test", "pooh123","98753633","22344");
////		service.deleteUser("1");
////		verify(userRepository).deleteById();
////	}
//
//	@Test
//	public void getUserByIdTest()
//	{
//		String id="2";
//		User user=new User("1","pooh", "pooh@test", "pooh123","98753633","22344");
//
//		when(userRepository.findById(id)).thenReturn(java.util.Optional.of(user));
//		System.out.println(service.getUserById(id)+"and"+user);
//
//		assertEquals(user,service.getUserById(id));
//
//	}
//}
