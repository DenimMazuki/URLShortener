package urlshortener.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urlshortener.app.helper.IDConverter;
import urlshortener.app.repository.URLRepository;


@Service
public class URLConverterServiceImplementation implements URLConverterService {
    private static final Logger LOGGER = LoggerFactory.getLogger(URLConverterServiceImplementation.class);
    private final URLRepository urlRepository;
    private final IDConverter idConverter = new IDConverter();

    @Autowired
    public URLConverterServiceImplementation(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String shortenURL(String longUrl) {
        LOGGER.debug("Shortening {}", longUrl);
        Long id = urlRepository.incrementID();
        String uniqueID = idConverter.createUniqueID(id);
        urlRepository.saveUrl("url:"+id, uniqueID);
        return uniqueID;
    }

    public String getLongURLFromID(String uniqueID) {
        Long dictionaryKey = idConverter.getDictionaryKeyFromUniqueID(uniqueID);
        String longUrl = urlRepository.getUrl(dictionaryKey);
        LOGGER.debug("Converting shortened URL back to {}", longUrl);
        return longUrl;
    }
}
