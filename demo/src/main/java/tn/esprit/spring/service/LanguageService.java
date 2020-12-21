package tn.esprit.spring.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.spring.DTO.Results;
import tn.esprit.spring.DTO.Word;

@Service
public class LanguageService {
	
	private final ObjectMapper mapper;	
	
	public LanguageService(ObjectMapper mapper) {
		this.mapper = mapper;
	}


	public List<Word> findWords(String language) throws IOException {
		return extractWordsFromJSONFile(language);
	}


	private List<Word> extractWordsFromJSONFile(String language)
			throws IOException, JsonParseException, JsonMappingException {
		Results readValue = this.mapper.readValue(new ClassPathResource("./dataset_"+ language + ".json").getFile(), Results.class);
		//TODO: manage exception when language is not recognized !
		return readValue.getResults();
	}
	
	public List<Word> findFirstTenWords(String language) throws IOException {
		List<Word> words = extractWordsFromJSONFile(language);
		return words.stream().limit(10).collect(Collectors.toList());
	}
	

}
