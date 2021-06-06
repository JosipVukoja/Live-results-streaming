package com.example.demo;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/results")
public class ResultController {

	@Autowired
	private ResultRepository resultRepository;

	@Autowired
	private HashRepository hashRepository;


	@GetMapping
	public List<Result> getAllResults() {
		return this.resultRepository.findAll();
	}

	@PostMapping
	public Result createResult(@RequestBody Result user) {
		hashRepository.add(user);

		ExecutorService exec = Executors.newSingleThreadExecutor();
		exec.execute(
			()->{
				if(hashRepository.isEmptyResult()==true){
					
					exec.shutdown();
					
				}

				else{
				
					List<Result> list = hashRepository.findAll();
					for (Result resultElement : list) {
						String PrimaryKey = resultElement.getmatchID();
						resultRepository.save(resultElement);
						hashRepository.delete(PrimaryKey);

					}

				}


			});

		
		return null;
	}
	
}
