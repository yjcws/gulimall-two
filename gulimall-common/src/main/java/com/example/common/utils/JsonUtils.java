package com.example.common.utils;

/**
 * @ClassName: JsonUtils
 * @Description:
 * @Author: yjc
 * @Date: 2023/5/26 10:18
 */
/*
解释说明：工具类包含了以下几个方法：

 toJsonString: 将对象转换为JSON字符串。
 fromJsonString: 将JSON字符串转换为指定类型的对象。
 parseJson: 解析JSON字符串为JsonNode对象。
 getStringValue: 获取指定键路径下的字符串值。
 getIntValue: 获取指定键路径下的整数值。
 getBooleanValue: 获取指定键路径下的布尔值。
 getNode: 获取指定键路径下的JsonNode对象。
 您可以根据实际需要使用这些方法来获取和处理JSON数据。通过封装这些操作，您可以更方便地在代码中使用这些工具方法，提高代码的可读性和复用性。

 请注意，上述示例中使用了单例模式创建了一个ObjectMapper实例，以提高性能和效率。确保在多线程环境下使用时进行适当的同步处理。
*/

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Optional;

public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toJsonString(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert object to JSON string", e);
        }
    }

    public static <T> T fromJsonString(String jsonString, Class<T> valueType) {
        try {
            return mapper.readValue(jsonString, valueType);
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert JSON string to object", e);
        }
    }

    public static Optional<JsonNode> parseJson(String jsonString) {
        try {
            return Optional.ofNullable(mapper.readTree(jsonString));
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse JSON string", e);
        }
    }

    public static Optional<String> getStringValue(JsonNode rootNode, String... keys) {
        return getNode(rootNode, keys)
                .filter(JsonNode::isTextual)
                .map(JsonNode::asText);
    }

    public static Optional<Integer> getIntValue(JsonNode rootNode, String... keys) {
        return getNode(rootNode, keys)
                .filter(JsonNode::isInt)
                .map(JsonNode::asInt);
    }

    public static Optional<Boolean> getBooleanValue(JsonNode rootNode, String... keys) {
        return getNode(rootNode, keys)
                .filter(JsonNode::isBoolean)
                .map(JsonNode::asBoolean);
    }

    private static Optional<JsonNode> getNode(JsonNode rootNode, String... keys) {
        JsonNode node = rootNode;
        for (String key : keys) {
            if (node == null || !node.isObject() || !node.has(key)) {
                return Optional.empty();
            }
            node = node.get(key);
        }
        return Optional.ofNullable(node);
    }
}


