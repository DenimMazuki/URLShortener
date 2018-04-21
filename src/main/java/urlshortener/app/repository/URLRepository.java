package urlshortener.app.repository;

import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

@Repository
public class URLRepository {
    private final Jedis jedis;
    private final String idKey;
    private final String urlKey;

    public URLRepository() {
        this.jedis = new Jedis();
        this.idKey = "id";
        this.urlKey = "url:";
    }

    public URLRepository(Jedis jedis, String idKey, String urlKey) {
        this.jedis = jedis;
        this.idKey = idKey;
        this.urlKey = urlKey;
    }

    public Long incrementID() {
        Long id = jedis.incr(idKey);
        return id - 1;
    }

    public void saveUrl(String key, String longUrl) {
        System.out.println("SAVING AT: " + key);
        jedis.hset(urlKey, key, longUrl);
    }

    public String getUrl(Long id) {
        System.out.println("Retrieving AT: url:" + id);
        return jedis.hget(urlKey, "url:"+id);
    }
}
