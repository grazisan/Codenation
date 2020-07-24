package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {

		return repository.getQuote();
	}

	@Override
	public Quote getQuoteByActor(String actor) {

		return repository.getQuoteByActor(actor);
	}



}
