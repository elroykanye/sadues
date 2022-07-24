package com.elroykanye.sadues.config.constants;

public class ResponseMessage {
    public static class SUCCESS {
        public static String created(String entityName) {
            return String.format("%s successfully created", entityName);
        }

        public static String updated(String entityName) {
            return String.format("%s successfully updated", entityName);
        }
    }
}
