package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Course;
import com.stg.services.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	// get all courses
	@GetMapping("/courses")
	public List<Course> getCourse() {

		return this.courseService.getCourse();
	}

	// get course based on id
	@GetMapping("/courses/{courseId}")
	public Course getCourseById(@PathVariable String courseId) {

		return this.courseService.getCourseById(Long.parseLong(courseId));
	}
	
	// create new course 
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.courseService.saveCourse(course);// saveCourse ===> this method present in service interface
	}
	
	
	// update course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		
		return this.courseService.updatedCourse(course);
	}
	
	// Delete course 
	@DeleteMapping("/courses")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourseById(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
