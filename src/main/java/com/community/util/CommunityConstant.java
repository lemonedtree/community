package com.community.util;

/**
 * @author XD
 * @create 2022-05-27 12:56
 */
public interface CommunityConstant {
    int ACTIVATION_SUCCESS = 0;
    int ACTIVATION_REPEAT = 1;
    int ACTICATION_FAILURE = 2;

    long DEFAULT_EXPIRED_SECOND = 3600 * 12;
    long REMEMBER_EXPIRED_SECONDS = 3600 * 12 * 100;
}
