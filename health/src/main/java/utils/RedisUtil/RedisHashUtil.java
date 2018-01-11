package utils.RedisUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import utils.JsonUtils;

@Service
public class RedisHashUtil {

    private static Log log = LogFactory.getLog(RedisHashUtil.class);

    private static StringRedisTemplate redisTemplate;

    @Autowired
    public  void setRedisTemplate(StringRedisTemplate redisTemplate) {
        RedisHashUtil.redisTemplate = redisTemplate;
    }




    public static void put(String key, String id, Object value) {
        try {
            redisTemplate.opsForHash().put(key,id, JsonUtils.toJson(value));
        }catch (Exception e){
            log.debug("操作缓存出错",e);
        }
    }

    public static String get(String key, String id) {
        Object ob = null;
        String result = null;
        try{
            ob = redisTemplate.opsForHash().get(key,id);
        }catch (Exception e){
            log.debug("操作缓存出错",e);
        }
        if(ob != null){
            result = ob.toString();
        }
        return result;
    }

    public static Boolean exit(String key, String id) {
        if (id == null) {
            return false;
        }
        Boolean flag = redisTemplate.opsForHash().hasKey(key,id);
        return flag;
    }

   
}
