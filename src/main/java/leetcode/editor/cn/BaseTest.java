package leetcode.editor.cn;

import base.DataStructBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import java.util.Arrays;

public class BaseTest {
    public static Object baseTest(Object solution, String... params) {
        String methodName = params[0];
        Method[] methods = solution.getClass().getDeclaredMethods();
        Method method = Arrays.stream(methods).filter(e -> e.getName().equals(methodName)).findAny().get();
        Object[] paramArray = new Object[params.length - 1];
        for (int i = 0; i < method.getParameterTypes().length; i++) {
            Class<?> classType = method.getParameterTypes()[i];
            Object paramObject = parseParamFromString(classType.getTypeName(), params[i + 1]);
            paramArray[i] = paramObject;
        }
        try {
            return method.invoke(solution, paramArray);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Object parseParamFromString(String typeName, String param) {
        switch (typeName) {
            case "int[]":
                return DataStructBuilder.initIntArray(param);
            case "solutions.base.ListNode":
                return DataStructBuilder.initNodeList(param);
            case "int":
                return Integer.valueOf(param);
            case "java.lang.String":
                return param;
            case "java.lang.String[]":
                return DataStructBuilder.initStringArray(param);
            case "solutions.base.TreeNode":
                return DataStructBuilder.initNodeTree(param);
            case "int[][]":
                return DataStructBuilder.init2DIntArray(param);
            case "double":
                return Double.parseDouble(param);
            default:
                throw new InvalidParameterException();
        }
    }
}
