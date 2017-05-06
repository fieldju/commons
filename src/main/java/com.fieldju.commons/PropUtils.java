package com.fieldju.commons;

public class PropUtils {

    private PropUtils() {}

    /**
     * Attempts to first get the key from the environment, then searches system props, falling back to the default value
     *
     * @param key - The key to search the Env and System Props
     * @return - The value of the key in the environment variables or system properties falling back to the default value.
     */
    public static String getPropWithDefaultValue(String key, String defaultValue) {
        return EnvUtils.getEnvWithDefault(key, System.getProperty(key, defaultValue));
    }

    /**
     * Attempts to first get the key from the environment, then searches system props
     *
     * @throws IllegalStateException if the required property is unset or blank
     * @param key - The key to search the Env and System Props
     * @return - The value of the key in the environment variables or system properties falling back to the default value.
     */
    public static String  getRequiredProperty(String key) {
        return getRequiredProperty(key, null);
    }

    /**
     * Attempts to first get the key from the environment, then searches system props, falling back to the default value
     *
     * @throws IllegalStateException if the required property is unset or blank
     * @param msg  the message to include of the property is unset or blank
     * @param key - The key to search the Env and System Props
     * @return - The value of the key in the environment variables or system properties falling back to the default value.
     */
    public static String getRequiredProperty(String key, String msg) {
        String value = getPropWithDefaultValue(key, null);

        if (StringUtils.isBlank(value)) {
            StringBuilder sb = new StringBuilder("The key: ")
                    .append(key)
                    .append(" was not set or is blank. Check the environment variables and system properties");

            if (StringUtils.isNotBlank(msg)) {
                sb.append(" Msg: ").append(msg);
            }

            throw new IllegalStateException(sb.toString());
        }

        return value;
    }

}
