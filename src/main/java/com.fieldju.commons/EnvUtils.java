package com.fieldju.commons;

/**
 * Environment Utilities
 */
public class EnvUtils {

    private EnvUtils() {}

    /**
     * <p>Fetches a required environment variable</p>
     *
     * @throws IllegalStateException if the required environment variable is unset or blank
     * @param key  the name of the required environment variable
     * @return  {@code String} the value of the environment variable
     */
    public static String getRequiredEnv(String key) {
        return getRequiredEnv(key, null);
    }

    /**
     * <p>Fetches a required environment variable</p>
     *
     * @throws IllegalStateException if the required environment variable is unset or blank
     * @param key  the name of the required environment variable
     * @param msg  the message to include of the environment variable is unset or blank
     * @return  {@code String} the value of the environment variable
     */
    public static String getRequiredEnv(String key, String msg) {
        String value = System.getenv(key);
        if (StringUtils.isBlank(value)) {
            StringBuilder sb = new StringBuilder("The required environment variable ")
                    .append(key)
                    .append(" was not set or is blank.");

            if (StringUtils.isNotBlank(msg)) {
                sb.append(" Msg: ").append(msg);
            }

            throw new IllegalStateException(sb.toString());
        }
        return value;
    }

}
