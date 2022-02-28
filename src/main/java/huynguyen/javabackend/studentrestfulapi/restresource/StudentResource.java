package huynguyen.javabackend.studentrestfulapi.restresource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import huynguyen.javabackend.studentrestfulapi.model.Student;

@RestController
public class StudentResource {
	List<Student> students=new ArrayList<Student>();
	
	@GetMapping
	public Object getAllStudent() {
		return students;
	}
	
	@GetMapping("/add")
	public Object InsertUsingRequestParam (@RequestParam(name = "name",required = false) String name,
			@RequestParam(name ="age",required = false) int age) {
		students.add(new Student(name,age));
		return students;
	}
	
	@GetMapping("/{name}/{age}")
	public Object InsertUsingPathVariable(@PathVariable("name") String name,@PathVariable("age") int age ) {
		students.add(new Student(name,age));
		return students;
	}
	
	@PostMapping
	public Object InserUsingRequestBody(@RequestBody Student student) {
		Student data = new Student();
		data.setName(student.getName());
		data.setAge(student.getAge());
		students.add(data); 
		
		return student;
	}
	
}
