package urlshortener.app.service;

public interface URLConverterService {
    String shortenURL(String longUrl);
    String getLongURLFromID(String id);
}
