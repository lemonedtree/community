package com.community.util;

/**
 * @author XD
 * @create 2022-07-10 16:20
 */
public class RedisKeyUtil {
    private static final String SPLIT = ":";
    private static final String PREFIX_ENTITY_LIKE = "like:entity";
    //like:entity:entityType:entityId -> set(userId)
    //某个实体的赞
    public static String getEntityLikeKey(int entityType, int entityId) {
        return PREFIX_ENTITY_LIKE + SPLIT + entityType + SPLIT +entityId;
    }
    //某个用户得到的赞
    //like:user:userId
    public static String getUserLikeKey(int userId) {
        return PREFIX_ENTITY_LIKE + SPLIT + userId;
    }

}



















































