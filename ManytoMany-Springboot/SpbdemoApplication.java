package com.spring.spboot;

import com.spring.spboot.Entity.*;
import com.spring.spboot.repository.*;
import com.spring.spboot.service.DepartmentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpbdemoApplication {


	public static void main(String[] args) {

		ConfigurableApplicationContext container = SpringApplication.run(SpbdemoApplication.class, args);

		StudentRepository studentRepository = container.getBean(StudentRepository.class);
		Optional<Student> student = studentRepository.findById(2);
		if(student.isPresent()){
			Student s = student.get();
			System.out.println(s.getStudId() + "  " + s.getName());
			for(Course c: s.getLikedCourses()){
				System.out.println(c.getCourseName());
			}
		}

		CourseRepository courseRepository = container.getBean(CourseRepository.class);
		Optional<Course> course = courseRepository.findById(7001);
		if(course.isPresent()){
			Course c = course.get();
			System.out.println(c.getCourseId() + "  " + c.getCourseName());
			for(Student student1: c.getLikes()){
				System.out.println(student1.getName());
			}
		}


//		Person p= container.getBean(Person.class);
//		System.out.println(p.getSsn() + " " + p.getName() + " " +  p.getAge());
//		System.out.println(p.getAddress().getHno() +  " " + p.getAddress().getStreet()+ " " + p.getAddress().getCity() +  " " + p.getAddress().getState());

		container.close();
	}

}
