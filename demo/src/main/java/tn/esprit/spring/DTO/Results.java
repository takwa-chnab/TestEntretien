package tn.esprit.spring.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
	
	private List<Word> results;

	public List<Word> getResults() {
		return results;
	}

	public void setResults(List<Word> results) {
		this.results = results;
	}	

}
