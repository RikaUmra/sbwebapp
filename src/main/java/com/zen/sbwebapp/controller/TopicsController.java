package com.zen.sbwebapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zen.sbwebapp.domain.Topic;

@RestController
public class TopicsController {

	@Value("${customer.name}")
	private String cname;
	
	private List<Topic> topics = new ArrayList<Topic>();

	public TopicsController() {
		topics.add(new Topic(1, "Java"));
		topics.add(new Topic(2, "Spring"));
		topics.add(new Topic(3, "Tomcat"));
		topics.add(new Topic(4, "Angular"));
		topics.add(new Topic(5, "React")); 
	}

	@RequestMapping(value = "/topics")
	public List<Topic> show() {
		System.out.println(cname);
		return topics;

	}

	@RequestMapping(value = "/topics/{id}", method = RequestMethod.GET)
	public Topic showById(@PathVariable(name = "id", required = true) int id) {

		for (Topic t : topics) {

			if (t.getId() == id) {
				return t;
			}
		}
		return null;

	}

	@RequestMapping(value = "/topics", method = RequestMethod.POST)
	public ResponseEntity<String> addTopic(@RequestBody Topic t) {
		topics.add(t);
		return new ResponseEntity<String>(HttpStatus.OK);

	}

	@RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delTopic(@PathVariable(name = "id", required = true) int id) {
		for (Topic t : topics) {
			if (t.getId() == id) {
				topics.remove(t);
				return new ResponseEntity<String>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

	}
}